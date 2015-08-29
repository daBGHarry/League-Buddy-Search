import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;




public class FirstClass {
	
	private String username;
	private String buddy;
	
	public void Setup() throws AreYouThereException {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Hello and welcome to the League Buddy Finder.");
		System.out.println("*********************************************");
		System.out.print("Please enter your League of Legends username : ");
		// Add time here to count the amount of time the user is taking to enter their username.
		// If they take too long prompt the user to see if they are still there.
		setUsername(keyboard.nextLine().toLowerCase());
		System.out.print("Please enter your buddy's League of Legends username : ");
		setBuddy(keyboard.nextLine().toLowerCase());
		
		
		findMatches(usernameSetupForUrl(getUsername()), buddySetupForUrl(getBuddy()));
		
	}
	
	public void findMatches(String username, String buddy) {
		try {
			WebDriver webdriver = new FirefoxDriver();
			webdriver.get("http://na.op.gg/summoner/userName=" + usernameSetupForUrl(username));
			WebElement renewData = webdriver.findElement(By.className("ladda-button _refreshSummonerInfo summonerRefreshButton"));
			renewData.click();
			webdriver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
			
//			Document doc = Jsoup.connect("http://na.op.gg/summoner/userName=" + usernameSetupForUrl(username)).get();
//			Elements listOfGames = doc.getElementsByAttributeValue("class", "GameSimpleStats");
//			Elements listOfPlayers;
//			Elements matchPlayers;
			
			for (Element match : listOfGames) {
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String usernameSetupForUrl(String username) {
		username = username.trim();
		if (username.contains(" ")) {
			username = username.replace(' ', '+');
			setUsername(username);
		}
		return username;
	}
	
	public String buddySetupForUrl(String buddy) {
		buddy = buddy.trim();
		if (buddy.contains(" ")) {
			buddy = buddy.replace(' ', '+');
			setBuddy(buddy);
		}
		return buddy;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getBuddy() {
		return buddy;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setBuddy(String buddy) {
		this.buddy = buddy;
	}

}
