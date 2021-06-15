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

import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Experience;

@RestController
@RequestMapping("/api/jobExperiences")
@CrossOrigin
public class ExperiencesController {
	
	private ExperienceService experienceService;
	
	@Autowired
	public ExperiencesController(ExperienceService experienceService) {
		super();
		this.experienceService = experienceService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Experience>> getAll(){
		return this.experienceService.getAll();
	}
	
    @PostMapping("/add")
    public Result add(@Valid @RequestBody Experience experience){
        return this.experienceService.add(experience);
    }
    
	@GetMapping("/getByJobSeekerIdOrderByDateOfEndASC")
	public DataResult<List<Experience>> getByJobSeekerIdOrderByDateOfEndASC(int jobSeekerId){
		return this.experienceService.getByJobSeekerIdOrderByDateOfEndASC(jobSeekerId);
	}
	
	@GetMapping("/getByJobSeekerIdOrderByDateOfEndDESC")
	public DataResult<List<Experience>> getByJobSeekerIdOrderByDateOfEndDESC(int jobSeekerId){
		return this.experienceService.getByJobSeekerIdOrderByDateOfEndDESC(jobSeekerId);
	}

}