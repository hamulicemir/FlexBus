package FluxBus.provided;

/**
 * A bus in the Fix bus management system (FluxBus).
 * 
 * Skeleton implementation, no argument checking whatsoever.
 * 
 * @author TeM
 * @ProgrammingProblem.Hint provided
 */
public class Bus {
	private String licenceNumber;
	private int capacity;

	/**
	 * Creates a bus with a specified license number  and capacity.
	 * 
	 * @param license
	 *            the licenceNumber to set
	 * @param capacity
	 *            the capacity to set
	 */
	public Bus(String license, int capacity) {
		this.licenceNumber = new String(license);
		this.capacity = capacity;
	}

	/**
	 * Copy constructor.
	 * 
	 * @param a
	 *            the aircraft to copy.
	 */
	public Bus(Bus a) {
		licenceNumber = new String(a.licenceNumber);
		capacity = a.capacity;
	}

	/**
	 * Gets the capacity.
	 * 
	 * @return the capacity of this bus
	 */

	public int getCapactiy() {
		return capacity;
	}

	@Override
	public String toString() {
		return String.format("%s %d", licenceNumber, capacity);
	}
}
