package com.example.lcj.enumexample.advanced;

public enum DayEnum {
    MON(1, "星期一", "各种不在状态") {
        @Override
        public String doSomething() {
            return MON.getValue();
        }
    },
    TUES(2, "星期二", "依旧犯困") {
        @Override
        public String doSomething() {
            return TUES.getValue();
        }
    },
    WEDNES(3, "星期三", "感觉半周终于过去了") {
        @Override
        public String doSomething() {
            return WEDNES.getValue();
        }
    };

    DayEnum(int index, String name, String value) {
        this.index = index;
        this.name = name;
        this.value = value;
    }

    private int index;
    private String name;
    private String value;

    public abstract String doSomething();

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
