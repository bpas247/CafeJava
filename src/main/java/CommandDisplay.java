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
}
