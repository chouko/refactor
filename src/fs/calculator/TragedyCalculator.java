package fs.calculator;

import fs.bean.Performance;
import fs.bean.Play;

public class TragedyCalculator extends Calculator {

	public TragedyCalculator(Performance aPerformance,
			Play play){
		super(aPerformance, play);
	}

	@Override
	public int calculateAmount() {
		int result = 40000;
		if(aPerformance.audience > 30) {
			result += 1000 * (aPerformance.audience - 30);
		}
		return result;
	}

	@Override
	public int calculatevolumeCredit() {
		return super.volumeCreditFor();
	}
}
