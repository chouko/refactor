package fs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fs.bean.Invoice;
import fs.bean.Performance;
import fs.bean.Play;

public class HelloWorld {


	public static void main(String[] args) {
		HelloWorld hw = new HelloWorld();
		try {
			Statement st = new Statement(hw.makeInvoiceData(), hw.makePlayData());
			st.rederPlainText(st.data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Invoice makeInvoiceData() {
		List<Performance> performances = new ArrayList<Performance>();
		Performance perf1 = new Performance();
		perf1.playID = "hamlet";
		perf1.audience = 55;
		performances.add(perf1);
		
		Performance perf2 = new Performance();
		perf2.playID = "as_like";
		perf2.audience = 35;
		performances.add(perf2);
		
		Performance perf3 = new Performance();
		perf3.playID = "othello";
		perf3.audience = 40;
		performances.add(perf3);
		
		Invoice invoice = new Invoice();
		invoice.customer = "BigCo";
		invoice.performances = performances;
		
		return invoice;
	}
	
	private Map<String,Play> makePlayData() {
		Map<String,Play> plays = new HashMap<String,Play>();
		Play play1 = new Play();
		play1.name = "Hamlet";
		play1.type = "tragedy";
		plays.put("hamlet", play1);

		Play play2 = new Play();
		play2.name = "As You Like It";
		play2.type = "comedy";
		plays.put("as_like", play2);

		Play play3 = new Play();
		play3.name = "Othello";
		play3.type = "tragedy";
		plays.put("othello", play3);
		
		return plays;
	}

}
