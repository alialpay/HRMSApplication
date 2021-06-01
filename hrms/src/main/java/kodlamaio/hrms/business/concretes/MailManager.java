package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.MailService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

public class MailManager implements MailService{

	@Override
	public Result verification(String email) {
		return new SuccessResult("Mail checked");
	}

}
