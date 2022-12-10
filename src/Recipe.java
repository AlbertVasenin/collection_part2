import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Recipe {

  private final Set<Product> products = new HashSet<>();
  private Double costOfProducts = 0.0;
  private final String nameRecipe;

  public Recipe(String nameRecipe) {
    this.nameRecipe = (nameRecipe != null && !nameRecipe.trim().isEmpty()) ? nameRecipe
        : "...введите название рецепта...";
  }

  public void addProductInRecipe(Product product) {
    if (products.contains(product)) {
      throw new RuntimeException("Продукт уже есть в списке рецепта: " + product.getName());
    }
    products.add(product);
  }

  public Set<Product> getProducts() {
    return products;
  }

  public Double getCostOfProducts() {
    for (Product product : products) {
      costOfProducts += product.getPrice();
    }
    return costOfProducts;
  }

  public String getNameRecipe() {
    return nameRecipe;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Recipe recipe = (Recipe) o;
    return Objects.equals(products, recipe.products) && Objects.equals(costOfProducts,
        recipe.costOfProducts) && Objects.equals(nameRecipe, recipe.nameRecipe);
  }

  @Override
  public int hashCode() {
    return Objects.hash(products, costOfProducts, nameRecipe);
  }

  @Override
  public String toString() {
    return String.format("\nНазвание рецепта:\"%s\", необходимые продукты:%s\n", nameRecipe,
        getProducts());
  }
}
