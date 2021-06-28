package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeekerPhoto;

public interface JobSeekerPhotoService {
	Result add(MultipartFile file, JobSeekerPhoto image);
	Result addAll(List<JobSeekerPhoto> images); //cv
	DataResult<List<JobSeekerPhoto>> getByJobSeekerId(int jobSeekerId);
}
