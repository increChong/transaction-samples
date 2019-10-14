package com.example.seatabusiness.service;

import com.example.seatacommon.dto.BusinessDTO;
import com.example.seatacommon.dto.ResponseData;


public interface BusinessService {

    ResponseData handleBusiness(BusinessDTO businessDTO);
}
