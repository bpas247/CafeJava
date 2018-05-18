/**
 * This class parses the given string to add items in the storage object.
 *
 * @author: Justin Cheriyan
 * @version 5/18/18
 * @since 5/18/18
 */

public class CommandAdd extends Command {
   private ItemType type;
   private String name;
   private int price;
   private int stock;
   
  /**
   * 
   * Constructor for CommandAdd
   * @param n Name of Command
   */
   public CommandAdd(String n) {
      super(n);
   }
   
  /**
   * This method validates the given String to see if it can be parsed or not.
   *
   * @param toValidate The given String to validate.
   * @return The status of whether or not it was successfully validated.
   */
  public CommandStatus validate(String toValidate) {
    return null;
  }

  /**
   * This method parses the given String (if it is valid).
   *
   * @param toParse The given String to parse.
   * @return The Command object that was parsed. Null if it is invalid.
   */
  public CommandStatus parse(String toParse) {
    return null;
  }

  /**
   * This method runs the Command given the String to describe the command.
   * It should be checked for validity, and then parsed into a Command.
   *
   * @param toParse The given String to parse.
   * @return The status of whether or not it was successfully ran or not
   */
  public CommandStatus run(String toParse, Storage storage) {
    return null;
  }
}
