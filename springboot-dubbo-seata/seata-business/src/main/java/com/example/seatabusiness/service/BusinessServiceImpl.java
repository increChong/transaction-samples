package com.example.seatabusiness.service;

import com.example.seatacommon.dto.*;
import com.example.seatacommon.dubbo.AccountDubboService;
import com.example.seatacommon.dubbo.OrderDubboService;
import com.example.seatacommon.dubbo.StorageDubboService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
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

    private boolean flag;

    /**
     * 处理业务逻辑
     * @Param:
     * @Return:
     */
    @Override
    @GlobalTransactional(timeoutMills = 300000, name = "dubbo-gts-seata-example")
    public ResponseData handleBusiness(BusinessDTO businessDTO) {
        System.out.println("开始全局事务，XID = " + RootContext.getXID());

        //1、扣用户余额
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUserId(businessDTO.getUserId());
        accountDTO.setAmount(businessDTO.getAmount());
        ResponseData response = accountDubboService.decreaseAccount(accountDTO);

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
}
