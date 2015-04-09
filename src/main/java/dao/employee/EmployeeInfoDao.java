package dao.employee;


import entities.employee.EmployeeInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cmj on 2015/4/6.
 */
@Repository
public interface EmployeeInfoDao {


    /**
     * 获取所有员工信息记录
     * @return
     */
    @Select("select * from employeeInfo")
    public List<EmployeeInfo> findAllEmployeeInfo();

    /**
     * 根据员工id查询员工信息
     * @param employeeId
     * @return
     */
    @Select("select * from employeeInfo where employeeId=#{employeeId}")
    public EmployeeInfo findEmployeeInfoById(Integer employeeId);

    /**
     * 添加一个员工信息记录
     * @param employeeInfo
     */
    @Insert("INSERT INTO employeeInfo(name,sex,birthday,age,hometownAddress,phone,presentAddress,qq,educationYear,educationSchool,educationCollege,major,marriage,idNumber,jobs,email,emergencyContact,relationship,ecAddress,emergencyContactPhone) VALUES(#{name},#{sex},#{birthday},#{age},#{hometownAddress},#{phone},#{presentAddress},#{qq},#{educationYear},#{educationSchool},#{educationCollege},#{major},#{marriage},#{idNumber},#{jobs},#{email},#{emergencyContact},#{relationship},#{ecAddress},#{emergencyContactPhone})")
    public void addEmployeeInfo(EmployeeInfo employeeInfo);

    /**
     * 修改员工记录
     * @param employeeInfo
     */
    @Update("update employeeInfo set name=#{name},sex=#{sex},birthday=#{birthday},age=#{age},hometownAddress=#{hometownAddress},phone=#{phone},presentAddress=#{presentAddress},qq=#{qq},educationYear=#{educationYear},educationSchool=#{educationSchool},major=#{major},marriage=#{marriage},idNumber=#{idNumber},jobs=#{jobs},email=#{email},emergencyContact=#{emergencyContact},relationship=#{relationship},ecAddress=#{ecAddress},emergencyContactPhone=#{emergencyContactPhone} where employeeId=#{employeeId}")
    public void updateEmployeeInfo(EmployeeInfo employeeInfo);

    /**
     * 查找没有录入员工基础信息的员工号
     * @return
     */
    @Select("SELECT employeeId from employeeInfo WHERE employeeId not in(SELECT employeeId FROM employeeBaseInfo )")
    public  List<Integer>  finEmployeeId();


}
