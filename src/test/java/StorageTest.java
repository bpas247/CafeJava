import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class StorageTest {
  private Storage test;
  private int itemIter = 1000;

  private List<Item> getTestList() {
    List<Item> testList = new ArrayList<>();

    testList.add(new Item(itemIter++, ItemType.FROZEN_FOOD, "apples", 1234, 18.75));
    testList.add(new Item(itemIter++, ItemType.FROZEN_FOOD, "applesgreen", 215757, 19.625));
    testList.add(new Item(itemIter++, ItemType.FROZEN_FOOD, "tater tots", 17, 00));
    testList.add(new Item(itemIter++, ItemType.FROZEN_FOOD, "carrots", 239391694, 2000));
    testList.add(new Item(itemIter++, ItemType.FROZEN_FOOD, "something that's good", 2, 23));

    testList.add(new Item(itemIter++, ItemType.INGREDIENT, "Ketchup", 215757, 207.9274));
    testList.add(new Item(itemIter++, ItemType.INGREDIENT, "mustard", 215757, 15));
    testList.add(new Item(itemIter++, ItemType.INGREDIENT, "something nice?", 215757, 1));
    testList.add(new Item(itemIter++, ItemType.INGREDIENT, "oregano", 215757, 205));
    testList.add(new Item(itemIter++, ItemType.INGREDIENT, "seasoning", 215757, 1020));

    return testList;
  }

  @Before
  public void setUp() throws Exception {
    test = new Storage();
  }

  @Test
  public void searchTest() {
    List<Item> testList = getTestList();

    Item toSearch = testList.get(0);

    for (Item cur : testList) {
      test.add(cur);
    }

    List<Item> returnedList = test.search(toSearch.getItemNumber());

    Assert.assertNotNull(returnedList);

    Assert.assertEquals(returnedList.size(), testList.size());

    Assert.assertTrue(returnedList.contains(toSearch));

    for (Item cur : testList) {
      Assert.assertTrue(returnedList.contains(cur));
    }
  }

  @Test
  public void findIdTest() {
    List<Item> testList = getTestList();

    Item toFind = testList.get(0);
    Item toNotFind = new Item(itemIter++, ItemType.INGREDIENT, "not there", 1929, 9.62);

    for (Item cur : testList) {
      test.add(cur);
    }

    Item found = test.find(toFind.getItemNumber());

    Assert.assertNotNull(found);

    Assert.assertTrue(toFind.equals(found));

    Item notFound = test.find(toNotFind.getItemNumber());

    Assert.assertNull(notFound);
  }

  @Test
  public void findNameTest() {
    List<Item> testList = getTestList();

    Item toFind = testList.get(0);
    Item toNotFind = new Item(itemIter++, ItemType.INGREDIENT, "not there", 1929, 9.62);

    for (Item cur : testList) {
      test.add(cur);
    }

    Item found = test.find(toFind.getItemNumber());

    Assert.assertNotNull(found);

    Assert.assertTrue(toFind.equals(found));

    Item notFound = test.find(toNotFind.getItemNumber());

    Assert.assertNull(notFound);
  }

  @Test
  public void addTest() {
    List<Item> testList = getTestList();

    for (Item cur : testList) {
      Assert.assertTrue(test.add(cur));
    }
  }

  @Test
  public void removeTest() {
    List<Item> testList = getTestList();

    for (Item cur : testList) {
      test.add(cur);
    }

    for (Item cur : testList) {
      Assert.assertTrue(test.remove(cur));
    }
  }
}