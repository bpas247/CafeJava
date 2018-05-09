import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CommandParserTest {
  private CommandParser test;

  @Before
  public void setUp() throws Exception {
    test = new CommandParser();
  }

  private void runValidateTest(String toValidate) {
    Assert.assertEquals(ParserStatus.OK, test.parse(toValidate));
  }

  private void runParseTest(String toParse) {
    Assert.assertEquals(ParserStatus.OK, test.parse(toParse));
  }

  private void runRunCommandTest(String toRun) {
    Assert.assertEquals(ParserStatus.OK, test.runCommand(toRun));
  }

  @Test
  public void validateDisplay() {

    //Display valid tests
    runValidateTest("Display FF date high");
    runValidateTest("Display FF date low");
    runValidateTest("Display FF name high");
    runValidateTest("Display FF name low");
    runValidateTest("Display FF price high");
    runValidateTest("Display FF price low");
    runValidateTest("Display FF stock high");
    runValidateTest("Display FF stock low");
    runValidateTest("Display FF id high");
    runValidateTest("Display FF id low");

    runValidateTest("Display ingredient date high");
    runValidateTest("Display ingredient date low");
    runValidateTest("Display ingredient name high");
    runValidateTest("Display ingredient name low");
    runValidateTest("Display ingredient price high");
    runValidateTest("Display ingredient price low");
    runValidateTest("Display ingredient stock high");
    runValidateTest("Display ingredient stock low");
    runValidateTest("Display ingredient id high");
    runValidateTest("Display ingredient id low");
  }

  @Test
  public void validateSearch() {
    runValidateTest("Search FF date 4/28/17");
    runValidateTest("Search FF date 6/24/18");
    runValidateTest("Search FF name bagel");
    runValidateTest("Search FF name sandwich");
    runValidateTest("Search FF price 1.47");
    runValidateTest("Search FF price 6.96");
    runValidateTest("Search FF stock 27");
    runValidateTest("Search FF stock 19");
    runValidateTest("Search FF id 1234");
    runValidateTest("Search FF id 5736");

    runValidateTest("Search ingredient date 4/28/17");
    runValidateTest("Search ingredient date 6/24/18");
    runValidateTest("Search ingredient name bagel");
    runValidateTest("Search ingredient name sandwich");
    runValidateTest("Search ingredient price 1.47");
    runValidateTest("Search ingredient price 6.96");
    runValidateTest("Search ingredient stock 27");
    runValidateTest("Search ingredient stock 19");
    runValidateTest("Search ingredient id 1234");
    runValidateTest("Search ingredient id 5736");
  }

  @Test
  public void validateFind() {
    runValidateTest("Find FF name bagel");
    runValidateTest("Find FF name sandwich");
    runValidateTest("Find FF id 1234");
    runValidateTest("Find FF id 5736");

    runValidateTest("Find ingredient name bagel");
    runValidateTest("Find ingredient name sandwich");
    runValidateTest("Find ingredient id 1234");
    runValidateTest("Find ingredient id 5736");
  }

  @Test
  public void validateChangeStock() {
    runValidateTest("Change FF stock 45");  // Sets the stock
    runValidateTest("Change FF stock -37"); // Decreases stock
    runValidateTest("Change FF stock +19"); // Increases stock

    runValidateTest("Change ingredient stock 45");  // Sets the stock
    runValidateTest("Change ingredient stock -37"); // Decreases stock
    runValidateTest("Change ingredient stock +19"); // Increases stock
  }

  @Test
  public void validateChangePrice() {
    runValidateTest("Change FF price 45");  // Sets the price
    runValidateTest("Change FF price -37"); // Decreases price
    runValidateTest("Change FF price +19"); // Increases price

    runValidateTest("Change ingredient price 45");  // Sets the price
    runValidateTest("Change ingredient price -37"); // Decreases price
    runValidateTest("Change ingredient price +19"); // Increases price
  }


  @Test
  public void parseDisplay() {

    //Display valid tests
    runParseTest("Display FF date high");
    runParseTest("Display FF date low");
    runParseTest("Display FF name high");
    runParseTest("Display FF name low");
    runParseTest("Display FF price high");
    runParseTest("Display FF price low");
    runParseTest("Display FF stock high");
    runParseTest("Display FF stock low");
    runParseTest("Display FF id high");
    runParseTest("Display FF id low");

    runParseTest("Display ingredient date high");
    runParseTest("Display ingredient date low");
    runParseTest("Display ingredient name high");
    runParseTest("Display ingredient name low");
    runParseTest("Display ingredient price high");
    runParseTest("Display ingredient price low");
    runParseTest("Display ingredient stock high");
    runParseTest("Display ingredient stock low");
    runParseTest("Display ingredient id high");
    runParseTest("Display ingredient id low");
  }

  @Test
  public void parseSearch() {
    runParseTest("Search FF date 4/28/17");
    runParseTest("Search FF date 6/24/18");
    runParseTest("Search FF name bagel");
    runParseTest("Search FF name sandwich");
    runParseTest("Search FF price 1.47");
    runParseTest("Search FF price 6.96");
    runParseTest("Search FF stock 27");
    runParseTest("Search FF stock 19");
    runParseTest("Search FF id 1234");
    runParseTest("Search FF id 5736");

    runParseTest("Search ingredient date 4/28/17");
    runParseTest("Search ingredient date 6/24/18");
    runParseTest("Search ingredient name bagel");
    runParseTest("Search ingredient name sandwich");
    runParseTest("Search ingredient price 1.47");
    runParseTest("Search ingredient price 6.96");
    runParseTest("Search ingredient stock 27");
    runParseTest("Search ingredient stock 19");
    runParseTest("Search ingredient id 1234");
    runParseTest("Search ingredient id 5736");
  }

  @Test
  public void parseFind() {
    runParseTest("Find FF name bagel");
    runParseTest("Find FF name sandwich");
    runParseTest("Find FF id 1234");
    runParseTest("Find FF id 5736");

    runParseTest("Find ingredient name bagel");
    runParseTest("Find ingredient name sandwich");
    runParseTest("Find ingredient id 1234");
    runParseTest("Find ingredient id 5736");
  }

  @Test
  public void parseChangeStock() {
    runParseTest("Change FF stock 45");  // Sets the stock
    runParseTest("Change FF stock -37"); // Decreases stock
    runParseTest("Change FF stock +19"); // Increases stock

    runParseTest("Change ingredient stock 45");  // Sets the stock
    runParseTest("Change ingredient stock -37"); // Decreases stock
    runParseTest("Change ingredient stock +19"); // Increases stock
  }

  @Test
  public void parseChangePrice() {
    runParseTest("Change FF price 45");  // Sets the price
    runParseTest("Change FF price -37"); // Decreases price
    runParseTest("Change FF price +19"); // Increases price

    runParseTest("Change ingredient price 45");  // Sets the price
    runParseTest("Change ingredient price -37"); // Decreases price
    runParseTest("Change ingredient price +19"); // Increases price
  }


  @Test
  public void runDisplay() {

    //Display valid tests
    runRunCommandTest("Display FF date high");
    runRunCommandTest("Display FF date low");
    runRunCommandTest("Display FF name high");
    runRunCommandTest("Display FF name low");
    runRunCommandTest("Display FF price high");
    runRunCommandTest("Display FF price low");
    runRunCommandTest("Display FF stock high");
    runRunCommandTest("Display FF stock low");
    runRunCommandTest("Display FF id high");
    runRunCommandTest("Display FF id low");

    runRunCommandTest("Display ingredient date high");
    runRunCommandTest("Display ingredient date low");
    runRunCommandTest("Display ingredient name high");
    runRunCommandTest("Display ingredient name low");
    runRunCommandTest("Display ingredient price high");
    runRunCommandTest("Display ingredient price low");
    runRunCommandTest("Display ingredient stock high");
    runRunCommandTest("Display ingredient stock low");
    runRunCommandTest("Display ingredient id high");
    runRunCommandTest("Display ingredient id low");
  }

  @Test
  public void runSearch() {
    runRunCommandTest("Search FF date 4/28/17");
    runRunCommandTest("Search FF date 6/24/18");
    runRunCommandTest("Search FF name bagel");
    runRunCommandTest("Search FF name sandwich");
    runRunCommandTest("Search FF price 1.47");
    runRunCommandTest("Search FF price 6.96");
    runRunCommandTest("Search FF stock 27");
    runRunCommandTest("Search FF stock 19");
    runRunCommandTest("Search FF id 1234");
    runRunCommandTest("Search FF id 5736");

    runRunCommandTest("Search ingredient date 4/28/17");
    runRunCommandTest("Search ingredient date 6/24/18");
    runRunCommandTest("Search ingredient name bagel");
    runRunCommandTest("Search ingredient name sandwich");
    runRunCommandTest("Search ingredient price 1.47");
    runRunCommandTest("Search ingredient price 6.96");
    runRunCommandTest("Search ingredient stock 27");
    runRunCommandTest("Search ingredient stock 19");
    runRunCommandTest("Search ingredient id 1234");
    runRunCommandTest("Search ingredient id 5736");
  }

  @Test
  public void runFind() {
    runRunCommandTest("Find FF name bagel");
    runRunCommandTest("Find FF name sandwich");
    runRunCommandTest("Find FF id 1234");
    runRunCommandTest("Find FF id 5736");

    runRunCommandTest("Find ingredient name bagel");
    runRunCommandTest("Find ingredient name sandwich");
    runRunCommandTest("Find ingredient id 1234");
    runRunCommandTest("Find ingredient id 5736");
  }

  @Test
  public void runChangeStock() {
    runRunCommandTest("Change FF stock 45");  // Sets the stock
    runRunCommandTest("Change FF stock -37"); // Decreases stock
    runRunCommandTest("Change FF stock +19"); // Increases stock

    runRunCommandTest("Change ingredient stock 45");  // Sets the stock
    runRunCommandTest("Change ingredient stock -37"); // Decreases stock
    runRunCommandTest("Change ingredient stock +19"); // Increases stock
  }

  @Test
  public void runChangePrice() {
    runRunCommandTest("Change FF price 45");  // Sets the price
    runRunCommandTest("Change FF price -37"); // Decreases price
    runRunCommandTest("Change FF price +19"); // Increases price

    runRunCommandTest("Change ingredient price 45");  // Sets the price
    runRunCommandTest("Change ingredient price -37"); // Decreases price
    runRunCommandTest("Change ingredient price +19"); // Increases price
  }
}
