package studentmgtworkspace.studentMgtSystem.dto;


import studentmgtworkspace.studentMgtSystem.model.Course;
import studentmgtworkspace.studentMgtSystem.model.Teacher;

public class CourseDto {
    private String title;
    private Integer courseCredit;
    private CourseMaterialDto courseMaterialDto;

    public CourseDto() {

    }

    public CourseDto(String title, Integer courseCredit, CourseMaterialDto courseMaterialDto) {
        this.title = title;
        this.courseCredit = courseCredit;
        this.courseMaterialDto = courseMaterialDto;
    }

    public CourseDto(Course course){
        this.title = course.getTitle();
        this.courseCredit = course.getCourseCredit();
        this.courseMaterialDto = new CourseMaterialDto(course.getCoursematerial().getUrl());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(Integer courseCredit) {
        this.courseCredit = courseCredit;
    }

    public CourseMaterialDto getCourseMaterialDto() {
        return courseMaterialDto;
    }

    public void setCourseMaterialDto(CourseMaterialDto courseMaterialDto) {
        this.courseMaterialDto = courseMaterialDto;
    }

    @Override
    public String toString() {
        return "CourseDto{" +
                "title='" + title + '\'' +
                ", courseCredit=" + courseCredit +
                '}';
    }
}
