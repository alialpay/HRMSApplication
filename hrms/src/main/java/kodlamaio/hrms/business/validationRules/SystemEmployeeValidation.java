package kodlamaio.hrms.business.validationRules;

import org.springframework.stereotype.Component;

import com.google.common.base.Strings;

import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.SystemEmployee;

@Component
public class SystemEmployeeValidation extends UserValidation implements SystemEmployeeValidationService {
    @Override
    public Result isEmployeeNullCheck(SystemEmployee systemEmployee) {
        String firstName = systemEmployee.getFirstName();
        String lastName = systemEmployee.getLastName();
        if(!super.userNullCheck(systemEmployee).isSuccess()|| Strings.isNullOrEmpty(firstName)||Strings.isNullOrEmpty(lastName)){
            return new ErrorResult("Alanlar boş bırakılamaz");
        }
        return new SuccessResult();
    }
}
