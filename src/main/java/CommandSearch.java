import java.util.Date;
import java.util.List;

/**
 * This class parses the given string to search items in the storage object.
 *
 * @author: Justin Cheriyan
 * @version 6/03/18
 * @since 5/18/18
 */

public class CommandSearch extends Command {
  private String attribute;
  private String value;

  /**
   * Constructor for CommandAdd
   */
  public CommandSearch() {
    super("Search");
  }

  private CommandSearch(String a, String v/*ItemType t, String n, Date d, int in, int s, int p*/) {
    this();
    attribute = a;
    value = v;
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
    if (!tokens[0].toLowerCase().equals("search")) {
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
      case "type":
        break;
      case "name":
        break;
      case "date":
        break;
      case "id":
        break;
      case "stock":
        break;
      case "price":
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
    attribute = tokens[2];
    value = tokens[3];
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
    if(attribute == null || value == null) {
      return CommandStatus.NULL_PARSE;
    }
    List<Item> returnSearch = storage.search(attribute, value);

    if(returnSearch == null) {
      return CommandStatus.UNHANDLED_ERROR;
    }

    for(Item cur : returnSearch) {
      System.out.println(cur);
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
    return new CommandSearch(attribute, value);
  }
}