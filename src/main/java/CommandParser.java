import java.util.ArrayList;
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
    validCommands = new ArrayList<>(6);

    //Commands should be inserted into the list here
    validCommands.add(new CommandAdd());
    validCommands.add(new CommandChange());
    validCommands.add(new CommandDisplay());
    validCommands.add(new CommandFind());
    validCommands.add(new CommandRemove());
    validCommands.add(new CommandSearch());
  }

  /**
   * This method validates the given String to see if it can be parsed or not.
   *
   * @param toValidate The given String to validate.
   * @return The status of whether or not it was successfully validated.
   */
  public ParserStatus validate(String toValidate) {

    if (toValidate == null) {
      return ParserStatus.UNHANDLED_ERROR;
    }

    //Check name
    boolean validateName = false;
    String name = toValidate.split(" ")[0];
    for (Command cur : validCommands) {
      if (cur.getName().equalsIgnoreCase(name)) {
        validateName = true;
      }
    }
    if (!validateName) {
      return ParserStatus.BAD_COMMAND;
    }

    //Check validation
    boolean validateString = false;
    for (Command cur : validCommands) {
      if (cur.validate(toValidate) == CommandStatus.OK) {
        validateString = true;
      }
    }

    if (!validateString) {
      return ParserStatus.BAD_ARGUMENT;
    }

    return ParserStatus.OK;
  }

  /**
   * This method parses the given String (if it is valid).
   *
   * @param toParse The given String to parse.
   * @return The Command object that was parsed. Null if it is invalid.
   */
  public Command parse(String toParse) {
    //Validate
    if (toParse == null || validate(toParse) != ParserStatus.OK) {
      return null;
    }
    for (Command cur : validCommands) {
      if (cur.validate(toParse) == CommandStatus.OK) {
        Command clone = cur.clone();

        CommandStatus stats = clone.parse(toParse);

        if (stats == CommandStatus.OK) {
          return clone;
        } else {
          return null;
        }
      }
    }
    return null;
  }

  /**
   * This method runs the Command given the String to describe the command.
   * It should be checked for validity, and then parsed into a Command.
   *
   * @param toParse The given String to parse.
   * @param storage The storage object to run its command on
   * @return The status of whether or not it was successfully ran or not
   */
  public ParserStatus runCommand(String toParse, Storage storage) {
    Command parseCommand = parse(toParse);

    if (parseCommand == null) {
      return ParserStatus.BAD_COMMAND;
    }

    CommandStatus stats = parseCommand.run(storage);

    if (stats == CommandStatus.OK) {
      return ParserStatus.OK;
    } else {
      return ParserStatus.UNHANDLED_ERROR;
    }
  }
}