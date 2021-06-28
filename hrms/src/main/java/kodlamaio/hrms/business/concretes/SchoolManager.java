package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SchoolDao;
import kodlamaio.hrms.entities.concretes.SchoolInfo;

@Service
public class SchoolManager implements SchoolService {

	private SchoolDao schoolDao;
	
	@Autowired
	public SchoolManager(SchoolDao schoolDao) {
		super();
		this.schoolDao = schoolDao;
	}

	@Override
	public Result add(SchoolInfo school) {
		var result = this.schoolDao.save(school);
		if (result != null) {
			return new SuccessResult("Başarılı");
		}
		return new ErrorResult("Okul bilgisi eklenemedi");
	}

	@Override
	public DataResult<List<SchoolInfo>> getAll() {
		var result = this.schoolDao.findAll();
		if (result != null) {
			return new SuccessDataResult<List<SchoolInfo>>(result);
		}
		return new ErrorDataResult<List<SchoolInfo>>();
	}

	@Override
	public DataResult<List<SchoolInfo>> getByJobSeekerIdOrderByGraduationDateDESC(int jobSeekerId) {
		Sort sortBy = Sort.by(Sort.Direction.DESC,"graduationDate");
		var result = this.schoolDao.getByJobSeekerId(sortBy,jobSeekerId);
		if (result != null) {
			return new SuccessDataResult<List<SchoolInfo>>(result);
		}
		return new SuccessDataResult<List<SchoolInfo>>("listeleme yapılamadı");
	}

	@Override
	public Result addAll(List<SchoolInfo> schools) {
		  schoolDao.saveAll(schools);
	      return new SuccessResult("başarılı");
	}

	
}
