package entities.employee;

/**
 * 薪资结构
 * Created by cmj on 2015/4/6.
 */
public class SalaryStructure {

    private Integer id;
    private Integer employeeId;
    private Float baseSalary;
    private Float professionalAllowance;
    private Float performanceAllowance;
    private Float cadresAllowance;
    private Float otherAllowance;
    private Float selfPremiumBenefits;

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

    public Float getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Float baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Float getProfessionalAllowance() {
        return professionalAllowance;
    }

    public void setProfessionalAllowance(Float professionalAllowance) {
        this.professionalAllowance = professionalAllowance;
    }

    public Float getPerformanceAllowance() {
        return performanceAllowance;
    }

    public void setPerformanceAllowance(Float performanceAllowance) {
        this.performanceAllowance = performanceAllowance;
    }

    public Float getCadresAllowance() {
        return cadresAllowance;
    }

    public void setCadresAllowance(Float cadresAllowance) {
        this.cadresAllowance = cadresAllowance;
    }

    public Float getOtherAllowance() {
        return otherAllowance;
    }

    public void setOtherAllowance(Float otherAllowance) {
        this.otherAllowance = otherAllowance;
    }

    public Float getSelfPremiumBenefits() {
        return selfPremiumBenefits;
    }

    public void setSelfPremiumBenefits(Float selfPremiumBenefits) {
        this.selfPremiumBenefits = selfPremiumBenefits;
    }
}
