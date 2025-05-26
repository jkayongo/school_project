package studentmgtworkspace.studentMgtSystem.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import studentmgtworkspace.studentMgtSystem.dto.StudentDto;
import studentmgtworkspace.studentMgtSystem.service.StudentService;

import java.util.List;

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
    @GetMapping(path = "/getStudents")
    public ResponseEntity<?> getStudents(){
        try{
            List<StudentDto> studentDtos = studentService.getStudents();
            return new ResponseEntity<>(studentDtos, HttpStatus.OK);
        }catch(Exception exception){
            logger.error("Failed to retrieve students: {} ", exception.getMessage() + exception);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Failed to retrieve students " + exception.getMessage());
        }
    }
    @PutMapping(path = "/update/student/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable Long id, @RequestBody StudentDto studentDto){
        try{
            studentService.updateStudentById(id, studentDto);
            return new ResponseEntity<>("Student data updated successfully", HttpStatus.OK);
        }catch(Exception exception){
            logger.error("Ooops failed to update student data: {} ", exception.getMessage(), exception);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Ooops failed to update student data,something went wrong on our side." + exception.getMessage());
        }
    }
    @DeleteMapping(path = "/delete/student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        try{
            studentService.deleteStudent(id);
            return new ResponseEntity<>("You have successfully deleted a student", HttpStatus.OK);
        } catch (Exception exception) {
            logger.error("Ooops,failed to delete a student: {}", exception.getMessage(), exception);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Ooops,failed to delete a student " + exception.getMessage());
        }
    }
}
