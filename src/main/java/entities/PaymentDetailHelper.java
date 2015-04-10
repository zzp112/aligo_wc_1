package entities;

import org.springframework.stereotype.Repository;

/**
 * Created by 张超红 on 2015-04-09.
 */
@Repository
public class PaymentDetailHelper {
    private String balance=null;
    private String balance_type=null;
    private String start_time=null;
    private String end_time=null;

    public PaymentDetailHelper(String balance, String balance_type, String start_time, String end_time) {
        this.balance = balance;
        this.balance_type = balance_type;
        this.start_time = start_time;
        this.end_time = end_time;
    }

    public PaymentDetailHelper(){

    }
    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getBalance_type() {
        return balance_type;
    }

    public void setBalance_type(String balance_type) {
        this.balance_type = balance_type;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }
}
