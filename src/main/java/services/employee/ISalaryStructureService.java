package services.employee;


import entities.employee.SalaryStructure;

/**
 * Created by cmj on 2015/4/6.
 */
public interface ISalaryStructureService {

    /**
     * 根据员工号获得薪资结构记录
     * @param employeeId
     * @return
     */
    public SalaryStructure findSalaryStructureById(Integer employeeId);

    /**
     * 添加薪资结构记录
     * @param salaryStructure
     */
    public void addSalaryStructure(SalaryStructure salaryStructure);

    /**
     * 更新薪资结构记录
     * @param salaryStructure
     */
    public void updateSalaryStructure(SalaryStructure salaryStructure);

}
