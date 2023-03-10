package edu.sltc.currencyconvertorserver;

import  javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public class webServer {
    @WebMethod
    public double convert(String sourceCurrency, String targetCurrency, double amountInSourceCurrency){
        currencyRate tempRate = new currencyRate(sourceCurrency,targetCurrency);
        double result = tempRate.convert(amountInSourceCurrency);
        System.out.println("Sending "+result+".\n");
        return result;
    }
    public static void main(String[] args){
        Endpoint.publish("http://localhost:8888/SoapWebService", new webServer());
    }
}
