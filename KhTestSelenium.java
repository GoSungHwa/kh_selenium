package kh.test.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KhTestSelenium {

	public static void main(String[] args) {
		System.getProperty("webdriver.chrome.driver", "chromedriver.exe");//실행되는 곳의 정보를 얻어오거나 운영체제의 정보가 필요할 때, 시스템의 정보를 가져온다.
		WebDriver dr1=new ChromeDriver(); //크롬창을 열기 위한 준비->열기,dr1=현재 크롬창
		WebDriverWait w1=new WebDriverWait(dr1, 10); //위 크롬창이 실제 열릴 때까지 10초 정도 기다려줌.
		
		dr1.get("https://iei.or.kr/login/login.kh"); //열린 크롬창에 url 이동함.
		WebElement e1=dr1.findElement(By.id("id")); //웹에서 사용하는 요소를 꺼내준다.
		WebElement e2=dr1.findElement(By.id("password"));
		e1.sendKeys("내 아이디"); //입력창에 알아서 들어감.
		e2.sendKeys("내 비밀번호");
		
		JavascriptExecutor jsexe=(JavascriptExecutor)dr1;
		jsexe.executeScript("fnLogin()"); //바로 로그인됨
		//페이지 로딩될때까지 기다려야 다음 js가 실행댐.
		w1.until(ExpectedConditions.titleContains("KH정보교육원 - 마이페이지"));
		jsexe.executeScript("location.href='/login/currBoard.kh'");
		//페이지 로딩될때까지 기다려야 다음 js가 실행댐.
		w1.until(ExpectedConditions.titleContains("우리반 게시판"));
		jsexe.executeScript("fnWriteForm()");
		//페이지 로딩될때까지 기다려야 하는데..title이라는 것을 클릭할 수 있는지 확인 될때까지 기다림
		w1.until(ExpectedConditions.elementToBeClickable(By.id("title")));
		WebElement e3=dr1.findElement(By.id("title")); 
		e3.sendKeys("제목입력테스트");
		
		//wusiwyg 프레임으로 이동
		dr1.switchTo().frame("tx_canvas_wysiwyg");
		//내용 입력창
		WebElement e4=dr1.findElement(By.className("tx-content-container")); 
		//내용 입력
		e4.sendKeys("내용입력~~~아이프레임 사용된 입력창-frame~이동");
		//부모프레임, 원본 프레임으로 이동
		dr1.switchTo().parentFrame();
		//완료버튼
		jsexe.executeScript("fnRegister()");
		
		//popup 떳을때 확인,alert창 이동
		dr1.switchTo().alert().accept();
		//크롬창 닫고, resource 닫기
//		dr1.close();
	
	
	//참고
	//selector 복사
//	for(int i=1;i<2;i++) {
//		for(int j=1;j<=5;j++) {
//			WebElement e=dr1.findElement(By.cssSelector("#content > div:nth-child(2) > div > div > div > ul > li:nth-child("+i+") > ul > li:nth-child("+j+") > div.song_area > div.song> a"));
//			WebElement e5=dr1.findElement(By.xpath("*[@id=\"content\"]/div[1]/div/div/div/ul/li[1]/ul/li[1]/div[3]/div[1]/a"));
//			String innertext=e.getText();
//		}
//	}
	//#content > div:nth-child(2) > div > div > div > ul > li:nth-child(1) > ul > li:nth-child(1) > div.song_area > div.song> a
	//#content > div:nth-child(2) > div > div > div > ul > li:nth-child(1) > ul > li:nth-child(2) > div.song_area > div.song > a
	//#content > div:nth-child(2) > div > div > div > ul > li:nth-child(2) > ul > li:nth-child(2) > div.song_area > div.song > a
	
	//#content > div:nth-child(2) > div > div > div > ul > li:nth-child(1) > ul > li:nth-child(1) > div.song_area > div.artist > span > span:nth-child(1) > span > a > span
	//#content > div:nth-child(2) > div > div > div > ul > li:nth-child(1) > ul > li:nth-child(2) > div.song_area > div.artist > span > span:nth-child(1) > span > a > span
	//#content > div:nth-child(2) > div > div > div > ul > li:nth-child(2) > ul > li:nth-child(2) > div.song_area > div.artist > span > span:nth-child(1) > span > a > span
	
	//xpath 복사 -->selector 보다 보기 편하다.
	//*[@id="content"]/div[1]/div/div/div/ul/li[1]/ul/li[1]/div[3]/div[1]/a
	}
}
