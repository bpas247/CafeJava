import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class CommandDisplayTest {
  List<Item> testList;
  Storage storage;


  @Before
  public void setUp() throws Exception {
    storage = new Storage();
    testList = new ArrayList<>();

    testList.add(new Item(1000, ItemType.FROZEN_FOOD, "apples", 1234, 18.75));
    testList.add(new Item(1001, ItemType.FROZEN_FOOD, "applesgreen", 25, 19.625));
    testList.add(new Item(1002, ItemType.INGREDIENT, "oregano", 30, 205));
    testList.add(new Item(1003, ItemType.INGREDIENT, "seasoning", 40, 1020));

    storage.add(testList.get(0));
    storage.add(testList.get(1));
    storage.add(testList.get(2));
    storage.add(testList.get(3));
  }

  @Test
  public void validateTest() {
    CommandDisplay test = new CommandDisplay();
    Assert.assertEquals(CommandStatus.OK, test.validate("Display ff type high"));
    Assert.assertEquals(CommandStatus.OK, test.validate("Display ff type low"));

    Assert.assertEquals(CommandStatus.OK, test.validate("Display ff name high"));
    Assert.assertEquals(CommandStatus.OK, test.validate("Display ff name low"));

    Assert.assertEquals(CommandStatus.OK, test.validate("Display ff date high"));
    Assert.assertEquals(CommandStatus.OK, test.validate("Display ff date low"));

    Assert.assertEquals(CommandStatus.OK, test.validate("Display ff number high"));
    Assert.assertEquals(CommandStatus.OK, test.validate("Display ff number low"));

    Assert.assertEquals(CommandStatus.OK, test.validate("Display ff stock high"));
    Assert.assertEquals(CommandStatus.OK, test.validate("Display ff stock low"));

    Assert.assertEquals(CommandStatus.OK, test.validate("Display ff price high"));
    Assert.assertEquals(CommandStatus.OK, test.validate("Display ff price low"));

    Assert.assertEquals(CommandStatus.BAD_LENGTH, test.validate("Display ff price high price"));
    Assert.assertEquals(CommandStatus.BAD_LENGTH, test.validate("Display ff price"));

    Assert.assertEquals(CommandStatus.BAD_NAME, test.validate("Dis ff name high"));

    Assert.assertEquals(CommandStatus.BAD_TYPE, test.validate("Display ffff name high"));
    Assert.assertEquals(CommandStatus.BAD_TYPE, test.validate("Display apple name low"));

    Assert.assertEquals(CommandStatus.BAD_ATTRIBUTE, test.validate("Display ff nam high"));

    Assert.assertEquals(CommandStatus.BAD_VALUE, test.validate("Display ff number sort"));
    Assert.assertEquals(CommandStatus.BAD_VALUE, test.validate("Display ff number Mid"));

    Assert.assertEquals(CommandStatus.NULL_PARSE, test.validate(null));
  }

  @Test
  public void parseTest() {
    CommandDisplay test = new CommandDisplay();
    Assert.assertEquals(CommandStatus.OK, test.parse("Display ff type high"));
    Assert.assertEquals(CommandStatus.OK, test.parse("Display ff type low"));

    Assert.assertEquals(CommandStatus.OK, test.parse("Display ff name high"));
    Assert.assertEquals(CommandStatus.OK, test.parse("Display ff name low"));

    Assert.assertEquals(CommandStatus.OK, test.parse("Display ff date high"));
    Assert.assertEquals(CommandStatus.OK, test.parse("Display ff date low"));

    Assert.assertEquals(CommandStatus.OK, test.parse("Display ff number high"));
    Assert.assertEquals(CommandStatus.OK, test.parse("Display ff number low"));

    Assert.assertEquals(CommandStatus.OK, test.parse("Display ff stock high"));
    Assert.assertEquals(CommandStatus.OK, test.parse("Display ff stock low"));

    Assert.assertEquals(CommandStatus.OK, test.parse("Display ff price high"));
    Assert.assertEquals(CommandStatus.OK, test.parse("Display ff price low"));

    Assert.assertEquals(CommandStatus.BAD_LENGTH, test.parse("Display ff price high price"));
    Assert.assertEquals(CommandStatus.BAD_LENGTH, test.parse("Display ff price"));

    Assert.assertEquals(CommandStatus.BAD_NAME, test.parse("Dis ff name high"));

    Assert.assertEquals(CommandStatus.BAD_TYPE, test.parse("Display ffff name high"));
    Assert.assertEquals(CommandStatus.BAD_TYPE, test.parse("Display apple name low"));

    Assert.assertEquals(CommandStatus.BAD_ATTRIBUTE, test.parse("Display ff nam high"));

    Assert.assertEquals(CommandStatus.BAD_VALUE, test.parse("Display ff number sort"));
    Assert.assertEquals(CommandStatus.BAD_VALUE, test.parse("Display ff number Mid"));

    Assert.assertEquals(CommandStatus.NULL_PARSE, test.parse(null));
  }

  @Test
  public void runTest() {
    CommandDisplay test = new CommandDisplay();
    Assert.assertEquals(CommandStatus.OK, test.run("Display ff type high", storage));
    Assert.assertEquals(CommandStatus.OK, test.run("Display ff type low", storage));
    Assert.assertEquals(CommandStatus.OK, test.run(storage));

    Assert.assertEquals(CommandStatus.OK, test.run("Display ff name high", storage));
    Assert.assertEquals(CommandStatus.OK, test.run("Display ff name low", storage));
    Assert.assertEquals(CommandStatus.OK, test.run(storage));

    Assert.assertEquals(CommandStatus.OK, test.run("Display ff date high", storage));
    Assert.assertEquals(CommandStatus.OK, test.run("Display ff date low", storage));
    Assert.assertEquals(CommandStatus.OK, test.run(storage));

    Assert.assertEquals(CommandStatus.OK, test.run("Display ff number high", storage));
    Assert.assertEquals(CommandStatus.OK, test.run("Display ff number low", storage));
    Assert.assertEquals(CommandStatus.OK, test.run(storage));

    Assert.assertEquals(CommandStatus.OK, test.run("Display ff stock high", storage));
    Assert.assertEquals(CommandStatus.OK, test.run("Display ff stock low", storage));
    Assert.assertEquals(CommandStatus.OK, test.run(storage));

    Assert.assertEquals(CommandStatus.OK, test.run("Display ff price high", storage));
    Assert.assertEquals(CommandStatus.OK, test.run("Display ff price low", storage));
    Assert.assertEquals(CommandStatus.OK, test.run(storage));

    Assert.assertEquals(CommandStatus.BAD_LENGTH, test.run("Display ff price high price", storage));
    Assert.assertEquals(CommandStatus.BAD_LENGTH, test.run("Display ff price", storage));
    Assert.assertEquals(CommandStatus.OK, test.run(storage));

    Assert.assertEquals(CommandStatus.BAD_NAME, test.run("Dis ff name high", storage));
    Assert.assertEquals(CommandStatus.OK, test.run(storage));

    Assert.assertEquals(CommandStatus.BAD_TYPE, test.run("Display ffff name high", storage));
    Assert.assertEquals(CommandStatus.BAD_TYPE, test.run("Display apple name low", storage));
    Assert.assertEquals(CommandStatus.OK, test.run(storage));

    Assert.assertEquals(CommandStatus.BAD_ATTRIBUTE, test.run("Display ff nam high", storage));
    Assert.assertEquals(CommandStatus.OK, test.run(storage));

    Assert.assertEquals(CommandStatus.BAD_VALUE, test.run("Display ff number sort", storage));
    Assert.assertEquals(CommandStatus.BAD_VALUE, test.run("Display ff number Mid", storage));
    Assert.assertEquals(CommandStatus.OK, test.run(storage));

    Assert.assertEquals(CommandStatus.NULL_PARSE, test.run(null, storage));
    Assert.assertEquals(CommandStatus.OK, test.run(storage));
  }

  @Test
  public void cloneTest() {
    CommandDisplay test = new CommandDisplay();
    test.parse("Display ff type high");
    CommandDisplay copy = (CommandDisplay) test.clone();
    Assert.assertEquals(CommandStatus.OK, copy.run(storage));
  }
}

