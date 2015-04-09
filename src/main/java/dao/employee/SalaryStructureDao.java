package dao.employee;

import entities.employee.SalaryStructure;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * Created by cmj on 2015/4/6.
 */
@Repository
public interface SalaryStructureDao {

    /**
     * 根据员工号获得薪资结构记录
     * @param employeeId
     * @return
     */
    @Select("select * from salaryStructure where employeeId=#{employeeId}")
    public SalaryStructure findSalaryStructureById(Integer employeeId);

    /**
     * 添加薪资结构记录
     * @param salaryStructure
     */
    @Insert("insert into salaryStructure(employeeId,baseSalary,professionalAllowance,performanceAllowance,cadresAllowance,otherAllowance,selfPremiumBenefits) values(#{employeeId},#{baseSalary},#{professionalAllowance},#{performanceAllowance},#{cadresAllowance},#{otherAllowance},#{selfPremiumBenefits})")
    public void addSalaryStructure(SalaryStructure salaryStructure);

    /**
     * 更新薪资结构记录
     * @param salaryStructure
     */
    @Update("update salaryStructure set employeeId=#{employeeId},baseSalary=#{baseSalary},professionalAllowance=#{professionalAllowance},performanceAllowance=#{performanceAllowance},cadresAllowance=#{cadresAllowance},otherAllowance=#{otherAllowance},selfPremiumBenefits=#{selfPremiumBenefits} where id=#{id}")
    public void updateSalaryStructure(SalaryStructure salaryStructure);


}
