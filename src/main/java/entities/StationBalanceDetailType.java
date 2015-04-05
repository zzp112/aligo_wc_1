package entities;

import org.springframework.stereotype.Repository;

/**
 * Created by 张超红 on 2015-04-03.
 * 小站收支明细类型类
 */
@Repository
public class StationBalanceDetailType {
    //小站收支明细类型的id
    private Integer paymentTypeId;

    //小站收支明细类型名称
    private String paymentTypeName;

    public String getPaymentTypeName() {
        return paymentTypeName;
    }

    public void setPaymentTypeName(String paymentTypeName) {
        this.paymentTypeName = paymentTypeName;
    }

    public Integer getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(Integer paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    @Override
    public String toString() {
        return "id:"+this.paymentTypeId+"类型:"+this.paymentTypeName;
    }
}
