import java.util.Date;

/**
 * This class represents a item.
 *
 * @author JD Mauthe
 * @version 5/18/18
 * @since 5/8/18
 */
public class Item {
  private ItemType type;
  private String name;
  private Date dateAdded;
  private int itemNumber;
  private int stock;
  private double price;

  /**
   * Constructor for Item.
   *
   * @param type  Type of Item.
   * @param name  Name of Item.
   * @param stock Stock of Item.
   * @param price Price of Item.
   */
  public Item(ItemType type, String name, int stock, double price) {
  }

  /**
   * This methods takes a attribute and returns the value of the attribute.
   *
   * @param attribute The attribute.
   * @return Sting The value of the given attribute.
   */
  public String getAttribute(String attribute) {
    return "";
  }

  /**
   * Getter for name.
   *
   * @return String Returns the name.
   */
  public String getName() {
    return "";
  }

  /**
   * Getter for type.
   *
   * @return ItemType Returns the type of item.
   */
  public ItemType getType() {
    return null;
  }

  /**
   * Getter for dateAdded.
   *
   * @return Date Returns the dateAdded.
   */
  public Date getDateAdded() {
    return null;
  }

  /**
   * Getter for itemNumber.
   *
   * @return int Returns the itemNumber.
   */
  public int getItemNumber() {
    return 0;
  }

  /**
   * Getter for stock.
   *
   * @return int Returns the stock.
   */
  public int getStock() {
    return 0;
  }

  /**
   * This method is used to set the stock.
   *
   * @param amount The amount to set stock.
   */
  public void setStock(int amount) {
  }

  /**
   * Getter for price.
   *
   * @return double Returns the price.
   */
  public double getPrice() {
    return 0;
  }

  /**
   * This method is used to set the price.
   *
   * @param amount The amount to set price.
   */
  public void setPrice(double amount) {
  }

  /**
   * Overloaded toString
   *
   * @return String The information for the item.
   */
  @Override
  public String toString() {
    return "";
  }

  /**
   * Overloaded hashCode
   *
   * @return int The hash code.
   */
  @Override
  public int hashCode() {
    return 0;
  }
}