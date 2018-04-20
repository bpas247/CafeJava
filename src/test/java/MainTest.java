import org.junit.Assert;
import org.junit.Test;

public class MainTest {

  @Test
  public void print() {
    String test = "Hello World";

    String result = Main.print(test);

    Assert.assertEquals(test, result);
  }
}