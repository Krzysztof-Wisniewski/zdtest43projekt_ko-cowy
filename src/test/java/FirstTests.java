import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FirstTests {

    WebDriver driver;
    WebDriverWait wait;

    public void highlightElement(WebElement element){
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js. executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }

    @Before //warunki poczatkowe testow
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        System.out.println("wykonuję się tutaj! przed metodą testową");
        wait = new WebDriverWait(driver, 10);
    }

//    @Test
//    public void orderSearchTesting(){
//        driver.get("https://dev.to");
//        WebElement searchBar = driver.findElement(By.xpath("//*[@id=\"header-search\"]/form/input[2]"));
//        searchBar.sendKeys("testing");
//        searchBar.sendKeys(Keys.RETURN);
//
//    }






    @Test
    public void selectFirstPodcast(){
        driver.get("https://dev.to");
        WebElement podcasts = driver.findElement(By.partialLinkText("Podcasts"));
        podcasts.click();
        wait.until(ExpectedConditions.urlToBe("https://dev.to/pod"));
        WebElement firstPodcast = driver.findElement(By.cssSelector(".content > h3:first-child"));
        String podcastTitleFromList = firstPodcast.getText();
        String firstPodcastFromListLink = driver.findElement(By.cssSelector("#substories > a:first-child")).getAttribute("href");
        firstPodcast.click();

        wait.until(ExpectedConditions.urlToBe(firstPodcastFromListLink));
        WebElement podcastTitle = driver.findElement(By.cssSelector(".title > h1:nth-child(2)"));
        String podcastTitleSite = podcastTitle.getText();
        System.out.println(podcastTitleFromList);
        System.out.println(podcastTitleSite);
        highlightElement(podcastTitle);
        assertTrue(podcastTitleFromList.contains(podcastTitleSite));

        WebElement record = driver.findElement(By.className("record"));
        record.click();
        WebElement initializing = driver.findElement(By.className("status-message"));
        wait.until(ExpectedConditions.invisibilityOf(initializing));
        WebElement recordWrapper = driver.findElement(By.className("record-wrapper"));
        String classAttribute = recordWrapper.getAttribute("class");
        Boolean isPodcastPlayed = classAttribute.contains("playing");
        assertTrue(isPodcastPlayed);
    }

//    @Test //kroki testowe - po prostu test do wykonania
//    public void firstTest(){
//        driver.get("https://dev.to"); //przejdź na stronę dev.to
//        WebElement sideBarVideo = driver.findElement(By.xpath("/html/body/div[9]/div/div/div[1]/aside/nav[1]/div/a[3]")); //znajdz element week
//        highlightElement(sideBarVideo);
//        //sideBarVideo.click(); //klikamy w weekBtn
//    }
//
    @Test
    public void openFirstVideoPage(){
        driver.get("https://dev.to");
        WebElement sideBarVideo = driver.findElement(By.partialLinkText("Videos"));
        highlightElement(sideBarVideo);
        sideBarVideo.click();
        //przechodzimy na strone z video
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlToBe("https://dev.to/videos"));
        WebElement firstVideo = driver.findElement(By.className("video-image"));
        highlightElement(firstVideo);
        firstVideo.click();
    }

//    @Test
//    public void highlightFirstVideo(){
//        driver.get("https://dev.to/videos");
//        WebElement firstVideo = driver.findElement(By.className("video-image"));
//        highlightElement(firstVideo);
//    }
//
//    @Test
//    public void openFirstPageWeek(){
//        driver.get("https://dev.to");
//        WebElement weekBtn = driver.findElement(By.cssSelector("#articles-list > header > nav > a:nth-child(2)"));
//        weekBtn.click();
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.urlToBe("https://dev.to/top/week"));
//        WebElement firstStory = driver.findElement(By.className("crayons-story__indention"));
//        highlightElement(firstStory);
//        firstStory.click();
//    }

//    @Test
//    public void firstTest(){
//        driver.get("https://dev.to");
//        WebElement weekBtn = driver.findElement(By.cssSelector("#articles-list > header > nav > a:nth-child(2)"));
//        weekBtn.click();
//    }

//    @Test
//    public void secondTest(){
//        driver.get("https://dev.to");
//        WebElement cssBtn = driver.findElement(By.cssSelector("#default-sidebar-element-css > a.crayons-link.crayons-link--block.py-2.px-2"));
//        cssBtn.click();
//    }

//    @Test
//    public void secondTest(){
//        System.out.println("drugi test");
//    }

//    @After
//    public void tearDown(){
//        driver.quit();
//    }
}