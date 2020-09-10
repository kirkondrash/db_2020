package real_spring.databases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class DatabaseManagerService {

    @Autowired
    @Database(DatabaseEnum.ORACLE)
    Dao oracle;
    @Autowired
    @Database(DatabaseEnum.DERBY)
    Dao derby;

    @Scheduled(fixedDelay = 1000)
    public void doWork(){
        oracle.save();
    }

    @Scheduled(fixedDelay = 3000)
    public void doBackup(){
        derby.save();
    }

}
