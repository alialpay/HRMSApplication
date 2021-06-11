package kodlamaio.hrms.api.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("api/jobAdvertisements")
public class JobAdvertisementsController {

	private JobAdvertisementService jobAdvertisementService;

	@Autowired 
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobAdvertisement>> getAll(){
		return this.jobAdvertisementService.getAll();
	}
	
    @PostMapping("/add")
    public Result add(@RequestBody JobAdvertisement jobAdvertisement){
        return this.jobAdvertisementService.add(jobAdvertisement);
    }
    
    @GetMapping("/getByIsActiveTrue")
    public DataResult<List<JobAdvertisement>> getByIsActiveTrue() {
        return this.jobAdvertisementService.getByIsActiveTrue();
    }
    
    @GetMapping("/getByApplicationDeadline")
    public DataResult<List<JobAdvertisement>> getByApplicationDeadline(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return this.jobAdvertisementService.getByApplicationDeadlineLessThanEqual(date);
    }
    
    @GetMapping("/getByActiveAndApplicationDeadline")
    public DataResult<List<JobAdvertisement>> getByIsActiveTrueAndApplicationDeadlineLessThanEqual(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return this.jobAdvertisementService.getByIsActiveTrueAndApplicationDeadlineLessThanEqual(date);
    }
    
    @GetMapping("/getByIsActiveAndCompanyName")
    public DataResult<List<JobAdvertisement>> getByIsActiveAndEmployer_CompanyName(@RequestParam String companyName) {
        return this.jobAdvertisementService.getByIsActiveTrueAndEmployer_CompanyName(companyName);
    }
    
    @GetMapping("/getByEmployer")
    public DataResult<List<JobAdvertisement>> getByEmployer(@RequestParam int id) {
        return this.jobAdvertisementService.getByEmployerId(id);
    }
    
    @GetMapping("/changeStatus")
    public DataResult<JobAdvertisement> changeStatus(@RequestParam int employerId,@RequestParam int advertisementId,@RequestParam boolean status) {
        return this.jobAdvertisementService.changeStatus(employerId,advertisementId,status);
    }
	
}
