# language: es
@SegundaFuncionalidadPadron
Característica: Funcionalidad Padron
  @registroPadron2
  Esquema del escenario: Inicio de sesión exitoso
    Dado que estoy en la página de inicio de sesión
    Cuando ingreso mi nombre de usuario "admin" y mi contraseña "admin"
    Y hago clic en el botón Iniciar sesión
    Entonces debería ser redirigido a registrar solicitud
    Y se da click en el boton interno
    Y se selecciona el select2 "id_graTit" con el texto "<DEN_GRAD>"
    Y se selecciona el select2 "id_proTit" con el texto "<CARR_PROG>"
    Y se selecciona el select2 "id_estu" con el texto "<DOCU_NUM>"
    Y se selecciona el select "id_docIdeTip" con texto "<DOCU_TIP>"
    Y se selecciona el select "modNueSolExt_id_sexo" con texto "<SEXO>"
    Y se da click en el boton guardar cambios de la solicitud interna
    Y se obtiene el id de la solicitud registrada y se redirecciona a verlo
    Y se selecciona el select "id_autTit1" con texto "<AUTORIDAD1>"
    Y se selecciona el select "id_autTit2" con texto "<AUTORIDAD2>"
    Y se selecciona el select "id_autTit3" con texto "<AUTORIDAD3>"

    Y se selecciona el select "id_proEst" con texto "<PROG_ESTU>"
    Y se selecciona el select "id_modObt" con texto "<MOD_OBT>"
    Y se selecciona el select "id_resolucion" con texto "<RESO_NUM>"

    Y completar input "pad_codDip" con el texto "<DIPL_NUM>"
    Y se selecciona el select "pad_tipEmiDip" con texto "<DIPL_TIP_EMI>"
    Y completar input "pad_fecDipOri" con el texto "<DIPL_FEC_ORG>"

    Y se selecciona el select "id_escuela" con texto "<CARR_PROG>"

    Y completar input "pad_regLib" con el texto "<REG_LIBRO>"
    Y completar input "pad_regFol" con el texto "<REG_FOLIO>"
    Y completar input "pad_regReg" con el texto "<REG_REGISTRO>"
    Y completar input "pad_regOfi" con el texto "<REG_OFICIO>"
    Y verificar que el padron corresponda al usuario "<DOCU_NUM>"
    Y click en generar vista previa
 # Y esperar segundos
    Y dar click en guardar padron

    Ejemplos: Tabla de cantidades
      |CODUNIV|RAZ_SOC|MATRI_FEC|FAC_NOM|CARR_PROG|ESC_POS|EGRES_FEC|APEPAT|APEMAT|NOMBRE|SEXO|DOCU_TIP|DOCU_NUM|PROC_BACH|GRAD_TITU|DEN_GRAD|SEG_ESP|TRAB_INV|NUM_CRED|REG_METADATO|PROG_ESTU|PROC_TITULO_PED|MOD_OBT|MOD_EST|ABRE_GYT|PROC_REV_PAIS|PROC_REV_UNIV|PROC_REV_GRADO|RESO_NUM|RESO_FEC|DIPL_FEC_ORG|DIPL_FEC_DUP|DIPL_NUM|DIPL_TIP_EMI|REG_LIBRO|REG_FOLIO|REG_REGISTRO|CARGO1|AUTORIDAD1|CARGO2|AUTORIDAD2|CARGO3|AUTORIDAD3|PROC_PAIS_EXT|PROC_UNIV_EXT|PROC_GRADO_EXT|REG_OFICIO|FEC_MAT_PROG|FEC_INICIO_PROG|FEC_FIN_PROG||
      |122|UNIVERSIDAD NACIONAL DE  CAÑETE |21/04/2014| CIENCIAS AGRARIAS|AGRONOMÍA ||04/01/2019|ESPINOZA |ASTORAYME |JOSE MARIA |M|1|77326961||BACHILLER |BACHILLER EN CIENCIAS AGRARIAS |||220||CICLO REGULAR ||AUTOMÁTICO |P|B||||RCO 070-2019-UNDC|13/05/2019|26/06/2019||UNDC0000001|O|005-EPDAG|N° 001-EPDA|001|PRESIDENTE |CARLOS EDUARDO VILLANUEVA AGUILAR |SECRETARIO GENERAL |ABAD OSNAYO VILLALTA |VICEPRESIDENTE ACADÉMICO|JOSE OCTAVIO RUIZ TEJADA||||077-2019-UNDC/CO-P-SG|||||
      |122|UNIVERSIDAD NACIONAL DE  CAÑETE |22/04/2014| CIENCIAS AGRARIAS|AGRONOMÍA ||04/01/2019|DOLORES |FLORES|HENRY ALBIO|M|1|70789818||BACHILLER |BACHILLER EN CIENCIAS AGRARIAS |||220||CICLO REGULAR ||AUTOMÁTICO |P|B||||RCO 070-2019-UNDC|13/05/2019|26/06/2019||UNDC0000002|O|005-EPDAG|N° 001-EPDA|002|PRESIDENTE |CARLOS EDUARDO VILLANUEVA AGUILAR |SECRETARIO GENERAL |ABAD OSNAYO VILLALTA |VICEPRESIDENTE ACADÉMICO|JOSE OCTAVIO RUIZ TEJADA||||077-2019-UNDC/CO-P-SG|||||

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