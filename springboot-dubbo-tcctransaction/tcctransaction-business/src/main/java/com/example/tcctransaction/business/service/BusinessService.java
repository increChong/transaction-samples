package com.example.tcctransaction.business.service;


import com.example.tcctransaction.common.dto.BusinessDTO;
import com.example.tcctransaction.common.dto.ResponseData;

public interface BusinessService {

    ResponseData handleBusiness(BusinessDTO businessDTO) throws Exception;
}
