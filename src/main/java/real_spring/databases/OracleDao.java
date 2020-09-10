package real_spring.databases;

import org.springframework.stereotype.Repository;

@Database(DatabaseEnum.ORACLE)
@Repository
public class OracleDao implements Dao {
    @Override
    public void save() {
        System.out.println("Oracle");
    }
}
