import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CommandParserTest {
  private CommandParser test;

  @Before
  public void setUp() throws Exception {
    test = new CommandParser();
  }

  enum Function {
    VALIDATE,
    PARSE,
    RUN
  }

  private void runTest(String toValidate, Function method) {

    switch(method) {
      case VALIDATE:
        Assert.assertEquals(ParserStatus.OK, test.validate(toValidate));
        break;
      case PARSE:
        Assert.assertEquals(ParserStatus.OK, test.parse(toValidate));
        break;
      case RUN:
        Assert.assertEquals(ParserStatus.OK, test.runCommand(toValidate));
        break;
    }
  }

  private void runDisplayTests(Function method) {
    runTest("Display FF date high", method);
    runTest("Display FF date low", method);
    runTest("Display FF name high", method);
    runTest("Display FF name low", method);
    runTest("Display FF price high", method);
    runTest("Display FF price low", method);
    runTest("Display FF stock high", method);
    runTest("Display FF stock low", method);
    runTest("Display FF id high", method);
    runTest("Display FF id low", method);

    runTest("Display ingredient date high", method);
    runTest("Display ingredient date low", method);
    runTest("Display ingredient name high", method);
    runTest("Display ingredient name low", method);
    runTest("Display ingredient price high", method);
    runTest("Display ingredient price low", method);
    runTest("Display ingredient stock high", method);
    runTest("Display ingredient stock low", method);
    runTest("Display ingredient id high", method);
    runTest("Display ingredient id low", method);
  }

  private void runSearchTests(Function method) {
    runTest("Search FF date 4/28/17", method);
    runTest("Search FF date 6/24/18", method);
    runTest("Search FF name bagel", method);
    runTest("Search FF name sandwich", method);
    runTest("Search FF price 1.47", method);
    runTest("Search FF price 6.96", method);
    runTest("Search FF stock 27", method);
    runTest("Search FF stock 19", method);
    runTest("Search FF id 1234", method);
    runTest("Search FF id 5736", method);

    runTest("Search ingredient date 4/28/17", method);
    runTest("Search ingredient date 6/24/18", method);
    runTest("Search ingredient name bagel", method);
    runTest("Search ingredient name sandwich", method);
    runTest("Search ingredient price 1.47", method);
    runTest("Search ingredient price 6.96", method);
    runTest("Search ingredient stock 27", method);
    runTest("Search ingredient stock 19", method);
    runTest("Search ingredient id 1234", method);
    runTest("Search ingredient id 5736", method);
  }

  private void runFindTests(Function method) {
    runTest("Find FF name bagel", method);
    runTest("Find FF name sandwich", method);
    runTest("Find FF id 1234", method);
    runTest("Find FF id 5736", method);

    runTest("Find ingredient name bagel", method);
    runTest("Find ingredient name sandwich", method);
    runTest("Find ingredient id 1234", method);
    runTest("Find ingredient id 5736", method);

  }

  private void runChangeTests(Function method) {
    runTest("Change FF name ice-cream stock 45", method);  // Sets the stock
    runTest("Change FF name bagel stock -37", method); // Decreases stock
    runTest("Change FF id 4691 stock +19", method); // Increases stock

    runTest("Change ingredient name rosemary stock 45", method);  // Sets the stock
    runTest("Change ingredient name ginger stock -37", method); // Decreases stock
    runTest("Change ingredient id 9654 stock +19", method); // Increases stock

    runTest("Change FF name cheese price 45", method);  // Sets the price
    runTest("Change FF name ice price -37", method); // Decreases price
    runTest("Change FF id 1276 price +19", method); // Increases price

    runTest("Change ingredient name ginger price 45", method);  // Sets the price
    runTest("Change ingredient name olive price -37", method); // Decreases price
    runTest("Change ingredient id 1196 price +19", method); // Increases price
  }

  private void runAddTests(Function method) {
    runTest("Add FF name ice-cream price 37 stock 15", method);
    runTest("Add FF name bagel price 47 stock 270", method);

    runTest("Add ingredient name olive price 37 stock 15", method);
    runTest("Add ingredient name syrup price 47 stock 270", method);

  }

  }

  @Test
  public void validateDisplay() {
    runDisplayTests(Function.VALIDATE);
  }

  @Test
  public void validateSearch() {
    runSearchTests(Function.VALIDATE);
  }

  @Test
  public void validateFind() {
    runFindTests(Function.VALIDATE);
  }

  @Test
  public void validateChange() {
    runChangeTests(Function.VALIDATE);
  }

  @Test
  public void validateAdd() {
    runAddTests(Function.VALIDATE);
  }

  @Test
  public void parseDisplay() {
    runDisplayTests(Function.PARSE);
  }

  @Test
  public void parseSearch() {
    runSearchTests(Function.PARSE);
  }

  @Test
  public void parseFind() {
    runFindTests(Function.PARSE);
  }

  @Test
  public void parseChange() {
    runChangeTests(Function.PARSE);
  }

  @Test
  public void parseAdd() {
    runAddTests(Function.PARSE);
  }

  @Test
  public void runRunCommandDisplay() {
    runDisplayTests(Function.RUN);
  }

  @Test
  public void runRunCommandSearch() {
    runSearchTests(Function.RUN);
  }

  @Test
  public void runRunCommandFind() {
    runFindTests(Function.RUN);
  }

  @Test
  public void runRunCommandChangeStock() {
    runChangeTests(Function.RUN);
  }

  @Test
  public void runRunCommmandAdd() {
    runAddTests(Function.RUN);
  }

}
