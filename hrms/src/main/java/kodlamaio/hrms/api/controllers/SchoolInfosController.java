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

import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SchoolInfo;

@RestController
@RequestMapping("/api/schoolInfos")
@CrossOrigin
public class SchoolInfosController {
	
	private SchoolService schoolService;

	@Autowired
	public SchoolInfosController(SchoolService schoolService) {
		super();
		this.schoolService = schoolService;
	};
	
	
	@GetMapping("/getall")
	public DataResult<List<SchoolInfo>> getAll(){
		return this.schoolService.getAll();
	}
	
    @PostMapping("/add")
    public Result add(@Valid @RequestBody SchoolInfo school){
        return this.schoolService.add(school);
	}
	
	@GetMapping("/getDESCOrderByGraduationDate")
	public DataResult<List<SchoolInfo>> getDESCOrderByGraduationDate(int jobSeekerId){
		return this.schoolService.getByJobSeekerIdOrderByGraduationDateDESC(jobSeekerId);
	}
    
}