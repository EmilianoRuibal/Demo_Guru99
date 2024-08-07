package base;

import org.testng.annotations.AfterMethod;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    // Declaración de todas las variables
    public static Properties prop;
    public static InputStream fileInputStream;

    public static WebDriver driver;

    @BeforeMethod
    public void setup() {
        // Este método se ejecutará antes de cada método de prueba anotado con @Test
    	// Cargar propiedades desde el archivo config.properties
        prop = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("..\\Demo_Guru100\\src\\main\\resources\\config\\config.properties");
            prop.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String browser = prop.getProperty("browser");
        String url = prop.getProperty("url");

        // Selección del navegador basado en la propiedad "browser"
        switch (browser.toLowerCase()) {
	        case "chrome":
	            driver = new ChromeDriver();
	            break;
	        case "firefox":
	            driver = new FirefoxDriver();
	            break;
	        case "edge":
	            driver = new EdgeDriver();
	            break;
	        case "safari":
	            driver = new SafariDriver();
	            break;
            default:
                throw new IllegalArgumentException("Navegador no soportado: " + browser);
        }
        Reporter.log("======Launch Browser======", true);
        
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(url);
    }

	@AfterMethod
    public void tearDown() {
        // Este método se ejecutará después de cada método de prueba anotado con @Test
		driver.quit();
        Reporter.log("======Navegador Cerrado======", true);
    }

}
