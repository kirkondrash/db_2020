package homework.enums.http_classes.impl;

import homework.enums.http_classes.HttpClassHandler;

public class Success implements HttpClassHandler {

    @Override
    public void work() {
        System.out.println("Success! ^_^");
    }

}
