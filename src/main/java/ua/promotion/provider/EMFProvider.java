package ua.promotion.provider;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMFProvider {
    private static final EMFProvider instance = new EMFProvider();
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Promotions");

    private EMFProvider(){
    }

    public static EMFProvider getInstance() {
        return instance;
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }
    public void close(){
        emf.close();
    }
}
