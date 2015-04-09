package services.employee.impl;


import dao.employee.SalaryStructureDao;
import entities.employee.SalaryStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import services.employee.ISalaryStructureService;

/**
 * Created by cmj on 2015/4/6.
 */
@Service
@Transactional
public class SalaryStructureServiceImpl implements ISalaryStructureService {

    @Autowired
    private SalaryStructureDao salaryStructureDao;

    @Override
    public SalaryStructure findSalaryStructureById(Integer employeeId) {

        return salaryStructureDao.findSalaryStructureById(employeeId);

    }

    @Override
    public void addSalaryStructure(SalaryStructure salaryStructure) {

        salaryStructureDao.addSalaryStructure(salaryStructure);

    }

    @Override
    public void updateSalaryStructure(SalaryStructure salaryStructure) {

        salaryStructureDao.updateSalaryStructure(salaryStructure);

    }
}
