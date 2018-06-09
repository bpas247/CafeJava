/**
 * This class parses the given string to add items in the storage object.
 *
 * @author: Justin Cheriyan
 * @version 6/03/18
 * @since 5/18/18
 */

public class CommandAdd extends Command {
  private ItemType type;
  private String name;
  private int price;
  private int stock;

  /**
   * Constructor for CommandAdd
   */
  public CommandAdd() {
    super("Add");
  }

  private CommandAdd(ItemType t, String n, int p, int s) {
    this();
    type = t;
    name = n;
    price = p;
    stock = s;
  }

  /**
   * This method validates the given String to see if it can be parsed or not.
   *
   * @param toValidate The given String to validate.
   * @return The status of whether or not it was successfully validated.
   */
  public CommandStatus validate(String toValidate) {
    return CommandStatus.UNHANDLED_ERROR;
  }

  /**
   * This method parses the given String (if it is valid).
   *
   * @param toParse The given String to parse.
   * @return The Command object that was parsed. Null if it is invalid.
   */
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
//  @Override
//  public CommandStatus run(String toParse, Storage storage) {
//    return CommandStatus.UNHANDLED_ERROR;
//  }

  /**
   * Copies (or clones) the contents of the current Command instance
   * into a new instance.
   *
   * @return A deep copy of this current instance.
   */
  @Override
  public Command clone() {
    return new CommandAdd(type, name, price, stock);
  }
}