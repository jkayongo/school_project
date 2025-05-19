package studentmgtworkspace.studentMgtSystem.dto;

import java.util.List;

public class TeacherDto {
    private String firstName;
    private String lastName;
    private List<CourseDto> courses;

    public TeacherDto() {

    }

    public TeacherDto(String firstName, String lastName, List<CourseDto> courses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.courses = courses;
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

    public List<CourseDto> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseDto> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "TeacherDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", courses=" + courses +
                '}';
    }
}
