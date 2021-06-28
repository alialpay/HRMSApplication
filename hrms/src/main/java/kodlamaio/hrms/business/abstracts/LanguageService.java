package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Language;

public interface LanguageService {
	
	Result add(Language language);
	Result addAll(List<Language> languages); //cv
	Result delete(Language language);
	
	DataResult<List<Language>> getAll();
	DataResult<List<Language>> getByJobSeekerId(int jobSeekerId);
}
