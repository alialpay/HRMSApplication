package kodlamaio.hrms.business.validationRules;

import com.google.common.base.Strings;

import kodlamaio.hrms.core.entities.User;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

public class UserValidator implements UserValidatorService{

	@Override
	public Result userNullCheck(User user) {
		if (Strings.isNullOrEmpty(user.getEmail()) || Strings.isNullOrEmpty(user.getPassword())) {
            return new ErrorResult("Alanlar boş bırakılamaz");
        }
        return new SuccessResult();
	}

}
