package kodlamaio.hrms.core.utilities.helpers.cloudinary;



import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;


public interface CloudinaryService {
	DataResult<?> upload(MultipartFile file);
}
