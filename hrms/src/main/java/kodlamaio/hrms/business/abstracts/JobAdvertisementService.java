package kodlamaio.hrms.business.abstracts;

import java.time.LocalDate;
import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {

	DataResult<List<JobAdvertisement>> getAll();
	Result add(JobAdvertisement jobAdvertisement);
	DataResult<JobAdvertisement> changeStatus(int employerId,int advertisementId, boolean status);
	
	DataResult<List<JobAdvertisement>> getByIsActiveTrue();
	DataResult<List<JobAdvertisement>> getByApplicationDeadlineLessThanEqual(LocalDate date);
	DataResult<List<JobAdvertisement>> getByIsActiveTrueAndApplicationDeadlineLessThanEqual(LocalDate date);
	DataResult<List<JobAdvertisement>> getByIsActiveTrueAndEmployer_CompanyName(String companyName);
	DataResult<List<JobAdvertisement>> getByEmployerId(int id);
}
