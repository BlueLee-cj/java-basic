package com.example.lcj.spring.bean.InstantiatingBeans.method04InstanceFactory;

public class PersonFactory {
    public  Person getPerson(String arg) {
        if (arg.equalsIgnoreCase("chinese")) {
            Chinese chinese = new Chinese();
            chinese.setMsg(arg);
            return chinese;
        } else {
            American american = new American();
            american.setMsg(arg);
            return american;
        }
    }
}
