package br.github.gnomex.two_th_exercises.frogs;

public class Scenario {

	private Integer routeSize = 100; //Route size
	private String name = "Amazing Road";

	public synchronized Boolean hasWinner(Integer distance){
		return distance > routeSize ? Boolean.TRUE : Boolean.FALSE;
	}

	@Override
	public String toString() {
		return "Scenario [routeSize=" + routeSize + ", name=" + name + "]";
	}
	
}
