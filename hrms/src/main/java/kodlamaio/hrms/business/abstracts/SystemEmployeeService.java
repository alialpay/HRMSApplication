package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SystemEmployee;

public interface SystemEmployeeService extends UserService<SystemEmployee> {
	DataResult<List<SystemEmployee>> getAll();
	Result add(SystemEmployee systemEmployee);
}
