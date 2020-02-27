package speedMeterCarSpeedMeter;

public abstract class SpeedMeter {
	
	private double turnRate;
	
	public SpeedMeter() {}
	
	//define getRadius() as abstract
	public abstract double getRadius();
	
	public void setTurnRate(double turnRate) {
		this.turnRate = turnRate;
	}
	
	//how to calculate speed
	public double getSpeed() {
		return java.lang.Math.PI * 2 * getRadius() * turnRate;
	}

}
