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

    Market market = new Market("Магнит");
    market.addProduct(banana);
    market.addProduct(tomato);
    market.addProduct(potatoes);
    market.addProduct(carrot);
    market.addProduct(cabbage);
    market.addProduct(beet);
    System.out.println(market);

    Recipe salad = new Recipe("Салат");
    salad.addProductInRecipe(cabbage);
    salad.addProductInRecipe(carrot);

    Recipe saladTwo = new Recipe("Салат 2");
    saladTwo.addProductInRecipe(potatoes);
    saladTwo.addProductInRecipe(beet);

    Recipe saladThree = new Recipe("Салат 3");
    saladThree.addProductInRecipe(potatoes);
    saladThree.addProductInRecipe(beet);
    saladThree.addProductInRecipe(carrot);

    ListOfRecipes listOfRecipes = new ListOfRecipes("Рецепты");
    listOfRecipes.addRecipeInList(salad);
    listOfRecipes.addRecipeInList(saladTwo);
    listOfRecipes.addRecipeInList(saladThree);
    listOfRecipes.toStringListOfRecipes();

    System.out.println(
        "Общая стоимость продуктов из рецепта: \"" + salad.getNameRecipe() + "\": "
            + salad.getCostOfProducts() + " рублей");
    System.out.println(
        "Общая стоимость продуктов из рецепта: \"" + saladTwo.getNameRecipe() + "\": "
            + saladTwo.getCostOfProducts() + " рублей");
    System.out.println(
        "Общая стоимость продуктов из рецепта: \"" + saladThree.getNameRecipe() + "\": "
            + saladThree.getCostOfProducts() + " рублей");

    System.out.println();
    Set<Integer> integerSet = new HashSet<>();
    generateRandom(integerSet);
    System.out.println("Рандомные двадцать чисел: " + integerSet);
    List<Integer> integerList = new ArrayList<>();
    getEvenNumbers(integerSet, integerList);
    System.out.println("Оставшиеся четные числа из рандомных: " + integerList);

  }

  public static void getEvenNumbers(Set<Integer> integerSet, List<Integer> integerList) {
    for (Integer integer : integerSet) {
      if (integer % 2 == 0) {
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

}
