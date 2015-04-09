package services.employee;


import entities.employee.EmployeeSalaryStructure;
import entities.employee.PayRecord;

import java.util.List;

/**
 * Created by cmj on 2015/4/6.
 */
public interface IPayRecordService {

    /**
     * 根据员工号得到薪资发放记录
     * @param employeeId
     * @return
     */
    public PayRecord findPayRecodById(Integer employeeId, Integer year, Integer month);

    /**
     * 添加薪资发放记录
     * @param payRecord
     */
    public void addPayRecord(PayRecord payRecord);

    /**
     * 更新薪资发放记录
     * @param payRecord
     */
    public void updatePayRecord(PayRecord payRecord);


    /**
     * 根据年月查询月工资
     * @param year
     * @param month
     * @return
     */
    public List<EmployeeSalaryStructure> findemployeesalaryByDate(int year, int month);
}
