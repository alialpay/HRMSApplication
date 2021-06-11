package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{

	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(),"Data listelendi");
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		//jobAdvertisement.getCreatedAt().equals(LocalDate.now());
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("başarılı");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveTrue() {
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.getByIsActiveTrue());
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByApplicationDeadlineLessThanEqual(LocalDate date) {
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.getByApplicationDeadlineLessThanEqual(date));
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueAndApplicationDeadlineLessThanEqual(LocalDate date) {
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.getByIsActiveTrueAndApplicationDeadlineLessThanEqual(date));
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueAndEmployer_CompanyName(String companyName) {
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.getByIsActiveTrueAndEmployer_CompanyName(companyName));
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByEmployerId(int id) {
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.getByEmployerId(id));
	}

	@Override
	public DataResult<JobAdvertisement> changeStatus(int employerId,int advertisementId, boolean status) {
		
		List<JobAdvertisement> advertisement = this.jobAdvertisementDao.getByEmployerId(employerId);
		
		for (JobAdvertisement jobAdvertisement : advertisement) {
			if (advertisementId == jobAdvertisement.getId()) {
				jobAdvertisement.setActive(status);
				this.jobAdvertisementDao.save(jobAdvertisement);
				return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.getById(advertisementId));
			}
		}
		
		return new ErrorDataResult<JobAdvertisement>();	
	}


}
