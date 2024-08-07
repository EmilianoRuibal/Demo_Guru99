package pruebas;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilidades.DatosExcel;
import base.BaseTest;
import pagina.PaginaLogin;
import pagina.PaginaPrincipal;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

public class SSR1_inicioSesionExitoso extends BaseTest{
	String archivoDatos = "..\\Demo_Guru99\\Datos\\Datos_Login.xlsx";
	String directorioEvidencias = "..\\Demo_Guru99\\Evidencias\\";
	File screen;

	@Test(dataProvider="Datos Login Excel")
	public void iniciarSesion(String userID, String password) throws IOException {
		
		PaginaLogin login = new PaginaLogin(driver);
		login.escribirUsuer(userID);
		login.escribirPass(password);
		login.clickLogin();
		
		PaginaPrincipal msj = new PaginaPrincipal(driver);
		String msjEsperado = "Manger Id : " + userID;
		String msjObtenido = msj.mensajeObtenido();
		Assert.assertEquals(msjEsperado, msjObtenido);
		
		// Captura Pantalla #1
		String nombreArchivo = "Ventana Login-"+"U-"+userID+"-P-"+password+".jpg";
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(directorioEvidencias + nombreArchivo));
		
		// Obtener el WebElement del elemento a capturar
        WebElement elemento = msj.getElementoParaCapturar();
        // Utilizar AShot para capturar la sección del elemento
        Screenshot screenshot = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .takeScreenshot(driver, elemento);
        // Guardar la imagen capturada
        try {
    		nombreArchivo = "Mensaje Login-"+"U-"+userID+"-P-"+password+".jpg";
            ImageIO.write(screenshot.getImage(), "jpg", new File(directorioEvidencias + nombreArchivo));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
	}
	
	@DataProvider(name="Datos Login Excel")
	public Object[][] obtenerDatosExcel() throws Exception{
	    Object[][] datosCompletos = DatosExcel.leerExcel(archivoDatos, "Hoja1");
		  // Devuelve el primer par de datos (0)
	    if (datosCompletos.length > 0) {
	        return new Object[][] { datosCompletos[0] };
	    } else {
	        return new Object[][] {};
	    }
	}

}
