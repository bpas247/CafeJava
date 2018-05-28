import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class represents a item.
 *
 * @author JD Mauthe
 * @version 5/25/18
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
  public Item(int itemNumber, ItemType type, String name, int stock, double price) {
    this.type = type;
    this.name = name;
    this.dateAdded = new Date();
    setItemNumber(itemNumber);
    setStock(stock);
    setPrice(price);
  }

  /**
   * This methods takes a attribute and returns the value of the attribute.
   *
   * @param attribute The attribute.
   * @return Sting The value of the given attribute.
   */
  public String getAttribute(String attribute) {
    attribute = attribute.toLowerCase();
    switch (attribute) {
      case "type":
        return type.toString();
      case "name":
        return name;
      case "date":
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        return dateFormat.format(dateAdded);
      case "number":
        return String.valueOf(itemNumber);
      case "stock":
        return String.valueOf(stock);
      case "price":
        return String.format("%.2f", price);
      default:
        return "Unknown Attribute";
    }
  }

  /**
   * Getter for name.
   *
   * @return String Returns the name.
   */
  public String getName() {
    return name;
  }

  /**
   * Getter for type.
   *
   * @return ItemType Returns the type of item.
   */
  public ItemType getType() {
    return type;
  }

  /**
   * Getter for dateAdded.
   *
   * @return Date Returns the dateAdded.
   */
  public Date getDateAdded() {
    return dateAdded;
  }

  /**
   * Getter for itemNumber.
   *
   * @return int Returns the itemNumber.
   */
  public int getItemNumber() {
    return itemNumber;
  }

  /**
   * Sets the item number, if the parameter is not between 1000 and 9999, then item number is
   * set as -1.
   *
   * @param itemNumber The item number to be set.
   */
  private void setItemNumber(int itemNumber) {
    if (itemNumber < 1000 || itemNumber > 9999) {
      itemNumber = -1;
    }
    this.itemNumber = itemNumber;
  }

  /**
   * Getter for stock.
   *
   * @return int Returns the stock.
   */
  public int getStock() {
    return stock;
  }

  /**
   * This method is used to set the stock.
   *
   * @param amount The amount to set stock.
   */
  public void setStock(int amount) {
    if (amount < 0) {
      amount = 0;
    }
    stock = amount;
  }

  /**
   * Getter for price.
   *
   * @return double Returns the price.
   */
  public double getPrice() {
    return price;
  }

  /**
   * This method is used to set the price.
   *
   * @param amount The amount to set price.
   */
  public void setPrice(double amount) {
    if (amount < 0) {
      amount = 0;
    }
    amount = Math.round(amount * 100.0) / 100.0; //Round amount to 2 decimal places
    price = amount;
  }

  /**
   * Overridden toString
   *
   * @return String The information for the item.
   */
  @Override
  public String toString() {
    return getAttribute("number") + " " + getAttribute("name") + " " + getAttribute("type") + " " + getAttribute("stock") + " "
        + "$" + getAttribute("price") + " " + getAttribute("date");
  }

  /**
   * Overridden hashCode
   *
   * @return int The hash code.
   */
  @Override
  public int hashCode() {
    int asciiValue = 0;
    for (int position = 0; position < name.length(); position++) {
      asciiValue += name.charAt(position);
    }
    return Integer.parseInt(String.valueOf(itemNumber) + String.valueOf(asciiValue));
  }
}

