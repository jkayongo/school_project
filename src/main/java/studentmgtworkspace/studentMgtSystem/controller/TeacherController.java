package studentmgtworkspace.studentMgtSystem.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import studentmgtworkspace.studentMgtSystem.dto.TeacherDto;
import studentmgtworkspace.studentMgtSystem.service.TeacherService;

@RestController
@RequestMapping(path = "/stdmgtsys")
public class TeacherController {
    private TeacherService teacherService;
    private static final Logger logger = LoggerFactory.getLogger(TeacherController.class);

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping(path = "/teacher")
    public ResponseEntity<?> saveTeacher(@RequestBody TeacherDto teacherDto){
        try{
            TeacherDto response = teacherService.saveTeacherAndTheirCourses(teacherDto);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception exception){
            //log the error for developers to investigate.
            logger.error("Cannot save a teacher: {}", exception.getMessage(), exception);
            //return a response back to the api caller(postman or frontend app)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Cannot save a teacher " + exception.getMessage());
        }
    }
}
