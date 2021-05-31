package kodlamaio.hrms.business.validationRules;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SystemEmployee;

public interface SystemEmployeeValidatorService extends UserValidatorService {
	Result isEmployeeNullCheck(SystemEmployee systemEmployee);
}
