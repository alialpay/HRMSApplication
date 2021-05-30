package kodlamaio.hrms.business.validationRules;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;

public interface JobSeekerValidationService {
	Result jobSeekerNullCheck(JobSeeker jobSeeker);
    Result nationalIdValid (String nationalIdentity);
}
