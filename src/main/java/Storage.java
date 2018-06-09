import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * This class stores Item objects that can be manipulated by
 * Command objects. it utilizes a hashmap based on the output
 * of the has() function from each Item object.
 *
 * @author Brady Pascoe
 * @version 5/28/18
 * @since 5/08/18
 */
public class Storage {
  private HashMap<Integer, Item> items = new HashMap<>();
  private int hashGen = 1000; //VERY primitive hash number generator variable

  /**
   * Searches for a specific hashcode and returns
   * the top 10 most relevant hash codes.
   *
   * @param itemHash the hashcode to search for
   * @return A list of 10 Item objects that match itemHash
   */
  public List<Item> search(int itemHash) {
    List<Item> out = null;
    int size = 10;

    if (items.size() < 10) {
      size = items.size();
    }
    out = new ArrayList<>(size);

    Object[] itemColl = items.values().toArray();

    //Find the closest number based on distance
    //To the given hash number
    int closestIndex = 0, closestDis = Integer.MAX_VALUE;
    for (int i = 0; i < itemColl.length; i++) {
      Item cur = (Item) itemColl[i];
      int curDis = Math.abs(itemHash - cur.getItemNumber());
      if (curDis < closestDis) {
        closestDis = curDis;
        closestIndex = i;
      }
    }

    int counter = size; //Set the counter to size
    int index = closestIndex; //Start it at closest index
    while (counter > 0) {
      counter--;
      if (index >= itemColl.length) {
        index = 0;
      }

      out.add((Item) itemColl[index]);

      index++;
    }

    return out;
  }
  /**
   * Searches for a specified attribute with
   * a specified value and returns
   * the top 10 most relevant hash codes.
   *
   * @param attribute the attribute to search for
   * @param value the value of the attrbute
   * @return A list of 10 Item objects that match itemHash
   */
  public List<Item> search(String attribute, String value) {
    List<Item> out;
    int size = 10;

    if (items.size() < 10) {
      size = items.size();
    }
    out = new ArrayList<>(size);

    Object[] itemColl = items.values().toArray();

    if(((Item) itemColl[0]).getAttribute(attribute) == null) {
      return null;
    }

    //Find the closest number based on distance
    //To the given hash number
    int closestIndex = 0, closestDis = Integer.MAX_VALUE;
    for (int i = 0; i < itemColl.length; i++) {
      Item cur = (Item) itemColl[i];
      int curDis = cur.getAttribute(attribute).compareToIgnoreCase(value);
      if (curDis < closestDis) {
        closestDis = curDis;
        closestIndex = i;
      }
    }

    int counter = size; //Set the counter to size
    int index = closestIndex; //Start it at closest index
    while (counter > 0) {
      counter--;
      if (index >= itemColl.length) {
        index = 0;
      }

      out.add((Item) itemColl[index]);

      index++;
    }

    return out;
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
    return items.get(itemHash);
  }

  /**
   * Searches for a specific name and returns
   * the specific item represented by that hash.
   * Null if it is not present in Storage.
   *
   * @param attribute the attribute of the item to find.
   * @param value the value of the attribute of the item to find.
   * @return The Item object it finds. Null if it's not present.
   */
  public Item find(String attribute, String value) {
    Object[] itemColl = items.values().toArray();

    for(Object cur : itemColl) {
      Item curItem = (Item) cur;
      String returnedValue = curItem.getAttribute(attribute.toLowerCase());
      if(returnedValue == null) {
        return null;  //Not a valid attribute
      }
      if(returnedValue.equals(value)) {
        return curItem;
      }
    }
    return null;
  }

  /**
   * Adds the given item into Storage.
   *
   * @param itemToAdd the Item to add into Storage
   * @return Whether or not it was added into Storage
   */
  public boolean add(Item itemToAdd) {
    if (items.containsKey(itemToAdd.getItemNumber())) {
      return false;
    }
    if (itemToAdd.getItemNumber() == -1) { //Does it not have an item number?
      while(items.containsKey(hashGen)) { //Prevents hashgen from overwriting existing numbers
        hashGen++;
      }
      itemToAdd = new Item(hashGen, itemToAdd.getType(), itemToAdd.getName(), itemToAdd.getStock(), itemToAdd.getPrice());
    }

    items.put(itemToAdd.getItemNumber(), itemToAdd);

    return items.containsValue(itemToAdd);
  }

  /**
   * Removes the given item from Storage.
   *
   * @param itemToRemove the Item to remove from Storage
   * @return Whether or not it was removed from Storage
   */
  public boolean remove(Item itemToRemove) {
    if (itemToRemove.getItemNumber() == -1) {
      return false;
    }

    items.remove(itemToRemove.getItemNumber());

    return !items.containsKey(itemToRemove.getItemNumber());
  }

  /**
   * Returns a deep copy of all of the items in the current hashmap
   *
   * @return A copy of the list of every item in Storage
   */
  public List<Item>getList() {
    if(items.size() == 0) {
      return null;
    } else {
      List<Item> out = new ArrayList<>(items.size());
      Collection<Item> coll = items.values();
      for(Item cur : coll) {
        out.add(cur.clone());
      }

      return out;
    }
  }
}