package com.hao.mappar.impl;

import com.hao.entity.Employee;
import com.hao.mappar.EmployeeDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

/**
 * @Description:
 * @Company:
 * @version: 1.0
 * @date 2021/1/19 - 15:45
 */
public class EmployeeDaoImpl implements EmployeeDao {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
    private SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

    public String save(String firstName, String lastName, Integer salary) throws Exception{
        Session session =sessionFactory.openSession();
        Transaction transaction =session.beginTransaction();
        Employee employee = new Employee(firstName,lastName,salary);
        String id = (String) session.save(employee);
        transaction.commit();
        session.close();
        return id;

    }

    public void getAll() {
        Session session =sessionFactory.openSession();
        Transaction transaction =session.beginTransaction();
        List employees = session.createQuery("FROM Employee").list();
        for (Object employee : employees) {
            Employee employee1 = (Employee)employee;
            System.out.println("First Name:"+employee1.getFirstName());
            System.out.println("  Last Name: " + employee1.getLastName());
            System.out.println("  Salary: " + employee1.getSalary());
        }
        transaction.commit();
        session.close();

    }

    public void update(String id, int salary) {
        Session session =sessionFactory.openSession();
        Transaction transaction =session.beginTransaction();
        Employee employee = (Employee)session.get(Employee.class,id);
        employee.setSalary(salary);
        session.update(employee);
        transaction.commit();
        session.close();

    }

    public void delete(String id) {
        Session session =sessionFactory.openSession();
        Transaction transaction =session.beginTransaction();
        Employee employee = (Employee)session.get(Employee.class,id);
        session.delete(employee);
        transaction.commit();
        session.close();

    }
}
