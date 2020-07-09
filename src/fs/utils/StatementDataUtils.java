package fs.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import fs.bean.EnrichedPerf;
import fs.bean.Invoice;
import fs.bean.Play;
import fs.bean.StatementData;

public class StatementDataUtils {
	public Map<String,Play> plays;
	public Invoice invoice;
	
	public StatementData makeStatementData(){
		EnrichPerUtils utils = new EnrichPerUtils();
		utils.plays = plays;
		
		List<EnrichedPerf> enrichPerfList = new ArrayList<EnrichedPerf>();
		
		invoice.performances.forEach((item)->{
			try {
				enrichPerfList.add(utils.enrichPerformance(item));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		StatementData result = new StatementData();
		result.customer = invoice.customer;
		result.performances = enrichPerfList;
		result.totalAmount = this.totalAmount(result);
		result.totalvolumeCredit = this.totalVolumeCredits(result);
		return result;
	} 
	
	/**
	 * 1. ÌáŸ’º¯”µ
	 * 2. °áÒÆº¯”µ
	 * 3. ¹ÜµÀÌæ´úÑ­­h
	 * @param statementsData
	 * @return
	 */
	private int totalVolumeCredits(StatementData statementsData) {
		// ÒÆ„ÓÕZ¾ä(Slide Statements)
		return statementsData.performances.stream()
				.map(x -> {
					return x.volumeCredit;
				}).reduce(Integer::sum).get();
	}
	
	/**
	 * 1. ÌáŸ’º¯”µ
	 * 2. °áÒÆº¯”µ
	 * 3. ¹ÜµÀÌæ´úÑ­­h
	 * @param statementsData
	 * @return
	 * @throws Exception
	 */
	private int totalAmount(StatementData statementsData){
		return statementsData.performances.stream()
				.map(x -> {
					return x.amount;
				}).reduce(Integer::sum).get();
	}
	
	
}
