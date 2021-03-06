package com.example.tcctransaction.storage.service;


import com.example.tcctransaction.common.dto.CommodityDTO;
import com.example.tcctransaction.common.dto.ResponseData;
import com.example.tcctransaction.storage.mapper.TStorageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TStorageServiceImpl implements ITStorageService {

    @Autowired
    private TStorageMapper tStorageMapper;
    @Override
    public ResponseData decreaseStorage(CommodityDTO commodityDTO) {
        int storage = tStorageMapper.decreaseStorage(commodityDTO.getCommodityCode(), commodityDTO.getCount());
        if (storage > 0){
            return new ResponseData("200","success");
        }
        return new ResponseData("500","fail");
    }
}
