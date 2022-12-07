import java.util.ArrayList;

public class Main {

  public static void main(String[] args) {
    Product banana = new Product("Банан", 120.0, 1.5);
    Product tomato = new Product("Помидор", 100.0, 1.0);
    Product potatoes = new Product("Картошка", 80.0, 5.5);
    Product carrot = new Product("Морковь", 70.5, 2.5);
    Product cabbage = new Product("Капуста", 85.0, 3.0);
    Product beet = new Product("Свёкла", 95.0, 1.0);
    ArrayList<Product> productsList = new ArrayList<>();
    addProduct(banana,productsList);
    addProduct(tomato,productsList);
    addProduct(potatoes,productsList);
    addProduct(carrot,productsList);
    addProduct(cabbage,productsList);
    addProduct(beet,productsList);


  }
  public static void addProduct(Product product, ArrayList<Product> productsList) {
    if (productsList.contains(product)){
      throw new RuntimeException("Продукт уже есть в списке: " + product.getName());
    }else {
      productsList.add(product);
    }
  }
}
