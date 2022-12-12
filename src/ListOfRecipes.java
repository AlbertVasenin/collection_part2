import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListOfRecipes {

  private final List<Recipe> recipesList = new ArrayList<>();
  private final String name;

  ListOfRecipes(String name) {
    this.name = (name != null) ? name : "Список рецептов";
  }

  public void addRecipeInList(Recipe recipe) {
    if (recipesList.contains(recipe) && recipe.getNameRecipe().equals(recipe.getNameRecipe())
        && recipe.getProducts() == recipe.getProducts()) {
      throw new RuntimeException("Рецепт уже есть в списке: " + recipe.getNameRecipe());
    } else {
      recipesList.add(recipe);
    }
  }

  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListOfRecipes that = (ListOfRecipes) o;
    return Objects.equals(recipesList, that.recipesList) && Objects.equals(name, that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(recipesList, name);
  }

  public void toStringListOfRecipes() {
    System.out.println(getName() + ":");
    for (Recipe recipe : recipesList) {
      if (recipesList.contains(recipe)) {
        System.out.println("\"" + recipe.getNameRecipe() + "\"");
      }
    }
  }
}
