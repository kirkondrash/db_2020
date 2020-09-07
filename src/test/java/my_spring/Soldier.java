package my_spring;

import lombok.Getter;
import my_spring.system.annotations.InjectRandomInt;

/**
 * @author Evgeny Borisov
 */
@Getter
public class Soldier {
    @InjectRandomInt(min = 10,max = 15)
    private int power;
}
