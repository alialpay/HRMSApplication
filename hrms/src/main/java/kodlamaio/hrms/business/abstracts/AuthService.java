package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.EmployerForRegisterDto;
import kodlamaio.hrms.entities.dtos.JobSeekerForRegisterDto;

public interface AuthService {
	Result jobSeekerRegister(JobSeekerForRegisterDto jobSeekerDto);
	
	Result employerRegister(EmployerForRegisterDto employerDto);
	
}
