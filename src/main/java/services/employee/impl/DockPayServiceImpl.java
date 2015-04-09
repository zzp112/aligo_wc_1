package services.employee.impl;


import dao.employee.DockPayDao;
import entities.employee.DockPay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import services.employee.IDockPayService;

/**
 * Created by cmj on 2015/4/6.
 */
@Service
@Transactional
public class DockPayServiceImpl implements IDockPayService {

    @Autowired
    private DockPayDao dockPayDao;

    @Override
    public DockPay findDockPayById(Integer employeeId,Integer year,Integer month) {

        return dockPayDao.findDockPayById(employeeId,year,month);

    }

    @Override
    public void addDockPay(DockPay dockPay) {

        dockPayDao.addDockPay(dockPay);

    }

    @Override
    public void updateDockPay(DockPay dockPay) {

        dockPayDao.updateDockPay(dockPay);

    }
}
