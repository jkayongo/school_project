package studentmgtworkspace.studentMgtSystem.dto;

import studentmgtworkspace.studentMgtSystem.model.Guardian;

import java.util.List;

public class StudentDto {
    private String firstName;
    private String lastName;
    private String email;
    private GuardianDto guardianDto;
    private List<CourseDto> courseDtos;

    public StudentDto() {

    }

    public StudentDto(String firstName, String lastName, String email, GuardianDto guardianDto, List<CourseDto> courseDtos) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.guardianDto = guardianDto;
        this.courseDtos = courseDtos;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public GuardianDto getGuardianDto() {
        return guardianDto;
    }

    public void setGuardianDto(GuardianDto guardianDto) {
        this.guardianDto = guardianDto;
    }

    public List<CourseDto> getCourseDtos() {
        return courseDtos;
    }

    public void setCourseDtos(List<CourseDto> courseDtos) {
        this.courseDtos = courseDtos;
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", guardianDto=" + guardianDto +
                ", courseDtos=" + courseDtos +
                '}';
    }
}
