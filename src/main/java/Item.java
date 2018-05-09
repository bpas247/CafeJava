import java.util.Date;

/**
 * Item is an abstract base class.
 * @author JD Mauthe
 */
abstract public class Item {
    String name;
    Date dateAdded;
    int itemNumber;
    int stock;
    double price;

    /**
     * Constructor for Item.
     * @param name Name of Item.
     * @param itemNumber Number of Item.
     * @param stock Stock of Item.
     * @param price Price of Item.
     */
    Item(String name, int itemNumber, int stock, double price) {
    }

    /**
     * Getter for name.
     * @return String Returns the name.
     */
    public String getName() {
        return "";
    }

    /**
     * Getter for dateAdded.
     * @return Date Returns the dateAdded.
     */
    public Date getDateAdded() {
        return null;
    }

    /**
     * Getter for itemNumber.
     * @return int Returns the itemNumber.
     */
    public int getItemNumber() {
        return 0;
    }

    /**
     * Getter for stock.
     * @return int Returns the stock
     */
    public int getStock() {
        return 0;
    }

    /**
     * Getter for price.
     * @return double Returns the price
     */
    public double getPrice() {
        return 0;
    }

    /**
     * This method is used to increase the stock.
     * @param amount The amount to increase stock.
     */
    public void increaseStock(int amount) {
    }

    /**
     * This method is used to decrease the amount of stock.
     * @param amount The amount to decrease stock.
     */
    public void decreaseStock(int amount) {
    }

    /**
     * This method is used to increase the price.
     * @param amount The amount to increase price
     */
     public void increasePrice(int amount) {
    }

    /**
     * This method is used to decrease price.
     * @param amount The amount to decrease price.
     */
    public void decreasePrice(int amount) {
    }

    /**
     * Overloaded toString
     * @return String The information for the item
     */
    @Override
    public String toString() {
        return "";
    }

    /**
     * Overloaded hashCode
     * @return int The hash code
     */
    @Override
    public int hashCode() {
        return 0;
    }
}
