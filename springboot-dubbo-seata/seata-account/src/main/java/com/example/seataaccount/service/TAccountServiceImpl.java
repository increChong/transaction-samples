package com.example.seataaccount.service;

import com.example.seataaccount.mapper.TAccountDao;
import com.example.seatacommon.dto.AccountDTO;
import com.example.seatacommon.dto.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TAccountServiceImpl implements ITAccountService {


    @Autowired
    private TAccountDao tAccountDao;

    /**
     * 扣用户钱
     *
     * @param accountDTO
     */
    @Override
    public ResponseData decreaseAccount(AccountDTO accountDTO) {
        int account = tAccountDao.decreaseAccount(accountDTO.getUserId(), accountDTO.getAmount().doubleValue());
        if (account > 0) {
            return new ResponseData("10000", "success");
        }
        return new ResponseData("20000", "fail");
    }
}
