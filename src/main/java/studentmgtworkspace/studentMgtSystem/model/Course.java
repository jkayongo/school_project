package studentmgtworkspace.studentMgtSystem.model;

import jakarta.persistence.*;

@Entity(name = "Course")
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id", updatable = false)
    private Long courseId;
    @Column(name = "title", nullable = false, columnDefinition = "TEXT")
    private String title;
    @Column(name = "course_credit", nullable = false)
    private Integer courseCredit;
    @OneToOne(mappedBy = "course", cascade = CascadeType.ALL)
    private CourseMaterial coursematerial;

    public Course() {

    }

    public Course(String title, Integer courseCredit, CourseMaterial coursematerial) {
        this.title = title;
        this.courseCredit = courseCredit;
        this.coursematerial = coursematerial;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
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

    public CourseMaterial getCoursematerial() {
        return coursematerial;
    }

    public void setCoursematerial(CourseMaterial coursematerial) {
        this.coursematerial = coursematerial;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", title='" + title + '\'' +
                ", courseCredit=" + courseCredit +
                ", coursematerial=" + coursematerial +
                '}';
    }
}
