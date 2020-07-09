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
 * �ó����������
 * һ��Ϸ���ݳ��ţ���Ա�Ǿ���ȥ���ֳ�����ϲ�磬ͨ����customer����ָ�������磬�����Ÿ��ݹ��ڣ�audience�������Լ���Ŀ����ͻ��շ�
 * �þ���Ŀǰ��������Ϸ�磬���磨tragedy�� ��Ϸ�磨comedy�������ͻ������˵�ʱ�����Ż�����ݵ������ڵ��������������ڻ��֡���volume credit�� �Ż�
 * �´οͻ��ٴο��Ϳ������ۿۡ�
 * s
 * ���⣺
 * 1.�ó�����Ƶ���Σ�
 * 2.�����Ҫ����¹��ܱ�����Ҫ����µľ�Ŀ����Ҹ������ӣ�
 * 3.����øô���������Щ���۾��ĵط��أ�
 * 4.��������3���������ò��ã������ʱ��������ʵ�֣�
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
