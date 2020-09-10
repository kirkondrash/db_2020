package real_spring.databases;

import org.springframework.stereotype.Repository;

@Database(DatabaseEnum.DERBY)
@Repository
public class DerbyDao implements Dao {
    @Override
    public void save() {
        System.out.println("Derby");
    }
}
