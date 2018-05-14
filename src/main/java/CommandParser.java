import java.util.List;

/**
 * This class parses a given String to manipulate the Storage object in some way.
 * It also checks for valid and invalid Commands within the given String.
 *
 * @author Brady Pascoe
 * @version 5/08/18
 * @since 5/07/18
 */
public class CommandParser {
  private List<Command> validCommands;

  public CommandParser() {
    //Commands should be inserted into the list here
  }

  /**
   * This method validates the given String to see if it can be parsed or not.
   *
   * @param toValidate The given String to validate.
   * @return The status of whether or not it was successfully validated.
   */
  public ParserStatus validate(String toValidate) {
    return ParserStatus.UNHANDLED_ERROR;
  }

  /**
   * This method parses the given String (if it is valid).
   *
   * @param toParse The given String to parse.
   * @return The Command object that was parsed. Null if it is invalid.
   */
  public Command parse(String toParse) {
    return null;
  }

  /**
   * This method runs the Command given the String to describe the command.
   * It should be checked for validity, and then parsed into a Command.
   *
   * @param toParse The given String to parse.
   * @return The status of whether or not it was successfully ran or not
   */
  public ParserStatus runCommand(String toParse) {
    return ParserStatus.UNHANDLED_ERROR;
  }
}