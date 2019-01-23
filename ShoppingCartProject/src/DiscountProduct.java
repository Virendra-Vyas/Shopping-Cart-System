
/**
 * File    : DiscountProduct.java
 * Purpose : Denotes a Product having some discount associated with it
 * @author Virendra Vyas
 *
 */
public class DiscountProduct extends Product{

	/**
	 * discount rate associated with this product
	 */
	private double discountRate;
	
	/*
	 * (non-Javadoc)
	 * @see Product#getUnitPrice()
	 */
	@Override
	public int getUnitPrice()
	{
		double discount = discountRate * super.getUnitPrice();
		return (int) Math.floor(super.getUnitPrice() -discount);
	}

	public DiscountProduct(String productCode, String description, int unitPrice, double discountRate) {
		super(productCode, description, unitPrice);
		this.discountRate = discountRate;
	}

	/*
	 * (non-Javadoc)
	 * @see Product#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public String toString() {
		String s=super.toString();
		s+="Discounted Price : "+getUnitPrice()+" ["+discountRate+"]"+System.lineSeparator();
		return s;
	}
	
	
		
}
