package services;

import entities.StuCou;
import entities.StuCouSearchHelper;

import java.util.List;

/**
 * Created by Administrator on 2015/4/4.
 */
public interface IStuCouService {

    /**根据id查找学生选课记录*/
    public StuCou loadStuCouByStuCouId(Integer stuCouId);

    /**
     * 加载学生选课信息
     * @return 选课信息列表
     * */
    public List<StuCou> loadStuCus();



    public List<StuCou> findByParam(StuCouSearchHelper stuCouSearchHelper);
    /**
     * 根据课程ID查找选课信息
     * @return 选课信息列表
     * */
    public List<StuCou> loadStuCouByCouId(Integer courseId);

    /**
     * 根据学生查找选课信息
     * @return 选课信息列表
     * */
    public List<StuCou> loadStuCouByStuId(Integer studentId);

    /**
     * 根据日期范围查找选课信息
     * @Param beginDate 起始日期
     * @Param endDate 结束日期
     * @return 选课信息列表
     * */
    public List<StuCou> loadStuCouByDateScope(String beginDate,String endDate);

    /**
     * 根据月份查找选课信息
     * @Param yearAndMonth 需要查询的月份
     * @return 选课信息列表
     * */
    public List<StuCou> loadStuCouByDate(String yearAndMonth);

    public List<StuCou> loadStuCouByDate(String courseDate, String courseDate2);

    /**
     * 更新选课信息
     * */
    public void updateStuCou(StuCou stuCou);

    /**
     * 删除选课信息
     * */
    public void deleteStuCou(Integer id);

    /**
     * 添加选课信息
     * */
    public void addStuCou(StuCou stuCou);
}
