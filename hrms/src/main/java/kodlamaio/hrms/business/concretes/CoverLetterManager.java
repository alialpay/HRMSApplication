package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CoverLetterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CoverLetterDao;
import kodlamaio.hrms.entities.concretes.CoverLetter;

@Service
public class CoverLetterManager implements CoverLetterService{
	CoverLetterDao coverLetterDao;

	public CoverLetterManager(CoverLetterDao coverLetterDao) {
		super();
		this.coverLetterDao = coverLetterDao;
	}

	@Override
	public Result add(CoverLetter coverLetter) {
		var result = this.coverLetterDao.save(coverLetter);
		if (result != null) {
			return new SuccessResult("başarılı");
		}
		return new ErrorResult("ekleme yapılamadı");
	}

	@Override
	public Result delete(CoverLetter coverLetter) {
		this.coverLetterDao.delete(coverLetter);
		return new SuccessResult("silindi");
	}

	@Override
	public DataResult<List<CoverLetter>> getAll() {
		var result =this.coverLetterDao.findAll();
		if (result != null) {
			return new SuccessDataResult<List<CoverLetter>>(result,"başarılı");
		}
		return new ErrorDataResult<List<CoverLetter>>("data getirilemedi");
	}

	@Override
	public DataResult<List<CoverLetter>> getByJobSeekerId(int jobSeekerId) {

		var result = this.coverLetterDao.getByJobSeekerId(jobSeekerId);
		if (result != null) {
			return new SuccessDataResult<List<CoverLetter>>(result,"başarılı");
		}
		return new ErrorDataResult<List<CoverLetter>>("data getirilemedi");
	
	}
	
}
