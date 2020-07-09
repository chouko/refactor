package fs.utils;

import java.util.Map;

import fs.bean.EnrichedPerf;
import fs.bean.Performance;
import fs.bean.Play;
import fs.calculator.Calculator;
import fs.factory.PerformanceCalculatorFactory;

public class EnrichPerUtils {
	public Map<String,Play> plays;
	
	public EnrichedPerf enrichPerformance(Performance aPerformance) throws Exception {
		PerformanceCalculatorFactory factory = new PerformanceCalculatorFactory(aPerformance, this.playFor(aPerformance));
		Calculator calculator = factory.createCalculator();
		EnrichedPerf result = new EnrichedPerf();
		result.audience = aPerformance.audience;
		result.playId = aPerformance.playID;
		result.play = this.playFor(aPerformance);
		result.amount = calculator.calculateAmount();
		result.volumeCredit = calculator.calculatevolumeCredit();
		
		return result;
	}
	
	private Play playFor(Performance aPerformance) {
		return this.plays.get(aPerformance.playID);
	}
	
	/**
	 * ��������
	 * ���������ֵϰ���Բ���result
	 * @param aplay
	 * @param aPerformance
	 * @return
	 * @throws Exception
	 */
	private int amountFor(Performance aPerformance) throws Exception {
		int result = 0;
		switch (this.playFor(aPerformance).type) {
		case "tragedy":
			result = 40000;
			if(aPerformance.audience > 30) {
				result += 1000 * (aPerformance.audience - 30);
			}
			break;
		case "comedy":
			result = 30000;
			if(aPerformance.audience > 20) {
				result += 1000 + 500 * (aPerformance.audience - 20);
			}
			result += 300 * aPerformance.audience;
			break;
		default:
			throw new Exception("unknown type " + this.playFor(aPerformance).type);
		}
		return result;
	}
	
	/**
	 * 1.��������
	 * 2.�Ƴ�play��ʱ������ֻʹ����һ��, aplay -> playFor(aPerformance)
	 * ���������ֵϰ���Բ���result
	 * @param aplay
	 * @param aPerformance
	 * @return
	 */
	private int volumeCreditsFor(Performance aPerformance) {
		int result = 0;
		result += Math.max(aPerformance.audience-30, 0);
		
		if("comedy".equals(this.playFor(aPerformance).type)) {
			result += Math.floor(aPerformance.audience/5);
		}
		
		return result;
	}

}
