package dao.employee;


import entities.employee.Premium;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * Created by cmj on 2015/4/6.
 */
@Repository
public interface PremiumDao {

    /**
     * 根据员工号查找险金记录
     * @param employeeId
     * @return
     */
    @Select("select * from premium where employeeId=#{employeeId} and year(years)=#{year} and month(years)=#{month}")
    public Premium findPremiumDaoById(@Param("employeeId") Integer employeeId, @Param("year") Integer year, @Param("month") Integer month);

    /**
     * 添加险金记录
     * @param premium
     */
    @Insert("insert into premium(employeeId,companyPremium,selfPremium,cashIncome,years) values(#{employeeId},#{companyPremium},#{selfPremium},#{cashIncome},#{years})")
    public void addPremium(Premium premium);

    /**
     * 更新险金记录
     * @param premium
     */
    @Update("update premium set companyPremium=#{companyPremium},selfPremium=#{selfPremium},cashIncome=#{cashIncome},years=#{years} where id=#{id}")
    public void updatePremium(Premium premium);



}
