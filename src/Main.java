import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Main {

  public static void main(String[] args) {
    Product banana = new Product("Банан", 120.0, 1.5);
    Product tomato = new Product("Помидор", 100.0, 1.0);
    Product potatoes = new Product("Картошка", 80.0, 5.5);
    Product carrot = new Product("Морковь", 70.5, 2.5);
    Product cabbage = new Product("Капуста", 85.0, 3.0);
    Product beet = new Product("Свёкла", 95.0, 1.0);

    ArrayList<Product> productsList = new ArrayList<>();
    addProduct(banana, productsList);
    addProduct(tomato, productsList);
    addProduct(potatoes, productsList);
    addProduct(carrot, productsList);
    addProduct(cabbage, productsList);
    addProduct(beet, productsList);

    Recipe salad = new Recipe("Салат", new HashSet<>(), null);
    salad.addProductInRecipe(cabbage);
    salad.addProductInRecipe(carrot);

    Recipe saladTwo = new Recipe("Салат 2", new HashSet<>(), null);
    saladTwo.addProductInRecipe(potatoes);
    saladTwo.addProductInRecipe(beet);

    Recipe saladThree = new Recipe("Салат 3", new HashSet<>(), null);
    saladThree.addProductInRecipe(potatoes);
    saladThree.addProductInRecipe(beet);

    ArrayList<Recipe> recipesList = new ArrayList<>();
    addRecipeList(salad, recipesList);
    addRecipeList(saladTwo, recipesList);
    addRecipeList(saladThree, recipesList);
    System.out.println(recipesList);

    System.out.println(
        "Общая стоимость продуктов из рецепта: " + salad.getNameRecipe() + ": "
            + getSumProductsRecipe(
            salad) + " рублей");
    System.out.println(
        "Общая стоимость продуктов из рецепта: " + saladTwo.getNameRecipe() + ": "
            + getSumProductsRecipe(saladTwo) + " рублей");

    System.out.println();
    Set<Integer> integerSet = new HashSet<>();
    generateRandom(integerSet);
    System.out.println(integerSet);
    List<Integer> integerList = new ArrayList<>();
    getEvenNumbers(integerSet, integerList);
    System.out.println(integerList);

  }

  public static void getEvenNumbers(Set<Integer> integerSet, List<Integer> integerList) {
    for (Integer integer : integerSet) {
      if (integer.intValue() % 2 == 0) {
        integerList.add(integer);
      }
    }
  }

  public static void generateRandom(Set<Integer> integerSet) {
    Random random = new Random();
    int i = 0;
    while (i < 20) {
      integerSet.add(random.nextInt(1000));
      i++;
    }
  }

  public static void addRecipeList(Recipe recipe, ArrayList<Recipe> recipesList) {
    if (recipesList.contains(recipe) && recipe.getNameRecipe().equals(recipe.getNameRecipe())
        && recipe.getProducts() == recipe.getProducts()) {
      throw new RuntimeException("Рецепт уже есть в списке: " + recipe.getNameRecipe());
    } else {
      recipesList.add(recipe);
    }
  }

  public static double getSumProductsRecipe(Recipe recipe) {
    double sum = 0;
    List<Product> products = new ArrayList<>(recipe.getProducts());
    for (Product product : products) {
      sum = sum + product.getPrice();
    }
    return sum;
  }

  public static void addProduct(Product product, ArrayList<Product> productsList) {
    if (productsList.contains(product)) {
      throw new RuntimeException("Продукт уже есть в списке: " + product.getName());
    } else {
      productsList.add(product);
    }
  }
}
