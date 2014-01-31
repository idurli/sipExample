package com.cinchcast.telephony.tests;

/**
 * Created by ignaciod-temp on 29/01/14.
 */

import org.apache.log4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.sip.SipServlet;
import javax.servlet.sip.SipServletRequest;
import javax.servlet.sip.SipServletResponse;
import java.io.IOException;


public class MyTestSipServlet extends SipServlet{

    private static Logger Log = Logger.getLogger(MyTestSipServlet.class);

    @Override
    public void init(ServletConfig config) throws ServletException{
        Log.info("MyTestSipServlet started.");
        super.init(config);
    }

    @Override
    public void doOptions(SipServletRequest request) throws ServletException, IOException{
        Log.info("MyTestSipServlet got a request: \n" + request.toString());
        SipServletResponse sipResponse = request.createResponse(SipServletResponse.SC_OK);
        Log.info("MyTestSipServlet is about to send a response: \n" + sipResponse.toString());
        sipResponse.send();
    }
}
