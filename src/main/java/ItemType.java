/**
 * Values that can be used for the type of item.
 */
public enum ItemType {
  /**
   * Frozen Food
   */
  FROZEN_FOOD,

  /**
   * Ingredient
   */
  INGREDIENT;


  /**
   * Overridden toString()
   *
   * @return String The item type.
   */
  @Override
  public String toString() {
    switch (this) {
      case FROZEN_FOOD:
        return "Frozen-Food";
      case INGREDIENT:
        return "Ingredient";
      default:
        return "Unknown";
    }
  }
}
