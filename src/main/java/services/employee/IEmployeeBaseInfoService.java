package services.employee;



import entities.employee.EmployeeBaseInfo;
import entities.employee.EmployeeSalaryStructure;

import java.util.List;

/**
 * Created by cmj on 2015/4/6.
 */
public interface IEmployeeBaseInfoService {

    /**
     * 获取所有员工基本信息
     * @return
     */
    public List<EmployeeBaseInfo> findAllEmployeeBaseInfo();


    /**
     * 根据员工号获得员工基本信息
     * @param employeeId
     * @return
     */
    public EmployeeBaseInfo findEmployeeBaseInfoById(Integer employeeId);


    /**
     * 添加员工基本信息
     * @param employeeBaseInfo
     */
    public void addEmployeeBaseInfo(EmployeeBaseInfo employeeBaseInfo);

    /**
     * 更新员工基本信息
     * @param employeeBaseInfo
     */
    public void updateEmployeeBaseInfo(EmployeeBaseInfo employeeBaseInfo);


    /**
     * 联合查询
     * @return
     */
    public List<EmployeeSalaryStructure> findemployeesalary();

    /**
     * 联合查询
     * @return
     */
    public List<EmployeeSalaryStructure> findemployeesalaryById(Integer employeeId);
}
