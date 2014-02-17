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

public class CheckHandler_ extends MIDletHandler_ {

    public String perform(String serviceName, String request) {
        if (serviceName.equals(CHK_VALIDITY)) {
            CheckValidityService checkValidityService = new CheckValidityServiceImpl();
            return checkValidityService.check(serviceName, request);
        }   if (serviceName.equals(CHK_AMOUNT)) {
            CheckAmountService checkValidityService = new CheckAmountServiceImpl();
            return checkValidityService.setCheckAmount(serviceName, request);
        }   if (serviceName.equals(CHK_DATE)) {
            CheckDateService checkDateService = new CheckDateServiceImpl();
            return checkDateService.setCheckDate(serviceName, request);
        }   if (serviceName.equals(CHK_TO_SIM)) {
            CheckToSimcardService checkToSimcardService = new CheckToSimcardServiceImpl();
            return checkToSimcardService.moveCheckInfo(serviceName, request);
        }
        return null;

    }
}
