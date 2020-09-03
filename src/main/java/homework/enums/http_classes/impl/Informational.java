package homework.enums.http_classes.impl;

import homework.enums.http_classes.HttpClassHandler;

public class Informational implements HttpClassHandler {

    @Override
    public void work() {
        System.out.println("Informational. -_-");
    }

}
