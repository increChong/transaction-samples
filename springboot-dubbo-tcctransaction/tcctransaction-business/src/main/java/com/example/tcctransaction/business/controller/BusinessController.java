package com.example.tcctransaction.business.controller;


import com.alibaba.fastjson.JSON;
import com.example.tcctransaction.business.service.BusinessService;
import com.example.tcctransaction.common.dto.BusinessDTO;
import com.example.tcctransaction.common.dto.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @Author: heshouyou
 * @Description  Dubbo业务执行入口
 * @Date Created in 2019/1/14 17:15
 */
@RestController
@RequestMapping("/business/dubbo")
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    /**
     * 模拟用户购买商品下单业务逻辑流程
     * @Param:
     * @Return:
     */
    @PostMapping("/buy")
    ResponseData handleBusiness(@RequestBody BusinessDTO businessDTO) throws Exception {
        System.out.println("请求参数："+businessDTO.toString());
        return businessService.handleBusiness(businessDTO);
    }

    public static void main(String[] args) {
        BusinessDTO businessDTO = new BusinessDTO();
        businessDTO.setAmount(new BigDecimal(100));
        businessDTO.setCommodityCode("C201901140001");
        businessDTO.setCount(5);
        businessDTO.setName("水杯");
        businessDTO.setUserId("1");
        System.out.println(JSON.toJSONString(businessDTO));
    }
}
