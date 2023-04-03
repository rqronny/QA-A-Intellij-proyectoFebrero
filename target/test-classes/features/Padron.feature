# language: es
@primeraFuncionalidadPadron
Característica: Funcionalidad Padron
@registroPadron
  Esquema del escenario: Inicio de sesión exitoso
    Dado que estoy en la página de inicio de sesión
    Cuando ingreso mi nombre de usuario "admin" y mi contraseña "admin"
    Y hago clic en el botón Iniciar sesión
    Entonces se registra la solicitud "<RESO_NUM>" con fecha "<RESO_FEC>" si no existe
    Y debería ser redirigido a registrar solicitud
    Y se da click en el boton interno
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

  Y se selecciona el select2 "id_proEst" con el texto "<PROG_ESTU>"
  Y se selecciona el select2 "id_resolucion" con el texto "<RESO_NUM>"

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
    |CODUNIV|RAZ_SOC|MATRI_FEC|FAC_NOM|CARR_PROG|ESC_POS|EGRES_FEC|APEPAT|APEMAT|NOMBRE|SEXO|DOCU_TIP|DOCU_NUM|PROC_BACH|GRAD_TITU|DEN_GRAD|SEG_ESP|TRAB_INV|NUM_CRED|REG_METADATO|PROG_ESTU|PROC_TITULO_PED|MOD_OBT|MOD_EST|ABRE_GYT|PROC_REV_PAIS|PROC_REV_UNIV|PROC_REV_GRADO|RESO_NUM|RESO_FEC|DIPL_FEC_ORG|DIPL_FEC_DUP|DIPL_NUM|DIPL_TIP_EMI|REG_LIBRO|REG_FOLIO|REG_REGISTRO|CARGO1|AUTORIDAD1|CARGO2|AUTORIDAD2|CARGO3|AUTORIDAD3|PROC_PAIS_EXT|PROC_UNIV_EXT|PROC_GRADO_EXT|REG_OFICIO|FEC_MAT_PROG|FEC_INICIO_PROG|FEC_FIN_PROG|
    |122|UNIVERSIDAD NACIONAL DE  CAÑETE |27/03/2015|INGENIERÍA |INGENIERÍA DE SISTEMAS||10/01/2020|SOLIS |ROJAS|CHRISTIAN JAVIER|M|1|75205269||BACHILLER |BACHILLER EN INGENIERÍA DE SISTEMAS|||217||CICLO REGULAR ||AUTOMÁTICO |P|B||||RCO 097-2020-UNDC|03/09/2020|03/09/2020||UNDC 0000261|O|004-EPDIS|015-EPDIS|045|PRESIDENTE |CARLOS EDUARDO VILLANUEVA AGUILAR |SECRETARIO GENERAL |ABAD OSNAYO VILLALTA |VICEPRESIDENTE ACADÉMICO|JOSE OCTAVIO RUIZ TEJADA||||117-2020-UNDC/CO-P-SG||||



