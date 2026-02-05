package com.example.lcj.jdk8NewSyntax.lambda;

/**
 * @author lichengjian
 * @date 2021/1/24
 */
public class LambdaTest1 {
    // 静态内部类
    static class LikeStatic implements ILike {

        @Override
        public void love() {
            System.out.println("make love static");
        }
    }

    // 非静态内部类
    class LikeNoStatic implements ILike {

        @Override
        public void love() {
            System.out.println("make love nostatic");
        }
    }

    public static void main(String[] args) {

        // 1、普通实现
        ILike like = new Like();
        like.love();

        // 2、静态内部类
        LikeStatic likeStatic = new LikeStatic();
        likeStatic.love();

        // 3、非静态内部类有具体引用才能使用
        // LikeNoStatic likeNoStatic = new LikeNoStatic();
        LikeNoStatic likeNoStatic = new LambdaTest1().new LikeNoStatic();
        likeNoStatic.love();

        // 4、匿名内部类，实在方法内部
        ILike likenoname = new ILike() {
            @Override
            public void love() {
                System.out.println("make love nonameinnerclass");
            }
        };
        likenoname.love();

        // 5、lambda语法
        ILike likelambda = () -> {
            System.out.println("make love lambda");
        };
        likelambda.love();

        // 6、精简
        ILike likelam = () -> System.out.println("make love lam");
        likelam.love();
    }

    static class Like implements ILike {

        @Override
        public void love() {
            System.out.println("make love implement");
        }
    }
}


interface ILike {
    void love();
}


