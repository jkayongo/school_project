package studentmgtworkspace.studentMgtSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import studentmgtworkspace.studentMgtSystem.model.Teacher;
@Repository
public interface TeacherDao extends JpaRepository<Teacher, Long> {
}
