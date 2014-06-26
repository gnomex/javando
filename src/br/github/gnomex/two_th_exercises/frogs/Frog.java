package br.github.gnomex.two_th_exercises.frogs;

public class Frog implements Runnable{

	private String name = "CrazyFrog"; // The Frog's name 
	private Integer participantNumber;	// The participant number on race 
	private Integer jump_velocity;	// Jump velocity
	private Integer jump_distance;	// Jump distance
	
	private Integer distanceCoveredSoFar = new Integer(0);
	
	private Long timeToNextJump = new Long(0); //Time to try another jump
	
	private Scenario scenario;
	
	public Frog(String name, Integer participantNumber, Integer jump_velocity,
			Integer jump_distance, Long timeToNextJump, Scenario scenario) {
		super();
		this.name = name;
		this.participantNumber = participantNumber;
		this.jump_velocity = jump_velocity;
		this.jump_distance = jump_distance;
		this.timeToNextJump = timeToNextJump;
		this.scenario = scenario;
	}



	@Override
	public void run() {
		while (!scenario.hasWinner(distanceCoveredSoFar))	{
			this.jump();
			try {
				Thread.sleep(this.timeToNextJump);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("I got it!" + this.toString());
		
	}
	
	private void jump()	{
		System.out.println(name + " " + participantNumber +  " says: My time to jump!");
		this.distanceCoveredSoFar += this.jump_distance;
	}



	@Override
	public String toString() {
		return "Frog [name=" + name + ", participantNumber="
				+ participantNumber + ", jump_velocity=" + jump_velocity
				+ ", jump_distance=" + jump_distance
				+ ", distanceCoveredSoFar=" + distanceCoveredSoFar
				+ ", timeToNextJump=" + timeToNextJump + ", scenario="
				+ scenario.toString() + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((distanceCoveredSoFar == null) ? 0 : distanceCoveredSoFar
						.hashCode());
		result = prime * result
				+ ((jump_distance == null) ? 0 : jump_distance.hashCode());
		result = prime * result
				+ ((jump_velocity == null) ? 0 : jump_velocity.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime
				* result
				+ ((participantNumber == null) ? 0 : participantNumber
						.hashCode());
		result = prime * result
				+ ((timeToNextJump == null) ? 0 : timeToNextJump.hashCode());
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
		Frog other = (Frog) obj;
		if (distanceCoveredSoFar == null) {
			if (other.distanceCoveredSoFar != null)
				return false;
		} else if (!distanceCoveredSoFar.equals(other.distanceCoveredSoFar))
			return false;
		if (jump_distance == null) {
			if (other.jump_distance != null)
				return false;
		} else if (!jump_distance.equals(other.jump_distance))
			return false;
		if (jump_velocity == null) {
			if (other.jump_velocity != null)
				return false;
		} else if (!jump_velocity.equals(other.jump_velocity))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (participantNumber == null) {
			if (other.participantNumber != null)
				return false;
		} else if (!participantNumber.equals(other.participantNumber))
			return false;
		if (timeToNextJump == null) {
			if (other.timeToNextJump != null)
				return false;
		} else if (!timeToNextJump.equals(other.timeToNextJump))
			return false;
		return true;
	}
	
	
}
