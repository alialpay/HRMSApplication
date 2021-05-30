package kodlamaio.hrms.business.validationRules;


import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.google.common.base.Strings;

import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Component
public class JobSeekerValidation extends UserValidation implements JobSeekerValidationService {

	@Override
	public Result jobSeekerNullCheck(JobSeeker jobSeeker) {
		String firstName = jobSeeker.getFirstName();
        String lastName = jobSeeker.getLastName();
        String tc = jobSeeker.getNationalIdentity();
        LocalDate birth = jobSeeker.getDateOfBirth();
        
		if (!super.userNullCheck(jobSeeker).isSuccess() || (Strings.isNullOrEmpty(firstName)) ||
                (Strings.isNullOrEmpty(lastName)) || (Strings.isNullOrEmpty(tc)) || birth == null) {
            return new ErrorResult("Alanlar boş bırakılamaz");
        }
        return new SuccessResult();
	}

	@Override
	public Result nationalIdValid(String nationalIdentity) {
		if (nationalIdentity.length() == 11) {
            return new SuccessResult();
        }
        return new ErrorResult("Doğrulama başarız");
	}

}
