package com.example.seataaccount.service;


import com.example.seatacommon.dto.AccountDTO;
import com.example.seatacommon.dto.ResponseData;


public interface ITAccountService {

    /**
     * 扣用户钱
     */
    ResponseData decreaseAccount(AccountDTO accountDTO);
}
