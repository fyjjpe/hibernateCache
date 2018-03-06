package cacheTest;


import com.entity.Students;
import com.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

import java.util.List;

/**
 * Created by yuanjie.fang on 2018/3/6.
 */
public class SessionCacheTest {
    //测试一级缓存
    @Test
    public void testSessionCache(){
        Session session = HibernateUtil.getSession();
//        Students s = (Students) session.get(Students.class,1);
//        System.out.println(s.getSname());

        //evict方法清除一级缓存中的指定对象
//        session.evict(s);
        //clear清除一级缓存中的所有内容
//        session.clear();
//        s = (Students) session.get(Students.class,1);
//        System.out.println(s.getSname());


        Query query = session.createQuery("from Students");
        List<Students> list = query.list();
        for (Students students : list) {
            System.out.println(students.getSname());
        }

        list = query.list();
        for (Students students : list) {
            System.out.println(students.getSname());
        }
        HibernateUtil.colseSession(session);
    }


    //测试二级缓存
    @Test
    public void testSessionCache2(){
        Session session = HibernateUtil.getSession();
        Students s = (Students) session.get(Students.class,1);
        System.out.println(s.getSname());

        s = (Students) session.get(Students.class,1);
        System.out.println(s.getSname());

        HibernateUtil.colseSession(session);
    }

}
