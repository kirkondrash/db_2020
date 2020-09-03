package homework.class_loading.http_classes.impl;

import homework.class_loading.http_classes.HttpClass;

public class Success extends HttpClass {

    public Success() {
        super("2");
    }

    @Override
    public void work() {
        System.out.println("Success! ^_^");
    }

}
