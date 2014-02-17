package com.sefryek.broker.mobileHandler;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 6/9/13
 * Time: 2:58 AM
 * To change this template use File | Settings | File Templates.
 */

import com.sefryek.broker.*;

import static com.sefryek.broker.mobileHandler.MIDletConstant.*;

public class CardHandler_ extends MIDletHandler_ {

    public String perform(String serviceName, String request) {
        if (serviceName.equals(CARD_BALANCE)) {
            CardBalanceService cardBalanceService = new CardBalanceServiceImpl();
            return cardBalanceService.getBalance(serviceName, request);
        } else if (serviceName.equals(CARD_INVOICE)) {
            CardInvoiceService cardInvoiceService = new CardInvoiceServiceImpl();
            return cardInvoiceService.getInvoice(serviceName, request);
        }  else if (serviceName.equals(CARD_INVOICE)) {
            CardBillPaymentServiceSt1 cardBillPaymentService = new CardBillPaymentServiceImplSt1();
            return cardBillPaymentService.payBill(serviceName, request);
        }  else if (serviceName.equals(CARD_BILL_ST1)) {
            CardBillPaymentServiceSt1 cardBillPaymentService = new CardBillPaymentServiceImplSt1();
            return cardBillPaymentService.payBill(serviceName, request);
        }   else if (serviceName.equals(CARD_BILL_ST2)) {
            CardBillPaymentServiceSt2 cardBillPaymentService = new CardBillPaymentServiceImplSt2();
            return cardBillPaymentService.payBill(serviceName, request);
        }    else if (serviceName.equals(CELL_PHONE_CARD)) {
            CellphoneChargeWithCardService cardBillPaymentService = new CellphoneChargeWithCardServiceImpl();
            return cardBillPaymentService.charge(serviceName, request);
        }     else if (serviceName.equals(LOST_CARD)) {
            LostCardService lostCardService = new LostCardServiceImpl();
            return lostCardService.registerLostCard(serviceName, request);
        }      else if (serviceName.equals(RELATED_ACC_CARD)) {
            RelatedAccountsWithCardService relatedAccountsWithCardService = new RelatedAccountsWithCardServiceImpl();
            return relatedAccountsWithCardService.getAccounts(serviceName, request);
        }
        return null;

    }
}
