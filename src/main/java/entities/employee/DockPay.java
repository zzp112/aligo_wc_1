package entities.employee;

import java.util.Date;

/**
 * 缺勤扣薪实体类
 * Created by cmj on 2015/4/6.
 */
public class DockPay {

    private Integer id;
    private Integer employeeId;
    private Integer absentDay;
    private Float dockPay;
    private Float receivable;
    private Date years;

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

    public Integer getAbsentDay() {
        return absentDay;
    }

    public void setAbsentDay(Integer absentDay) {
        this.absentDay = absentDay;
    }

    public Float getDockPay() {
        return dockPay;
    }

    public void setDockPay(Float dockPay) {
        this.dockPay = dockPay;
    }

    public Float getReceivable() {
        return receivable;
    }

    public void setReceivable(Float receivable) {
        this.receivable = receivable;
    }

    public Date getYears() {
        return years;
    }

    public void setYears(Date years) {
        this.years = years;
    }
}
