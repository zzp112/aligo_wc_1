package entities.employee;

import java.util.Date;

/**
 * 员工具体信息类
 * Created by cmj on 2015/4/6.
 */
public class EmployeeInfo {

    private Integer employeeId;
    private String name;
    private String sex;
    private Date birthday;
    private Integer age;
    private String hometownAddress;
    private String phone;
    private String presentAddress;
    private String qq;
    private Integer educationYear;
    private String educationSchool;
    private String educationCollege;
    private String major;
    private String marriage;
    private String idNumber;
    private String jobs;
    private String email;
    private String emergencyContact;
    private String relationship;
    private String ecAddress;
    private String emergencyContactPhone;
    private byte[] photo;
    private String state;


    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHometownAddress() {
        return hometownAddress;
    }

    public void setHometownAddress(String hometownAddress) {
        this.hometownAddress = hometownAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPresentAddress() {
        return presentAddress;
    }

    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public Integer getEducationYear() {
        return educationYear;
    }

    public void setEducationYear(Integer educationYear) {
        this.educationYear = educationYear;
    }

    public String getEducationSchool() {
        return educationSchool;
    }

    public void setEducationSchool(String educationSchool) {
        this.educationSchool = educationSchool;
    }

    public String getEducationCollege() {
        return educationCollege;
    }

    public void setEducationCollege(String educationCollege) {
        this.educationCollege = educationCollege;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getJobs() {
        return jobs;
    }

    public void setJobs(String jobs) {
        this.jobs = jobs;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getEcAddress() {
        return ecAddress;
    }

    public void setEcAddress(String ecAddress) {
        this.ecAddress = ecAddress;
    }

    public String getEmergencyContactPhone() {
        return emergencyContactPhone;
    }

    public void setEmergencyContactPhone(String emergencyContactPhone) {
        this.emergencyContactPhone = emergencyContactPhone;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public EmployeeInfo( String name, String sex, Date birthday, Integer age, String hometownAddress, String phone, String presentAddress, String qq, Integer educationYear, String educationSchool, String educationCollege, String major, String marriage, String idNumber, String jobs, String email, String emergencyContact, String relationship, String ecAddress, String emergencyContactPhone) {

        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.age = age;
        this.hometownAddress = hometownAddress;
        this.phone = phone;
        this.presentAddress = presentAddress;
        this.qq = qq;
        this.educationYear = educationYear;
        this.educationSchool = educationSchool;
        this.educationCollege = educationCollege;
        this.major = major;
        this.marriage = marriage;
        this.idNumber = idNumber;
        this.jobs = jobs;
        this.email = email;
        this.emergencyContact = emergencyContact;
        this.relationship = relationship;
        this.ecAddress = ecAddress;
        this.emergencyContactPhone = emergencyContactPhone;

    }

    public EmployeeInfo() {
    }


}
