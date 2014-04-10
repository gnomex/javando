package br.github.gnomex.files;

import java.io.Serializable;

/**
 * A dummy object to provide some data to save on a file 
 */

public class DummieRecord implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String something;
	private String somebody;
	private int aNumber;
	private double bNumber;
	
	public DummieRecord(String something, String somebody, int aNumber,
			double bNumber) {
		super();
		this.something = something;
		this.somebody = somebody;
		this.aNumber = aNumber;
		this.bNumber = bNumber;
	}
	
	public DummieRecord() {
		// TODO Auto-generated constructor stub
	}

	public static DummieRecord getStub()	{
		return new DummieRecord("Something", "Lol", 1, 100.0); 
	}
	
	public String getSomething() {
		return something;
	}
	public void setSomething(String something) {
		this.something = something;
	}
	public String getSomebody() {
		return somebody;
	}
	public void setSomebody(String somebody) {
		this.somebody = somebody;
	}
	public int getaNumber() {
		return aNumber;
	}
	public void setaNumber(int aNumber) {
		this.aNumber = aNumber;
	}
	public double getbNumber() {
		return bNumber;
	}
	public void setbNumber(double bNumber) {
		this.bNumber = bNumber;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + aNumber;
		long temp;
		temp = Double.doubleToLongBits(bNumber);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((somebody == null) ? 0 : somebody.hashCode());
		result = prime * result
				+ ((something == null) ? 0 : something.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DummieRecord other = (DummieRecord) obj;
		if (aNumber != other.aNumber)
			return false;
		if (Double.doubleToLongBits(bNumber) != Double
				.doubleToLongBits(other.bNumber))
			return false;
		if (somebody == null) {
			if (other.somebody != null)
				return false;
		} else if (!somebody.equals(other.somebody))
			return false;
		if (something == null) {
			if (other.something != null)
				return false;
		} else if (!something.equals(other.something))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "<" + something + ","
				+ somebody + "," + aNumber + "," + bNumber
				+ ">";
	}	
}
