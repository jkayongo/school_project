package studentmgtworkspace.studentMgtSystem.dto;

public class CourseMaterialDto {
    private String url;

    public CourseMaterialDto() {

    }

    public CourseMaterialDto(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "CourseMaterialDto{" +
                "url='" + url + '\'' +
                '}';
    }
}
