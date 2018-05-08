public class CommandParser {
  private List<CommandMock> validCommands;
  public CommandParser() {
    //Commands should be inserted into the list here
  }
  public ParserStatus validate(String toValidate) {
    return ParserStatus.UNHANDLED_ERROR;
  }
  public ParserStatus parse(String toParse) {
    return ParserStatus.UNHANDLED_ERROR;
  }
  public ParserStatus runCommand(String toParse) {
    return ParserStatus.UNHANDLED_ERROR;
  }
}
class CommandMock {

}
