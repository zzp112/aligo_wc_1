package services.impl;

import dao.StuCouDao;
import entities.StuCou;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import services.IStuCouService;
import entities.StuCouSearchHelper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/4/4.
 */
@Service
@Transactional
public class StuCouService implements IStuCouService {


    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public StuCou loadStuCouByStuCouId(Integer stuCouId) {
        return (StuCou) sqlSession.selectList("stuCou.loadStuCouByStuCouId", stuCouId).get(0);
    }

    @Override
    public List<StuCou> loadStuCus() {
        return sqlSession.selectList("stuCou.loadStuCou");
    }

    @Override
    public List<StuCou> findByParam(StuCouSearchHelper stuCouSearchHelper) {
        return sqlSession.selectList("stuCou.findByParam", stuCouSearchHelper);
//        return null;
    }

    @Override
    public List<StuCou> loadStuCouByCouId(Integer courseId) {
        return sqlSession.selectList("stuCou.loadStuCouByCouId", courseId);
    }

    @Override
    public List<StuCou> loadStuCouByStuId(Integer studentId) {
        return sqlSession.selectList("stuCou.loadStuCouByStuId", studentId);
    }

    @Override
    public List<StuCou> loadStuCouByDateScope(String beginDate, String endDate) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("beginDate", beginDate);
        param.put("endDate", endDate);
        return sqlSession.selectList("stuCou.loadStuCouByDateScope", param);
    }

    @Override
    public List<StuCou> loadStuCouByDate(String yearAndMonth) {
        return sqlSession.selectList("stuCou.loadStuCouByYearAndMonth", yearAndMonth);
    }

    @Override
    public List<StuCou> loadStuCouByDate(String courseDate, String courseDate2) {
//        return stuCouDao.loadStuCouByDate(courseDate, courseDate2);
        return null;
    }

    @Override
    public void updateStuCou(StuCou stuCou) {
        sqlSession.selectList("stuCou.updateStuCou",stuCou);
    }

    @Override
    public void deleteStuCou(Integer id) {
        sqlSession.selectList("stuCou.deleteStuCou", id);
    }

    @Override
    public void addStuCou(StuCou stuCou) {
        sqlSession.selectList("stuCou.addStuCou", stuCou);
    }
}
