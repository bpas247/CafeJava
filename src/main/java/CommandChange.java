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
    return new CommandChange(itemType, findAttribute, findValue, changeAttribute, changeValue);
  }
}
