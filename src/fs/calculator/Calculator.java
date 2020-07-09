package fs.calculator;

import fs.bean.Performance;
import fs.bean.Play;

/**
 * �Զ��Bȡ�����_ʽ(Replace Conditional with Polymorphism)
 * ��Q��������͵Ć��}
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
	 * ��ͨӋ��߉݋����ģ���ڳ�����Ќ��F
	 * ����ģ�巽��ģʽ˼��
	 * @return
	 */
	protected int volumeCreditFor() {
		int result = 0;
//		add volume credits
		result += Math.max(this.aPerformance.audience-30, 0);
		return result;
	}

}
