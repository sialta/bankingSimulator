package com.sefryek.mbanking;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 6/9/13
 * Time: 2:58 AM
 * To change this template use File | Settings | File Templates.
 */

import com.sefryek.mbanking.mobileHandler.MIDletHandler_;

import static com.sefryek.mbanking.mobileHandler.MIDletConstant.*;

public class ServiceHandler_ extends MIDletHandler_ {

    public String perform(String serviceName, String request) {
        if (serviceName.equals(ADD_SERVICE)) {
            AddOnewayService addOnewayService = new AddOnewayServiceImpl();
            return addOnewayService.addService(serviceName, request);
        } else if (serviceName.equals(REMOVE_SERVICE)) {
            RemoveOnewayService removeOnewayService = new RemoveOnewayServiceImpl();
            return removeOnewayService.removeService(serviceName,request);
        } else if (serviceName.equals(UPDATE_SERVICE_LIST)) {
            ServiceListUpdate serviceListUpdate = new ServiceListUpdateImpl();
            return serviceListUpdate.updateList(serviceName, request);
        }
        return null;

    }
}
