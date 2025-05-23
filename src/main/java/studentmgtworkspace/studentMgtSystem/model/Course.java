package studentmgtworkspace.studentMgtSystem.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Course")
@Table(name = "courses_offered")
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
    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id")
    private Teacher teacher;
    @ManyToMany(mappedBy = "courses")
    private List<Student> students = new ArrayList<>();

    public Course() {

    }

    public Course(String title, Integer courseCredit, CourseMaterial coursematerial, Teacher teacher, List<Student> students) {
        this.title = title;
        this.courseCredit = courseCredit;
        this.coursematerial = coursematerial;
        this.teacher = teacher;
        this.students = students;
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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", title='" + title + '\'' +
                ", courseCredit=" + courseCredit +
                ", coursematerial=" + coursematerial +
                ", teacher=" + teacher +
                ", students=" + students +
                '}';
    }
}
