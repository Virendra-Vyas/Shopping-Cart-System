
/**
 * 
 * File    : Order.java
 * Purpose : Denotes a Order having a product, quantity and a price policy
 * @author Virendra Vyas
 *
 */


public class Order implements Comparable<Order>{

	/**
	 * quantity of the product for this order
	 */
	private int quantity;

	/**
	 * product of this order
	 */
	private Product product;

	/**
	 * Price policy of this order
	 */
	private PricePolicy policy;

	/**
	 * Return the cost of this order according to the associated price policy
	 * @return the cost of this order according to the associated price policy
	 */
	public int getCost()
	{
		return policy.calculateCost(quantity, product.getUnitPrice());
	}

	/**
	 * increase the quantity of this order by 1
	 */
	public void increaseQuantity()
	{
		this.quantity=this.quantity+1;
	}
	
	/**
	 * decrease the quantity of this order by 1
	 * only if the quantity is greater than 0
	 */
	public void decreaseQuantity()
	{
		if(this.quantity>0)
			this.quantity=this.quantity-1;
	}
	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Order o) {
		if(product.compareTo(o.product)!=0)
			return product.compareTo(o.product);
		return quantity - o.quantity;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return (product.hashCode() +quantity) % 31;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {

		Order order = (Order) obj;
		return product.equals(order.product);
	}

	/**
	 * Return the product for this cart
	 * @return the product for this cart
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * Return the quantity of this order
	 * @return the quantity of this order
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * set the new price policy for this order
	 * @param policy the new price policy for this order
	 */
	public void setPricePolicy(PricePolicy pricePolicy) {
		this.policy = pricePolicy;
	}

	public Order(int quantity, Product product) {
		super();
		this.quantity = quantity;
		this.product = product;
		this.policy = new PricePolicy() {

			@Override
			public int calculateCost(int quantity, int price) {
				return quantity * price;
			}
		};
	}

	@Override
	public String toString() {
		String s=product.toString();
		s+="Quantity    : "+quantity+System.lineSeparator();
		s+="Total Price : "+getCost()+System.lineSeparator();
		return s;
	}


}
