
/**
 *File    : Customer.java
 *Purpose : Denotes a customer
 * @author Virendra Vyas
 *
 */
public class Customer {

	/**
	 * unique id of the customer
	 */
	private String customerId;
	
	/**
	 * name of the customer
	 */
	private Name customerName;
	
	/**
	 * reward points of the customer
	 */
	private int rewardPoints;

	/**
	 * add the passed reward points to the customer reward points
	 * @param points the reward points to be added
	 */
	public void addRewardPoints(int points)
	{
		this.rewardPoints = this.getRewardPoints() + points;
	}
	
	public Customer(String customerId, Name customerName, int rewardPoints) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.rewardPoints = rewardPoints;
	}

	/**
	 * Return the reward points for this customer
	 * @return the reward points for this customer
	 */
	public int getRewardPoints() {
		return rewardPoints;
	}

	@Override
	public String toString() {
		String s=customerId+" : "+customerName.getFullName()+" Have "+rewardPoints+" Reward Points.";
		return s;
	}
	
	
	

}
