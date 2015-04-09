package dao.employee;


import entities.employee.DockPay;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * Created by cmj on 2015/4/6.
 */
@Repository
public interface DockPayDao {

    /**
     * 根据员工号获得缺勤扣薪记录
     * @return
     * @param employeeId
     */
    @Select("select * from dockPay where employeeId=#{employeeId} and year(years)=#{year} and month(years)=#{month}")
    public DockPay findDockPayById(@Param("employeeId") Integer employeeId, @Param("year") Integer year, @Param("month") Integer month);

    /**
     * 添加缺勤扣薪记录
     * @param dockPay
     */
    @Insert("insert into dockPay(employeeId,absentDay,dockPay,receivable,years) values(#{employeeId},#{absentDay},#{dockPay},#{receivable},#{years})")
    public void addDockPay(DockPay dockPay);

    /**
     * 更新缺勤扣薪记录
     * @param dockPay
     */
    @Update("update dockPay set employeeId=#{employeeId},absentDay=#{absentDay},dockPay=#{dockPay},receivable=#{receivable},years=#{years} where id=#{id}")
    public void updateDockPay(DockPay dockPay);
}
