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
  @Override
  public CommandStatus validate(String toValidate) {
    if (toValidate == null) {
      return CommandStatus.NULL_PARSE;
    }
    String[] tokens = toValidate.split(" ");
    if (tokens.length != 8) {
      return CommandStatus.BAD_LENGTH;
    }
    if (!tokens[0].toLowerCase().equals("add")) {
      return CommandStatus.BAD_NAME;
    }
    switch (tokens[1].toLowerCase()) {
      case "ff":
        break;
      case "ingredient":
        break;
      default:
        return CommandStatus.BAD_TYPE;
    }
    if(!tokens[2].equalsIgnoreCase("name")) {
      return CommandStatus.BAD_ATTRIBUTE;
    }
    if(!tokens[4].equalsIgnoreCase("price")) {
      return CommandStatus.BAD_ATTRIBUTE;
    }

    return CommandStatus.OK;
  }

  /**
   * This method parses the given String (if it is valid).
   *
   * @param toParse The given String to parse.
   * @return The Command object that was parsed. Null if it is invalid.
   */
  @Override
  public CommandStatus parse(String toParse) {
    CommandStatus validateStatus = validate(toParse);
    if (validateStatus != CommandStatus.OK) {
      return validateStatus;
    }

    String[] tokens = toParse.split(" ");
    switch (tokens[1].toLowerCase()) {
      case "ff":
        type = ItemType.FROZEN_FOOD;
        break;
      case "ingredient":
        type = ItemType.INGREDIENT;
        break;
      default:
        return CommandStatus.BAD_TYPE;
    }
    name = tokens[3];
    price = Integer.parseInt(tokens[5]);
    stock = Integer.parseInt(tokens[7]);
    return CommandStatus.OK;
  }

  /**
   * Runs this Command on the given Storage object.
   *
   * @param storage The Storage object to perform on.
   * @return Whether or not it was successful in its operation(s)
   */
  @Override
  public CommandStatus run(Storage storage) {
    if(storage == null) {
      return CommandStatus.UNHANDLED_ERROR;
    }
    if(type == null || name == null) {
      return CommandStatus.NULL_PARSE;
    }
    Item newItem = new Item(type, name, stock, price);
    if(storage.add(newItem) != true) {
      return CommandStatus.BAD_VALUE;
    }
    return CommandStatus.OK;
  }

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