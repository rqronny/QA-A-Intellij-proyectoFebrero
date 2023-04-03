package pageobjects;

import definitions.hooks;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.util;

import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class padronPage extends util {

    @FindBy(name = "user_name") protected WebElement txtUsuario;
    @FindBy(name = "user_password") protected WebElement txtContrasena;
    @FindBy(id = "submit") protected WebElement btnIniciarSesion;
    @FindBy(name = "btnInterno") protected WebElement btnInterno;
    @FindBy(xpath = "//strong[contains(text(), '¡Exito!')]") protected WebElement msjExito;



    //@FindBy(xpath = "//*[@id='select2-id_graTit-container']") protected WebElement cmbGraTit;
   // @FindBy(id = "id_graTit") protected WebElement cmbGraTit;

    //@FindBy(xpath = "//*[@id='form_nueva_solicitud']/div[3]/span") protected WebElement cmbGraTit;
    @FindBy(xpath = "//*[@class='select2-search__field']") protected WebElement txtSearch;
    @FindBy(className = "select2-results__option--highlighted") protected WebElement optGraTit;
    @FindBy(id = "btn_guaCamSolInt") protected WebElement btnGuaCamSolInt;
    @FindBy(id = "buscador") protected WebElement txtBuscar;
    @FindBy(id = "btn_buscar") protected WebElement btnBuscar;
    @FindBy(id = "myTable") protected WebElement myTable;

    @FindBy(xpath = "//*[@title='Generar Padron']") protected WebElement lnkPorGenerar;
    @FindBy(xpath = "//*[@name='btn_regGraTit']") protected WebElement btnGenerarVistaPrevia;
    @FindBy(id = "btn_guaPad") protected WebElement btnGuardarPadron;
    @FindBy(id = "id_solReg") protected WebElement id_solReg;
    @FindBy(id = "pad_numDoc") protected WebElement dniEnPadron;
    @FindBy(id = "btn_busReg") protected WebElement btnBusReg;
    @FindBy(id = "btn_GenEnvExc") protected WebElement btnGenEnvExc;
    @FindBy(id = "buscador") protected WebElement txtBuscador;
    @FindBy(xpath = "//*/strong/div[contains(text(), 'Mostrando 1 al 1 de 1 registros')]") protected WebElement resBusSolPositivo;
    @FindBy(xpath = "//*/h4[contains(text(), 'Aviso!!!')]") protected WebElement resBusSolNegativo;

    @FindBy(id = "btn_nueRes") protected WebElement btnNueRes;
    @FindBy(id = "btn_regRes") protected WebElement btnRegRes;
    @FindBy(id = "res_fecha") protected WebElement txtResFec;
    @FindBy(id = "res_nombre") protected WebElement txtResNom;
    @FindBy(id = "Int_sol_numDoc") protected WebElement txtIntDNISol;
    public padronPage() {
        PageFactory.initElements(driver, this);
    }
    public void ingresarDatosEnLogin(String usuario, String contrasena){
        wait.until(ExpectedConditions.visibilityOf(txtUsuario));
        txtUsuario.sendKeys(usuario);
        txtContrasena.sendKeys(contrasena);
    }
    public void clickIniciarSesion(){
        wait.until(ExpectedConditions.elementToBeClickable(btnIniciarSesion));
        btnIniciarSesion.click();
    }

    public void clickBtnInterno(){
        wait.until(ExpectedConditions.elementToBeClickable(btnInterno));
        btnInterno.click();
    }

    public void seleccionarSelect2(String id_select){
        String selector="//*[@id='select2-"+id_select+"-container']";
        WebElement selectElement = driver.findElement(By.xpath(selector));
        wait.until(ExpectedConditions.visibilityOf(selectElement));
        selectElement.click();
    }
    public void seleccionarOpcion(String opcion){
        wait.until(ExpectedConditions.elementToBeClickable(txtSearch));
        txtSearch.sendKeys(opcion);
        wait.until(ExpectedConditions.elementToBeClickable(optGraTit));
        optGraTit.click();

    }

    public void seleccionarSelectTexto(String id_select, String texto){
        WebElement selectElement = driver.findElement(By.id(id_select));

        // Recupera todas las opciones del select
        List<WebElement> options = selectElement.findElements(By.tagName("option"));

        // Recorre todas las opciones y selecciona la que contiene la parte de texto que estás buscando
        String elementoEncontrado = null;

        for (WebElement option : options) {
            if (option.getText().contains(texto)) {
                option.click();
                elementoEncontrado="SI";
                break;
            }
        }
        Assert.assertEquals("SI",elementoEncontrado);
    }

    public void clickGuardarCambiosSolicitudInterna() {
        wait.until(ExpectedConditions.elementToBeClickable(btnGuaCamSolInt));
        wait.until(ExpectedConditions.textToBePresentInElementValue(txtIntDNISol, ""));
        btnGuaCamSolInt.click();
    }

    public void buscarSolicitud(String documento){
       // wait.until(ExpectedConditions.visibilityOf(msjExito));
        txtBuscar.sendKeys(documento);
    }

    public void clickBuscar() {
        btnBuscar.click();
    }

    public void clickGenerarPadron(){
        //wait.until(ExpectedConditions.visibilityOf(lnkPorGenerar));
        //lnkPorGenerar.click();


        wait.until(ExpectedConditions.visibilityOf(myTable));
        try {
            // Hacer clic en el botón
            lnkPorGenerar.click();
        } catch (StaleElementReferenceException e) {
            // Si se produce un error, buscar y obtener una nueva referencia al botón
            System.out.println("Se produjo un error StaleElement");
            lnkPorGenerar = driver.findElement(By.xpath("//*[@title='Generar Padron']"));
            lnkPorGenerar.click();
        }

    }


    public void escribirEnInput(String id_input, String texto){
        // Espera hasta que el elemento sea visible en la página web
        WebElement inputElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id_input)));


        //WebElement inputElement = driver.findElement(By.id(id_input));
        inputElement.sendKeys(texto);
    }
    public void esperarSolicitudAjax(){
        // espera a que se complete la solicitud Ajax y el DataTable se actualice
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dataTable = driver.findElement(By.id("myTable"));
        //wait.until(ExpectedConditions.attributeContains(dataTable, "class", "dataTables_processing"));
        //wait.until(ExpectedConditions.attributeToBe(dataTable, "class", "dataTable"));
    }
    public void clickGenerarVistaPrevia() {
        btnGenerarVistaPrevia.click();
    }
    public void esperarSegundos() throws InterruptedException {
        Thread.sleep(5000);
    }
    public void clickGuardarPadron() {
        wait.until(ExpectedConditions.visibilityOf(btnGuardarPadron));
        btnGuardarPadron.click();
    }

    public String obtenerIdSolReg(){
        wait.until(ExpectedConditions.visibilityOf(id_solReg));
        String id_solicitud2 = id_solReg.getText();
        return  id_solicitud2;
    }

    public void compararDniConPadron(String dni){
        wait.until(ExpectedConditions.visibilityOf(dniEnPadron));
        Assert.assertEquals(dniEnPadron.getAttribute("value"),dni);
    }
    public void clickBuscarRegistro(){
        wait.until(ExpectedConditions.visibilityOf(btnBusReg));
        btnBusReg.click();
    }
    public void clickGenerarExcel(){
        wait.until(ExpectedConditions.visibilityOf(btnGenEnvExc));
        btnGenEnvExc.click();
    }
    public boolean buscarResolucion(String numRes){
        wait.until(ExpectedConditions.visibilityOf(txtBuscador));
        txtBuscador.sendKeys(""+numRes+"");
        //WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(2));
        //wait2.until(ExpectedConditions.visibilityOf(resBusSolPositivo));
        // Validar si un elemento existe por xpath

        System.out.println("El texto recibido es :"+numRes);

        WebElement btnBusRes = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn_busRes")));
        btnBusRes.click();


        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(3));
        try {
            WebElement resultado = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*/strong/div[contains(text(), 'Mostrando 1 al 1 de 1 registros')]")));
            return true;
        } catch (TimeoutException e) {
            // Hacer algo si el botón no está presente después de 2 segundos
            return false;
        }

        //List<WebElement> elements = driver.findElements(By.xpath("//*/strong/div[contains(text(), 'Mostrando 1 al 1 de 1 registros')]"));
        //if (elements.size() > 0) {
            // El elemento existe
          //  return true;
        //} else {
            // El elemento no existe
          //  return false;
        //}
    }
    public void registrarResolucion(String res_fecha, String res_nombre){
        wait.until(ExpectedConditions.visibilityOf(btnNueRes));
        btnNueRes.click();

        wait.until(ExpectedConditions.visibilityOf(txtResFec));
        txtResFec.sendKeys(res_fecha);

        wait.until(ExpectedConditions.visibilityOf(txtResNom));
        txtResNom.sendKeys(res_nombre);

        wait.until(ExpectedConditions.visibilityOf(btnRegRes));
        btnRegRes.click();
        //wait.until(ExpectedConditions.visibilityOf(resBusSol));
        //txtBuscador.sendKeys(numRes);
    }

}
