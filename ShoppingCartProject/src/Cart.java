
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;



/**
 * File    : Cart.java
 * Purpose : Denotes a cart having a customer and list of items
 * @author Virendra Vyas
 *
 */
public class Cart implements Iterable<Order>{

	/**
	 * unique id of the cart
	 */
	private String cartId;
	/**
	 * delivery date of this cart
	 */
	private Date deliveryDate;
	
	/**
	 * list of orders in this cart
	 */
	private List<Order> productOrders;
	
	/**
	 * customer of this cart
	 */
	private Customer customer;
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<Order> iterator() {
		return productOrders.iterator();
	}

	
	/**
	 * Return the total cost of this cart
	 * @return the total cost of this cart
	 */
	public int getTotalCost()
	{
		int total=0;
		for(Order order:productOrders)
			total+=order.getCost();
		return total;
	}
	
	/**
	 * add passed order to the list of product orders
	 * @param order the new order to be added to the list of product orders
	 */
	public void addOrder(Order order)
	{
		productOrders.add(order);
	}
	
	/**
	 * check whether passed order exist in the list of product orders
	 * @param order the new order check in the list of product orders
	 */
	public boolean containsOrder(Order order)
	{
		return productOrders.contains(order);
	}
	
	/**
	 * remove the passed order from the list of product orders
	 * @param order the order to be removed from the list of product orders
	 */
	public void removeOrder(Order order)
	{
		productOrders.remove(order);
	}
	
	/**
	 * find and return an Order with the passed product code
	 * @param productCode the product code of the product to find
	 * @return the Order with the passed product code
	 */
	public Order findOrder(String productCode)
	{
		for(Order order : productOrders)
		{
			if(order.getProduct().getProductCode().compareTo(productCode)==0)
				return order;
		}
		return null;
	}
	
	/**
	 * sort the list of product orders
	 */
	public void sortOrders()
	{
		Collections.sort(productOrders);
	}
	
	
	/**
	 * sort the list of product orders according to the passed comparator
	 * @param comparator the new comparator to be used for sorting
	 */
	public void sortOrders(Comparator<Order> comparator)
	{
		Collections.sort(productOrders,comparator);
	}

	/**
	 * Return the customer of this cart
	 * @return the customer of this cart
	 */
	public Customer getCustomer() {
		return customer;
	}


	public Cart(String cartId, Date deliveryDate, Customer customer) {
		super();
		this.cartId = cartId;
		this.deliveryDate = deliveryDate;
		this.customer = customer;
		this.productOrders=new ArrayList<>();
	}


	@Override
	public String toString() {
		String s=cartId+" : ["+deliveryDate.getDateString()+"] : "+customer.toString();
		return s+System.lineSeparator();
	}


	/**
	 * Return the number of orders in this cart
	 * @return the number of orders in this cart
	 */
	public int size() {
		return productOrders.size();
	}
	
	
	
	
	
	

}
