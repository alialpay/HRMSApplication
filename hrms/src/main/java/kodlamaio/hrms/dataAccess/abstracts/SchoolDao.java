package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.SchoolInfo;

@Repository
public interface SchoolDao extends JpaRepository<SchoolInfo, Integer> {
	List<SchoolInfo> getByJobSeekerId(Sort sort, int jobSeekerId);
	List<SchoolInfo> getAllByJobSeekerIdOrderByGraduationDate(int jobSeekerId);
}