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
    public List<StuCou> loadStuCus() {
        return stuCouDao.loadStuCou();
    }
}
