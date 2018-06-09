/**
 * This class parses the given string to remove items in the storage object.
 *
 * @author: Justin Cheriyan
 * @version 6/03/18
 * @since 5/18/18
 */

public class CommandRemove extends Command {
  private ItemType type;
  private String name;
  private int id;
  private int stock;

  /**
   * Constructor for CommandAdd
   */
  public CommandRemove() {
    super("Remove");
  }

  private CommandRemove(ItemType t, String n, int in, int s) {
    this();

    type = t;
    name = n;
    id = in;
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
    if (tokens.length != 4) {
      return CommandStatus.BAD_LENGTH;
    }
    if (!tokens[0].equalsIgnoreCase("remove")) {
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
    switch (tokens[2].toLowerCase()) {
      case "name":
        break;
      case "id":
        break;
      default:
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

    switch (tokens[2].toLowerCase()) {
      case "name":
        name = tokens[3];
        id = -1;
        break;
      case "id":
        name = "-1";
        id = Integer.parseInt(tokens[3]);
        break;
      default:
        return CommandStatus.BAD_ATTRIBUTE;
    }
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
    if (storage == null) {
      return CommandStatus.UNHANDLED_ERROR;
    }
    if (type == null || name == null) {
      return CommandStatus.NULL_PARSE;
    }
    if (name.equals("-1") && id == -1) {
      return CommandStatus.BAD_VALUE;
    }

    if (!name.equals("-1")) {
      Item foundItem = storage.find("name", name);
      if (foundItem == null) {
        return CommandStatus.BAD_VALUE;
      }

      if (!storage.remove(foundItem)) {
        return CommandStatus.UNHANDLED_ERROR;
      }
      return CommandStatus.OK;
    } else if (id != -1) {
      Item foundItem = storage.find(id);

      if (foundItem == null) {
        return CommandStatus.BAD_VALUE;
      }

      if (!storage.remove(foundItem)) {
        return CommandStatus.UNHANDLED_ERROR;
      }
    } else {
      return CommandStatus.UNHANDLED_ERROR;
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
    return new CommandRemove(type, name, id, stock);
  }
}