package kodlamaio.hrms.business.validationRules;

import kodlamaio.hrms.business.abstracts.MailService;
import kodlamaio.hrms.core.adapters.mernis.UserCheckService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SystemEmployee;
import kodlamaio.hrms.entities.dtos.EmployerForRegisterDto;
import kodlamaio.hrms.entities.dtos.JobSeekerForRegisterDto;
import kodlamaio.hrms.entities.dtos.UserDto;

public interface AuthValidatorService {
    Result isPasswordConfirmed(String password, String confirmPassword);
    
    Result userNullCheck(UserDto user);

    Result isSystemEmployeeNullCheck(SystemEmployee systemEmployee);

    Result employerNullCheck(EmployerForRegisterDto employerDto);
    Result isEmailDomainCheck(EmployerForRegisterDto employerDto);
    
    Result jobSeekerNullCheck(JobSeekerForRegisterDto jobSeekerDto);
    Result nationalIdValid (JobSeekerForRegisterDto jobSeekerDto);
    
    Result checkEmail(MailService mailService, UserDto user);
    Result checkMernis(JobSeekerForRegisterDto jobSeekerDto, UserCheckService mernisCheck);
    
}
