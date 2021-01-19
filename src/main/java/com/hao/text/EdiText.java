package com.hao.text;

import com.hao.mappar.impl.EmployeeDaoImpl;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @Description:
 * @Company:
 * @version: 1.0
 * @date 2021/1/19 - 15:52
 */
public class EdiText {

    public static void main(String[] args) throws Exception {
        EmployeeDaoImpl em = new EmployeeDaoImpl();
        //String id = em.save("aaa", "aaa1", 3000);//id=40288abd7719f87d017719f87f190000
        //String id = em.save("bbb", "bbb1", 6000);//id=40288abd7719fa6e017719fa70660000
        //String id = em.save("ccc", "ccc1", 9000);//id=40288abd7719fb28017719fb2a3e0000
        //System.out.println(id);
        //em.getAll();
        //em.update("", 10000);
        em.delete("40288abd7719f87d017719f87f190000");

    }
}
