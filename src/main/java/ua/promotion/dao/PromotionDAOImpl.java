package ua.promotion.dao;

import ua.promotion.entity.Promotion;
import ua.promotion.provider.EMFProvider;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class PromotionDAOImpl implements PromotionDAO {
    private static final PromotionDAO instance = new PromotionDAOImpl();
    private EntityManagerFactory emf = EMFProvider.getInstance().getEmf();

    private PromotionDAOImpl() {
    }

    public static PromotionDAO getInstance() {
        return instance;
    }

    @Override
    public synchronized void add(Promotion promotion) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try{
            List<Promotion> promotions = em.createQuery("FROM Promotion p WHERE p.edrpou = '"+promotion.getEdrpou() +
                    "'AND p.nominalValue = '" + promotion.getNominalValue() + "'", Promotion.class).getResultList();
            if(promotions.size() == 0){
                promotion.setTotalNominalValue(promotion.getNumber()*promotion.getNominalValue());
                em.persist(promotion);
            }
            em.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

    }

    @Override
    public synchronized void edit(Promotion promotion) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.merge(promotion);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

    }

    @Override
    public synchronized void delete(Promotion promotion) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try{
            em.remove(promotion);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public Promotion findOne(int id) {
        return null;
    }

    @Override
    public List<Promotion> list() {
        EntityManager em = emf.createEntityManager();
        List<Promotion> promotions = em.createQuery("FROM Promotion", Promotion.class).getResultList();
        em.close();
        return promotions;
    }
}
