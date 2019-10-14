package com.example.seatacommon.dubbo;


import com.example.seatacommon.dto.CommodityDTO;
import com.example.seatacommon.dto.ResponseData;

/**
 * @Author: heshouyou
 * @Description  仓库服务
 * @Date Created in 2019/1/13 16:22
 */
public interface StorageDubboService {

    /**
     * 扣减库存
     */
    ResponseData decreaseStorage(CommodityDTO commodityDTO);
}
