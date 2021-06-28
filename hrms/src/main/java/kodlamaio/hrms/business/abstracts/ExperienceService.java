package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Experience;

public interface ExperienceService {
	Result add(Experience experience);
	Result addAll(List<Experience> experiences); //cv
	DataResult<List<Experience>> getAll();
	DataResult<List<Experience>> getByJobSeekerIdOrderByDateOfEndASC(int jobSeeker_id);
	DataResult<List<Experience>> getByJobSeekerIdOrderByDateOfEndDESC(int jobSeeker_id);
}
