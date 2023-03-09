package definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class hooks {
    public static WebDriver driver;
    @Before
    public static void setUp(){
        /*
        ////Inicio - Evita cerrar seccion de los ajax////
        // Crea una instancia de ChromeOptions
        ChromeOptions options = new ChromeOptions();
        // Establece la estrategia de carga de la página en "none"
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        ////Fin - Evita cerrar seccion de los ajax////
    */
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public static void tearDown(){
        driver.manage().deleteAllCookies();
        driver.close();
        //driver.quit();
    }
}
