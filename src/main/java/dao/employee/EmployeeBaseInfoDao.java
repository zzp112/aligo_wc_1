package dao.employee;


import entities.employee.EmployeeBaseInfo;
import entities.employee.EmployeeSalaryStructure;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cmj on 2015/4/6.
 */
@Repository
public interface EmployeeBaseInfoDao {

    /**
     * 获取所有员工基本信息
     * @return
     */
    @Select("select * from employeeBaseInfo")
    public List<EmployeeBaseInfo> findAllEmployeeBaseInfo();


    /**
     * 根据员工号获得员工基本信息
     * @param employeeId
     * @return
     */
    @Select("select * from employeeBaseInfo where employeeId=#{employeeId}")
    public EmployeeBaseInfo findEmployeeBaseInfoById(Integer employeeId);


    /**
     * 添加员工基本信息
     * @param employeeBaseInfo
     */
    @Insert("insert into employeeBaseInfo values(#{employeeId},#{departMent},#{abcId},#{bbcId},#{hireTime})")
    public void addEmployeeBaseInfo(EmployeeBaseInfo employeeBaseInfo);

    /**
     * 更新员工基本信息
     * @param employeeBaseInfo
     */
    @Update("update employeeBaseInfo set departMent=#{departMent},abcId=#{abcId},bbcId=#{bbcId},hireTime=#{hireTime} where employeeId=#{employeeId}")
    public void updateEmployeeBaseInfo(EmployeeBaseInfo employeeBaseInfo);

    /**
     * 联合查询
     * @return
     */
    @Select("select * from employeeInfo,employeeBaseInfo,salaryStructure where employeeInfo.employeeId=employeeBaseInfo.employeeId and employeeBaseInfo.employeeId=salaryStructure.employeeId")
    public List<EmployeeSalaryStructure> findemployeesalary();

    /**
     * 联合查询
     * @return
     */
    @Select("select * from employeeInfo,employeeBaseInfo,salaryStructure where employeeInfo.employeeId=employeeBaseInfo.employeeId and employeeBaseInfo.employeeId=salaryStructure.employeeId and employeeBaseInfo.employeeId=#{employeeId}")
    public List<EmployeeSalaryStructure> findemployeesalaryById(Integer employeeId);





}
