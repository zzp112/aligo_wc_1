package entities.employee;

import java.util.Date;

/**
 * 薪资发放记录实体类
 * Created by cmj on 2015/4/6.
 */
public class PayRecord {

    private  Integer id;
    private  Integer employeeId;
    private  Float abcIssue;
    private  Float bbcIssue;
    private  Date  years;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Float getAbcIssue() {
        return abcIssue;
    }

    public void setAbcIssue(Float abcIssue) {
        this.abcIssue = abcIssue;
    }

    public Float getBbcIssue() {
        return bbcIssue;
    }

    public void setBbcIssue(Float bbcIssue) {
        this.bbcIssue = bbcIssue;
    }

    public Date getYears() {
        return years;
    }

    public void setYears(Date years) {
        this.years = years;
    }
}
