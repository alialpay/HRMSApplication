package kodlamaio.hrms.business.validationRules;

import kodlamaio.hrms.core.utilities.results.Result;

public interface AuthValidatorService {
    Result isPasswordConfirmed(String password, String confirmPassword);
}
