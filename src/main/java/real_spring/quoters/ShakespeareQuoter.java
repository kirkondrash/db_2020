package real_spring.quoters;

import lombok.Setter;
import my_spring.InjectRandomInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author Evgeny Borisov
 */

@Component
public class ShakespeareQuoter implements Quoter {

    @Value("${shake}")
    private String message;

    @Autowired
    private int repeat;


    @PostConstruct
    public void init(){
        System.out.println("repeat = " + repeat);
    }


    @Override
    public void sayQuote() {
        for (int i = 0; i < repeat; i++) {
            System.out.println(message);
        }
    }

}


