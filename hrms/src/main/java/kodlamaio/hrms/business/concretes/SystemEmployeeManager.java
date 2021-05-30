package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SystemEmployeeService;
import kodlamaio.hrms.business.validationRules.SystemEmployeeValidationService;
import kodlamaio.hrms.core.dataAccess.UserDao;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SystemEmployeeDao;
import kodlamaio.hrms.entities.concretes.SystemEmployee;

@Service
public class SystemEmployeeManager extends UserManager<SystemEmployee> implements SystemEmployeeService {
	
	private SystemEmployeeValidationService systemEmployeeValidationService;
	private SystemEmployeeDao systemEmployeeDao;

	public SystemEmployeeManager(UserDao<SystemEmployee> userDao,SystemEmployeeValidationService systemEmployeeValidationService,SystemEmployeeDao systemEmployeeDao) {
		super(userDao);
		this.systemEmployeeValidationService=systemEmployeeValidationService;
		this.systemEmployeeDao = systemEmployeeDao;
	}
	
	@Override
    public Result add(SystemEmployee systemEmployee) {
		Result result = systemEmployeeValidationService.isEmployeeNullCheck(systemEmployee);
		if (!result.isSuccess()) {
            return result;
        }
		this.systemEmployeeDao.save(systemEmployee);
		return new SuccessResult("Kullanıcı eklendi");
	}

}
