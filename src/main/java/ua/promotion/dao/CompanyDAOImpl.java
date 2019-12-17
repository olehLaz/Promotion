package ua.promotion.dao;

import ua.promotion.entity.Company;
import ua.promotion.provider.EMFProvider;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class CompanyDAOImpl implements CompanyDAO {
    private static final CompanyDAO instance = new CompanyDAOImpl();
    private EntityManagerFactory emf = EMFProvider.getInstance().getEmf();

    public CompanyDAOImpl() {
    }

    public static CompanyDAO getInstance() {
        return instance;
    }

    @Override
    public void add(Company transaction) {

    }

    @Override
    public void delete(Company company) {

    }

    @Override
    public Company findOne(int id) {
        EntityManager em = emf.createEntityManager();
        Company company = em.createQuery("SELECT c FROM Company c WHERE c.id = " + id, Company.class).getSingleResult();
        em.close();
        return company;
    }

    @Override
    public List<Company> list() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("FROM User", Company.class).getResultList();
    }
}
