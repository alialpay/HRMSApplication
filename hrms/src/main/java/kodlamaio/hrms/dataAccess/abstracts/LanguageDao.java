package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CoverLetter;
import kodlamaio.hrms.entities.concretes.Language;

public interface LanguageDao extends JpaRepository<Language, Integer>{
	 List<Language> getByJobSeekerId(int jobSeekerId);
		List<CoverLetter> deleteByJobSeekerId(int jobSeekerId);
}