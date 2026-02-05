package com.example.lcj.jdk8NewSyntax.lambda.more;

/**
 * 苹果实体
 *
 * @author zhenchao.wang 2016-09-17 12:49
 * @version 1.0.0
 */
public class Apple {

    /**
     * 编号
     */
    private long id;

    /**
     * 颜色
     */
    private Color color;

    /**
     * 重量
     */
    private float weight;

    /**
     * 产地
     */
    private String origin;

    public Apple() {
    }

    public Apple(long id, Color color, float weight, String origin) {
        this.id = id;
        this.color = color;
        this.weight = weight;
        this.origin = origin;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    // 省略getter和setter
}
