package services.employee.impl;


import dao.employee.PremiumDao;
import entities.employee.Premium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import services.employee.IPremiumService;

/**
 * Created by cmj on 2015/4/6.
 */
@Service
@Transactional
public class PremiumServiceImpl implements IPremiumService {

    @Autowired
    private PremiumDao premiumDao;

    @Override
    public Premium findPremiumDaoById(Integer employeeId,Integer year,Integer month) {

        return premiumDao.findPremiumDaoById(employeeId,year,month);

    }

    @Override
    public void addPremium(Premium premium) {

        premiumDao.addPremium(premium);

    }

    @Override
    public void updatePremium(Premium premium) {

        premiumDao.updatePremium(premium);

    }
}
