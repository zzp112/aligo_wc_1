package entities;

/**
 * Created by Administrator on 2015/4/1 0001.
 */
public class Station {
    private Integer id;
    private String address;
    private Integer managerid;
    private Float accountratio;
    private Integer totalamount;
    private String actualamount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getManagerid() {
        return managerid;
    }

    public void setManagerid(Integer managerid) {
        this.managerid = managerid;
    }

    public Float getAccountratio() {
        return accountratio;
    }

    public void setAccountratio(Float accountratio) {
        this.accountratio = accountratio;
    }

    public Integer getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(Integer totalamount) {
        this.totalamount = totalamount;
    }

    public String getActualamount() {
        return actualamount;
    }

    public void setActualamount(String actualamount) {
        this.actualamount = actualamount;
    }
}
