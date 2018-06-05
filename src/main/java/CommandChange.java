/**
 * This class parses the given string to change items in the storage object.
 *
 * @author JD Mauthe
 * @version 6/03/18
 * @since 5/13/18
 */
public class CommandChange extends Command {
  private String itemType;
  private String findAttribute;
  private String findValue;
  private String changeAttribute;
  private String changeValue;

  /**
   * Constructor for CommandChange.
   */
  public CommandChange() {
    super("Change");
  }

  private CommandChange(String it, String fa, String fv, String ca, String cv) {
    this();

    itemType = it;
    findAttribute = fa;
    findValue = fv;
    changeAttribute = ca;
    changeValue = cv;
  }

  /**
   * This method validates the given String.
   *
   * @param toValidate String to validate.
   * @return The status of whether or not it was successfully validated.
   */
  @Override
  public CommandStatus validate(String toValidate) {
    if (toValidate == null) {
      return CommandStatus.NULL_PARSE;
    }
    String[] tokens = toValidate.split(" ");
    if (tokens.length != 6) {
      return CommandStatus.BAD_LENGTH;
    }
    if (!tokens[0].toLowerCase().equals("change")) {
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
    try {
      switch (tokens[2].toLowerCase()) {
        case "name":
          break;
        case "id":
          Integer.valueOf(tokens[3]);
          break;
        default:
          return CommandStatus.BAD_ATTRIBUTE;
      }

      switch (tokens[4].toLowerCase()) {
        case "stock":
          Integer.valueOf(tokens[5]);
          break;
        case "price":
          Double.valueOf(tokens[5]);
          break;
        default:
          return CommandStatus.BAD_ATTRIBUTE;
      }
    } catch (NumberFormatException e) {
      return CommandStatus.BAD_VALUE;
    }
    return CommandStatus.OK;
  }

  /**
   * This method parses the given string.
   *
   * @param toParse String to parse.
   * @return The status of whether or not it was successfully parsed.
   */
  @Override
  public CommandStatus parse(String toParse) {
    CommandStatus validateStatus = validate(toParse);
    if (validateStatus != CommandStatus.OK) {
      return validateStatus;
    }
    String[] tokens = toParse.split(" ");
    itemType = tokens[1];
    findAttribute = tokens[2];
    findValue = tokens[3];
    changeAttribute = tokens[4];
    changeValue = tokens[5];
    return CommandStatus.OK;
  }

  /**
   * Runs this Command on the given Storage object.
   *
   * @param storage The Storage object to perform on.
   * @return Whether or not it was successful in its operation(s)
   */
  public CommandStatus run(Storage storage) {
    if (storage == null) {
      return CommandStatus.UNHANDLED_ERROR;
    }
    if (findAttribute == null || findValue == null || changeAttribute == null || changeValue == null) {
      return CommandStatus.NULL_PARSE;
    }
    Item findItem = storage.find(findAttribute, findValue);
    if (findItem == null) {
      System.out.println("Item not found");
    } else {
      switch (changeAttribute) {
        case "stock":
          findItem.setStock(findItem.getStock() + Integer.valueOf(changeValue));
          break;
        case "price":
          findItem.setPrice(findItem.getPrice() + Double.valueOf(changeValue));
          break;
        default:
          return CommandStatus.BAD_ATTRIBUTE;
      }
      System.out.println(findItem);
    }
    return CommandStatus.OK;
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
    CommandStatus parseStatus = parse(toParse);
    if (parseStatus != CommandStatus.OK) {
      return parseStatus;
    }
    return run(storage);
  }

  /**
   * Copies (or clones) the contents of the current Command instance
   * into a new instance.
   *
   * @return A deep copy of this current instance.
   */
  @Override
  public Command clone() {
    return new CommandChange(itemType, findAttribute, findValue, changeAttribute, changeValue);
  }
}
