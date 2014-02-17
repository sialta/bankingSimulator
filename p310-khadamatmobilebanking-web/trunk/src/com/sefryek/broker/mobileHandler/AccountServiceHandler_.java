package com.sefryek.broker.mobileHandler;

import com.sefryek.broker.*;

import static com.sefryek.broker.mobileHandler.MIDletConstant.*;

public class AccountServiceHandler_ extends MIDletHandler_ {

    public String perform(String serviceName, String request) {
        if (serviceName.equals(ADD_NEW_ACCOUNT)) {
            AddAccountService addAccountService = new AddAccountServiceImpl();
            return addAccountService.addNewAccount(serviceName, request);
        } else if (serviceName.equals(DELETE_ACCOUNT)) {
            DeleteAccountService deleteAccountService = new DeleteAccountServiceImpl();
            return deleteAccountService.deleteAccount(serviceName, request);
        } else if (serviceName.equals(CHANGE_PIN)) {
            ChangePinService changePinService = new ChangePinServiceImpl();
            return changePinService.changePin(serviceName, request);
        } else if (serviceName.equals(UPDATE_ACCOUNT)) {
            UpdateAccountService updateAccountService = new UpdateAccountServiceImpl();
            return updateAccountService.updateAccountList(serviceName, request);
        } else if (serviceName.equals(ACCOUNT_BALANCE)) {
            AccountBalanceService accountBalanceService = new AccountBalanceServiceImpl();
            return accountBalanceService.getAccountBalance(serviceName, request);
        } else if (serviceName.equals(ACCOUNT_PIN)) {
            AccountPinService accountBalanceService = new AccountPinServiceImpl();
            return accountBalanceService.getAccountPin(serviceName, request);
        } else if (serviceName.equals(PAY_BILL_WITH_ACCOUNT_FIRST_STEP)) {
            BillPaymentWithAccountSt1Service accountBalanceService = new BillPaymentWithAccountSt1ServiceImpl();
            return accountBalanceService.payBillWithAccount(serviceName, request);
        } else if (serviceName.equals(PAY_BILL_WITH_ACCOUNT_SECOND_STEP)) {
            BillPaymentWithAccountSt2Service accountBalanceService = new BillPaymentWithAccountSt2ServiceImpl();
            return accountBalanceService.payBillWithAccount(serviceName, request);
        } else if (serviceName.equals(SHEBA_NUMBER)) {
            ShebaNumberService shebaNumberService = new ShebaNumberServiceImpl();
            return shebaNumberService.getShebaNumber(serviceName, request);
        } else if (serviceName.equals(ACC_SLF_TRANSFER)) {
            TransferSelfAccountService transferSelfAccountService = new TransferSelfAccountServiceImpl();
            return transferSelfAccountService.transfer(serviceName, request);
        } else if (serviceName.equals(ACC_BANK_TRANSFER)) {
            TransferBetweenBanksService transferBetweenBanksService = new TransferBetweenBanksServiceImpl();
            return transferBetweenBanksService.transfer(serviceName, request);
        } else if (serviceName.equals(ACC_OTHER_ACC_TRANSFER_STEP1)) {
            TransferToOtherAccountServiceStep1 transferToOtherAccountServiceStep1 = new TransferToOtherAccountServiceImplStep1();
            return transferToOtherAccountServiceStep1.transfer(serviceName, request);
        } else if (serviceName.equals(ACC_OTHER_ACC_TRANSFER_STEP2)) {
            TransferToOtherAccountServiceStep2 transferToOtherAccountServiceStep2 = new TransferToOtherAccountServiceImplStep2();
            return transferToOtherAccountServiceStep2.transfer(serviceName, request);
        } else if (serviceName.equals(MOVE_ACC_TO_SIMCARD)) {
            AddToSimcardService addToSimcardService = new AddToSimcardServiceImpl();
            return addToSimcardService.add(serviceName, request);
        } else if (serviceName.equals(DEFAULT_ACCOUNT)) {
            DefaultAccountService defaultAccountService = new DefaultAccountServiceImpl();
            return defaultAccountService.getDefaultAccount(serviceName, request);
        } else if (serviceName.equals(ACCOUNT_INVOICE)) {
            AccountInvoiceService accountInvoiceService = new AccountInvoiceServiceImpl();
            return accountInvoiceService.getAccountInvoice(serviceName, request);
        } else if (serviceName.equals(TRANSFER_FROM_ACC_TO_CARD)) {
            TransferFromAccToCardServiceStep1 transferFromAccToCardServiceStep1 = new TransferFromAccToCardServiceImplStep1();
            return transferFromAccToCardServiceStep1.transfer(serviceName, request);
        } else if (serviceName.equals(TRANSFER_FROM_ACC_TO_CARD_ST2)) {
            TransferFromAccToCardServiceStep2 transferFromAccToCardServiceStep2 = new TransferFromAccToCardServiceImplStep2();
            return transferFromAccToCardServiceStep2.transfer(serviceName, request);
        } else if (serviceName.equals(LOAN)) {
            LoanService loanService = new LoanServiceImpl();
            return loanService.payLoan(serviceName, request);
        } else if (serviceName.equals(LAST_3_CHARGE)) {
            Last3ChargesService last3ChargesService = new Last3ChargesServiceImpl();
            return last3ChargesService.getCharges(serviceName, request);
        } else if (serviceName.equals(CHARGE_IN_PERIOD)) {
            ChargesInPeriodService chargesInPeriodService = new ChargesInPeriodServiceImpl();
            return chargesInPeriodService.getCharges(serviceName, request);
        }


        //internal loan service here


        else if (serviceName.equals(CELL_PHONE_ACC)) {
            CellphoneChargeWithBankAccountService cellphoneChargeWithBankAccountService = new CellphoneChargeWithBankAccountServiceImpl();
            return cellphoneChargeWithBankAccountService.charge(serviceName, request);
        }
        return null;

    }
}
