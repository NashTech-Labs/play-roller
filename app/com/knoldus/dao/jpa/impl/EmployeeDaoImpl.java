package com.knoldus.dao.jpa.impl;

import com.knoldus.dao.jpa.EmployeeDao;
import com.knoldus.entities.jpa.Employee;
import play.db.jpa.JPAApi;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by knoldus on 27/12/16.
 */
@Singleton
public class EmployeeDaoImpl implements EmployeeDao {

    private JPAApi jpaApi;

    @Inject
    public EmployeeDaoImpl(JPAApi api) {
        this.jpaApi = api;
    }

    protected EntityManager getEntityManager() {
        return this.jpaApi.em();
    }

    @Override
    public void save(Employee t) {
        getEntityManager().persist(t);
    }

    @Override
    public Employee findById(int id) {
        return getEntityManager()
                .createQuery("SELECT em FROM Employee em WHERE em.id = :id", Employee.class)
                .setParameter("id", id).getSingleResult();
    }

    @Override
    public List<Employee> findAll() {
        return getEntityManager().createQuery("SELECT em FROM Employee em", Employee.class)
                .getResultList();
    }

    @Override
    public int updateById(int id) {
        return jpaApi.withTransaction(entityManager -> entityManager
                .createQuery("UPDATE Employee emp SET emp.age = :age WHERE emp.id = :id")
                .setParameter("id", id).setParameter("age", 25).executeUpdate());
    }
}
