/**
 * This enum represents the state of a parsed command
 * to be used to keep track of different errors that could
 * exist within the parsed command String.
 * 
 * @author  Brady Pascoe
 * @version 5/08/18
 * @since   5/14/18
 */
public enum ParserStatus {
  OK,
  BAD_COMMAND,
  BAD_ARGUMENT,
  UNHANDLED_ERROR
}
