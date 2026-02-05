package com.example.lcj;

import com.alibaba.fastjson.JSON;
import com.example.lcj.designpattern.chainOfResponsibilityPattern.demo2.*;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.lcj.designpattern.chainOfResponsibilityPattern.demo1.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JavaBasicApplication.class)
public class CreateProductTest {

    /**
     * 使用Spring注入:所有继承了AbstractCheckHandler抽象类的Spring Bean都会注入进来。Map的Key对应Bean的name,Value是name对应相应的Bean
     */
    @Resource
    private Map<String, AbstractCheckHandler> handlerMap;


    /**
     * 创建商品
     *
     * @return
     */
    @Test
    public void createProduct() {

        //创建商品参数
        ProductVO param = ProductVO.builder()
                .skuId(null).skuName("华为手机").path("http://...")
                .price(new BigDecimal(1))
                .stock(-1)
                .build();


        //参数校验，使用责任链模式
        Result paramCheckResult = this.paramCheck(param);
        if (!paramCheckResult.isSuccess()) {
            return ;
        }
    }

    /**
     * 参数校验：责任链模式
     *
     * @param param
     * @return
     */
    private Result paramCheck(ProductVO param) {

        //获取处理器配置：通常配置使用统一配置中心存储，支持动态变更
        ProductCheckHandlerConfig handlerConfig = this.getHandlerConfigFile();

        //获取处理器
        AbstractCheckHandler handler = this.getHandler(handlerConfig);

        //责任链：执行处理器链路
        Result executeChainResult = HandlerClient.executeChain(handler, param);
        if (!executeChainResult.isSuccess()) {
            System.out.println("创建商品 失败...");
            return executeChainResult;
        }

        //处理器链路全部成功
        return Result.success();
    }

    /**
     * 获取处理器配置：通常配置使用统一配置中心存储，支持动态变更
     *
     * @return
     */
    private ProductCheckHandlerConfig getHandlerConfigFile() {
        //配置中心存储的配置
        String configJson = "{\"handler\":\"nullValueCheckHandler\",\"down\":true,\"next\":{\"handler\":\"priceCheckHandler\",\"next\":{\"handler\":\"stockCheckHandler\",\"next\":null}}}";
        //转成Config对象
        ProductCheckHandlerConfig handlerConfig = JSON.parseObject(configJson, ProductCheckHandlerConfig.class);
        return handlerConfig;
    }

    /**
     * 获取处理器
     * @param config
     * @return
     */
    private AbstractCheckHandler getHandler (ProductCheckHandlerConfig config) {
        //配置检查：没有配置处理器链路，则不执行校验逻辑
        if (Objects.isNull(config)) {
            return null;
        }
        //配置错误
        String handler = config.getHandler();
        if (StringUtils.isBlank(handler)) {
            return null;
        }
        //配置了不存在的处理器
        AbstractCheckHandler abstractCheckHandler = handlerMap.get(config.getHandler());
        if (Objects.isNull(abstractCheckHandler)) {
            return null;
        }

        //处理器设置配置Config
        abstractCheckHandler.setConfig(config);

        //递归设置链路处理器
        abstractCheckHandler.setNextHandler(this.getHandler(config.getNext()));

        return abstractCheckHandler;
    }
}
