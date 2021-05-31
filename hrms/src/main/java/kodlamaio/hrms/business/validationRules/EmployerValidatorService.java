package kodlamaio.hrms.business.validationRules;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerValidatorService {
    Result employerNullCheck(Employer employer);
    Result isEmailDomainCheck(Employer employer);
}
