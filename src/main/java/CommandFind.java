/**
 * This class parses the given string to find items in the storage object.
 *
 * @author JD Mauthe
 * @version 5/13/18
 * @since 5/13/18
 */
public class CommandFind extends Command {
    private String itemType;
    private String attribute;
    private String value;

    /**
     * Constructor for CommandFind.
     * @param n Name of command.
     */
    public CommandFind(String n) {
        super(n);
    }

    /**
     * This method validates the given String.
     * @param toValidate String to validate.
     * @return The status of whether or not it was successfully validated.
     */
    @Override
    public CommandStatus validate(String toValidate) {
        return null;
    }

    /**
     * This method parses the given string.
     * @param toParse String to parse.
     * @return The status of whether or not it was successfully parsed.
     */
    @Override
    public CommandStatus parse(String toParse) {
        return null;
    }

    /**
     * This method runs the display command.
     * @param toParse String to parse.
     * @param storage The storage to run command on.
     * @return The status of whether or not it was successfully run.
     */
    @Override
    public CommandStatus run(String toParse, StorageMock storage) {
        return null;
    }
}
