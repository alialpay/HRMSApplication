package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobSeekerPhoto;

public interface JobSeekerPhotoDao extends JpaRepository<JobSeekerPhoto, Integer>{
	
	List<JobSeekerPhoto> getByJobSeekerId(int jobSeekerId);
}
