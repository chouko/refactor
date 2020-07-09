package fs.calculator;

import fs.bean.Performance;
import fs.bean.Play;

/**
 * 以多態取代表達式(Replace Conditional with Polymorphism)
 * 解決新增戲劇類型的問題
 * 
 * @author Administrator
 *
 */
public abstract class Calculator {
	public Performance aPerformance;
	public Play play;
	public Calculator(
			Performance aPerformance,
			Play play
	){
		this.aPerformance = aPerformance;
		this.play = play;
	}
	public abstract int calculateAmount();
	
	public abstract int calculatevolumeCredit();
	
	/**
	 * 共通計算邏輯作爲模板在抽象類中實現
	 * 參考模板方法模式思想
	 * @return
	 */
	protected int volumeCreditFor() {
		int result = 0;
//		add volume credits
		result += Math.max(this.aPerformance.audience-30, 0);
		return result;
	}

}
