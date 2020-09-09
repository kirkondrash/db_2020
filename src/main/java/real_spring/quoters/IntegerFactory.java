package real_spring.quoters;

import heroes.RandomUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Lazy
public class IntegerFactory implements FactoryBean<Integer> {


    private final int min;
    private final int max;

    @Autowired
    public IntegerFactory(@Value("${minRandomBound}") int min, @Value("${maxRandomBound}") int max) {
        this.min = min;
        this.max = max;
    }

    public int randomInt(){
        return RandomUtil.getIntBetween(min, max);
    }

    @Override
    public Integer getObject() throws Exception {
        return randomInt();
    }

    @Override
    public Class<?> getObjectType() {
        return Integer.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
