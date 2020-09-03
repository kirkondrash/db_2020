package homework.class_loading.http_classes.impl;

import homework.class_loading.http_classes.HttpClass;

public class Redirection extends HttpClass {

    public Redirection() {
        super("3");
    }

    @Override
    public void work() {
        System.out.println("Redirect. <_<");
    }

}
