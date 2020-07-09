package fs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fs.bean.EnrichedPerf;
import fs.bean.Invoice;
import fs.bean.Play;
import fs.bean.StatementData;
import fs.utils.StatementDataUtils;

/**
 * 该程序的能力：
 * 一个戏剧演出团，演员们经常去各种场合演喜剧，通常（customer）会指定几出剧，而剧团根据观众（audience）人数以及剧目来向客户收费
 * 该剧团目前出演两种戏剧，悲剧（tragedy） 和戏剧（comedy），给客户发出账单时，剧团还会根据到场观众的数量给出“观众积分”（volume credit） 优惠
 * 下次客户再次看就可以有折扣。
 * s
 * 问题：
 * 1.该程序设计的如何？
 * 2.如果我要添加新功能比如我要添加新的剧目類型我该如何添加？
 * 3.你觉得该代码中有哪些辣眼睛的地方呢？
 * 4.对于问题3，如果你觉得不好，那如果时你你会如何实现？
 * 
 * @author benjun.wang
 *
 */
public class Statement {
	public StatementData data;

	public Statement(Invoice invoice, Map<String,Play> plays) throws Exception {
		StatementDataUtils utils = new StatementDataUtils();
		utils.plays = plays;
		utils.invoice = invoice;
		
		data = utils.makeStatementData();
	}
	
	
	public void rederPlainText(StatementData data) throws Exception {
		StringBuilder result = new StringBuilder();
		result.append("statement for ");
		result.append(data.customer);
		result.append("\n");
		
		for(EnrichedPerf item :data.performances) {

			result.append(item.play.name + ":" + item.amount /100 + "(" + item.audience + "seats)" );
			result.append("\n");
		}
		
		result.append("Amount owed is " + data.totalAmount/100);
		result.append("\n");
		result.append("You earned " + data.totalvolumeCredit + "credits");
		result.append("\n");
		
		System.out.println(result);
	}
	
	
}
