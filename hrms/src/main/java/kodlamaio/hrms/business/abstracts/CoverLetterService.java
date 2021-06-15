package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CoverLetter;

public interface CoverLetterService {
	Result add(CoverLetter coverLetter);
	Result delete(CoverLetter coverLetter);
	//???Result update(CoverLetter coverLetter, int jobSeekerId);
	DataResult<List<CoverLetter>> getAll();
	DataResult<List<CoverLetter>> getByJobSeekerId(int jobSeekerId);
}
