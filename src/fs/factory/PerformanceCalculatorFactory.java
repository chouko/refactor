package fs.factory;


import fs.bean.Performance;
import fs.bean.Play;
import fs.calculator.ComedyCalculator;
import fs.calculator.Calculator;
import fs.calculator.TragedyCalculator;

public class PerformanceCalculatorFactory {
	protected Performance aPerformance;
	protected Play play;
	public PerformanceCalculatorFactory(
			Performance aPerformance,
			Play play
	){
		this.aPerformance = aPerformance;
		this.play = play;
	}
	
	public Calculator createCalculator() throws Exception{
		switch(this.play.type) {
		case "tragedy": return new TragedyCalculator(this.aPerformance,this.play);
		case "comedy": return new ComedyCalculator(this.aPerformance,this.play);
		default:
			throw new Exception("unknown type " + this.play.type);
		}
	}

}
