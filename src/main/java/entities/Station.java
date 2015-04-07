package entities;

/**
 * Created by Administrator on 2015/4/1 0001.
 */
public class Station {
    private Integer id;
    private String address;
    private Integer managerId;
    private Float accountRatio;
    private Integer totalAmount;
    private String actualAmountString;
    private Integer actualAmount;

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

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public Float getAccountRatio() {
        return accountRatio;
    }

    public void setAccountRatio(Float accountRatio) {
        this.accountRatio = accountRatio;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getActualAmountString() {
        return actualAmountString;
    }

    public void setActualAmountString(String actualAmountString) {
        this.actualAmountString = actualAmountString;
    }

    public Integer getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(Integer actualAmount) {
        this.actualAmount = actualAmount;
    }
}
