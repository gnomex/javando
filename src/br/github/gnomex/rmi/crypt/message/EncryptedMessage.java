package br.github.gnomex.rmi.crypt.message;

import java.util.ArrayList;
import java.util.List;

public class EncryptedMessage {

	private ArrayList<String> message;

	public EncryptedMessage(List<String> pgp_message) {
		this.message = new ArrayList<String>();
		this.message.addAll(pgp_message);
	}
	
	/**
	 * @return the message
	 */
	public String getPgpContent() {
		StringBuilder builder = new StringBuilder();
		
		for(String s : message)	{
			builder.append(s);
		}
		
		return builder.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof EncryptedMessage)) {
			return false;
		}
		EncryptedMessage other = (EncryptedMessage) obj;
		if (message == null) {
			if (other.message != null) {
				return false;
			}
		} else if (!message.equals(other.message)) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EncryptedMessage [");
		if (message != null)
			builder.append("message=").append(message);
		builder.append("]");
		return builder.toString();
	}
}
