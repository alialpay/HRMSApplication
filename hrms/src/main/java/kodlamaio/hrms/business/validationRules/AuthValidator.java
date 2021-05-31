package kodlamaio.hrms.business.validationRules;

import org.springframework.stereotype.Component;

import kodlamaio.hrms.core.utilities.results.*;

@Component
public class AuthValidator implements AuthValidatorService {
    public Result isPasswordConfirmed(String password, String confirmPassword){
        if(password.equals(confirmPassword)){
            return new SuccessResult();
        }
        return new ErrorResult("Parola eşleşmedi");
    }
}
