import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;




public class FirstClass {
	
	public static void main(String[] args) {
		try {
			Document doc = Jsoup.connect("http://en.wikipedia.org/").get();
			Elements links = doc.select("a");
			
			for (Element e : links) {
				System.out.println(e.attr("abs:href"));
			}
		}
		catch (IOException e) {
			
		}
	}

}
