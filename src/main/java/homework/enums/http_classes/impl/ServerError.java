package homework.enums.http_classes.impl;

import homework.enums.http_classes.HttpClassHandler;

public class ServerError  implements HttpClassHandler {

    @Override
    public void work() {
        System.out.println("ServerError. ~_~");
    }

}
