package com.sprayou.spray.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // se.getSession().setMaxInactiveInterval((int) (60*0.25)); //세션만료 15초
        se.getSession().setMaxInactiveInterval((int) (60*60)); //세션만료 1시간
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
    }

}
