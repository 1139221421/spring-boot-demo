package com.lxl.listener;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener(value = "systemListener")
public class SystemListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    private Logger logger = Logger.getLogger(this.getClass());
    private ServletContext servletContext;
    private static ApplicationContext context;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        servletContext = servletContextEvent.getServletContext();
        initSpring();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

    private void initSpring() {
        logger.info("初始化...");
        context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        servletContext.setAttribute("springBeansContext", context);
        logger.info("初始化...ok!");
    }


    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {

    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }
}
