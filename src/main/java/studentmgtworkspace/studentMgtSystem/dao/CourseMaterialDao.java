package studentmgtworkspace.studentMgtSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import studentmgtworkspace.studentMgtSystem.model.CourseMaterial;
@Repository
public interface CourseMaterialDao extends JpaRepository<CourseMaterial, Long> {

}
