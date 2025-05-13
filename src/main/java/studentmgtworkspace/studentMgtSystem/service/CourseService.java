package studentmgtworkspace.studentMgtSystem.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import studentmgtworkspace.studentMgtSystem.dao.CourseDao;
import studentmgtworkspace.studentMgtSystem.dao.CourseMaterialDao;
import studentmgtworkspace.studentMgtSystem.dto.CourseDto;
import studentmgtworkspace.studentMgtSystem.model.Course;
import studentmgtworkspace.studentMgtSystem.model.CourseMaterial;


@Service
public class CourseService{
    private final CourseDao courseDao;
    private final CourseMaterialDao courseMaterialDao;

    public CourseService(CourseDao courseDao, CourseMaterialDao courseMaterialDao) {
        this.courseDao = courseDao;
        this.courseMaterialDao = courseMaterialDao;
    }

    @Transactional
    public Course saveCourseWithCourseMaterial(CourseDto courseDto){
        //Create a course object
        Course course = new Course();
        course.setTitle(courseDto.getTitle());
        course.setCourseCredit(courseDto.getCourseCredit());
        //Create a CourseMaterial
        CourseMaterial courseMaterial = new CourseMaterial();
        courseMaterial.setUrl(courseDto.getCourseMaterialDto().getUrl());
        //set the course that this material belongs to
        courseMaterial.setCourse(course);
        //assign course material to a course
        course.setCoursematerial(courseMaterial);
        //save the course which shall save the associate course material
        return courseDao.save(course);
    }
}
