package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
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

        System.out.println("\n=== TESTE 4: Seller insert ===");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());

        System.out.println("\n=== TESTE 5: Seller update ===");
        seller = sellerDao.findById(newSeller.getId());
        seller.setName("Greg Alterado");
        sellerDao.update(seller);
        System.out.println("Update completed");

        System.out.println("\n=== TESTE 6: Seller delete ===");
        seller = sellerDao.findById(newSeller.getId());
        sellerDao.deleteById(seller.getId());
        System.out.println("Delete completed");



    }
}
