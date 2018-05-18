import java.util.HashMap;
import java.util.List;

/**
 * This class stores Item objects that can be manipulated by
 * Command objects. it utilizes a hashmap based on the output
 * of the has() function from each Item object.
 *
 * @author Brady Pascoe
 * @version 5/14/18
 * @since 5/08/18
 */
public class Storage {
  private HashMap<Integer, Item> items = new HashMap<>();

  /**
   * Searches for a specific hashcode and returns
   * the top 10 most relevant hash codes.
   *
   * @param itemHash the hashcode to search for
   * @return A list of 10 Item objects that match itemHash
   */
  public List<Item> search(int itemHash) {
    return null;
  }

  /**
   * Searches for a specific hashcode and returns
   * the specific item represented by that hash.
   * Null if it is not present in Storage.
   *
   * @param itemHash the hashcode to search for
   * @return The Item object it finds. Null if it's not present
   */
  public Item find(int itemHash) {
    return null;
  }

  /**
   * Adds the given item into Storage.
   *
   * @param itemToAdd the Item to add into Storage
   * @return Whether or not it was added into Storage
   */
  public boolean add(Item itemToAdd) {
    return false;
  }

  /**
   * Removes the given item from Storage.
   *
   * @param itemToRemove the Item to remove from Storage
   * @return Whether or not it was removed from Storage
   */
  public boolean remove(Item itemToRemove) {
    return false;
  }
}