package homework.enums.http_classes.impl;

import homework.enums.http_classes.HttpClassHandler;

public class ClientError implements HttpClassHandler {

    @Override
    public void work() {
        System.out.println("ClientError. o_O");
    }

}
