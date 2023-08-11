package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.List;


public class Program {

    public static void main(String[] args) {
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TESTE 1: Seller findById ===");
        Seller seller = sellerDao.findById(4);
        System.out.println(seller);

        System.out.println("\n=== TESTE 2: Seller findByDepartment ===");
        Department department = new Department(2, null);
        List<Seller> sellers = sellerDao.findByDepartment(department);
        for (Seller obj: sellers) {
            System.out.println(obj);
        }

        System.out.println("\n=== TESTE 3: Seller findAll ===");
        List<Seller> sellers2 = sellerDao.findAll();
        for (Seller obj: sellers2) {
            System.out.println(obj);
        }
    }
}
