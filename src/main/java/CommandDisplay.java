import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * This class parses the given string to display items in the storage object.
 *
 * @author JD Mauthe
 * @version 6/03/18
 * @since 5/13/18
 */
public class CommandDisplay extends Command {
  private String itemType;
  private String attribute;
  private String sortOrder;

  /**
   * Constructor for CommandDisplay
   */
  public CommandDisplay() {
    super("Display");
  }

  private CommandDisplay(String it, String att, String so) {
    this();

    itemType = it;
    attribute = att;
    sortOrder = so;
  }

  /**
   * This method validates the given String.
   *
   * @param toValidate String to validate.
   * @return The status of whether or not it was successfully validated.
   */
  @Override
  public CommandStatus validate(String toValidate) {
    return CommandStatus.UNHANDLED_ERROR;
  }

  /**
   * This method parses the given string.
   *
   * @param toParse String to parse.
   * @return The status of whether or not it was successfully parsed.
   */
  @Override
  public CommandStatus parse(String toParse) {
    return CommandStatus.UNHANDLED_ERROR;
  }

  /**
   * Runs this Command on the given Storage object.
   *
   * @param storage The Storage object to perform on.
   * @return Whether or not it was successful in its operation(s)
   */
  public CommandStatus run(Storage storage) {
    return CommandStatus.UNHANDLED_ERROR;
  }

  /**
   * Runs this Command on the given object based on the given String.
   * It should validate and parse the String before performing its
   * operation(s) on the Storage.
   *
   * @param toParse The string to try and parse.
   * @param storage The Storage object to perform on.
   * @return Whether or not it was successful in its operation(s)
   */
  public CommandStatus run(String toParse, Storage storage) {
    return CommandStatus.UNHANDLED_ERROR;
  }

  /**
   * Copies (or clones) the contents of the current Command instance
   * into a new instance.
   *
   * @return A deep copy of this current instance.
   */
  @Override
  public Command clone() {
    return new CommandDisplay(itemType, attribute, sortOrder);
  }

  /**
   * Sorts the given ArrayList of items based on a specific attribute
   *
   * @param list The list to sort
   * @param attribute the attribute to sort the Item objects by
   */
  private void sortItemList(List<Item> list, String attribute) {
    if(list == null || list.size() == 0 || list.get(0).getAttribute(attribute) == null) {
      return;
    } else {
      for(int i = 0; i < list.size() - 1; i++) {
        for(int j = 0; j < list.size() - 1; j++) {
          String curAttr = list.get(j).getAttribute(attribute);
          String nextAttr = list.get(j+1).getAttribute(attribute);

          //If the next thing is heavier than the current thing
          if(curAttr.compareToIgnoreCase(nextAttr) < 0) {
            //Swap the indices
            Collections.swap(list, j, j+1);
          }
        }
      }
    }
  }
}
