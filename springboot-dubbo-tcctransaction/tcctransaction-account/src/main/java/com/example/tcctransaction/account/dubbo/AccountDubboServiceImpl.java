package com.example.tcctransaction.account.dubbo;


import com.alibaba.dubbo.config.annotation.Service;
import com.example.tcctransaction.account.service.ITAccountService;
import com.example.tcctransaction.common.dto.AccountDTO;
import com.example.tcctransaction.common.dto.ResponseData;
import com.example.tcctransaction.common.dubbo.AccountDubboService;
import org.mengyun.tcctransaction.api.Compensable;
import org.mengyun.tcctransaction.dubbo.context.DubboTransactionContextEditor;
import org.mengyun.tcctransaction.support.TransactionConfigurator;
import org.springframework.beans.factory.annotation.Autowired;

//import org.apache.dubbo.config.annotation.Service;

/**
 * @Author: heshouyou
 * @Description  Dubbo Api Impl
 * @Date Created in 2019/1/23 14:40
 */
@Service(version = "1.0.0",protocol = "${dubbo.protocol.id}",
         application = "${dubbo.application.id}",registry = "${dubbo.registry.id}",
         timeout = 3000)
public class AccountDubboServiceImpl implements AccountDubboService {

    @Autowired
    private ITAccountService accountService;

    @Autowired
    private TransactionConfigurator transactionConfigurator;

    @Override
    @Compensable(confirmMethod = "confirmDecreaseAccount",cancelMethod = "cancelDecreaseAccount",transactionContextEditor = DubboTransactionContextEditor.class)
    public ResponseData decreaseAccount(AccountDTO accountDTO) {
        System.out.println("TCC事务预操作");
        System.out.println(transactionConfigurator.getTransactionManager().getCurrentTransaction().getXid());
        return accountService.decreaseAccount(accountDTO);
    }

    public void confirmDecreaseAccount(AccountDTO accountDTO) {
        System.out.println("TCC事务确认");
    }

    public void cancelDecreaseAccount(AccountDTO accountDTO) {
        System.out.println("TCC事务取消");
        accountDTO.setAmount(accountDTO.getAmount().negate());
        accountService.decreaseAccount(accountDTO);
    }
}
