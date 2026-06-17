import java.util.HashMap;

class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    void display() {
        System.out.println("ID: " + productId +
                ", Name: " + productName +
                ", Quantity: " + quantity +
                ", Price: ₹" + price);
    }
}

public class InventoryManagementSystem {

    static HashMap<Integer, Product> inventory = new HashMap<>();

    // Add Product
    public static void addProduct(Product product) {
        inventory.put(product.productId, product);
        System.out.println("Product Added Successfully");
    }

    // Update Product
    public static void updateProduct(int productId, int newQuantity, double newPrice) {
        if (inventory.containsKey(productId)) {
            Product p = inventory.get(productId);
            p.quantity = newQuantity;
            p.price = newPrice;
            System.out.println("Product Updated Successfully");
        } else {
            System.out.println("Product Not Found");
        }
    }

    // Delete Product
    public static void deleteProduct(int productId) {
        if (inventory.containsKey(productId)) {
            inventory.remove(productId);
            System.out.println("Product Deleted Successfully");
        } else {
            System.out.println("Product Not Found");
        }
    }

    // Display Inventory
    public static void displayInventory() {
        System.out.println("\nInventory Details:");
        for (Product p : inventory.values()) {
            p.display();
        }
    }

    public static void main(String[] args) {

        addProduct(new Product(101, "Laptop", 10, 55000));
        addProduct(new Product(102, "Mobile", 20, 25000));
        addProduct(new Product(103, "Keyboard", 15, 1500));

        displayInventory();

        updateProduct(102, 25, 26000);

        deleteProduct(103);

        displayInventory();
    }
}