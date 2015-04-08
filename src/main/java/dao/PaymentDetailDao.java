package dao;

import entities.PaymentDetail;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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
    static String loadAll = "select DetailId as detail_id,StationId as station_id,CreateDate " +
            "as create_date,Balance as balance,BalanceAmount as balance_amount,Type as balance_type," +
            "Comment as balance_comment from paymentDetails";
    /**
     * 创建一条收支记录
     */
    static String CreatePayment = "insert into paymentDetails(StationId,CreateDate,Balance,BalanceAmount,Type,Comment)" +
            "values(#{station_id},#{create_date},#{balance},#{balance_amount},#{balance_type},#{balance_comment})";

    /**
     * 更新一条记录
     */
    static String UpdatePayment = "update paymentDetails set StationId=#{station_id}" +
            ",CreateDate=#{create_date},Balance=#{balance},BalanceAmount=#{balance_amount}" +
            ",Type=#{balance_type},Comment=#{balance_comment} where DetailId=#{detail_id}";

    /**
     * 删除一条收支记录
     *
     * @return
     */
    static String DeletePayment = "delete from paymentDetails where DetailId=#{payment_id}";

    /**
     * 找到指定id的小站收支明细记录
     */
    static String findPaymentDetailById="select DetailId as detail_id,StationId as station_id,CreateDate " +
            "as create_date,Balance as balance,BalanceAmount as balance_amount,Type as balance_type," +
            "Comment as balance_comment from paymentDetails where DetailId=#{detail_id}";

    @Select(loadAll)
    public List<PaymentDetail> loadAllPaymentDetails();

    @Insert(CreatePayment)
    public void CreatePaymentDetail(PaymentDetail paymentDetail);

    @Delete(DeletePayment)
    public void DeletePaymentDetail(Integer payment_id);

    @Update(UpdatePayment)
    public void UpdatePayment(PaymentDetail paymentDetail);

    @Select(findPaymentDetailById)
    public PaymentDetail findPaymentDetailById(Integer detail_id);
}
