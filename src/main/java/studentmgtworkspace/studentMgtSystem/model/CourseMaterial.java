package studentmgtworkspace.studentMgtSystem.model;

import jakarta.persistence.*;

@Entity(name = "CourseMaterial")
@Table(name = "course_materials")
public class CourseMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_material_id", updatable = false)
    private Long courseMaterialId;
    @Column(name = "url", nullable = false)
    private String url;
    @OneToOne
    @JoinColumn(name = "course_id", referencedColumnName = "course_id")
    private Course course;

    public CourseMaterial() {

    }

    public CourseMaterial(String url, Course course) {
        this.url = url;
        this.course = course;
    }

    public Long getCourseMaterialId() {
        return courseMaterialId;
    }

    public void setCourseMaterialId(Long courseMaterialId) {
        this.courseMaterialId = courseMaterialId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "CourseMaterial{" +
                "courseMaterialId=" + courseMaterialId +
                ", url='" + url + '\'' +
                ", course=" + course +
                '}';
    }
}
