import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class CommandFindTest {
  List<Item> testList;
  Storage storage;


  @Before
  public void setUp() throws Exception {
    storage = new Storage();
    testList = new ArrayList<>();

    testList.add(new Item(1000, ItemType.FROZEN_FOOD, "apples", 1234, 18.75));
    testList.add(new Item(1001, ItemType.FROZEN_FOOD, "applesgreen", 215757, 19.625));
    testList.add(new Item(1002, ItemType.INGREDIENT, "oregano", 215757, 205));
    testList.add(new Item(1003, ItemType.INGREDIENT, "seasoning", 215757, 1020));

    storage.add(testList.get(0));
    storage.add(testList.get(1));
    storage.add(testList.get(2));
    storage.add(testList.get(3));
  }

  @Test
  public void validateTest() {
    CommandFind test = new CommandFind();
    Assert.assertEquals(CommandStatus.OK, test.validate("Find ff name apples"));
    Assert.assertEquals(CommandStatus.OK, test.validate("find ff name apples"));
    Assert.assertEquals(CommandStatus.OK, test.validate("Find ff name Apples"));

    Assert.assertEquals(CommandStatus.OK, test.validate("Find ff id 1000"));
    Assert.assertEquals(CommandStatus.OK, test.validate("Find ff id 1005"));
    Assert.assertEquals(CommandStatus.OK, test.validate("Find ff id 2000"));

    Assert.assertEquals(CommandStatus.BAD_LENGTH, test.validate("Find ff name apples extra"));
    Assert.assertEquals(CommandStatus.BAD_LENGTH, test.validate("Find ff"));

    Assert.assertEquals(CommandStatus.BAD_NAME, test.validate("Fin ff name apples"));

    Assert.assertEquals(CommandStatus.BAD_TYPE, test.validate("Find ffff name apples"));
    Assert.assertEquals(CommandStatus.BAD_TYPE, test.validate("Find apple name apples"));

    Assert.assertEquals(CommandStatus.BAD_ATTRIBUTE, test.validate("Find ff nam apples"));
    Assert.assertEquals(CommandStatus.BAD_ATTRIBUTE, test.validate("Find ff stock 5"));
    Assert.assertEquals(CommandStatus.BAD_ATTRIBUTE, test.validate("Find ff price 5.25"));
    Assert.assertEquals(CommandStatus.BAD_ATTRIBUTE, test.validate("Find ff date 04/10/18"));
    Assert.assertEquals(CommandStatus.BAD_ATTRIBUTE, test.validate("Find ff type ff"));


    Assert.assertEquals(CommandStatus.BAD_VALUE, test.validate("Find ff id apple"));
    Assert.assertEquals(CommandStatus.BAD_VALUE, test.validate("Find ff id 10OO"));

    Assert.assertEquals(CommandStatus.NULL_PARSE, test.validate(null));
  }

  @Test
  public void parseTest() {
    CommandFind test = new CommandFind();
    Assert.assertEquals(CommandStatus.OK, test.parse("Find ff name apples"));
    Assert.assertEquals(CommandStatus.OK, test.parse("find ff name apples"));
    Assert.assertEquals(CommandStatus.OK, test.parse("Find ff name Apples"));

    Assert.assertEquals(CommandStatus.OK, test.parse("Find ff id 1000"));
    Assert.assertEquals(CommandStatus.OK, test.parse("Find ff id 1005"));
    Assert.assertEquals(CommandStatus.OK, test.parse("Find ff id 2000"));

    Assert.assertEquals(CommandStatus.BAD_LENGTH, test.parse("Find ff name apples extra"));
    Assert.assertEquals(CommandStatus.BAD_LENGTH, test.parse("Find ff"));

    Assert.assertEquals(CommandStatus.BAD_NAME, test.parse("Fin ff name apples"));

    Assert.assertEquals(CommandStatus.BAD_TYPE, test.parse("Find ffff name apples"));
    Assert.assertEquals(CommandStatus.BAD_TYPE, test.parse("Find apple name apples"));

    Assert.assertEquals(CommandStatus.BAD_ATTRIBUTE, test.parse("Find ff nam apples"));
    Assert.assertEquals(CommandStatus.BAD_ATTRIBUTE, test.parse("Find ff stock 5"));
    Assert.assertEquals(CommandStatus.BAD_ATTRIBUTE, test.parse("Find ff price 5.25"));
    Assert.assertEquals(CommandStatus.BAD_ATTRIBUTE, test.parse("Find ff date 04/10/18"));
    Assert.assertEquals(CommandStatus.BAD_ATTRIBUTE, test.parse("Find ff type ff"));


    Assert.assertEquals(CommandStatus.BAD_VALUE, test.parse("Find ff id apple"));
    Assert.assertEquals(CommandStatus.BAD_VALUE, test.parse("Find ff id 10OO"));


    Assert.assertEquals(CommandStatus.NULL_PARSE, test.parse(null));
  }

  @Test
  public void runTest() {
    CommandFind test = new CommandFind();

    Assert.assertEquals(CommandStatus.NULL_PARSE, test.run(storage));

    Assert.assertEquals(CommandStatus.OK, test.run("Find ff name apples", storage));
    Assert.assertEquals(CommandStatus.OK, test.run("find ff name oregano", storage));
    Assert.assertEquals(CommandStatus.OK, test.run("Find ff name apples", storage));
    Assert.assertEquals(CommandStatus.OK, test.run(storage));

    Assert.assertEquals(CommandStatus.OK, test.parse("Find ff id 1005"));
    Assert.assertEquals(CommandStatus.OK, test.parse("Find ff id 2000"));
    Assert.assertEquals(CommandStatus.OK, test.parse("Find ff id 1000"));
    Assert.assertEquals(CommandStatus.OK, test.run(storage));

    Assert.assertEquals(CommandStatus.BAD_LENGTH, test.run("Find ff name apples extra", storage));
    Assert.assertEquals(CommandStatus.BAD_LENGTH, test.run("Find ff", storage));
    Assert.assertEquals(CommandStatus.OK, test.run(storage));

    Assert.assertEquals(CommandStatus.BAD_NAME, test.run("Fin ff name apples", storage));
    Assert.assertEquals(CommandStatus.OK, test.run(storage));

    Assert.assertEquals(CommandStatus.BAD_TYPE, test.run("Find ffff name apples", storage));
    Assert.assertEquals(CommandStatus.BAD_TYPE, test.run("Find apple name apples", storage));
    Assert.assertEquals(CommandStatus.OK, test.run(storage));

    Assert.assertEquals(CommandStatus.BAD_ATTRIBUTE, test.run("Find ff nam apples", storage));
    Assert.assertEquals(CommandStatus.BAD_ATTRIBUTE, test.run("Find ff stock 5", storage));
    Assert.assertEquals(CommandStatus.BAD_ATTRIBUTE, test.run("Find ff price 5.25", storage));
    Assert.assertEquals(CommandStatus.BAD_ATTRIBUTE, test.run("Find ff date 04/10/18", storage));
    Assert.assertEquals(CommandStatus.BAD_ATTRIBUTE, test.run("Find ff type ff", storage));
    Assert.assertEquals(CommandStatus.OK, test.run(storage));


    Assert.assertEquals(CommandStatus.BAD_VALUE, test.run("Find ff id apple", storage));
    Assert.assertEquals(CommandStatus.BAD_VALUE, test.run("Find ff id 10OO", storage));
    Assert.assertEquals(CommandStatus.OK, test.run(storage));


    Assert.assertEquals(CommandStatus.UNHANDLED_ERROR, test.run(null));
    Assert.assertEquals(CommandStatus.OK, test.run(storage));
  }

  @Test
  public void cloneTest() {
    CommandFind test = new CommandFind();
    test.run("Find ff name apples", storage);
    CommandFind copy = (CommandFind) test.clone();
    Assert.assertEquals(CommandStatus.OK, copy.run(storage));
  }
}

