package my_spring;

import lombok.Getter;
import my_spring.system.annotations.InjectRandomInt;
import my_spring.system.annotations.Singleton;

/**
 * @author Evgeny Borisov
 */
@Singleton
@Getter
public class PoorGuy implements Guy{
    @InjectRandomInt(min = 10,max = 15)
    private int power;
}
