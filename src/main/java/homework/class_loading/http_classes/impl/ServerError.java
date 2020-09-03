package homework.class_loading.http_classes.impl;

import homework.class_loading.http_classes.HttpClass;

public class ServerError extends HttpClass {

    public ServerError() {
        super("5");
    }

    @Override
    public void work() {
        System.out.println("ServerError. ~_~");
    }

}
