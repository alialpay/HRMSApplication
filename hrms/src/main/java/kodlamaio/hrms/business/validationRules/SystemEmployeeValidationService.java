package kodlamaio.hrms.business.validationRules;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SystemEmployee;

public interface SystemEmployeeValidationService {
	Result isEmployeeNullCheck(SystemEmployee systemEmployee);
}
