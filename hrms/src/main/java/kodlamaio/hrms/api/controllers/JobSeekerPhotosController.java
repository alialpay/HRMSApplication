package kodlamaio.hrms.api.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.JobSeekerPhotoService;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.concretes.JobSeekerPhoto;

@RestController
@RequestMapping("/api/jobSeekerImages")
@CrossOrigin
public class JobSeekerPhotosController {

	private JobSeekerPhotoService imageService;

	@Autowired
	public JobSeekerPhotosController(JobSeekerPhotoService imageService) {
		super();
		this.imageService = imageService;
	}
	
	@PostMapping(value="/upload")
	public ResponseEntity<?> add(@RequestBody MultipartFile file,@RequestParam int jobSeekerid) throws IOException {
		JobSeekerPhoto image = new JobSeekerPhoto();
		JobSeeker jobSeeker = new JobSeeker();
		jobSeeker.setId(jobSeekerid);
		image.setJobSeeker(jobSeeker);
		
		return ResponseEntity.ok(this.imageService.add(file, image));
	}
    
    @GetMapping("/getByJobSeekerId")
    public ResponseEntity<?> getByJobSeekerId(int id){
        return ResponseEntity.ok(this.imageService.getByJobSeekerId(id));
    }
	
}
