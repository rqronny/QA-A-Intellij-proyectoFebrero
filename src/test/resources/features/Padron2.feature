# language: es
@SegundaFuncionalidadPadron
Característica: Funcionalidad Padron
  @registroPadron2
  Esquema del escenario: Inicio de sesión exitoso
    Dado que estoy en la página de inicio de sesión
    Cuando ingreso mi nombre de usuario "admin" y mi contraseña "admin"
    Y hago clic en el botón Iniciar sesión
    Entonces se registra la solicitud "<RESO_NUM>" con fecha "<RESO_FEC>" si no existe
    Y debería ser redirigido a registrar solicitud
    Y se da click en el boton interno
    Y completar input "Int_sol_fecha" con el texto "<FEC_SOLICIT_GRAD_TIT>"
    Y se selecciona el select2 "id_graTit" con el texto "<DEN_GRAD>"
    Y se selecciona el select2 "id_modObt" con el texto "<MOD_OBT>"
    Y se selecciona el select2 "id_estu" con el texto "<DOCU_NUM>"
    Y se selecciona el select "id_docIdeTip" con texto "<DOCU_TIP>"
    Y se selecciona el select "modNueSolInt_id_sexo" con texto "<SEXO>"
    Y se da click en el boton guardar cambios de la solicitud interna
    Y se obtiene el id de la solicitud registrada y se redirecciona a verlo
    Y se selecciona el select2 "id_autTit1" con el texto "<AUTORIDAD1>"
    Y se selecciona el select2 "id_autTit2" con el texto "<AUTORIDAD2>"
    Y se selecciona el select2 "id_autTit3" con el texto "<AUTORIDAD3>"

    Y se selecciona el select "pad_proAcr" con texto "<PROG_ACREDIT>"
    Y se selecciona el select2 "id_proEst" con el texto "<PROG_ESTU>"
    Y se selecciona el select2 "id_resolucion" con el texto "<RESO_NUM>"
    Y completar input "pad_fecSusAprGraTit" con el texto "<FEC_TRAB_GRAD_TIT>"

    Y completar input "pad_codDip" con el texto "<DIPL_NUM>"
    Y se selecciona el select "pad_tipEmiDip" con texto "<DIPL_TIP_EMI>"
    Y completar input "pad_fecDipOri" con el texto "<DIPL_FEC_ORG>"

    Y completar input "pad_regLib" con el texto "<REG_LIBRO>"
    Y completar input "pad_regFol" con el texto "<REG_FOLIO>"
    Y completar input "pad_regReg" con el texto "<REG_REGISTRO>"
    Y completar input "pad_regOfi" con el texto "<REG_OFICIO>"
    Y verificar que el padron corresponda al usuario "<DOCU_NUM>"
    Y click en generar vista previa
 # Y esperar segundos
    Y dar click en guardar padron

    Ejemplos: Tabla de cantidades
      |CODUNIV|RAZ_SOC|MATRI_FEC|FAC_NOM|CARR_PROG|ESC_POS|EGRES_FEC|APEPAT|APEMAT|NOMBRE|SEXO|DOCU_TIP|DOCU_NUM|PROC_BACH|GRAD_TITU|DEN_GRAD|SEG_ESP|TRAB_INV|NUM_CRED|REG_METADATO|PROG_ESTU|PROC_TITULO_PED|MOD_OBT|PROG_ACREDIT|FEC_INICIO_ACREDIT|FEC_FIN_ACREDIT|FEC_INICIO_MOD_TIT_ACREDIT|FEC_FIN_MOD_TIT_ACREDIT|FEC_SOLICIT_GRAD_TIT|FEC_TRAB_GRAD_TIT|TRAB_INVEST_ORIGINAL|MOD_EST|ABRE_GYT|PROC_REV_PAIS|PROC_REV_UNIV|PROC_REV_GRADO|CRIT_REV|RESO_NUM|RESO_FEC|DIPL_FEC_ORG|DIPL_FEC_DUP|DIPL_NUM|DIPL_TIP_EMI|REG_LIBRO|REG_FOLIO|REG_REGISTRO|CARGO1|AUTORIDAD1|CARGO2|AUTORIDAD2|CARGO3|AUTORIDAD3|PROC_PAIS_EXT|PROC_UNIV_EXT|PROC_GRADO_EXT|REG_OFICIO|FEC_MAT_PROG|FEC_INICIO_PROG|FEC_FIN_PROG|MOD_SUSTENTACION|
      |122|UNIVERSIDAD NACIONAL DE  CAÑETE |22/04/2014|CIENCIAS EMPRESARIALES |ADMINISTRACIÓN DE TURISMO Y HOTELERÍA ||29/02/2020|GERONIMO|BERROCAL|EDITH ALESSANDRA|F|1|72671666||BACHILLER |BACHILLER EN ADMINISTRACIÓN DE TURISMO Y HOTELERÍA |||216||CICLO REGULAR ||AUTOMÁTICO |NO|||||6/08/2020|27/10/2020||P|B|||||RCO 135-2020-UNDC|27/11/2020|27/11/2020||UNDC0000303|O|003-EPDATH|011-EPDTH|032|PRESIDENTE |CARLOS EDUARDO VILLANUEVA AGUILAR |SECRETARIO GENERAL |ABAD OSNAYO VILLALTA |VICEPRESIDENTE ACADÉMICO|JOSE OCTAVIO RUIZ TEJADA||||003-2021-UNDC/CO-P-SG|||||




@GenerarExcel
    Escenario: Generar excel
      Dado que estoy en la página de inicio de sesión
      Cuando ingreso mi nombre de usuario "admin" y mi contraseña "admin"
      Y hago clic en el botón Iniciar sesión
      Entonces redirigirse a enviar padron
      Y dar click en buscar
      Y verificar que cargue el formulario de generacion de excel
      Y completar input "pad_nomArcExc" con el texto "nombre del excel"
      Y se selecciona el select "pad_forExc" con texto "FORMATO-1"
      Y dar click en generar excel