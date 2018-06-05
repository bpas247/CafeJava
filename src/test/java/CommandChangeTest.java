import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class CommandChangeTest {
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
    CommandChange test = new CommandChange();
    Assert.assertEquals(CommandStatus.OK, test.validate("Change ff name apples stock -1000"));
    Assert.assertEquals(CommandStatus.OK, test.validate("change ff name apples stock -1000"));
    Assert.assertEquals(CommandStatus.OK, test.validate("Change ff name apples stock +1000"));
    Assert.assertEquals(CommandStatus.OK, test.validate("change ff name apples stock +1000"));
    Assert.assertEquals(CommandStatus.OK, test.validate("Change ff name apples stock 0"));
    Assert.assertEquals(CommandStatus.OK, test.validate("change ff name apples stock 0"));

    Assert.assertEquals(CommandStatus.OK, test.validate("Change ff number 1000 price -10"));
    Assert.assertEquals(CommandStatus.OK, test.validate("change ff number 1000 price -10"));
    Assert.assertEquals(CommandStatus.OK, test.validate("Change ff number 1000 price +10"));
    Assert.assertEquals(CommandStatus.OK, test.validate("change ff number 1000 price +10"));
    Assert.assertEquals(CommandStatus.OK, test.validate("Change ff number 1000 price 0"));
    Assert.assertEquals(CommandStatus.OK, test.validate("change ff number 1000 price 0"));

    Assert.assertEquals(CommandStatus.BAD_LENGTH, test.validate("Change ff number 1000 stock -1000 stock"));
    Assert.assertEquals(CommandStatus.BAD_LENGTH, test.validate("Change ff"));

    Assert.assertEquals(CommandStatus.BAD_NAME, test.validate("Cha ff name apples stock -1000"));

    Assert.assertEquals(CommandStatus.BAD_TYPE, test.validate("Change ffff number 1000 stock -1000"));
    Assert.assertEquals(CommandStatus.BAD_TYPE, test.validate("Change apple number 1000 stock -1000"));

    Assert.assertEquals(CommandStatus.BAD_ATTRIBUTE, test.validate("Change ff number 1000 name david"));
    Assert.assertEquals(CommandStatus.BAD_ATTRIBUTE, test.validate("Change ff stock 1000 stock -10"));


    Assert.assertEquals(CommandStatus.BAD_VALUE, test.validate("Change ff number 1000 price -1O"));
    Assert.assertEquals(CommandStatus.BAD_VALUE, test.validate("Change ff number 1000 price -1O"));

    Assert.assertEquals(CommandStatus.NULL_PARSE, test.validate(null));
  }

  @Test
  public void parseTest() {
    CommandChange test = new CommandChange();
    Assert.assertEquals(CommandStatus.OK, test.parse("Change ff name apples stock -1000"));
    Assert.assertEquals(CommandStatus.OK, test.parse("change ff name apples stock -1000"));
    Assert.assertEquals(CommandStatus.OK, test.parse("Change ff name apples stock +1000"));
    Assert.assertEquals(CommandStatus.OK, test.parse("change ff name apples stock +1000"));
    Assert.assertEquals(CommandStatus.OK, test.parse("Change ff name apples stock 0"));
    Assert.assertEquals(CommandStatus.OK, test.parse("change ff name apples stock 0"));

    Assert.assertEquals(CommandStatus.OK, test.parse("Change ff number 1000 price -10"));
    Assert.assertEquals(CommandStatus.OK, test.parse("change ff number 1000 price -10"));
    Assert.assertEquals(CommandStatus.OK, test.parse("Change ff number 1000 price +10"));
    Assert.assertEquals(CommandStatus.OK, test.parse("change ff number 1000 price +10"));
    Assert.assertEquals(CommandStatus.OK, test.parse("Change ff number 1000 price 0"));
    Assert.assertEquals(CommandStatus.OK, test.parse("change ff number 1000 price 0"));

    Assert.assertEquals(CommandStatus.BAD_LENGTH, test.parse("Change ff number 1000 stock -1000 stock"));
    Assert.assertEquals(CommandStatus.BAD_LENGTH, test.parse("Change ff"));

    Assert.assertEquals(CommandStatus.BAD_NAME, test.parse("Cha ff name apples stock -1000"));

    Assert.assertEquals(CommandStatus.BAD_TYPE, test.parse("Change ffff number 1000 stock -1000"));
    Assert.assertEquals(CommandStatus.BAD_TYPE, test.parse("Change apple number 1000 stock -1000"));

    Assert.assertEquals(CommandStatus.BAD_ATTRIBUTE, test.parse("Change ff number 1000 name david"));
    Assert.assertEquals(CommandStatus.BAD_ATTRIBUTE, test.parse("Change ff stock 1000 stock -10"));


    Assert.assertEquals(CommandStatus.BAD_VALUE, test.parse("Change ff number 1000 price -1O"));
    Assert.assertEquals(CommandStatus.BAD_VALUE, test.parse("Change ff number 1000 price -1O"));

    Assert.assertEquals(CommandStatus.NULL_PARSE, test.parse(null));
  }

  @Test
  public void runTest() {
    CommandChange test = new CommandChange();
    Assert.assertEquals(CommandStatus.OK, test.run("Change ff name apples stock -1000", storage));
    Assert.assertEquals(234, storage.find("name", "apples").getStock());
    Assert.assertEquals(CommandStatus.OK, test.run("Change ff name apples stock +1000", storage));
    Assert.assertEquals(1234, storage.find("name", "apples").getStock());
    Assert.assertEquals(CommandStatus.OK, test.run("Change ff name apples stock 0", storage));
    Assert.assertEquals(1234, storage.find("name", "apples").getStock());

    Assert.assertEquals(CommandStatus.OK, test.run("Change ff number 1000 price -10", storage));
    Assert.assertEquals(8.75, storage.find("name", "apples").getPrice(), 0.01);
    Assert.assertEquals(CommandStatus.OK, test.run("Change ff number 1000 price +10", storage));
    Assert.assertEquals(18.75, storage.find("name", "apples").getPrice(), 0.01);
    Assert.assertEquals(CommandStatus.OK, test.run("Change ff number 1000 price 0", storage));
    Assert.assertEquals(18.75, storage.find("name", "apples").getPrice(), 0.01);

    Assert.assertEquals(CommandStatus.BAD_LENGTH, test.run("Change ff number 1000 stock -1000 stock", storage));
    Assert.assertEquals(CommandStatus.BAD_LENGTH, test.run("Change ff", storage));
    Assert.assertEquals(CommandStatus.OK, test.run(storage));
    Assert.assertEquals(18.75, storage.find("name", "apples").getPrice(), 0.01);

    Assert.assertEquals(CommandStatus.BAD_NAME, test.run("Cha ff name apples stock -1000", storage));
    Assert.assertEquals(CommandStatus.OK, test.run(storage));
    Assert.assertEquals(18.75, storage.find("name", "apples").getPrice(), 0.01);

    Assert.assertEquals(CommandStatus.BAD_TYPE, test.run("Change ffff number 1000 stock -1000", storage));
    Assert.assertEquals(CommandStatus.BAD_TYPE, test.run("Change apple number 1000 stock -1000", storage));
    Assert.assertEquals(CommandStatus.OK, test.run(storage));
    Assert.assertEquals(18.75, storage.find("name", "apples").getPrice(), 0.01);

    Assert.assertEquals(CommandStatus.BAD_ATTRIBUTE, test.run("Change ff number 1000 name david", storage));
    Assert.assertEquals(CommandStatus.BAD_ATTRIBUTE, test.run("Change ff stock 1000 stock -10", storage));
    Assert.assertEquals(CommandStatus.OK, test.run(storage));
    Assert.assertEquals(18.75, storage.find("name", "apples").getPrice(), 0.01);


    Assert.assertEquals(CommandStatus.BAD_VALUE, test.run("Change ff number 1000 price -1O", storage));
    Assert.assertEquals(CommandStatus.BAD_VALUE, test.run("Change ff number 1000 price -1O", storage));
    Assert.assertEquals(CommandStatus.OK, test.run(storage));
    Assert.assertEquals(18.75, storage.find("name", "apples").getPrice(), 0.01);

    Assert.assertEquals(CommandStatus.NULL_PARSE, test.run(null, storage));
    Assert.assertEquals(CommandStatus.OK, test.run(storage));
    Assert.assertEquals(18.75, storage.find("name", "apples").getPrice(), 0.01);
  }

  @Test
  public void cloneTest() {
    CommandChange test = new CommandChange();
    test.parse("Change ff name apples stock -1000");
    CommandChange copy = (CommandChange) test.clone();
    Assert.assertEquals(CommandStatus.OK, copy.run(storage));
    Assert.assertEquals(234, storage.find("name", "apples").getStock());

  }
}

