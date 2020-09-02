package homework.enums.http_classes.impl;

import homework.enums.http_classes.HttpClass;

public class Redirection extends HttpClass {

    public Redirection() {
        super("3");
    }

    @Override
    public void work() {
        System.out.println("Redirect. <_<");
    }

}
