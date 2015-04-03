package services;

import entities.PaymentDetail;

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
}
