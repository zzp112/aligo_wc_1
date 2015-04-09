package entities.employee;

import java.util.Date;

/**
 * 员工基本信息表
 * Created cmj on 2015/4/6.
 */
public class EmployeeBaseInfo {

    private Integer employeeId;
    private String departMent;
    private String abcId;
    private String bbcId;
    private Date hireTime;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getDepartMent() {
        return departMent;
    }

    public void setDepartMent(String departMent) {
        this.departMent = departMent;
    }

    public String getAbcId() {
        return abcId;
    }

    public void setAbcId(String abcId) {
        this.abcId = abcId;
    }

    public String getBbcId() {
        return bbcId;
    }

    public void setBbcId(String bbcId) {
        this.bbcId = bbcId;
    }

    public Date getHireTime() {
        return hireTime;
    }

    public void setHireTime(Date hireTime) {
        this.hireTime = hireTime;
    }
}
