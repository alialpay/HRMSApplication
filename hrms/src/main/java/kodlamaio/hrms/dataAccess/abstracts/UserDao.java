package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import kodlamaio.hrms.entities.abstracts.User;

public interface UserDao<T extends User> extends JpaRepository<T,Integer> {
    
}
