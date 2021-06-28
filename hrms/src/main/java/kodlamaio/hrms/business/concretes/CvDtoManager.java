package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CvDtoService;
import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.business.abstracts.JobSeekerPhotoService;
import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.business.abstracts.SkillService;
import kodlamaio.hrms.business.abstracts.SocialMediaService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SocialMediaDao;
import kodlamaio.hrms.dataAccess.abstracts.ExperienceDao;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerPhotoDao;
import kodlamaio.hrms.dataAccess.abstracts.LanguageDao;
import kodlamaio.hrms.dataAccess.abstracts.SchoolDao;
import kodlamaio.hrms.dataAccess.abstracts.SkillDao;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.dtos.CvDto;

@Service
public class CvDtoManager implements CvDtoService {
	
	private JobSeekerDao jobSeekerDao;
	private SchoolDao schoolDao;
	private SchoolService schoolService;
	private LanguageDao languageDao;
	private LanguageService languageService;
	private SkillDao skillDao;
	private SkillService skillService;
	private SocialMediaDao socialMediaDao;
	private SocialMediaService socialMediaService;
	private ExperienceDao experienceDao;
	private ExperienceService experienceService;
	private JobSeekerPhotoDao jobSeekerPhotoDao;
	private JobSeekerPhotoService jobSeekerPhotoService;
	
	
	@Autowired
	public CvDtoManager(JobSeekerDao jobSeekerDao, SchoolDao schoolDao, SchoolService schoolService,
			LanguageDao languageDao, LanguageService languageService, SkillDao skillDao, SkillService skillService,
			SocialMediaDao socialMediaDao, SocialMediaService socialMediaService, ExperienceDao experienceDao,
			ExperienceService experienceService, JobSeekerPhotoDao jobSeekerPhotoDao,
			JobSeekerPhotoService jobSeekerPhotoService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.schoolDao = schoolDao;
		this.schoolService = schoolService;
		this.languageDao = languageDao;
		this.languageService = languageService;
		this.skillDao = skillDao;
		this.skillService = skillService;
		this.socialMediaDao = socialMediaDao;
		this.socialMediaService = socialMediaService;
		this.experienceDao = experienceDao;
		this.experienceService = experienceService;
		this.jobSeekerPhotoDao = jobSeekerPhotoDao;
		this.jobSeekerPhotoService = jobSeekerPhotoService;
	}

	@Override
	public Result add(CvDto cvDto, int candidateId) {
		JobSeeker jobSeeker = this.jobSeekerDao.findById(candidateId).get();
        cvDto.setJobSeeker(jobSeeker);

        cvDto.getSchools().forEach(schools -> schools.setJobSeeker(jobSeeker));
        schoolService.addAll(cvDto.getSchools());
        
        cvDto.getLanguages().forEach(languages -> languages.setJobSeeker(jobSeeker));
        languageService.addAll(cvDto.getLanguages());
        
        cvDto.getSkills().forEach(skills -> skills.setJobSeeker(jobSeeker));
        skillService.addAll(cvDto.getSkills());
        
        cvDto.getLinks().forEach(links -> links.setJobSeeker(jobSeeker));
        socialMediaService.addAll(cvDto.getLinks());
      
        cvDto.getExperiences().forEach(experiences -> experiences.setJobSeeker(jobSeeker));
        experienceService.addAll(cvDto.getExperiences());
        
        cvDto.getImages().forEach(candidateImage -> candidateImage.setJobSeeker(jobSeeker));
        jobSeekerPhotoService.addAll(cvDto.getImages());
        
        return new SuccessResult("Cv bilgisi başarıyla oluşturuldu");
	}

	@Override
	public DataResult<CvDto> getCVByJobSeeker(int jobSeekerId) {
		CvDto cvDto = new CvDto();
		cvDto.setJobSeeker(this.jobSeekerDao.getById(jobSeekerId));
		cvDto.setSchools(this.schoolDao.getAllByJobSeekerIdOrderByGraduationDate(jobSeekerId));
		cvDto.setLanguages(this.languageDao.getByJobSeekerId(jobSeekerId));
		cvDto.setSkills(this.skillDao.getByJobSeekerId(jobSeekerId));
		cvDto.setLinks(this.socialMediaDao.getByJobSeekerId(jobSeekerId));
		cvDto.setExperiences(this.experienceDao.getAllByJobSeekerIdOrderByDateOfEndDesc(jobSeekerId));
		cvDto.setImages(this.jobSeekerPhotoDao.getByJobSeekerId(jobSeekerId));
		
		return new SuccessDataResult<CvDto>(cvDto);
	}
	
}
