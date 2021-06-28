package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.LanguageDao;
import kodlamaio.hrms.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {

	LanguageDao languageDao;
	
	public LanguageManager(LanguageDao languageDao) {
		super();
		this.languageDao = languageDao;
	}

	@Override
	public Result add(Language language) {
		var result = this.languageDao.save(language);
		if (result != null) {
			return new SuccessResult("başarılı");
		}
		return new ErrorResult("ekleme yapılamadı");
	}

	@Override
	public Result delete(Language language) {
		this.languageDao.delete(language);
		return new SuccessResult("silindi");
	}

	@Override
	public DataResult<List<Language>> getAll() {
		var result =this.languageDao.findAll();
		if (result != null) {
			return new SuccessDataResult<List<Language>>(result,"başarılı");
		}
		return new ErrorDataResult<List<Language>>("data getirilemedi");
	}

	@Override
	public DataResult<List<Language>> getByJobSeekerId(int jobSeekerId) {

		var result = this.languageDao.getByJobSeekerId(jobSeekerId);
		if (result != null) {
			return new SuccessDataResult<List<Language>>(result,"başarılı");
		}
		return new ErrorDataResult<List<Language>>("data getirilemedi");
	}

	@Override
	public Result addAll(List<Language> language) {
		  languageDao.saveAll(language);
	      return new SuccessResult("başarılı");
	}

}
