package com.example.tcctransaction.business.service;


import com.alibaba.fastjson.JSON;
import com.example.tcctransaction.common.dto.*;
import com.example.tcctransaction.common.dubbo.AccountDubboService;
import com.example.tcctransaction.common.dubbo.OrderDubboService;
import com.example.tcctransaction.common.dubbo.StorageDubboService;
import org.mengyun.tcctransaction.api.Compensable;
import org.mengyun.tcctransaction.dubbo.context.DubboTransactionContextEditor;
import org.mengyun.tcctransaction.support.TransactionConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Author: heshouyou
 * @Description  Dubbo业务发起方逻辑
 * @Date Created in 2019/1/14 18:36
 */
@Service
public class BusinessServiceImpl implements BusinessService{

    @Autowired
    private OrderDubboService orderDubboService;

    @Autowired
    private AccountDubboService accountDubboService;

    @Autowired
    private StorageDubboService storageDubboService;

    @Autowired
    private TransactionConfigurator transactionConfigurator;
    /**
     * 处理业务逻辑
     * @Param:
     * @Return:
     */
    @Override
    @Compensable(confirmMethod = "confirmHandleBusiness",
            cancelMethod = "cancelHandleBusiness",asyncCancel = true)
    public ResponseData handleBusiness(BusinessDTO businessDTO) throws Exception {
        System.out.println(transactionConfigurator.getTransactionManager().getCurrentTransaction().getXid());
        //1、扣用户余额
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUserId(businessDTO.getUserId());
        accountDTO.setAmount(businessDTO.getAmount());

        ResponseData response = accountDubboService.decreaseAccount(accountDTO);
        System.out.println(JSON.toJSONString(response));
//        if (true) {
//            throw new RuntimeException("事务回滚");
//        }
        //2、扣减库存
        CommodityDTO commodityDTO = new CommodityDTO();
        commodityDTO.setCommodityCode(businessDTO.getCommodityCode());
        commodityDTO.setCount(businessDTO.getCount());
        ResponseData storageResponse = storageDubboService.decreaseStorage(commodityDTO);
        if (!storageResponse.getCode().equals("200")) {
            throw new RuntimeException("全局事务回滚");
        }
        //3.创建订单
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setUserId(businessDTO.getUserId());
        orderDTO.setCommodityCode(businessDTO.getCommodityCode());
        orderDTO.setOrderCount(businessDTO.getCount());
        orderDTO.setOrderAmount(businessDTO.getAmount());
        ResponseData<OrderDTO> orderResponse = orderDubboService.createOrder(orderDTO);
        if (!orderResponse.getCode().equals("200")) {
            throw new RuntimeException("全局事务回滚");
        }
        return orderResponse;
    }

    public void confirmHandleBusiness(BusinessDTO businessDTO) {
        System.out.println("全局事务确认");
    }
    public void cancelHandleBusiness(BusinessDTO businessDTO) {
        System.out.println("全局事务取消");
    }
}
