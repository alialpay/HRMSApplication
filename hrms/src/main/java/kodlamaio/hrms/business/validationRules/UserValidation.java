package kodlamaio.hrms.business.validationRules;

import com.google.common.base.Strings;

import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.abstracts.User;

public class UserValidation implements UserValidationService{

	@Override
	public Result userNullCheck(User user) {
		if (Strings.isNullOrEmpty(user.getEmail()) || Strings.isNullOrEmpty(user.getPassword())) {
            return new ErrorResult("Alanlar boş bırakılamaz");
        }
        return new SuccessResult();
	}

}
