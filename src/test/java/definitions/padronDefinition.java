package definitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.openqa.selenium.Cookie;
import pageobjects.padronPage;

import java.util.Date;
import java.util.Set;

public class padronDefinition {
    padronPage padron;

    public padronDefinition() {
        padron = new padronPage();
    }


    @Dado("que estoy en la página de inicio de sesión")
    public void queEstoyEnLaPaginaDeInicioDeSesion() {

        hooks.driver.get("http://localhost/sigrati-v2/adm/");

    }

    @Cuando("ingreso mi nombre de usuario {string} y mi contraseña {string}")
    public void ingresoMiNombreDeUsuarioYMiContrasena(String usuario, String contrasena) {
        padron.ingresarDatosEnLogin(usuario,contrasena);
    }

    @Y("hago clic en el botón Iniciar sesión")
    public void hagoClicEnElBotonIniciarSesion() {
        padron.clickIniciarSesion();
        // Crear una cookie con nombre, valor y dominio especificados
        Cookie cookie = new Cookie("PHPSESSID", "15p0e6tbonjk3789tnmplunebk", "http://localhost/sigrati-v2/adm/", "/", null, false, true);

// Establecer la fecha de expiración de la cookie en 7 días a partir de ahora
        Date expiry = new Date();
        expiry.setTime(expiry.getTime() + (7 * 24 * 60 * 60 * 1000));
        cookie.getExpiry();

// Agregar la cookie al navegador
        hooks.driver.manage().getCookies();
    }

    @Y("debería ser redirigido a registrar solicitud")
    public void deberiaSerRedirigidoARegistrarSolicitud() {
        hooks.driver.navigate().to("http://localhost/sigrati-v2/adm/viewSolicitud.php");
    }

    @Y("se da click en el boton interno")
    public void seDaClickEnElBotonInterno() {
    padron.clickBtnInterno();

    }

    @Y("se selecciona el select2 {string} con el texto {string}")
    public void seCompletaElCampo(String id_select, String opcion) {
        padron.seleccionarSelect2(id_select);
        padron.seleccionarOpcion(opcion);
    }

    @Y("se selecciona el select {string} con texto {string}")
    public void seCompletaElSelectConTexto(String id_select, String texto) {
        padron.seleccionarSelectTexto(id_select, texto);
    }

    @Y("se da click en el boton guardar cambios de la solicitud interna")
    public void seDaClickEnElBotonGuardarCambiosDeLaSolicitudInterna() {
        padron.clickGuardarCambiosSolicitudInterna();
    }

    @Y("se busca la solicitud generada con el numero de documento {string}")
    public void seBuscaLaSolicitudGeneradaConElNumeroDeDocumento(String numeroDocumento) {
        padron.buscarSolicitud(numeroDocumento);
    }

    @Y("se da click en el boton buscar para encontrar la solicitud generada")
    public void seDaClickEnElBotonBuscarParaEncontrarLaSolicitudGenerada() {
        padron.clickBuscar();
    }

    @Y("se da click en el boton generar padron")
    public void seDaClickEnElBotonGenerarPadron() {
        padron.clickGenerarPadron();
    }

    @Y("completar input {string} con el texto {string}")
    public void completarInputConElTexto(String id_input, String texto) {
        padron.escribirEnInput(id_input,texto);
    }
    @Y("se espera solicitud")
    public void seEsperaSolicitud() {
        padron.esperarSolicitudAjax();
    }

    @Y("click en generar vista previa")
    public void clickEnGenerarVistaPrevia() {
        padron.clickGenerarVistaPrevia();
    }


    @Y("esperar segundos")
    public void esperarSegundos() throws InterruptedException {
        padron.esperarSegundos();
    }


    @Y("dar click en guardar padron")
    public void darClickEnGuardarPadron() {
        padron.clickGuardarPadron();
    }

    @Y("se obtiene el id de la solicitud registrada y se redirecciona a verlo")
    public void seObtieneElIdDeLaSolicitudRegistradaYSeRedireccionaAVerlo() {
        String id_soliditudRegistrado = padron.obtenerIdSolReg();
        String linkSolicitud="http://localhost/sigrati-v2/adm/viewPadron.php?id="+id_soliditudRegistrado;
        hooks.driver.navigate().to(linkSolicitud);
    }

    @Y("verificar que el padron corresponda al usuario {string}")
    public void verificarQueElPadronCorrespondaAlUsuario(String dni) {
        padron.compararDniConPadron(dni);
    }

    @Y("redirigirse a enviar padron")
    public void redirigirseAEnviarPadron() {
        hooks.driver.navigate().to("http://localhost/sigrati-v2/adm/viewEnviarSunedu.php");
    }

    @Y("dar click en buscar")
    public void darClickEnBuscar() {
        padron.clickBuscarRegistro();
    }


    @Y("dar click en generar excel")
    public void darClickEnGenerarExcel() {
        padron.clickGenerarExcel();
    }


    @Entonces("se registra la solicitud {string} con fecha {string} si no existe")
    public void seRegistraLaSolicitudConFechaSiNoExiste(String numRes, String fecRes) {
        hooks.driver.navigate().to("http://localhost/sigrati-v2/adm/viewResoluciones.php");

    }
}
