package com.isi.metier.dao;

import com.isi.metier.config.HibernateUtil;
import com.isi.metier.entity.Sectors;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class SectorsDAOImpl implements ISectorsDAO {
    @Override
    public void addSector(Sectors sector) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(sector);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Sectors getSectorById(long id) {
        return null;
    }

    @Override
    public List<Sectors> getAllSectors() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Sectors", Sectors.class).list();
        }
    }
}