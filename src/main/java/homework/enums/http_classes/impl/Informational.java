package homework.enums.http_classes.impl;

import homework.enums.http_classes.HttpClass;

public class Informational extends HttpClass {

    public Informational() {
        super("1");
    }

    @Override
    public void work() {
        System.out.println("Informational. -_-");
    }

}
