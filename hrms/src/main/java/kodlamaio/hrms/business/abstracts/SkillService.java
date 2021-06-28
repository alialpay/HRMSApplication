package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Skill;

public interface SkillService {
	Result add(Skill skill);
	Result addAll(List<Skill> skill); //cv
	DataResult<List<Skill>> getAll();
	DataResult<List<Skill>> getByJobSeekerId(int jobSeekerId);
}