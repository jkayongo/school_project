package studentmgtworkspace.studentMgtSystem.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import studentmgtworkspace.studentMgtSystem.dao.CourseDao;
import studentmgtworkspace.studentMgtSystem.dao.StudentDao;
import studentmgtworkspace.studentMgtSystem.dto.CourseDto;
import studentmgtworkspace.studentMgtSystem.dto.GuardianDto;
import studentmgtworkspace.studentMgtSystem.dto.StudentDto;
import studentmgtworkspace.studentMgtSystem.model.Course;
import studentmgtworkspace.studentMgtSystem.model.Guardian;
import studentmgtworkspace.studentMgtSystem.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentDao studentDao;
    private CourseDao courseDao;

    public StudentService(StudentDao studentDao, CourseDao courseDao) {
        this.studentDao = studentDao;
        this.courseDao = courseDao;
    }

    @Transactional
    public StudentDto saveStudent(StudentDto studentDto){
        //create a student
        Student student = new Student();
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setEmail(studentDto.getEmail());
        //create a guardian
        Guardian guardian = new Guardian();
        guardian.setName(studentDto.getGuardianDto().getName());
        guardian.setEmail(studentDto.getGuardianDto().getEmail());
        guardian.setMobile(studentDto.getGuardianDto().getMobile());
        student.setGuardian(guardian);
        //create a list of courses
        List<Course> courses = new ArrayList<>();
        for(CourseDto courseDto : studentDto.getCourseDtos()){
            Optional<Course> existingCourse = courseDao.findByTitleAndCourseCredit(courseDto.getTitle(), courseDto.getCourseCredit());
            Course course;
            if(existingCourse.isPresent()){
               course = existingCourse.get() ;
            }else{
                course = new Course();
                course.setTitle(courseDto.getTitle());
                course.setCourseCredit(courseDto.getCourseCredit());
            }
            //link a student to this course.This is the many to many part.
            course.getStudents().add(student);
            courses.add(course);
        }
        //set courses on a student
        student.setCourses(courses);
        //save a student
        Student savedStudent = studentDao.save(student);
        //build a response
        StudentDto studentResponse = new StudentDto();
        studentResponse.setFirstName(savedStudent.getFirstName());
        studentResponse.setLastName(savedStudent.getLastName());
        studentResponse.setEmail(savedStudent.getEmail());
        //build a GuardianDto
        GuardianDto guardianDto = new GuardianDto();
        guardianDto.setName(savedStudent.getGuardian().getName());
        guardianDto.setEmail(savedStudent.getGuardian().getEmail());
        guardianDto.setMobile(savedStudent.getGuardian().getMobile());
        studentResponse.setGuardianDto(guardianDto);
        //student courses
        List<CourseDto> courseDtos = new ArrayList<>();
        for(Course studentCourse : savedStudent.getCourses()){
            CourseDto studentCourseDto = new CourseDto();
            studentCourseDto.setTitle(studentCourse.getTitle());
            studentCourseDto.setCourseCredit(studentCourse.getCourseCredit());
            courseDtos.add(studentCourseDto);
        }
        studentResponse.setCourseDtos(courseDtos);
        return studentResponse;
    }
}
