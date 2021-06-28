package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SocialMediaService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SocialMediaDao;
import kodlamaio.hrms.entities.concretes.SocialMedia;

@Service
public class SocialMediaManager implements SocialMediaService {

	SocialMediaDao socialMediaDao;
	
	public SocialMediaManager(SocialMediaDao socialMediaDao) {
		super();
		this.socialMediaDao = socialMediaDao;
	}

	@Override
	public Result add(SocialMedia socialMedia) {
		var result = this.socialMediaDao.save(socialMedia);
		if (result != null) {
			return new SuccessResult("başarılı");
		}
		return new ErrorResult("eklenemedi");
	}

	@Override
	public DataResult<List<SocialMedia>> getAll() {
		var result = this.socialMediaDao.findAll();
		if (result != null) {
			return new SuccessDataResult<List<SocialMedia>>(result,"başarılı");
		}
		return new ErrorDataResult<List<SocialMedia>>("data getirilemedi");
	}

	@Override
	public DataResult<List<SocialMedia>> getByJobSeekerId(int jobSeekerId) {
		var result = this.socialMediaDao.getByJobSeekerId(jobSeekerId);
		if (result != null) {
			return new SuccessDataResult<List<SocialMedia>>(result,"başarılı");
		}
		return new ErrorDataResult<List<SocialMedia>>("data getirilemedi");
	}

	@Override
	public Result addAll(List<SocialMedia> links) {
		  socialMediaDao.saveAll(links);
	      return new SuccessResult("başarılı");
	}

}
