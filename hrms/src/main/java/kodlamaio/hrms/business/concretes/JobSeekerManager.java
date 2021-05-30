package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.business.validationRules.JobSeekerValidationService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;

import org.springframework.stereotype.Service;

@Service
public class JobSeekerManager extends UserManager<JobSeeker> implements JobSeekerService {

	private JobSeekerValidationService jobSeekerValidationService;
	private JobSeekerDao jobSeekerDao;
	
	public JobSeekerManager(UserDao<JobSeeker> userDao, JobSeekerValidationService jobSeekerValidationService, JobSeekerDao jobSeekerDao) {
		super(userDao);
		this.jobSeekerValidationService=jobSeekerValidationService;
		this.jobSeekerDao=jobSeekerDao;
	}

	@Override
    public Result add(JobSeeker jobSeeker) {
		Result result = jobSeekerValidationService.jobSeekerNullCheck(jobSeeker);
		if (!result.isSuccess()) {
            return result;
        }
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult("Kullanıcı eklendi");
	}
	
}
