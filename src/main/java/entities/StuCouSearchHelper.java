package entities;

import org.apache.commons.lang.StringUtils;

/**
 * Created by Administrator on 2015/4/8.
 */
public class StuCouSearchHelper {

    private Integer stationId;
    private String stationName;
    private Integer studentId;
    private String studentName;
    private Integer courseId;
    private String courseName;
    private String year;
    private String month;
    private String yearAndMonth;

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getYearAndMonth() {
        if(StringUtils.isNotEmpty(year)&&StringUtils.isNotEmpty(month)){
            return year+"-"+month+"-";
        }
        if(StringUtils.isNotEmpty(year)){
            return year+"";
        }
        if(StringUtils.isNotEmpty(month)){
            return "-"+month+"-";
        }
        return null;
    }

//    public void setYearAndMonth(String yearAndMonth) {
//        this.yearAndMonth = yearAndMonth;
//    }
}
