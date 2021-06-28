package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.JobSeekerPhotoService;
import kodlamaio.hrms.core.utilities.helpers.cloudinary.CloudinaryService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerPhotoDao;
import kodlamaio.hrms.entities.concretes.JobSeekerPhoto;

@Service
public class JobSeekerPhotoManager implements JobSeekerPhotoService {
	private JobSeekerPhotoDao imageDao;
	private CloudinaryService cloudinaryService;
	
	@Autowired
	public JobSeekerPhotoManager(JobSeekerPhotoDao imageDao,CloudinaryService cloudinaryService) {
		super();
		this.imageDao = imageDao;
		this.cloudinaryService = cloudinaryService;
	}

	
	@Override
	public Result add(MultipartFile file, JobSeekerPhoto image) {
		Map<String,String> getImage = (Map<String,String>)cloudinaryService.upload(file).getData();
		image.setPath(getImage.get("url"));
		image.setUploadedAt(LocalDate.now());
		var result = this.imageDao.save(image);
		if(result != null) {
			return new SuccessResult("Başarılı");
		}
		return new ErrorResult("İşlem yapılamıyor");
	}
	
	@Override
	public DataResult<List<JobSeekerPhoto>> getByJobSeekerId(int jobSeekerId) {
		var result =  this.imageDao.getByJobSeekerId(jobSeekerId);
		if (result != null) {
			return new SuccessDataResult<List<JobSeekerPhoto>>(this.imageDao.getByJobSeekerId(jobSeekerId),"Başarılı");
		}
		return new ErrorDataResult<List<JobSeekerPhoto>>("İşlem yapılamıyor");
	}


	@Override
	public Result addAll(List<JobSeekerPhoto> images) {
		  imageDao.saveAll(images);
	      return new SuccessResult("başarılı");
	}
}