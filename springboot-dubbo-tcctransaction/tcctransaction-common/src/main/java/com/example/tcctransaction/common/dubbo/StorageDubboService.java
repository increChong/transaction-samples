package com.example.tcctransaction.common.dubbo;


import com.example.tcctransaction.common.dto.CommodityDTO;
import com.example.tcctransaction.common.dto.ResponseData;
import org.mengyun.tcctransaction.api.Compensable;

/**
 * @Author: heshouyou
 * @Description  仓库服务
 * @Date Created in 2019/1/13 16:22
 */
public interface StorageDubboService {

    /**
     * 扣减库存
     */
    @Compensable
    ResponseData decreaseStorage(CommodityDTO commodityDTO);
}
