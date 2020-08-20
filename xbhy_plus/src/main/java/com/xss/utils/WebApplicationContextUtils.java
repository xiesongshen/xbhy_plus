package com.xss.utils;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.RequestScope;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.SessionScope;

public abstract class WebApplicationContextUtils {
    public static WebApplicationContext getRequiredWebApplicationContext(ServletContext sc)
            throws IllegalStateException {
        WebApplicationContext wac = getWebApplicationContext(sc);
        if (wac == null) {
            throw new IllegalStateException("No WebApplicationContext found: no ContextLoaderListener registered?");
        }
        return wac;
    }

    public static WebApplicationContext getWebApplicationContext(ServletContext sc) {
        return getWebApplicationContext(sc, WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
    }

    public static WebApplicationContext getWebApplicationContext(ServletContext sc, String attrName) {
        Assert.notNull(sc, "ServletContext must not be null");
        Object attr = sc.getAttribute(attrName);
        if (attr == null) {
            return null;
        }
        if ((attr instanceof RuntimeException)) {
            throw ((RuntimeException) attr);
        }
        if ((attr instanceof Error)) {
            throw ((Error) attr);
        }
        if ((attr instanceof Exception)) {
            IllegalStateException ex = new IllegalStateException();
            ex.initCause((Exception) attr);
            throw ex;
        }
        if (!(attr instanceof WebApplicationContext)) {
            throw new IllegalStateException("Context attribute is not of type WebApplicationContext: " + attr);
        }
        return (WebApplicationContext) attr;
    }

    public static void registerWebApplicationScopes(ConfigurableListableBeanFactory beanFactory) {
        beanFactory.registerScope("request", new RequestScope());
        beanFactory.registerScope("session", new SessionScope());
        beanFactory.registerScope("globalSession", new SessionScope());

        beanFactory.registerResolvableDependency(ServletRequest.class, new ObjectFactory() {
            public Object getObject() {
                RequestAttributes requestAttr = RequestContextHolder.currentRequestAttributes();
                if (!(requestAttr instanceof ServletRequestAttributes)) {
                    throw new IllegalStateException("Current request is not a servlet request");
                }
                return ((ServletRequestAttributes) requestAttr).getRequest();
            }
        });
        beanFactory.registerResolvableDependency(HttpSession.class, new ObjectFactory() {
            public Object getObject() {
                RequestAttributes requestAttr = RequestContextHolder.currentRequestAttributes();
                if (!(requestAttr instanceof ServletRequestAttributes)) {
                    throw new IllegalStateException("Current request is not a servlet request");
                }
                return ((ServletRequestAttributes) requestAttr).getRequest().getSession();
            }
        });
    }
}