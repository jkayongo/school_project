package studentmgtworkspace.studentMgtSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import studentmgtworkspace.studentMgtSystem.model.Student;
@Repository
public interface StudentDao extends JpaRepository<Student, Long> {

}
