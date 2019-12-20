package ua.promotion;

import ua.promotion.dao.CompanyDAO;
import ua.promotion.dao.CompanyDAOImpl;
import ua.promotion.entity.Company;

import java.util.List;

public class App {
    private static CompanyDAO companyDAO = CompanyDAOImpl.getInstance();
    public static void main(String[] args) {
        List<Company> companyes = companyDAO.list();
        for (Company companys : companyes){
            System.out.println(companys);
        }


    }
}
