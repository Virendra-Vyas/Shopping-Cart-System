
import java.util.HashSet;
import java.util.Iterator;

/**
 * File    : RewardProcessor.java
 * Purpose : Denotes a RewardProcessor for the products having some rewards associated with them
 * @author Virendra Vyas
 *
 */
public class RewardProcessor {

	/**
	 * HashSet of products
	 * This set will contain the products which have some rewards associated with them
	 */
	private HashSet<Product> products=new HashSet<>();
	
	/**
	 * Add the passed product to the set of products
	 * @param product the new product to be added
	 * @return true only if the product was successfully added else return false
	 */
	public boolean addProduct(Product product)
	{
		boolean returnValue=products.contains(product);
		products.add(product);
		return returnValue;
	}
	
	/**
	 * calculate the reward points for a cart
	 * @param cart cart to check
	 * @return calculated reward points for this cart
	 */
	public int rewardPoints(Cart cart)
	{
		int points=0;
		Iterator<Order> itr=cart.iterator();
		Customer cartCustomer=cart.getCustomer();
		while(itr.hasNext())
		{
			Order tempOrder=itr.next();
			Product product=tempOrder.getProduct();
			if(products.contains(product))
				points=points+tempOrder.getQuantity();
		}
		cartCustomer.addRewardPoints(points);
		return points;
	}
}
