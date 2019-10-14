package com.example.tcctransaction.order.service;


import com.example.tcctransaction.common.dto.OrderDTO;
import com.example.tcctransaction.common.dto.ResponseData;
import com.example.tcctransaction.order.entity.TOrder;
import com.example.tcctransaction.order.mapper.TOrderMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author heshouyou
 * @since 2019-01-13
 */
@Service
public class TOrderServiceImpl implements ITOrderService {

    @Autowired
    private TOrderMapper tOrderMapper;

    /**
     * 创建订单
     * @Param:  OrderDTO  订单对象
     * @Return:  OrderDTO  订单对象
     */
    @Override
    public ResponseData<OrderDTO> createOrder(OrderDTO orderDTO) {
        //生成订单号
        orderDTO.setOrderNo(UUID.randomUUID().toString().replace("-",""));
        //生成订单
        TOrder tOrder = new TOrder();
        BeanUtils.copyProperties(orderDTO,tOrder);
        tOrder.setCount(orderDTO.getOrderCount());
        tOrder.setAmount(orderDTO.getOrderAmount().doubleValue());
        try {
            tOrderMapper.createOrder(tOrder);
        } catch (Exception e) {
            return new ResponseData<OrderDTO>("500","exception",null);
        }

        return new ResponseData<OrderDTO>("200","success",orderDTO);
    }
}
