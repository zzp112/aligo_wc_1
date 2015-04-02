package entities;

import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2015-04-01.
 */
@Repository
public class PaymentDetail {
    /**
     * 明细ID
     */
    private int detail_id;
    /**
     * 明细所属的小站ID
     */
    private String station_id;
    /**
     * 明细添加日期
     */
    private String create_date;
    /**
     * 收支/支出 二选一
     */
    private String balance;
    /**
     * 收入/支出的金额数目
     */
    private double balance_amount;
    /**
     * 类别
     */
    private String balance_type;
    /**
     * 明细备注
     */
    private String balance_comment;

    public int getDetail_id() {
        return detail_id;
    }

    public void setDetail_id(int detail_id) {
        this.detail_id = detail_id;
    }

    public String getStation_id() {
        return station_id;
    }

    public void setStation_id(String station_id) {
        this.station_id = station_id;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public double getBalance_amount() {
        return balance_amount;
    }

    public void setBalance_amount(double balance_amount) {
        this.balance_amount = balance_amount;
    }

    public String getBalance_type() {
        return balance_type;
    }

    public void setBalance_type(String balance_type) {
        this.balance_type = balance_type;
    }

    public String getBalance_comment() {
        return balance_comment;
    }

    public void setBalance_comment(String balance_comment) {
        this.balance_comment = balance_comment;
    }


    /**
     * 全参构造方法
     *
     * @param detail_id
     * @param station_id
     * @param create_date
     * @param balance
     * @param balance_amount
     * @param balance_type
     * @param balance_comment
     */

    public PaymentDetail(int detail_id, String station_id, String create_date, String balance, double balance_amount, String balance_type, String balance_comment) {
        this.detail_id = detail_id;
        this.station_id = station_id;
        this.create_date = create_date;
        this.balance = balance;
        this.balance_amount = balance_amount;
        this.balance_type = balance_type;
        this.balance_comment = balance_comment;
    }

    /**
     * 无参构造方法
     */
    public PaymentDetail() {

    }

    @Override
    public String toString() {
        return "本小站：" + this.station_id + this.balance + ":" +
                this.balance_amount + "元" + "明细id" + this.detail_id
                +"明细备注："+this.balance_comment+"创建时间:"+this.create_date;
    }
}
