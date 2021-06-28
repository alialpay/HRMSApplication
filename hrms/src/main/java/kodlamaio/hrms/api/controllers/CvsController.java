package kodlamaio.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CvDtoService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.dtos.CvDto;

@RestController
@RequestMapping("/api/cv")
public class CvsController {

	private CvDtoService cvDtoService;

	@Autowired
	public CvsController(CvDtoService cvDtoService) {
		super();
		this.cvDtoService = cvDtoService;
	}
	
	@GetMapping("/getCVByJobSeeker")
	public DataResult<CvDto> getCVByJobseeker(@RequestParam int jobSeekerId){
		return this.cvDtoService.getCVByJobSeeker(jobSeekerId);
	}
	
	@PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody @Valid CvDto cvDto, int jobSeekerId) {
        return ResponseEntity.ok(cvDtoService.add(cvDto,jobSeekerId));
    }
}
