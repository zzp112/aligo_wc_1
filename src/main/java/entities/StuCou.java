package entities;

/**
 * Created by Administrator on 2015/4/4.
 */
public class StuCou {

    private int id;
    private int stationId;
    private String stationAddress;
    private int studentId;
    private String studentName;
    private String courseName;
    private int courseCount;
    private int costByOne;
    private int costTotal;
    private String courseDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    public String getStationAddress() {
        return stationAddress;
    }

    public void setStationAddress(String stationAddress) {
        this.stationAddress = stationAddress;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseCount() {
        return courseCount;
    }

    public void setCourseCount(int courseCount) {
        this.courseCount = courseCount;
    }

    public int getCostByOne() {
        return costByOne;
    }

    public void setCostByOne(int costByOne) {
        this.costByOne = costByOne;
    }

    public int getCostTotal() {
        return courseCount * costByOne;
    }

    public void setCostTotal(int costTotal) {
        this.costTotal = costTotal;
    }

    public String getCourseDate() {
        return courseDate;
    }

    public void setCourseDate(String courseDate) {
        this.courseDate = courseDate;
    }


}
