package com.example.lcj.jdk8NewSyntax.Stream.test;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author lichengjian
 * @date 2021/2/10
 */
public class StreamTest {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950));
        // 1、找出2011年的所有交易并按交易额排序(从低到高)
        List<Transaction> collect = transactions.stream().filter(item -> item.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue)).collect(toList());

        // 2、交易员都在哪些不同的城市工作过
        List<String> citys = transactions.stream().map(transaction -> transaction.getTrader().getCity())
                .distinct().collect(toList());
        Set<String> collect1 = transactions.stream().map(transaction -> transaction.getTrader().getCity())
                .collect(Collectors.toSet());

        // 3、查找所有来自于剑桥的交易员，并按姓名排序
        List<Trader> cambridge =
                transactions.stream().map(Transaction::getTrader).filter(item -> item.getCity().equals("Cambridge"))
                        .distinct()
                        .sorted(Comparator.comparing(Trader::getName))
                        .collect(toList());

        // 4、返回所有交易员的姓名字符串，按字母顺序排序
        String reduce = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct().sorted().reduce("", (n1, n2) -> n1 + n2);

        // 5、有没有交易员是在米兰工作的
        boolean milnan = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milnan"));
        // 6、打印生活在剑桥的交易员的所有交易额
        transactions.stream().filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                .map(Transaction::getValue)
                .forEach(System.out::println);

    }
}
