package studentmgtworkspace.studentMgtSystem.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import studentmgtworkspace.studentMgtSystem.dto.CourseDto;
import studentmgtworkspace.studentMgtSystem.model.Course;
import studentmgtworkspace.studentMgtSystem.service.CourseService;



@RestController
@RequestMapping(path = "/studentmgtsys")
public class CourseController {
    private final CourseService courseService;
    private static final Logger logger = LoggerFactory.getLogger(CourseController.class);

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping(path = "/saveCourse/saveCourseMaterial")
    public ResponseEntity<?> saveCourseWithCourseMaterial(@RequestBody CourseDto courseDto) {
        try {
            Course course = courseService.saveCourseWithCourseMaterial(courseDto);
            //converting course into course dto
            CourseDto courseDtoResponse = new CourseDto(course);
            return new ResponseEntity<>(courseDtoResponse, HttpStatus.OK);
        } catch (Exception exception) {
            logger.error("Oops something went wrong: {}", exception.getMessage(), exception);
            return ResponseEntity.
                    status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Failed to save course and course material." + exception.getMessage());
        }

    }
}
