package ua.promotion.dao;

import ua.promotion.entity.Company;
import ua.promotion.entity.Transaction;
import ua.promotion.provider.EMFProvider;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class TransactionDAOImpl implements TransactionDAO {
    private static final TransactionDAO instance = new TransactionDAOImpl();
    private EntityManagerFactory emf = EMFProvider.getInstance().getEmf();

    public TransactionDAOImpl() {
    }

    public static TransactionDAO getInstance() {
        return instance;
    }

    @Override
    public void add(Transaction transaction) {

    }

    @Override
    public void delete(Transaction transaction) {

    }

    @Override
    public Transaction findOne(int id) {
        EntityManager em = emf.createEntityManager();
        Transaction transaction = em.createQuery("SELECT t FROM Transaction t WHERE t.id = " + id, Transaction.class).getSingleResult();
        em.close();
        return transaction;
    }

    @Override
    public List<Transaction> list() {
        EntityManager em = emf.createEntityManager();
        List<Transaction> transactions = em.createQuery("FROM Transaction", Transaction.class).getResultList();
        em.close();
        return transactions;
    }
}
