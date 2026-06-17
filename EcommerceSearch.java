
class Product {
    int productId;
    String productName;
    String category;

    Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
}

public class EcommerceSearch {

    // Linear Search
    public static Product linearSearch(Product[] products, int id) {

        for(Product p : products) {

            if(p.productId == id) {
                return p;
            }
        }

        return null;
    }

    // Binary Search
    public static Product binarySearch(Product[] products, int id) {

        int low = 0;
        int high = products.length - 1;

        while(low <= high) {

            int mid = (low + high) / 2;

            if(products[mid].productId == id) {
                return products[mid];
            }

            if(products[mid].productId < id) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        Product[] products = {
            new Product(101,"Laptop","Electronics"),
            new Product(102,"Mobile","Electronics"),
            new Product(103,"Chair","Furniture"),
            new Product(104,"Table","Furniture"),
            new Product(105,"Sofa","Furniture")
        };

        Product result1 = linearSearch(products,104);

        if(result1 != null) {
            System.out.println("Linear Search Found: "
                    + result1.productName);
        }

        Product result2 = binarySearch(products,104);

        if(result2 != null) {
            System.out.println("Binary Search Found: "
                    + result2.productName);
        }
    }
}