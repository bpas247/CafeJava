import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ItemTest {
  private int[] numbers;
  private ItemType[] types;
  private String[] names;
  private Date date;
  private DateFormat dateFormat;
  private int[] stocks;
  private double[] prices;

  private Item item1;
  private Item item2;
  private Item item3;

  @Before
  public void setUp() throws Exception {
    numbers = new int[]{1000, 10000, 999};
    types = new ItemType[]{ItemType.FROZEN_FOOD, ItemType.INGREDIENT, ItemType.FROZEN_FOOD};
    names = new String[]{"Ice-cream", "Apple", "Nothing"};
    date = new Date();
    dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    stocks = new int[]{5, 5, -5};
    prices = new double[]{5.25, 0.688, -2};

    item1 = new Item(numbers[0], types[0], names[0], stocks[0], prices[0]);
    item2 = new Item(numbers[1], types[1], names[1], stocks[1], prices[1]);
    item3 = new Item(numbers[2], types[2], names[2], stocks[2], prices[2]);
  }

  @Test
  public void getAttributeTest() {
    Assert.assertEquals(types[0].toString(), item1.getAttribute("Type"));
    Assert.assertEquals(types[1].toString(), item2.getAttribute("Type"));
    Assert.assertEquals(types[2].toString(), item3.getAttribute("Type"));
    Assert.assertEquals(types[0].toString(), item1.getAttribute("type"));

    Assert.assertEquals(names[0], item1.getAttribute("Name"));
    Assert.assertEquals(names[1], item2.getAttribute("Name"));
    Assert.assertEquals(names[2], item3.getAttribute("Name"));
    Assert.assertEquals(names[0], item1.getAttribute("name"));

    Assert.assertEquals(dateFormat.format(date), item1.getAttribute("Date"));
    Assert.assertEquals(dateFormat.format(date), item2.getAttribute("Date"));
    Assert.assertEquals(dateFormat.format(date), item3.getAttribute("Date"));
    Assert.assertEquals(dateFormat.format(date), item1.getAttribute("date"));

    Assert.assertEquals(String.valueOf(numbers[0]), item1.getAttribute("Number"));
    Assert.assertEquals("-1", item2.getAttribute("Number"));
    Assert.assertEquals("-1", item3.getAttribute("Number"));
    Assert.assertEquals(String.valueOf(numbers[0]), item1.getAttribute("number"));

    Assert.assertEquals(String.valueOf(stocks[0]), item1.getAttribute("Stock"));
    Assert.assertEquals(String.valueOf(stocks[1]), item2.getAttribute("Stock"));
    Assert.assertEquals("0", item3.getAttribute("Stock"));
    Assert.assertEquals(String.valueOf(stocks[0]), item1.getAttribute("stock"));

    Assert.assertEquals(String.format("%.2f", roundDouble(prices[0])), item1.getAttribute("Price"));
    Assert.assertEquals(String.format("%.2f", roundDouble(prices[1])), item2.getAttribute("Price"));
    Assert.assertEquals("0.00", item3.getAttribute("Price"));
    Assert.assertEquals(String.format("%.2f", roundDouble(prices[0])), item1.getAttribute("price"));

    Assert.assertNull(item1.getAttribute("Discount"));
  }

  @Test
  public void getNameTest() {
    Assert.assertEquals(names[0], item1.getName());
    Assert.assertEquals(names[1], item2.getName());
    Assert.assertEquals(names[2], item3.getName());
  }

  @Test
  public void getTypeTest() {
    Assert.assertEquals(types[0], item1.getType());
    Assert.assertEquals(types[1], item2.getType());
    Assert.assertEquals(types[2], item3.getType());
  }

  @Test
  public void getDateAdded() {
    Assert.assertEquals(dateFormat.format(date), dateFormat.format(item1.getDateAdded()));
    Assert.assertEquals(dateFormat.format(date), dateFormat.format(item1.getDateAdded()));
    Assert.assertEquals(dateFormat.format(date), dateFormat.format(item1.getDateAdded()));
  }

  @Test
  public void getItemNumber() {
    Assert.assertEquals(numbers[0], item1.getItemNumber());
    Assert.assertEquals(-1, item2.getItemNumber());
    Assert.assertEquals(-1, item3.getItemNumber());
  }

  @Test
  public void getStockTest() {
    Assert.assertEquals(stocks[0], item1.getStock());
    Assert.assertEquals(stocks[1], item2.getStock());
    Assert.assertEquals(0, item3.getStock());
  }

  @Test
  public void setStockTest() {
    int testStock1 = 10;
    int testStock2 = -5;

    item1.setStock(testStock1);
    Assert.assertEquals(testStock1, item1.getStock());
    item1.setStock(testStock2);
    Assert.assertEquals(0, item1.getStock());
  }

  @Test
  public void getPriceTest() {
    Assert.assertEquals(roundDouble(prices[0]), item1.getPrice(), 0.01);
    Assert.assertEquals(roundDouble(prices[1]), item2.getPrice(), 0.01);
    Assert.assertEquals(0, item3.getPrice(), 0.01);
  }

  @Test
  public void setPriceTest() {
    double testPrice1 = 10.10;
    double testPrice2 = -22.25;

    item1.setPrice(testPrice1);
    Assert.assertEquals(testPrice1, item1.getPrice(), 0.01);
    item1.setPrice(testPrice2);
    Assert.assertEquals(0, item1.getPrice(), 0.01);
  }

  @Test
  public void toStringTest() {
    Assert.assertEquals("" + numbers[0] + " " + names[0] + " " + types[0] + " " + stocks[0] + " "
            + "$" + String.format("%.2f", roundDouble(prices[0])) + " " + dateFormat.format(date), item1.toString());
    Assert.assertEquals("-1 " + names[1] + " " + types[1] + " " + stocks[1] + " "
            + "$" + String.format("%.2f", roundDouble(prices[1])) + " " + dateFormat.format(date), item2.toString());
    Assert.assertEquals("-1 " + names[2] + " " + types[2] + " 0 "
            + "$0.00 " + dateFormat.format(date), item3.toString());
  }

  @Test
  public void hashCodeTest() {
    Assert.assertEquals(1000838, item1.hashCode());
    Assert.assertEquals(-1498, item2.hashCode());
    Assert.assertEquals(-1727, item3.hashCode());
  }

  @Test
  public void cloneTest() {
    Item copy = item1.clone();
    Assert.assertEquals(types[0].toString(), copy.getAttribute("Type"));

    Assert.assertEquals(names[0], copy.getAttribute("Name"));

    Assert.assertEquals(dateFormat.format(date), copy.getAttribute("Date"));

    Assert.assertEquals(String.valueOf(numbers[0]), copy.getAttribute("Number"));

    Assert.assertEquals(String.valueOf(stocks[0]), copy.getAttribute("Stock"));

    Assert.assertEquals(String.format("%.2f", roundDouble(prices[0])), copy.getAttribute("Price"));
  }

  private double roundDouble(double amount) {
    return Math.round(amount * 100.0) / 100.0;
  }
}
