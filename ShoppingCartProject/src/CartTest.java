import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Iterator;

/**
 * File : CartTest.java
 * @author Virendra Vyas
 * Purpose : Tester class for the Shopping Cart
 *
 */
public class CartTest {

	/**
	 * Main method to test the functionality of the application
	 */
	public static void main(String[] args) {
		useCase1();
		useCase2();
		useCase3();
		useCase4();
		useCase5();
		useCase6();
	}

	private static void useCase5() {
		System.out.println("=============> USE CASE 5");
		Cart cart=getCart();
		Product product2 = new Product("P001", "This is Product 1.", 11);
		Product product3 = new DiscountProduct("P002", "This is Product 2.", 15,0.4);
		RewardProcessor processor=new RewardProcessor();
		processor.addProduct(product2);
		processor.addProduct(product3);
		processor.addProduct(new Product("1", "test desc", 10));
		processor.addProduct(new Product("2", "test desc", 10));
		System.out.println("Initial reward points of customer : "+cart.getCustomer().getRewardPoints());
		System.out.println("rewardPoints(cart) returned : "+processor.rewardPoints(cart));
		System.out.println("Updated reward points for customer : "+cart.getCustomer().getRewardPoints());
		System.out.println();
		System.out.println();

	}

	private static void useCase4() {
		System.out.println("=============> USE CASE 4");
		Cart cart=getCart();
		System.out.println();
		System.out.println("==>Initial Cart by iterator");
		Iterator<Order> itr=cart.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
		Product product2 = new Product("P001", "This is Product 1.", 11);
		Product product3 = new DiscountProduct("P002", "This is Product 2.", 15,0.4);
		System.out.println("");
		System.out.println("Contains method for order with id P001: "+cart.containsOrder(new Order(1,product2)));
		System.out.println("Contains method for order with id P004: "+cart.containsOrder(new Order(1,product3)));
		System.out.println("Calling Remove method for order with id P001.");
		
		System.out.println("FindOrder with product Code P002 : "+cart.findOrder("P002"));
		System.out.println("");
		System.out.println("Sorting Orders...");
		cart.sortOrders();
		System.out.println("incrementing Order quantity with id P004");
		cart.findOrder("P004").increaseQuantity();
		System.out.println("incrementing Order quantity with id P004");
		cart.findOrder("P004").increaseQuantity();
		System.out.println("incrementing Order quantity with id P005");
		cart.findOrder("P004").decreaseQuantity();
		System.out.println("\nFinal Cart by Iterator: ");
		itr=cart.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
		System.out.println();
		System.out.println();
	}

	private static void useCase3() {
		System.out.println("=============> USE CASE 3");
		Cart cart=getCart();
		System.out.println();
		System.out.println("==>Initial Cart");
		cart.forEach((order) -> System.out.println(order));
		System.out.println();
		Product product2 = new Product("P001", "This is Product 1.", 11);
		Product product3 = new DiscountProduct("P002", "This is Product 2.", 15,0.4);
		Product product4 = new Product("P009", "This is Product 4.", 20);
		System.out.println("Testing contains ...");
		System.out.println("Contains method for order with id P001: "+cart.containsOrder(new Order(1,product2)));
		System.out.println("Contains method for order with id P004: "+cart.containsOrder(new Order(1,product3)));
		System.out.println("Contains method for order with id P009: "+cart.containsOrder(new Order(1,product4)));

		System.out.println("\nTesting Remove ...");
		System.out.println("Calling Remove method for order with id P001.");
		System.out.println("Calling Remove method for order with id P004.");
		System.out.println("Calling Remove method for order with id P009.");

		cart.removeOrder(new Order(1,product2));
		cart.removeOrder(new Order(1,product3));
		cart.removeOrder(new Order(1,product4));
		
		System.out.println("\n==>Final Cart");
		cart.forEach((order) -> System.out.println(order));

		cart=getCart();
		try {
			final PrintWriter writer=new PrintWriter(new File("Cart.txt"));
			writer.println(cart.toString());
			cart.forEach((order) -> writer.println(order.toString()));
			
			writer.println();
			
			writer.println("Number of items in the cart : "+cart.size());
			writer.println("Overall total price : "+cart.getTotalCost());
			
			writer.flush();
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("'Cart.txt' file created successfully.");
		System.out.println();
		System.out.println();

	}

	private static void useCase2() {
		System.out.println("=============> USE CASE 2");
		Cart cart=getCart();
		System.out.println("==>Initial Cart");
		cart.forEach((order) -> System.out.println(order));
		System.out.println();
		System.out.println("==>Sorting Cart");
		cart.sortOrders();
		cart.forEach((order) -> System.out.println(order));
		System.out.println();
		cart.sortOrders(new Comparator<Order>() {
			
			@Override
			public int compare(Order o1, Order o2) {
				
				if(o1.getCost()-o2.getCost()!=0)
					return o1.getCost()-o2.getCost();
				return o2.getProduct().compareTo(o1.getProduct());
			}
		});
		System.out.println("==>Sorting Cart by passing Comparator");
		cart.forEach((order) -> System.out.println(order));
		System.out.println();
		System.out.println();

	}

	private static void useCase6() {
		System.out.println("=============> USE CASE 6");
		PricePolicy B1G1=new PricePolicy() {

			@Override
			public int calculateCost(int quantity, int price) {
				return quantity/2 * price;
			}
		};
		PricePolicy B2G1=new PricePolicy() {

			@Override
			public int calculateCost(int quantity, int price) {
				int fPrice1 = (quantity/3)*(price*2);
				int fPrice2=(quantity%3)*price;
				return fPrice1 + fPrice2;
			}
		};
		PricePolicy B5G1=new PricePolicy() {

			@Override
			public int calculateCost(int quantity, int price) {
				int fPrice1 = (quantity/6)*(price*5);
				int fPrice2=(quantity%6)*price;
				return fPrice1 + fPrice2;
			}
		};
		Product product = new Product("P001", "This is Product 1.", 11);
		Cart cart=getCart();
		cart.removeOrder(new Order(1, product));
		System.out.println("Initial cart : ");
		cart.forEach((order) -> System.out.println(order));
		System.out.println("Number of items in the cart : "+cart.size());
		System.out.println("Overall total price : "+cart.getTotalCost());
		System.out.println();
		System.out.println();
		System.out.println("Setting price policy...");
		System.out.println("Order with Id P003 : Default Price Policy");
		System.out.println("Order with Id P002 : Buy 1 Get 1 Free Price Policy");
		System.out.println("Order with Id P004 : Buy 2 Get 1 Free Price Policy");
		System.out.println("Order with Id P005 : Buy 5 Get 1 Free Price Policy");
		cart.findOrder("P002").setPricePolicy(B1G1);
		cart.findOrder("P004").setPricePolicy(B2G1);
		cart.findOrder("P005").setPricePolicy(B5G1);

		System.out.println("Final cart : ");
		cart.forEach((order) -> System.out.println(order));
		System.out.println("Number of items in the cart : "+cart.size());
		System.out.println("Overall total price : "+cart.getTotalCost());
		System.out.println();
		System.out.println();
		System.out.println();


	}

	private static void useCase1() {
		System.out.println("=============> USE CASE 1");
		Cart cart=getCart();
		cart.forEach((order) -> System.out.println(order));
		System.out.println("Number of items in the cart : "+cart.size());
		System.out.println("Overall total price : "+cart.getTotalCost());
		System.out.println();
		System.out.println();

	}

	/**
	 * Create a new Cart with default data
	 * @return the created cart
	 */
	private static Cart getCart()
	{
		String cartId = "CART001";
		Date deliveryDate = new Date(9, 1, 2019);
		Name name = new Name("F_TEST","L_TEST");
		Customer customer = new Customer("CUSTOMER001", name, 0);
		Product product1 = new Product("P003", "This is Product 3.", 10);
		Product product2 = new Product("P001", "This is Product 1.", 11);
		Product product3 = new DiscountProduct("P002", "This is Product 2.", 15,0.4);
		Product product4 = new Product("P004", "This is Product 4.", 20);
		Product product5 = new DiscountProduct("P005", "This is Product 5.", 22,0.5);


		Cart cart=new Cart(cartId, deliveryDate, customer);

		//order with default price policy
		cart.addOrder(new Order(5, product1));

		//order with Buy 1 get 1 free price policy
		cart.addOrder(new Order(14, product2));

		//order with Buy 2 get 1 free price policy
		cart.addOrder(new Order(10, product3));
		//order with Buy 5 get 1 free price policy
		cart.addOrder(new Order(11, product4));

		//order with default price policy
		cart.addOrder(new Order(15, product5));

		return cart;
	}
}
