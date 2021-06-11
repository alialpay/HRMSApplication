package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.core.adapters.mernis.UserCheckService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.dtos.EmployerForRegisterDto;
import kodlamaio.hrms.entities.dtos.JobSeekerForRegisterDto;
import kodlamaio.hrms.business.validationRules.AuthValidator;

@Service
public class AuthManager implements AuthService {

	
	private AuthValidator authValidator;
	private UserCheckService userCheckService;
	
	
	@Autowired
	public AuthManager(AuthValidator authValidator,UserCheckService userCheckService) {
		this.authValidator = authValidator;
		this.userCheckService=userCheckService;
	}

	@Override
	public Result jobSeekerRegister(JobSeekerForRegisterDto jobSeekerDto) {
		
		Result passwordResult = authValidator.isPasswordConfirmed(jobSeekerDto.getPassword(),jobSeekerDto.getPasswordConfirm());
		if (!passwordResult.isSuccess()) {
            return passwordResult;
        }
		
		Result checkResult = authValidator.userNullCheck(jobSeekerDto);
		if (!checkResult.isSuccess()) {
            return checkResult;
        }
		
		Result jobSeekerResult = authValidator.jobSeekerNullCheck(jobSeekerDto);
		if (!jobSeekerResult.isSuccess()) {
            return jobSeekerResult;
        }
		Result tcRsesult = authValidator.nationalIdValid(jobSeekerDto);
		if (!tcRsesult.isSuccess()) {
            return tcRsesult;
        }
		Result mernis = authValidator.checkMernis(jobSeekerDto, userCheckService);
		if (!mernis.isSuccess()) {
            return mernis;
        }
		Result jobSeekerRegisterCheck = authValidator.checkJobSeekerRegisterForm(jobSeekerDto);
		if (!jobSeekerRegisterCheck.isSuccess()) {
            return jobSeekerRegisterCheck;
        }
		
		return new SuccessResult("Kayıt başarılı");
	}

	@Override
	public Result employerRegister(EmployerForRegisterDto employerDto) {
		
		Result passwordResult = authValidator.isPasswordConfirmed(employerDto.getPassword(), employerDto.getPasswordConfirm());
		if (!passwordResult.isSuccess()) {
            return passwordResult;
        }
		
		Result checkResult = authValidator.userNullCheck(employerDto);
		if (!checkResult.isSuccess()) {
            return checkResult;
        }
		
		Result isNullResult = authValidator.employerNullCheck(employerDto);
		if (!isNullResult.isSuccess()) {
            return isNullResult;
        }
		
		Result domainCheckResult = authValidator.isEmailDomainCheck(employerDto);
		if (!domainCheckResult.isSuccess()) {
            return domainCheckResult;
        }
		Result employerRegisterCheck = authValidator.checkEmployerRegisterForm(employerDto);
		if (!employerRegisterCheck.isSuccess()) {
            return employerRegisterCheck;
        }
		
		
		return new SuccessResult("Kayıt başarılı");
	}

	
	

}
