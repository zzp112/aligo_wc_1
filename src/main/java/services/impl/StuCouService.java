package services.impl;

import dao.StuCouDao;
import entities.StuCou;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import services.IStuCouService;

import java.util.List;

/**
 * Created by Administrator on 2015/4/4.
 */
@Service
@Transactional
public class StuCouService implements IStuCouService {
    @Autowired
    private StuCouDao stuCouDao;

    @Override
    public StuCou loadStuCouByStuCouId(Integer stuCouId) {
        return stuCouDao.loadStuCouByStuCouId(stuCouId);
    }

    @Override
    public List<StuCou> loadStuCus() {
        return stuCouDao.loadStuCou();
    }

    @Override
    public List<StuCou> loadStuCouByCouId(Integer courseId) {
        return stuCouDao.loadStuCouByCouId(courseId);
    }

    @Override
    public List<StuCou> loadStuCouByStuId(Integer studentId) {
        return stuCouDao.loadStuCouByStuId(studentId);
    }

    @Override
    public List<StuCou> loadStuCouByDate(String courseDate, String courseDate2) {
        return stuCouDao.loadStuCouByDate(courseDate,courseDate2);
    }

    @Override
    public void updateStuCou(StuCou stuCou) {
        stuCouDao.updateStuCou(stuCou);
    }

    @Override
    public void deleteStuCou(Integer id) {
        stuCouDao.deleteStuCou(id);
    }

    @Override
    public void addStuCou(StuCou stuCou) {
        stuCouDao.addStuCou(stuCou);
    }
}
