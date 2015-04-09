package dao.employee;


import entities.employee.Resume;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * Created by cmj on 2015/4/6.
 */
@Repository
public interface ResumeDao {

    /**
     * 根据员工id查询员工详细档案
     * @param employeeId
     * @return
     */
    @Select("select * from resume where employeeId=#{employeeId}" )
    public Resume findResumById(Integer employeeId);

    /**
     * 插入一条员工简历记录
     * @param resume
     */
    @Insert("insert into resume values(#{employeeId},#{resume},#{motivation},#{experience},#{leaveCause},#{hrAdvice},#{hrAdviceTime},#{cpAdvice},#{cpAdviceTime})")
    public void addResume(Resume resume);

    /**
     * 更新简历
     * @param resume
     */
    @Update("update resume set resume=#{resume},motivation=#{motivation},experience=#{experience},leaveCause=#{leaveCause},hrAdvice=#{hrAdvice},hrAdviceTime=#{hrAdviceTime},cpAdvice=#{cpAdvice},cpAdviceTime=#{cpAdviceTime} where employeeId=#{employeeId}")
    public void updateResume(Resume resume);

}
