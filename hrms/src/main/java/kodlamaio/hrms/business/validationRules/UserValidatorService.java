package kodlamaio.hrms.business.validationRules;

import kodlamaio.hrms.core.entities.User;
import kodlamaio.hrms.core.utilities.results.Result;

public interface UserValidatorService{
	 Result userNullCheck(User user);
}
