package dao.employee;


import entities.employee.EmployeeSalaryStructure;
import entities.employee.PayRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2015/4/6.
 */
@Repository
public interface PayRecordDao {

    /**
     * 根据员工号得到薪资发放记录
     * @param employeeId
     * @return
     */
    @Select("select * from payRecord where employeeId=#{employeeId} and year(years)=#{year} and month(years)=#{month}")
    public PayRecord findPayRecodById(@Param("employeeId") Integer employeeId, @Param("year") Integer year, @Param("month") Integer month);

    /**
     * 添加薪资发放记录
     * @param payRecord
     */
    @Insert("insert into payRecord(employeeId,abcIssue,bbcIssue,years) values(#{employeeId},#{abcIssue},#{bbcIssue},#{years})")
    public void addPayRecord(PayRecord payRecord);

    /**
     * 更新薪资发放记录
     * @param payRecord
     */
    @Update("update payRecord set employeeId=#{employeeId},abcIssue=#{abcIssue},bbcIssue=#{bbcIssue},years=#{years} where id=#{id}")
    public void updatePayRecord(PayRecord payRecord);

    /**
     * 根据年月查询月工资
     * @param year
     * @param month
     * @return
     */
    @Select("select * from employeeInfo,employeeBaseInfo,salaryStructure,payRecord where employeeInfo.employeeId=employeeBaseInfo.employeeId and employeeBaseInfo.employeeId=salaryStructure.employeeId and salaryStructure.employeeId=payRecord.employeeId and year(years)=#{year} and month(years)=#{month}")
    public List<EmployeeSalaryStructure> findemployeesalaryByDate(@Param("year") int year, @Param("month") int month);
}
