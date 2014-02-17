package com.sefryek.broker.mobileHandler;

import com.sefryek.broker.mobileHandler.ServiceHandler_;
import com.sefryek.broker.mobileHandler.AccountServiceHandler_;
import com.sun.net.httpserver.HttpExchange;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import static com.sefryek.broker.mobileHandler.MIDletConstant.*;


/**
 * Created by IntelliJ IDEA.
 * User: mahta
 * Date: May 14, 2011
 * Time: 4:47:47 PM
 */
public  class MIDletHandler_ extends HttpServlet {

//    public abstract String perform(String serviceName, StringBuilder stringBuilder, HttpExchange t);

    private static final Logger logger = Logger.getLogger(com.sefryek.broker.mobileHandler.MIDletHandler_.class);
    public String perform(String a , String b){
          return null;
    }

    String service = "";
    public com.sefryek.broker.mobileHandler.MIDletHandler_ handler;
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException{

        String req = request.getParameter("param");
//        isr  = new InputStreamReader (request.getInputStream());
//        br = new BufferedReader(isr);
//        int b;
//        StringBuilder buf = new StringBuilder(512);
//        while ((b = br.read()) != -1) {
//            buf.append((char) b);
//        }
        service = req.substring(0,3);
        handler = getHandler(service);

        String res = handler.perform(service, req);
        PrintWriter out = response.getWriter();
        out.println(res);
        }

    public static com.sefryek.broker.mobileHandler.MIDletHandler_ getHandler(String serviceType) {

        logger.debug("Service code is: " + serviceType);
        com.sefryek.broker.mobileHandler.MIDletHandler_ retVal = null;
        if (serviceType != null) {
            if (serviceType.equals(ADD_NEW_ACCOUNT) || serviceType.equals(DELETE_ACCOUNT) || serviceType.equals(UPDATE_ACCOUNT)
                    || serviceType.equals(ACCOUNT_BALANCE) || serviceType.equals(ACCOUNT_PIN)||serviceType.equals(PAY_BILL_WITH_ACCOUNT_FIRST_STEP)
                    ||serviceType.equals(PAY_BILL_WITH_ACCOUNT_SECOND_STEP)||serviceType.equals(SHEBA_NUMBER)
                    ||serviceType.equals(ACC_SLF_TRANSFER)||serviceType.equals(ACC_BANK_TRANSFER)||serviceType.equals(ACC_OTHER_ACC_TRANSFER_STEP1)||serviceType.equals(ACC_OTHER_ACC_TRANSFER_STEP2)
                    ||serviceType.equals(MOVE_ACC_TO_SIMCARD)||serviceType.equals(DEFAULT_ACCOUNT)||serviceType.equals(ACCOUNT_INVOICE)
                    ||serviceType.equals(TRANSFER_FROM_ACC_TO_CARD)||serviceType.equals(TRANSFER_FROM_ACC_TO_CARD_ST2)
                    ||serviceType.equals(LOAN)||serviceType.equals(CELL_PHONE_ACC)||serviceType.equals(CHANGE_PIN)||serviceType.equals(LAST_3_CHARGE)||serviceType.equals(CHARGE_IN_PERIOD)) {
                retVal = new AccountServiceHandler_();
            }
          else
        if(serviceType.equals(ADD_SERVICE)||serviceType.equals(REMOVE_SERVICE)||serviceType.equals(UPDATE_SERVICE_LIST)){
            retVal = new ServiceHandler_();
        }
            else
            if (serviceType.equals(CARD_BALANCE)||serviceType.equals(CARD_INVOICE)||serviceType.equals(CARD_BILL_ST1)
                    ||serviceType.equals(CARD_BILL_ST2)||serviceType.equals(CELL_PHONE_CARD)||serviceType.equals(LOST_CARD)
                    ||serviceType.equals(RELATED_ACC_CARD)){
                retVal = new CardHandler_();
            }
            else
            if (serviceType.equals(CHK_VALIDITY)||serviceType.equals(CHK_AMOUNT)||serviceType.equals(CHK_DATE)||
                    serviceType.equals(CHK_TO_SIM)){
                retVal = new CheckHandler_();
            }
        }
        return retVal;

    }
}

