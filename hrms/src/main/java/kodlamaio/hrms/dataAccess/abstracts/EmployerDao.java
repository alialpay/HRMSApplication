package kodlamaio.hrms.dataAccess.abstracts;


import java.util.Optional;

import kodlamaio.hrms.core.dataAccess.UserDao;
import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerDao extends UserDao<Employer>{
	Optional<Employer> findByEmail(String email);
}
