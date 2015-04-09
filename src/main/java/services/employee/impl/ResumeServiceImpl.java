package services.employee.impl;


import dao.employee.ResumeDao;
import entities.employee.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import services.employee.IResumeService;

/**
 * Created by cmj on 2015/4/6.
 */
@Service
@Transactional
public class ResumeServiceImpl implements IResumeService {

    @Autowired
    private ResumeDao resumeDao;
    @Override
    public Resume findResumById(Integer employeeId) {

        return resumeDao.findResumById(employeeId);

    }

    @Override
    public void addResume(Resume resume) {

        resumeDao.addResume(resume);

    }

    @Override
    public void updateResume(Resume resume) {

        resumeDao.updateResume(resume);
    }
}
