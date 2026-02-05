package com.example.lcj.base;

class Cat {
    int color, weight, height;

    public Cat(int color, int weight, int height) {
        this.color = color;
        this.weight = weight;
        this.height = height;
    }

    /**
     * ��������д��ȴ�Object��̳�������equals()�������ı��������Ĭ�ϵ�ʵ�֣�
     * ͨ�������Լ������ʵ�����жϾ��������������߼����Ƿ���ȡ�
     * �������Ƕ��������ֻè��color��weight��height����ͬ��
     * ��ô���Ǿ���Ϊ����ֻè���߼�����һģһ���ģ�������ֻè�ǡ���ȡ��ġ�
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else {
            /**
             * instanceof�Ƕ����������
             * ��������������ⶨһ�������Ƿ�����ĳ��ָ�����ָ���������ʵ����
             * �����������һ����ϵ���instanceof��
             * ���������һ��˫Ŀ�����������ߵı��ʽ��һ�������ұߵı��ʽ��һ���࣬
             * �����ߵĶ������ұߵ��ഴ���Ķ�����������Ϊtrue������Ϊfalse��
             */
            if (obj instanceof Cat) {
                Cat c = (Cat) obj;
                if (c.color == this.color && c.weight == this.weight && c.height == this.height) {
                    return true;
                }
            }
        }
        return false;
    }
}