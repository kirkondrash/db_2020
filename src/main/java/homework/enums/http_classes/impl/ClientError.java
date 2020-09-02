package homework.enums.http_classes.impl;

import homework.enums.http_classes.HttpClass;

public class ClientError extends HttpClass {

    public ClientError() {
        super("4");
    }

    @Override
    public void work() {
        System.out.println("ClientError. o_O");
    }

}
