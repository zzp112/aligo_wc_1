package services;

import entities.PaymentDetail;

import javax.xml.soap.DetailEntry;
import java.util.List;

/**
 * Created by Administrator on 2015/4/3.
 */
public interface IPaymentDetailService {

    /**
     * 加载所有的小站收支明细
     * @return
     */
    public List<PaymentDetail> findAllPaymentDetails();
    /**
     * 修改一条小站收支明细记录
     * @param paymentDetail
     * @return
     */
    public boolean UpdatePaymentDetail(PaymentDetail paymentDetail);
    /**
     * 添加一条小站收支明细
     * @param paymentDetail
     * @return
     */
    public void CreatePaymentDetail(PaymentDetail paymentDetail);
    /**
     * 删除一条数据
     * @param detail_id
     */
    public void DeletePaymentDetail(Integer detail_id);

    /**
     * 找到指定id的记录
     * @param detail_id
     * @return
     */
    public PaymentDetail findPaymentDetailById(Integer detail_id);
}
