package entities.employee;

import java.util.Date;

/**
 * 简历实体类
 * Created by cmj on 2015/4/6.
 */
public class Resume {

    private Integer employeeId;
    private String resume;
    private String motiVation;
    private String experience;
    private String leaveCause;
    private String hrAdvice;
    private Date hrAdviceTime;
    private String cpAdvice;
    private Date cpAdviceTime;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getMotiVation() {
        return motiVation;
    }

    public void setMotiVation(String motiVation) {
        this.motiVation = motiVation;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getLeaveCause() {
        return leaveCause;
    }

    public void setLeaveCause(String leaveCause) {
        this.leaveCause = leaveCause;
    }

    public String getHrAdvice() {
        return hrAdvice;
    }

    public void setHrAdvice(String hrAdvice) {
        this.hrAdvice = hrAdvice;
    }

    public Date getHrAdviceTime() {
        return hrAdviceTime;
    }

    public void setHrAdviceTime(Date hrAdviceTime) {
        this.hrAdviceTime = hrAdviceTime;
    }

    public String getCpAdvice() {
        return cpAdvice;
    }

    public void setCpAdvice(String cpAdvice) {
        this.cpAdvice = cpAdvice;
    }

    public Date getCpAdviceTime() {
        return cpAdviceTime;
    }

    public void setCpAdviceTime(Date cpAdviceTime) {
        this.cpAdviceTime = cpAdviceTime;
    }
}
