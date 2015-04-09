package services.employee;



import entities.employee.EmployeeInfo;

import java.util.List;

/**
 * Created by cmj on 2015/4/6.
 */
public interface IEmployeeInfoService {

    /**
     * 获取所有员工信息记录
     * @return
     */
    public List<EmployeeInfo> findAllEmployeeInfo();

    /**
     * 根据员工id查询员工信息
     * @param employeeId
     * @return
     */
    public EmployeeInfo findEmployeeInfoById(Integer employeeId);

    /**
     * 添加一个员工信息记录
     * @param employeeInfo
     */
    public void addEmployeeInfo(EmployeeInfo employeeInfo);

    /**
     * 修改员工记录
     * @param employeeInfo
     */
    public void updateEmployeeInfo(EmployeeInfo employeeInfo);


    /**
     * 查找没有录入员工基础信息的员工号
     * @return
     */
    public  List<Integer>  finEmployeeId();
}
