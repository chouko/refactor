package fs.calculator;

import fs.bean.Performance;
import fs.bean.Play;

public class ComedyCalculator extends Calculator {
	
	public ComedyCalculator(Performance aPerformance,
			Play play){
		super(aPerformance, play);
	}

	@Override
	public int calculateAmount() {
		int result = 30000;
		if(aPerformance.audience > 20) {
			result += 1000 + 500 * (aPerformance.audience - 20);
		}
		result += 300 * aPerformance.audience;
		return result;
	}

	@Override
	public int calculatevolumeCredit() {
		return super.volumeCreditFor() + 
				(int)Math.floor(this.aPerformance.audience/5);
	}
}
