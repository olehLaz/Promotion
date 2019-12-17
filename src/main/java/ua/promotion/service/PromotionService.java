package ua.promotion.service;

import ua.promotion.dao.CompanyDAO;
import ua.promotion.dao.CompanyDAOImpl;
import ua.promotion.dao.PromotionDAO;
import ua.promotion.dao.PromotionDAOImpl;

public class PromotionService {
    private static final PromotionService instance = new PromotionService();
    private PromotionDAO promotionDAO = PromotionDAOImpl.getInstance();
    private CompanyDAO companyDAO = CompanyDAOImpl.getInstance();

    private PromotionService() {
    }

    public static PromotionService getInstance() {
        return instance;
    }


}
