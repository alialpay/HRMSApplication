package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CoverLetter;

public interface CoverLetterDao extends JpaRepository<CoverLetter,Integer> {
	List<CoverLetter> getByJobSeekerId(int jobSeekerId);
	List<CoverLetter> deleteByJobSeekerId(int jobSeekerId);
}