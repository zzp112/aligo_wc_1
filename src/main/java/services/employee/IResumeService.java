package services.employee;


import entities.employee.Resume;

/**
 * Created by cmj on 2015/4/6.
 */
public interface IResumeService {

    /**
     * 根据员工id查询员工详细档案
     * @param employeeId
     * @return
     */
    public Resume findResumById(Integer employeeId);

    /**
     * 插入一条员工简历记录
     * @param resume
     */
    public void addResume(Resume resume);

    /**
     * 更新简历
     * @param resume
     */
    public void updateResume(Resume resume);
}
