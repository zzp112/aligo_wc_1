package dao;

import entities.PaymentDetail;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2015-04-01.
 */
@Repository
public interface PaymentDetailDao {
    /**
     * 查询出所有的收支明细
     */
    static String loadAll = "select DetailId as detail_id,StationId as station_id,CreateDate as create_id,Balance as balance,BalanceAmount as balance_amount,Type as balance_type,Comment as balance_comment from paymentDetails";
    /**
     *  创建一条收支记录
     */
    static String CreatePayment="insert into paymentDetails(StationId,CreateDate,Balance,BalanceAmount,Type,Comment)" +
            "values(#{station_id},#{create_date},#{balance},#{balance_amount},#{balance_type},#{balance_comment})";

    /**
     * 删除一条收支记录
     * @return
     */
    static String DeletePayment="delete from paymentDetails where DetailId=#{payment_id}";
    @Select(loadAll)
    public List<PaymentDetail> loadAllPaymentDetails();

    @Insert(CreatePayment)
    public Boolean CreatePaymentDetail(PaymentDetail paymentDetail);

    @Delete(DeletePayment)
    public void DeletePaymentDetail(Integer payment_id);

}
