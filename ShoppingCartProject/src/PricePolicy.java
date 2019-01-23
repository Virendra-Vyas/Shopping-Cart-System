
/**
 * File    : PricePolicy.java
 * Purpose : Denotes the functional interface for the Price Policy
 * @author Virendra Vyas
 *
 */
public interface PricePolicy {
	
	/**
	 * Calculate the price of product/Discounted Product
	 * @param quantity the quantity of the product
	 * @param price the price of the product (unit price)
	 * @return the calculated price of the product
	 */
	public int calculateCost(int quantity,int price);
}
