import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class Market {

  private final String name;
  private final Set<Product> products = new HashSet<>();

  Market(String name) {
    this.name = name;
  }

  public void addProduct(Product product) {
    if (products.contains(product)) {
      throw new RuntimeException("Продукт уже куплен: " + product.getName());
    }
    products.add(product);
  }

  public String getName() {
    return name;
  }

  public Set<Product> getProducts() {
    return products;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Market market = (Market) o;
    return Objects.equals(name, market.name) && Objects.equals(products,
        market.products);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, products);
  }

  @Override
  public String toString() {
    return "Магазин: " + "\"" + name + "\"" + " " +
        ", куплены продукты:\n" + products;
  }
}
