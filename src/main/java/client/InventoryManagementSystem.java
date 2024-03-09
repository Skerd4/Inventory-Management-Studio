package client;

import dto.CategoryRequest;
import dto.ProductRequest;
import entity.Category;
import entity.Product;
import service.ProductService;
import service.ProductServiceImpl;

import java.util.List;
import java.util.Scanner;

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Inventory Management System");
        System.out.println("1. Add product");
        System.out.println("2, Display all products");
        System.out.println("3, Notify for low stock product");
        System.out.println("4, Add category");
        System.out.println("5 display all categories");
        int choice = sc.nextInt();


        switch (choice){
            case 1:
                addProduct(sc);
                break;
            case 2:
                displayAllProduct();
                    break;

            case 3:
                lowStock();
                break;

            case 4:
                addCategory(sc);

        }


    }

    private static void displayAllProduct() {
        ProductService productService = new ProductServiceImpl();
        List<Product> products = productService.displayAllProduct();
        for (Product product: products) {
            System.out.println(product);
        }
    }


    public static void addProduct(Scanner scanner){
        ProductRequest productRequest = new ProductRequest();
        System.out.println("Ju lutem fusni emrin e produktit");
        productRequest.setTitle(scanner.next());
        System.out.println("Ju lutem fusni pershkrimin e produktit");
        productRequest.setDescription(scanner.next());
        System.out.println("Ju lutem fusni sasine e produktit");
        productRequest.setQuantity(scanner.nextInt());
        System.out.println("Ju lutem fusni  categorine e produktit");
        productRequest.setCategoryId(scanner.nextLong());
        System.out.println("Ju lutem fusni cmimin e produktit");
        productRequest.setPrice(scanner.nextDouble());
        ProductServiceImpl productService = new ProductServiceImpl();
        productService.addProduct(productRequest);
}

    public static void lowStock(){
        ProductService productService = new ProductServiceImpl();
        List<Product> products = productService.notifyForLowStock();
        for (Product product: products) {
            System.out.println(product);
        }
    }

    public static void  addCategory(Scanner scanner){
        System.out.println("Ju lutem fusni emrin e kategorise");
        CategoryRequest request = new CategoryRequest();
        request.setTitle(scanner.next());
        ProductService productService = new ProductServiceImpl();
        productService.addCategory(request);
    }
}
