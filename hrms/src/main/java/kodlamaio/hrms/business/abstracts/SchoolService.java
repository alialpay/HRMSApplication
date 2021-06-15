package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SchoolInfo;

public interface SchoolService {
	Result add(SchoolInfo school);
	DataResult<List<SchoolInfo>> getAll();
	DataResult<List<SchoolInfo>> getByJobSeekerIdOrderByGraduationDateDESC(int jobSeekerId);
}
