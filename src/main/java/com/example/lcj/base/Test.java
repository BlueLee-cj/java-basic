package com.example.lcj.base;

class Test {
    public static void main(String[] args) {
//        System.out.println(new B());
//        int a =3;
//        int c ;
//        if ( a>0 )
//            if ( a>3 )  c = 2;
//            else c = 3;
//        else c = 4;
//        System.out.println(c);
//        String s;
//        System.out.println("s=" + s);

//        int a=0;
//        int b=0;
//        int c=0;
//        do{
//            --c;
//            b--;
//            a=a-1;
//        }while(a>0);
//        System.out.println("a=" + a);
//        System.out.println("b=" + b);
//        System.out.println("c=" + c);
//        Person  person = new Student();
//        person.printAge();

//        System.out.println(getValue(2));
//        int c;
//        c = 2;
//        System.out.println(c);
////        System.out.println(c++);
//        System.out.println(++c);
//        System.out.println(c);
//        int [ ]  x = new int[10];
//        System.out.println(x[0]);
//        Long temp =  (Long)3.9;
        char a = (char) Integer.MAX_VALUE;
        System.out.println((int) a);
        char cc = '中';
        System.out.println(cc);
    }

    public static int getValue(int i) {
        int result = 0;
        switch (i) {
            case 1:
                result = result + i;
            case 2:
                result = result + i * 2;
            case 3:
                result = result + i * 3;
        }
        return result;
    }
}

