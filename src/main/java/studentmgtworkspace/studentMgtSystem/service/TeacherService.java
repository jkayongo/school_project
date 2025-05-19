package studentmgtworkspace.studentMgtSystem.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import studentmgtworkspace.studentMgtSystem.dao.CourseDao;
import studentmgtworkspace.studentMgtSystem.dao.TeacherDao;
import studentmgtworkspace.studentMgtSystem.dto.CourseDto;
import studentmgtworkspace.studentMgtSystem.dto.TeacherDto;
import studentmgtworkspace.studentMgtSystem.model.Course;
import studentmgtworkspace.studentMgtSystem.model.Teacher;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {
    private TeacherDao teacherDao;
    private CourseDao courseDao;

    public TeacherService(TeacherDao teacherDao, CourseDao courseDao) {
        this.teacherDao = teacherDao;
        this.courseDao = courseDao;
    }

    @Transactional
    public TeacherDto saveTeacherAndTheirCourses(TeacherDto teacherDto){
       //Create a teacher from dto
        Teacher teacher = new Teacher();
        teacher.setFirstName(teacherDto.getFirstName());
        teacher.setLastName(teacherDto.getLastName());
        //Create a list of course entities
        List<Course> courses = new ArrayList<>();
        for(CourseDto courseDto : teacherDto.getCourses()){
            //looping through dto and converting it to an entity
            Course course = new Course();
            course.setTitle(courseDto.getTitle());
            course.setCourseCredit(courseDto.getCourseCredit());
            //set the owning teacher
            course.setTeacher(teacher);
            courses.add(course);
        }
        // link courses to a teacher
        teacher.setCourses(courses);
        //save a teacher
        Teacher savedTeacher = teacherDao.save(teacher);
        //build a response dto
        TeacherDto responseDto = new TeacherDto();
        responseDto.setFirstName(savedTeacher.getFirstName());
        responseDto.setLastName(savedTeacher.getLastName());
        List<CourseDto> courseDtoList = new ArrayList<>();
        for(Course savedCourse : savedTeacher.getCourses()){
            CourseDto cd = new CourseDto();
            cd.setTitle(savedCourse.getTitle());
            cd.setCourseCredit(savedCourse.getCourseCredit());
            courseDtoList.add(cd);
        }
        responseDto.setCourses(courseDtoList);
        return responseDto;
    }

}
