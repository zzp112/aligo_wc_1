package entities.employee;

import java.util.Date;

/**
 * 险金实体类
 * Created by cmj on 2015/4/6.
 */
public class Premium {

    private  Integer id;
    private Integer employeeId;
    private Float companyPremium;
    private Float selfPremium;
    private Float cashIncome;
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

    public Float getCompanyPremium() {
        return companyPremium;
    }

    public void setCompanyPremium(Float companyPremium) {
        this.companyPremium = companyPremium;
    }

    public Float getSelfPremium() {
        return selfPremium;
    }

    public void setSelfPremium(Float selfPremium) {
        this.selfPremium = selfPremium;
    }

    public Float getCashIncome() {
        return cashIncome;
    }

    public void setCashIncome(Float cashIncome) {
        this.cashIncome = cashIncome;
    }

    public Date getYears() {
        return years;
    }

    public void setYears(Date years) {
        this.years = years;
    }
}
