package fs.bean;

import fs.bean.Play;

/**
 * 1. 中间变量，扩展一场演出的数据结构和信息
 * 2. 也是为了防止改变参数的值
 * @author Administrator
 *
 */
public class EnrichedPerf {
	public Play play;
	public int audience;
	public String playId;
	public int amount;
	public int volumeCredit;
	
}
