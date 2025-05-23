package studentmgtworkspace.studentMgtSystem.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import studentmgtworkspace.studentMgtSystem.dto.StudentDto;
import studentmgtworkspace.studentMgtSystem.service.StudentService;

@RestController
@RequestMapping(path = "/stdmgtsys")
public class StudentController {
    private StudentService studentService;
    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping(path = "/save/student")
    public ResponseEntity<?> saveStudent(@RequestBody StudentDto studentDto){
    try{
        StudentDto student = studentService.saveStudent(studentDto);
        return new ResponseEntity<>(student, HttpStatus.OK);

    }catch(Exception exception){
        //log the error
        logger.error("Cannot save a student: {}", exception.getMessage(), exception);
        //return a response back to the api caller like postman or frontend.
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                body("Cannot save a student" + exception.getMessage());
    }
    }
}
