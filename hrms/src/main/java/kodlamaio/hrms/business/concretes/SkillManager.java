package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SkillService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SkillDao;
import kodlamaio.hrms.entities.concretes.Skill;

@Service
public class SkillManager implements SkillService{

	private SkillDao skillDao;

	@Autowired
	public SkillManager(SkillDao skillDao) {
		super();
		this.skillDao = skillDao;
	}
	
	@Override
	public Result add(Skill skill) {
		var result = this.skillDao.save(skill);
		if (result != null) {
			return new SuccessResult("başarılı");
		}
		return new ErrorResult("ekleme yapılamadı");
	}

	@Override
	public DataResult<List<Skill>> getAll() {
		var result =this.skillDao.findAll();
		if (result != null) {
			return new SuccessDataResult<List<Skill>>(result,"başarılı");
		}
		return new ErrorDataResult<List<Skill>>("data getirilemedi");
	}

	@Override
	public DataResult<List<Skill>> getByJobSeekerId(int jobSeekerId) {
		var result = this.skillDao.getByJobSeekerId(jobSeekerId);
		if (result != null) {
			return new SuccessDataResult<List<Skill>>(result,"başarılı");
		}
		return new ErrorDataResult<List<Skill>>("data getirilemedi");
	}

	@Override
	public Result addAll(List<Skill> skill) {
		  skillDao.saveAll(skill);
	      return new SuccessResult("başarılı");
	}

}