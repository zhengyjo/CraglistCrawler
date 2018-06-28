import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document; 
import org.jsoup.nodes.Element; 
import org.jsoup.select.Elements;

public class CraiglistCrawl {
	public static void main(String[] args) throws IOException {
		CraiglistCrawl.Crawl("https://sfbay.craigslist.org/d/apts-housing-forrent/search/apa");
	}
	
	public static void Crawl(String url) throws IOException {
		Document doc = Jsoup.connect(url).get(); 
		Elements results = doc.select("li.result-row");

		for (Element result : results) { 
			//title
			String title = "NULL";
			Element titleContent = result.select("a.result-title").first(); 
			if (titleContent != null) {
				title = titleContent.html();
			}
			
			//price
			Element priceContent = result.select("a.result-image").first().select("span.result-price").first(); 
			String price = "NULL"; 
			if (priceContent != null) { 
				price = priceContent.html(); 
			}
			
			//url
			Element detail = result.select("a.result-image").first();
			String houseUrl = "NULL";
			if (detail != null) {
				houseUrl = detail.attr("href");
			}
			
			//hood
			Element hoodContent = result.select("span.result-hood").first(); 
			String hood = "NULL"; 
			if (hoodContent != null) { 
				hood = hoodContent.html(); 
			} 
		
			System.out.println(title + " " + price + " " + houseUrl + " " + hood);

		}
	}
}
