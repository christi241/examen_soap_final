package com.isi.metier.dao;

import com.isi.metier.config.HibernateUtil;
import com.isi.metier.entity.Classes;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class ClassesDAOImpl implements IClassesDAO {

    @Override
    public void addClass(Classes classe) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(classe);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<Classes> getClassesBySectorId(long sectorId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Classes c where c.sector.id = :sectorId", Classes.class)
                    .setParameter("sectorId", sectorId)
                    .list();
        }
    }

    @Override
    public List<Classes> getAllClasses() {
        return null;
    }
}