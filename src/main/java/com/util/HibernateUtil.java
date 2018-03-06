package com.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Created by yuanjie.fang on 2018/2/28.
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static Session session;

    static {
        //创建Configuration对象，读取hibernate.cfg.xml文件，完成初始化
        Configuration config = new Configuration().configure();
        //创建服务注册对象
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        //创建会话工厂
        sessionFactory = config.buildSessionFactory(serviceRegistry);
    }

    //获取sessionFactory
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    //获取session
    public static Session getSession() {
        return sessionFactory.openSession();
    }

    //关闭session
    public static void colseSession(Session session) {
        if (session != null) {
            session.close();
        }
    }
}
