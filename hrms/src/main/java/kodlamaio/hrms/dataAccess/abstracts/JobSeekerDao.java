package kodlamaio.hrms.dataAccess.abstracts;

import com.google.common.base.Optional;

import kodlamaio.hrms.entities.concretes.JobSeeker;

public interface JobSeekerDao extends UserDao<JobSeeker>{
	Optional<JobSeeker> findByNationalIdentity(String nationalIdentity);
}