package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import org.springframework.stereotype.Service;

@Service
public class JobSeekerManager extends UserManager<JobSeeker> implements JobSeekerService {

	public JobSeekerManager(UserDao<JobSeeker> userDao) {
		super(userDao);
		// TODO Auto-generated constructor stub
	}


}
