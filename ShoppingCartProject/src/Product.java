

/**
 * File    : Product.java
 * Purpose : Denotes a Product
 * @author Virendra Vyas
 *
 */
public class Product implements Comparable<Product>{

	/**
	 * unique code of the product
	 */
	private String productCode;
	
	/**
	 * description of the product
	 */
	private String description;
	
	/**
	 * price of 1 unit product
	 */
	private int unitPrice;
	
	/**
	 * This method returns the unit price of this product 
	 * @return the unit price of this product 
	 */
	public int getUnitPrice()
	{
		return unitPrice;
	}

	public Product(String productCode, String description, int unitPrice) {
		super();
		this.productCode = productCode;
		this.description = description;
		this.unitPrice = unitPrice;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Product o) {
		if(productCode.compareTo(o.productCode)!=0)
			return productCode.compareTo(o.productCode);
		if(description.compareTo(o.description)!=0)
			return description.compareTo(o.description);
		return unitPrice-o.unitPrice;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return (productCode.hashCode() + description.hashCode() + unitPrice)%31;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		Product product = (Product) obj;
		return unitPrice==product.unitPrice
				&& description.equals(product.description)
				&& productCode.equals(product.productCode);
	}

	/**
	 * @return the product code of this Product
	 */
	public String getProductCode() {
		return productCode;
	}

	@Override
	public String toString() {
		String s=productCode+" ["+description+"]"+System.lineSeparator();
		s+="Unit Price : "+unitPrice+System.lineSeparator();
		return s;
	}

	


	
	
	

	
	
	

}
