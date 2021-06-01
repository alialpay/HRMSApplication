package kodlamaio.hrms.business.validationRules;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.google.common.base.Strings;

import kodlamaio.hrms.business.abstracts.MailService;
import kodlamaio.hrms.core.adapters.mernis.UserCheckService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.entities.concretes.SystemEmployee;
import kodlamaio.hrms.entities.dtos.EmployerForRegisterDto;
import kodlamaio.hrms.entities.dtos.JobSeekerForRegisterDto;
import kodlamaio.hrms.entities.dtos.UserDto;

@Component
public class AuthValidator implements AuthValidatorService {
	public Result isPasswordConfirmed(String password, String confirmPassword) {
		if (password.equals(confirmPassword)) {
			return new SuccessResult();
		}
		return new ErrorResult("Parola eşleşmedi");
	}

	@Override
	public Result userNullCheck(UserDto user) {
		if (Strings.isNullOrEmpty(user.getEmail()) || Strings.isNullOrEmpty(user.getPassword())) {
			return new ErrorResult("Alanlar boş bırakılamaz");
		}
		return new SuccessResult();
	}

	@Override
	public Result isSystemEmployeeNullCheck(SystemEmployee systemEmployee) {
		String firstName = systemEmployee.getFirstName();
		String lastName = systemEmployee.getLastName();
		if (Strings.isNullOrEmpty(firstName) || Strings.isNullOrEmpty(lastName)) {
			return new ErrorResult("Alanlar boş bırakılamaz");
		}
		return new SuccessResult();
	}

	@Override
	public Result employerNullCheck(EmployerForRegisterDto employerDto) {
		String companyName = employerDto.getCompanyName();
		String webAddress = employerDto.getWebAddress();
		String phoneNumber = employerDto.getPhoneNumber();

		if (Strings.isNullOrEmpty(companyName) || Strings.isNullOrEmpty(webAddress)
				|| Strings.isNullOrEmpty(phoneNumber)) {
			return new ErrorResult("Alanlar boş bırakılamaz");
		}
		return new SuccessResult();
	}

	@Override
	public Result isEmailDomainCheck(EmployerForRegisterDto employerDto) {
		String email = employerDto.getEmail();
		String webAddress = employerDto.getWebAddress();

		String domain = webAddress.split("www.")[1];
		if (domain.equals(email.split("@")[1])) {
			return new SuccessResult();
		}
		return new ErrorResult("Domain geçersiz");
	}

	@Override
	public Result jobSeekerNullCheck(JobSeekerForRegisterDto jobSeekerDto) {
		String firstName = jobSeekerDto.getFirstName();
		String lastName = jobSeekerDto.getLastName();
		String tc = jobSeekerDto.getNationalityIdentity();
		LocalDate birth = jobSeekerDto.getDateOfBirth();

		if ((Strings.isNullOrEmpty(firstName)) || (Strings.isNullOrEmpty(lastName)) || (Strings.isNullOrEmpty(tc))
				|| birth == null) {
			return new ErrorResult("Alanlar boş bırakılamaz");
		}
		return new SuccessResult();
	}

	@Override
	public Result nationalIdValid(JobSeekerForRegisterDto jobSeekerDto) {
		if (jobSeekerDto.getNationalityIdentity().length() == 11) {
			return new SuccessResult();
		}
		return new ErrorResult("Doğrulama başarız");
	}

	@Override
	public Result checkEmail(MailService mailService, UserDto user) {
		Result result = mailService.verification(user.getEmail());

		if (result == null) {
			return new ErrorResult("email could not be verified");
		}

		return new SuccessResult();
	}

	@Override
	public Result checkMernis(JobSeekerForRegisterDto jobSeekerDto, UserCheckService mernisCheck) {
		if(mernisCheck.validate(jobSeekerDto.getNationalityIdentity(),jobSeekerDto.getDateOfBirth().getYear()) == false) {
			return new ErrorResult("Geçersiz kimlik bilgisi");
		}
		return new SuccessResult() ;
	}

}
