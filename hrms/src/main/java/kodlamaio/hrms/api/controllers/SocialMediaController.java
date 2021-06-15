package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SocialMediaService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SocialMedia;

@RestController
@RequestMapping("/api/socialMedia")
@CrossOrigin
public class SocialMediaController {
	
	private SocialMediaService socialMediaService;

	@Autowired
	public SocialMediaController(SocialMediaService socialMediaService) {
		super();
		this.socialMediaService = socialMediaService;
	};
	
	@GetMapping("/getall")
	public DataResult<List<SocialMedia>> getAll(){
		return this.socialMediaService.getAll();
	}
	
	@GetMapping("/getByJobSeeker")
	public DataResult<List<SocialMedia>> getByJobSeekerId(int jobSeekerId){
		return this.socialMediaService.getByJobSeekerId(jobSeekerId);
	}
	
    @PostMapping("/add")
    public Result add(@Valid @RequestBody SocialMedia socialMedia){
        return this.socialMediaService.add(socialMedia);
    }
}
