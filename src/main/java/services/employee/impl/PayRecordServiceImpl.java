package services.employee.impl;


import dao.employee.PayRecordDao;
import entities.employee.EmployeeSalaryStructure;
import entities.employee.PayRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import services.employee.IPayRecordService;

import java.util.List;

/**
 * Created by cmj on 2015/4/6.
 */
@Service
@Transactional
public class PayRecordServiceImpl implements IPayRecordService {

    @Autowired
    private PayRecordDao payRecordDao;

    @Override
    public PayRecord findPayRecodById(Integer employeeId,Integer year,Integer month) {

        return payRecordDao.findPayRecodById(employeeId,year,month);

    }

    @Override
    public void addPayRecord(PayRecord payRecord) {

        payRecordDao.addPayRecord(payRecord);

    }

    @Override
    public void updatePayRecord(PayRecord payRecord) {

        payRecordDao.updatePayRecord(payRecord);

    }

    @Override
    public List<EmployeeSalaryStructure> findemployeesalaryByDate(int year, int month) {
        return payRecordDao.findemployeesalaryByDate(year, month);
    }
}
