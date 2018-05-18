/**
 * This abstract class is a template for all of the Commands that
 * can be performed on the Storage object.
 *
 * @author Brady Pascoe
 * @version 5/14/18
 * @since 5/10/18
 */
public abstract class Command {
  private String name; //Name of the Command

  /**
   * Initializes the name of the Command
   *
   * @param n What to name the Command
   */
  public Command(String n) {
    name = n;
  }

  /**
   * Get's the name of the Command
   * @return The name of the command,
   */
  public String getName() {
    return name;
  }

  /**
   * Validates the given String to see if it matches this Command
   *
   * @param toValidate The String to validate user input from.
   * @return The status on the validity of the String
   */
  public abstract CommandStatus validate(String toValidate);

  /**
   * Validates and parses the given String for any additional arguments.
   *
   * @param toParse The String to validate and parse from
   * @return The status on if it's parsable
   */
  public abstract CommandStatus parse(String toParse);

  /**
   * Runs this Command on the given object based on the given String.
   * It should validate and parse the String before performing its
   * operation(s) on the Storage.
   *
   * @param toParse Validates and parses this String before running
   * @param storage The Storage object to perform on.
   * @return Whether or not it was successful in its operation(s)
   */
  public abstract CommandStatus run(String toParse, Storage storage);
}
