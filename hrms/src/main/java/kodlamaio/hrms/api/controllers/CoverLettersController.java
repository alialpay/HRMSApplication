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

import kodlamaio.hrms.business.abstracts.CoverLetterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CoverLetter;

@RestController
@RequestMapping("/api/coverLetters")
@CrossOrigin
public class CoverLettersController {
	
	private CoverLetterService coverLetterService;
	
	@Autowired
	public CoverLettersController(CoverLetterService coverLetterService) {
		super();
		this.coverLetterService = coverLetterService;
	};
	
	@GetMapping("/getall")
	public DataResult<List<CoverLetter>> getAll(){
		return this.coverLetterService.getAll();
		}
		
	@GetMapping("/getByJobSeeker")
	public DataResult<List<CoverLetter>> getAll(int jobSeekerId){
		return this.coverLetterService.getByJobSeekerId(jobSeekerId);
		}
		
	@PostMapping("/add")
	public Result add(@Valid @RequestBody CoverLetter coverLetter){
	    return this.coverLetterService.add(coverLetter);
	    }
	
	@PostMapping("/delete")
	public Result delete(@Valid @RequestBody CoverLetter coverLetter){
	    return this.coverLetterService.delete(coverLetter);
	    }
}
