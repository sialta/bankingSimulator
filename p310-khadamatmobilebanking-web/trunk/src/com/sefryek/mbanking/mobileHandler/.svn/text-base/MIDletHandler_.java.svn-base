package com.sefryek.mbanking.mobileHandler;

import com.sefryek.mbanking.ServiceHandler;
import com.sefryek.mbanking.ServiceHandler_;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.InetSocketAddress;

import static com.sefryek.mbanking.mobileHandler.MIDletConstant.*;


/**
 * Created by IntelliJ IDEA.
 * User: mahta
 * Date: May 14, 2011
 * Time: 4:47:47 PM
 */
public abstract class MIDletHandler_ extends HttpServlet {

    public abstract String perform(String serviceName, String request);

    private static final Logger logger = Logger.getLogger(MIDletHandler_.class);


    String req="";
    String service = "";

    public MIDletHandler_ handler;
    public void doGe(HttpServletRequest request, HttpServletResponse response)
            throws IOException{

        req=request.getParameter("param");
        service = req.substring(0, 3);
        handler = getHandler(service);
        String res = handler.perform(service, req);
//        t.sendResponseHeaders(200, res.length());
//        OutputStream os = t.getResponseBody();
//        os.write(res.getBytes());
//        os.close();




//    public static void main(String[] args) throws Exception {
//        HttpServer server = HttpServer.create(new InetSocketAddress(80), 0);
//        server.createContext("/test", new MyHandler());
//        server.setExecutor(null); // creates a default executor
//        server.start();
//    }

//        public MIDletHandler_ handler;
//        public String service;



        }
//    }


    public static MIDletHandler_ getHandler(String serviceType) {

        logger.debug("Service code is: " + serviceType);
        MIDletHandler_ retVal = null;
        if (serviceType != null) {
            if (serviceType.equals(ADD_NEW_ACCOUNT) || serviceType.equals(DELETE_ACCOUNT) || serviceType.equals(UPDATE_ACCOUNT)
                    || serviceType.equals(ACCOUNT_BALANCE) || serviceType.equals(ACCOUNT_PIN)||serviceType.equals(PAY_BILL_WITH_ACCOUNT_FIRST_STEP)
                    ||serviceType.equals(PAY_BILL_WITH_ACCOUNT_SECOND_STEP)||serviceType.equals(SHEBA_NUMBER)
                    ||serviceType.equals(ACC_SLF_TRANSFER)||serviceType.equals(ACC_BANK_TRANSFER)||serviceType.equals(ACC_OTHER_ACC_TRANSFER_STEP1)
                    ||serviceType.equals(MOVE_ACC_TO_SIMCARD)||serviceType.equals(DEFAULT_ACCOUNT)) {
                retVal = new AccountServiceHandler_();
            }
          else
        if(serviceType.equals(ADD_SERVICE)||serviceType.equals(REMOVE_SERVICE)||serviceType.equals(UPDATE_SERVICE_LIST)){
            retVal = new ServiceHandler_();
        }
        }
        return retVal;

    }
}

