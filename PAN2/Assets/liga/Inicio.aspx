

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1"><title>
	Sistema de Recursos Humanos
</title><link href="Style/BodyPanel.css" rel="stylesheet" type="text/css" /><link href="Style/PanelUsuario.css" rel="stylesheet" type="text/css" />
    <script src="Scripts/Display.js" type="text/javascript"></script>
        
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/alert-main.js"></script>
    <link rel="stylesheet" href="css/alert-style.css" type="text/css" media="screen" /> 

    <style type="text/css">
        #main div.titular
        {
            color: #FFFFFF;
            font-size: 14px;
            font-weight: bold;
            background-color: #AAC3DD;
            padding-top: 3px;
            padding-bottom: 3px;
            width: auto;
            text-indent: 10px;
            margin-left: 0px;
            margin-right: 0px;
            z-index: 0;
        }
        
        #main table
        {
            font-size: 11px;
            width: 100%;
        }
        
        #main table.data
        {
            font-size: 9px;
            color: #003366;
            width: 98%;
            margin-top: 6px;
            margin-right: auto;
            margin-bottom: 10px;
            margin-left: auto;
            text-transform: uppercase;
        }
        
        .titulo-azul-mensaje-error
        {
            font-family: Arial;
            font-size: 16px;
            font-weight: bold;
            color: #003366;
        }
        
        .boton
        {
	        background-color:#135392;
	        padding:2px;
	        width:100px;
	
	        -webkit-border-radius: 5px;
	        border-radius: 5px;
	        color:#fff;
	        font:16px/30px "Trebuchet MS", Arial, Helvetica, sans-serif;
        }
        
        .boton:hover
        {	
	        background-color:#E08C37;
	        -webkit-border-radius: 5px;
	        border-radius: 5px;
	        color:#fff;
	        font:16px/30px "Trebuchet MS", Arial, Helvetica, sans-serif;
	        cursor:pointer;	
        }
        
    </style>
    
    <script type="text/javascript">

        function CloseCallback() {
            window.location = window.document.URL;
        }

        function ShowDiv(Tipo) {
            switch (Tipo) {
                case '1':
                    document.getElementById('tdProcessData').style.display = 'none';
                    document.getElementById('tdSesionEXP').style.display = 'none';
                    document.getElementById('dvIninicioGral').style.display = 'block';
                    break;

                case '2':
                    document.getElementById('dvIninicioGral').style.display = 'none';
                    document.getElementById('tdSesionEXP').style.display = 'none';
                    document.getElementById('tdProcessData').style.display = 'block';
                    break;

                case '3':
                    document.getElementById('dvIninicioGral').style.display = 'none';
                    document.getElementById('tdProcessData').style.display = 'none';
                    document.getElementById('tdSesionEXP').style.display = 'block';
                    break;

                case '4':
                    document.getElementById('PanelUsuario').style.display = 'none';
                    document.getElementById('dvMenu').style.display = 'none';
                    document.getElementById('dvRptBotones').style.display = 'none';
                    document.getElementById('foot').style.display = 'none';
                    document.getElementById('linkImprime').style.display = 'none';
                    document.getElementById('top').style.display = 'none';
                    break;

                case '5':
                    document.getElementById('PanelUsuario').style.display = 'block';
                    document.getElementById('dvMenu').style.display = 'block';
                    document.getElementById('dvRptBotones').style.display = 'block';
                    document.getElementById('foot').style.display = 'block';
                    document.getElementById('linkImprime').style.display = 'block';
                    document.getElementById('top').style.display = 'block';
                    break;
            }
        }

        function mischandler() {
            return false;
        }

        document.oncontextmenu = mischandler;

        // backspace, ALT + 1, ALT + 2
        window.history.forward(window.history.length + 1);
                  
</script>
<style type="text/css">
	.mnuMainSRH_0 { background-color:white;visibility:hidden;display:none;position:absolute;left:0px;top:0px; }
	.mnuMainSRH_1 { color:White;font-family:font: 67.5% 'Lucida Sans Unicode','Bitstream Vera Sans','Trebuchet Unicode MS','Lucida Grande','Verdana','Helvetica','sans-serif';font-size:14px;font-weight:normal;text-decoration:none; }
	.mnuMainSRH_2 { color:White;font-family:font: 67.5% 'Lucida Sans Unicode','Bitstream Vera Sans','Trebuchet Unicode MS','Lucida Grande','Verdana','Helvetica','sans-serif';font-size:14px;font-weight:normal; }
	.mnuMainSRH_3 {  }
	.mnuMainSRH_4 { background-color:#264475;padding:10px 10px 10px 10px; }
	.mnuMainSRH_5 {  }
	.mnuMainSRH_6 { background-color:#264475;padding:5px 5px 5px 5px; }
	.mnuMainSRH_7 {  }
	.mnuMainSRH_8 { background-color:#E08C37; }
	.mnuMainSRH_9 {  }
	.mnuMainSRH_10 { background-color:#E08C37; }

</style></head>
<body>
    <form name="form1" method="post" action="Inicio.aspx" id="form1">
<div>
<input type="hidden" name="ScriptManager1_HiddenField" id="ScriptManager1_HiddenField" value="" />
<input type="hidden" name="__EVENTTARGET" id="__EVENTTARGET" value="" />
<input type="hidden" name="__EVENTARGUMENT" id="__EVENTARGUMENT" value="" />
<input type="hidden" name="__VIEWSTATE" id="__VIEWSTATE" value="/wEPDwUKMTA1MTM1NTY0NQ9kFgICAw9kFgICCw9kFgJmD2QWAgIBD2QWTmYPZBYCZg8VAQRBbHRhZAIBD2QWAmYPFQEEQmFqYWQCAg9kFgJmDxUBCExpY2VuY2lhZAIDD2QWAmYPFQEQQWp1c3RlIGRlIHN1ZWxkb2QCBA9kFgJmDxUBDU1vZGlmaWNhY2nDs25kAgUPZBYCZg8VAQVBbnVhbGQCBg9kFgJmDxUBD1JlY29udHJhdGFjacOzbmQCBw9kFgJmDxUBCEZvcm1hdG9zZAIID2QWAmYPFQEHRXZlbnRvc2QCCQ9kFgJmDxUBEERhdG9zIHBlcnNvbmFsZXNkAgoPZBYCZg8VAQ1EYXRvcyBlbXByZXNhZAILD2QWAmYPFQEUUGVuc2nDs24gYWxpbWVudGljaWFkAgwPZBYCZg8VARBBcG95byBhIGVzdHVkaW9zZAIND2QWAmYPFQEOQ29tcGVuc2FjaW9uZXNkAg4PZBYCZg8VAQ5EYXRvcyBtw6lkaWNvc2QCDw9kFgJmDxUBD0dhc3RvcyBtw6lkaWNvc2QCEA9kFgJmDxUBBU51ZXZvZAIRD2QWAmYPFQEJTW9kaWZpY2FyZAISD2QWAmYPFQEKRmFtaWxpYXJlc2QCEw9kFgJmDxUBC0VzY29sYXJpZGFkZAIUD2QWAmYPFQEFTnVldmFkAhUPZBYCZg8VAQlNb2RpZmljYXJkAhYPZBYCZg8VARVQcmVtaW8gZGUgUHVudHVhbGlkYWRkAhcPZBYCZg8VAQlBZ3VpbmFsZG9kAhgPZBYCZg8VARBQcmltYSBWYWNhY2lvbmFsZAIZD2QWAmYPFQEIUmV0YXJkb3NkAhoPZBYCZg8VARBBcG95byBhIGVzdHVkaW9zZAIbD2QWAmYPFQELQ3VtcGxlYcOxb3NkAhwPZBYCZg8VAQdHZW5lcmFsZAIdD2QWAmYPFQEIUGVyc29uYWxkAh4PZBYCZg8VAQZTdWVsZG9kAh8PZBYCZg8VAQpJbmNpZGVuY2lhZAIgD2QWAmYPFQEJSGlzdG9yaWFsZAIhD2QWAmYPFQEMRXN0YWTDrXN0aWNvZAIiD2QWAmYPFQELQ29uY2VudHJhZG9kAiMPZBYCZg8VARBFc3RhdHVzIGVtcGxlYWRvZAIkD2QWAmYPFQEMUHJlc3RhY2lvbmVzZAIlD2QWAmYPFQETRGlyZWN0b3JpbyBkZSBmb3Rvc2QCJg9kFgJmDxUBB0NvcnJlb3NkZMVgJJ9dJ/iwu/b1Bi28a9y/PDq2" />
</div>

<script type="text/javascript">
//<![CDATA[
var theForm = document.forms['form1'];
if (!theForm) {
    theForm = document.form1;
}
function __doPostBack(eventTarget, eventArgument) {
    if (!theForm.onsubmit || (theForm.onsubmit() != false)) {
        theForm.__EVENTTARGET.value = eventTarget;
        theForm.__EVENTARGUMENT.value = eventArgument;
        theForm.submit();
    }
}
//]]>
</script>


<script src="/SistemaRH/WebResource.axd?d=Rda_Tirv7oRvOy953ciLNHxbM_hK50Ov_e9A-RkugYN1FzV1McUk5cSrTsuZ71se7FMRqJtghWp0kn5Nu2ssUP5bMdE1&amp;t=635082980141708196" type="text/javascript"></script>


<script src="/SistemaRH/ScriptResource.axd?d=CTqgbxm_NrbFV2dtSofppQUaSQm1DJosAZiNfaTkILoyXSSNpPytQrSZ0lXL9IwA93ptEZrqLr0XeZRoV8ydHCaQKjLv5Ri68x7br88Cwa_mCM0_lvNjGOHr-X8T-g8tachu3w2&amp;t=ffffffff8b7a3bbf" type="text/javascript"></script>
<script type="text/javascript">
//<![CDATA[
var __cultureInfo = '{"name":"es-MX","numberFormat":{"CurrencyDecimalDigits":2,"CurrencyDecimalSeparator":".","IsReadOnly":true,"CurrencyGroupSizes":[3],"NumberGroupSizes":[3],"PercentGroupSizes":[3],"CurrencyGroupSeparator":",","CurrencySymbol":"$","NaNSymbol":"NeuN","CurrencyNegativePattern":1,"NumberNegativePattern":1,"PercentPositivePattern":0,"PercentNegativePattern":0,"NegativeInfinitySymbol":"-Infinito","NegativeSign":"-","NumberDecimalDigits":2,"NumberDecimalSeparator":".","NumberGroupSeparator":",","CurrencyPositivePattern":0,"PositiveInfinitySymbol":"Infinito","PositiveSign":"+","PercentDecimalDigits":2,"PercentDecimalSeparator":".","PercentGroupSeparator":",","PercentSymbol":"%","PerMilleSymbol":"‰","NativeDigits":["0","1","2","3","4","5","6","7","8","9"],"DigitSubstitution":1},"dateTimeFormat":{"AMDesignator":"a.m.","Calendar":{"MinSupportedDateTime":"\/Date(-62135575200000)\/","MaxSupportedDateTime":"\/Date(253402300799999)\/","AlgorithmType":1,"CalendarType":1,"Eras":[1],"TwoDigitYearMax":2029,"IsReadOnly":true},"DateSeparator":"/","FirstDayOfWeek":0,"CalendarWeekRule":0,"FullDateTimePattern":"dddd, dd\u0027 de \u0027MMMM\u0027 de \u0027yyyy hh:mm:ss tt","LongDatePattern":"dddd, dd\u0027 de \u0027MMMM\u0027 de \u0027yyyy","LongTimePattern":"hh:mm:ss tt","MonthDayPattern":"dd MMMM","PMDesignator":"p.m.","RFC1123Pattern":"ddd, dd MMM yyyy HH\u0027:\u0027mm\u0027:\u0027ss \u0027GMT\u0027","ShortDatePattern":"dd/MM/yyyy","ShortTimePattern":"hh:mm tt","SortableDateTimePattern":"yyyy\u0027-\u0027MM\u0027-\u0027dd\u0027T\u0027HH\u0027:\u0027mm\u0027:\u0027ss","TimeSeparator":":","UniversalSortableDateTimePattern":"yyyy\u0027-\u0027MM\u0027-\u0027dd HH\u0027:\u0027mm\u0027:\u0027ss\u0027Z\u0027","YearMonthPattern":"MMMM\u0027 de \u0027yyyy","AbbreviatedDayNames":["dom","lun","mar","mié","jue","vie","sáb"],"ShortestDayNames":["do","lu","ma","mi","ju","vi","sá"],"DayNames":["domingo","lunes","martes","miércoles","jueves","viernes","sábado"],"AbbreviatedMonthNames":["ene","feb","mar","abr","may","jun","jul","ago","sep","oct","nov","dic",""],"MonthNames":["enero","febrero","marzo","abril","mayo","junio","julio","agosto","septiembre","octubre","noviembre","diciembre",""],"IsReadOnly":true,"NativeCalendarName":"calendario gregoriano","AbbreviatedMonthGenitiveNames":["ene","feb","mar","abr","may","jun","jul","ago","sep","oct","nov","dic",""],"MonthGenitiveNames":["enero","febrero","marzo","abril","mayo","junio","julio","agosto","septiembre","octubre","noviembre","diciembre",""]}}';//]]>
</script>

<script src="/SistemaRH/ScriptResource.axd?d=4KqGeUSPPE0OaO6RrPRcv137ZP-AK2EJrBb2q5pHO56pTn7v4L2F6lhemGIofnHWLriKcOb-7Q0JpYV8iODRrSBndHqYb-gB_eNCxX2qLEf31g4QqbqUqXIiV89ZhiaAUokqZDtE5rLksjZJwYGV-wpsitqMxwp_mn9XHtuA_OJccANQ0&amp;t=2e2045e2" type="text/javascript"></script>
<script type="text/javascript">
//<![CDATA[
if (typeof(Sys) === 'undefined') throw new Error('Error al cargar el marco de trabajo de cliente ASP.NET Ajax.');
//]]>
</script>

<script src="/SistemaRH/ScriptResource.axd?d=d4aFRODjbuIKg6F5OJPX3FMUcu4l3caS7Hr4t-bk5iAFXlzLDlvtrFU5F5tbbn4RdA57Y2iG1K5rgLkMefHuay_wOCiG5t6JrzM3YZxtAVAmf_LXVrwiJZiSisblv0GswTYXDehWzv2tPf-0JRvwJjRnsdGlOCWUBlATV4VyJ615Xs520&amp;t=2e2045e2" type="text/javascript"></script>
<div>

	<input type="hidden" name="__SCROLLPOSITIONX" id="__SCROLLPOSITIONX" value="0" />
	<input type="hidden" name="__SCROLLPOSITIONY" id="__SCROLLPOSITIONY" value="0" />
	<input type="hidden" name="__PREVIOUSPAGE" id="__PREVIOUSPAGE" value="HKOY3kSd5-5SmJmwl3lPVGjROru6NxpcXCzzw_Ig_GAMXEVaPuBOyQLtLSzuU1MiiD36eWHR_JOnI8vbzetWQkMbuBE1" />
	<input type="hidden" name="__EVENTVALIDATION" id="__EVENTVALIDATION" value="/wEWJwL2t/6+DwKwgvmDDALFvfbvCgKU+tyvCAKU+tivCAKG3q7TAwLg1t9SAobeqtMDAvT45aoGAvT42fICAqHRrO0IArCz4qYJArm9iY0MAvrdufAFAt+kxI0PAsannpQDAsankpQDAsanlpQDAr/jmpMLArzjmpMLAvDG8p0DAp/40IAJAof/k8cDAqKQ5asLAqKQneINAqKQ0dQDAqKQ8a0IAvSixb0LAvSigcsGAvSi/fcNAvSi2doNAof/v/8HAof/q5gOAof/t9ADAof/o/0KApaj8tkEAtPDrs0NAv70jLACArursYYIsyeDz8JP81Rizs8Y4kErQDi9ifI=" />
</div>

    <script type="text/javascript">
//<![CDATA[
Sys.WebForms.PageRequestManager._initialize('ScriptManager1', document.getElementById('form1'));
Sys.WebForms.PageRequestManager.getInstance()._updateControls(['tupdimgFotoPerfil','tupdRHMenuPrincipal','tUpdatePanel188'], [], [], 90);
//]]>
</script>

 
    <div id="main">
        <div id="top" style=" height:248px;">
            <div id="header" style="border-bottom: 1px solid #9F9F9F; background-image: url(Images/sistemas_rh_01.png); height:248px;">
                <div style="width: 110px; float: left;margin-top: 132px; margin-left: 60px;">
                    <div id="updimgFotoPerfil">
	
                            <img id="imgFotoPerfil" src="Images/default_user.png" style="height:95px;width:70px;border-width:0px;" />
                        
</div>
                </div>
                <div id="PanelUsuario" style="display: block; margin-top: 145px; margin-left: 160px; position:absolute; color:White;">
                    <div style="float: left; width: 500px; text-align:left;">
                        <div class="separatorTitle">
                            <div style="float: left; width: 110px;" class="tituloSesion">
                                <span>Bienvenido(a):</span>
                            </div>
                            <div style="text-align:left;">
                                <span id="lblPerfilNombre" class="usuarioSesion"></span>
                            </div>
                            <div style="clear: both;">
                            </div>
                        </div>
                        <div class="separatorTitle">
                            <div style="float: left; width: 110px;" class="tituloSesion">
                                <span>Departamento:</span>
                            </div>
                            <div style="text-align:left;">
                                <span id="lblPerfilNomina" class="usuarioSesion"></span>
                            </div>
                            <div style="clear: both;">
                            </div>                        
                        </div>
                        <div class="separatorTitle">
                            <div style="float: left; width: 110px;" class="tituloSesion">
                                <span>Puesto:</span>
                            </div>
                            <div style="text-align:left;">
                                <span id="lblPerfilDepartamento" class="usuarioSesion"></span>
                            </div>
                            <div style="clear: both;">
                            </div>                               
                        </div>
                    </div>
                    <div style="clear: both;">
                    </div>
                </div>
            </div>
        </div>
        <div id="dvIninicioGral" style="display: block;">            
            <div id="dvMenu" style="display: block;">
            
            <div id="updRHMenuPrincipal">
	
                    <div style="background: #264475; width: 960px;">
                        <table id="mnuMainSRH" class="mnuMainSRH_2" cellpadding="0" cellspacing="0" border="0" style="width: 930px !important;">
		<tr>
			<td onmouseover="Menu_HoverStatic(this)" onmouseout="Menu_Unhover(this)" onkeyup="Menu_Key(event)" id="mnuMainSRHn0"><table class="mnuMainSRH_4" cellpadding="0" cellspacing="0" border="0" width="100%">
				<tr>
					<td><a class="mnuMainSRH_1 mnuMainSRH_3" href="javascript:__doPostBack('mnuMainSRH','000')"><img src="Images/iconos_10.png" alt="" style="border-style:none;vertical-align:middle;" /> Inicio</a></td>
				</tr>
			</table></td><td style="width:3px;"></td><td onmouseover="Menu_HoverStatic(this)" onmouseout="Menu_Unhover(this)" onkeyup="Menu_Key(event)" id="mnuMainSRHn1"><table class="mnuMainSRH_4" cellpadding="0" cellspacing="0" border="0" width="100%">
				<tr>
					<td><a class="mnuMainSRH_1 mnuMainSRH_3" href="javascript:__doPostBack('','');">Operaciones</a></td>
				</tr>
			</table></td><td style="width:3px;"></td><td onmouseover="Menu_HoverStatic(this)" onmouseout="Menu_Unhover(this)" onkeyup="Menu_Key(event)" id="mnuMainSRHn2"><table class="mnuMainSRH_4" cellpadding="0" cellspacing="0" border="0" width="100%">
				<tr>
					<td><a class="mnuMainSRH_1 mnuMainSRH_3" href="javascript:__doPostBack('','');">Personal</a></td>
				</tr>
			</table></td><td style="width:3px;"></td><td onmouseover="Menu_HoverStatic(this)" onmouseout="Menu_Unhover(this)" onkeyup="Menu_Key(event)" id="mnuMainSRHn3"><table class="mnuMainSRH_4" cellpadding="0" cellspacing="0" border="0" width="100%">
				<tr>
					<td><a class="mnuMainSRH_1 mnuMainSRH_3" href="javascript:__doPostBack('','');">Laboral</a></td>
				</tr>
			</table></td><td style="width:3px;"></td><td onmouseover="Menu_HoverStatic(this)" onmouseout="Menu_Unhover(this)" onkeyup="Menu_Key(event)" id="mnuMainSRHn4"><table class="mnuMainSRH_4" cellpadding="0" cellspacing="0" border="0" width="100%">
				<tr>
					<td><a class="mnuMainSRH_1 mnuMainSRH_3" href="javascript:__doPostBack('','');">Complementaria</a></td>
				</tr>
			</table></td><td style="width:3px;"></td><td onmouseover="Menu_HoverStatic(this)" onmouseout="Menu_Unhover(this)" onkeyup="Menu_Key(event)" id="mnuMainSRHn5"><table class="mnuMainSRH_4" cellpadding="0" cellspacing="0" border="0" width="100%">
				<tr>
					<td><a class="mnuMainSRH_1 mnuMainSRH_3" href="javascript:__doPostBack('','');">Incidencias</a></td>
				</tr>
			</table></td><td style="width:3px;"></td><td onmouseover="Menu_HoverStatic(this)" onmouseout="Menu_Unhover(this)" onkeyup="Menu_Key(event)" id="mnuMainSRHn6"><table class="mnuMainSRH_4" cellpadding="0" cellspacing="0" border="0" width="100%">
				<tr>
					<td><a class="mnuMainSRH_1 mnuMainSRH_3" href="javascript:__doPostBack('','');">Reportes</a></td>
				</tr>
			</table></td><td style="width:3px;"></td><td onmouseover="Menu_HoverStatic(this)" onmouseout="Menu_Unhover(this)" onkeyup="Menu_Key(event)" id="mnuMainSRHn7"><table class="mnuMainSRH_4" cellpadding="0" cellspacing="0" border="0" width="100%">
				<tr>
					<td><a class="mnuMainSRH_1 mnuMainSRH_3" href="Default.aspx"> Salir</a></td>
				</tr>
			</table></td><td><img src="Images/iconos_12.png" alt="" /></td>
		</tr>
	</table><div id="mnuMainSRHn1Items" class="mnuMainSRH_0">
		<table border="0" cellpadding="0" cellspacing="0">
			<tr onmouseover="Menu_HoverDynamic(this)" onmouseout="Menu_Unhover(this)" onkeyup="Menu_Key(event)" id="mnuMainSRHn8">
				<td><table class="mnuMainSRH_6" cellpadding="0" cellspacing="0" border="0" width="100%">
					<tr>
						<td style="width:100%;"><a class="mnuMainSRH_1 mnuMainSRH_5" href="javascript:__doPostBack('mnuMainSRH','Operaciones\\001')">
                                <div style="width:150px; height:15px;">
                                    Alta
                                </div>
                            </a></td>
					</tr>
				</table></td>
			</tr><tr onmouseover="Menu_HoverDynamic(this)" onmouseout="Menu_Unhover(this)" onkeyup="Menu_Key(event)" id="mnuMainSRHn9">
				<td><table class="mnuMainSRH_6" cellpadding="0" cellspacing="0" border="0" width="100%">
					<tr>
						<td style="width:100%;"><a class="mnuMainSRH_1 mnuMainSRH_5" href="javascript:__doPostBack('mnuMainSRH','Operaciones\\002')">
                                <div style="width:150px; height:15px;">
                                    Baja
                                </div>
                            </a></td>
					</tr>
				</table></td>
			</tr><tr onmouseover="Menu_HoverDynamic(this)" onmouseout="Menu_Unhover(this)" onkeyup="Menu_Key(event)" id="mnuMainSRHn10">
				<td><table class="mnuMainSRH_6" cellpadding="0" cellspacing="0" border="0" width="100%">
					<tr>
						<td style="width:100%;"><a class="mnuMainSRH_1 mnuMainSRH_5" href="javascript:__doPostBack('mnuMainSRH','Operaciones\\012')">
                                <div style="width:150px; height:15px;">
                                    Licencia
                                </div>
                            </a></td>
					</tr>
				</table></td>
			</tr><tr onmouseover="Menu_HoverDynamic(this)" onmouseout="Menu_Unhover(this)" onkeyup="Menu_Key(event)" id="mnuMainSRHn11">
				<td><table class="mnuMainSRH_6" cellpadding="0" cellspacing="0" border="0" width="100%">
					<tr>
						<td style="width:100%;"><a class="mnuMainSRH_1 mnuMainSRH_5" href="javascript:__doPostBack('','');">
                                <div style="width:150px; height:15px;">
                                    Ajuste de sueldo
                                </div>
                            </a></td>
					</tr>
				</table></td>
			</tr><tr onmouseover="Menu_HoverDynamic(this)" onmouseout="Menu_Unhover(this)" onkeyup="Menu_Key(event)" id="mnuMainSRHn12">
				<td><table class="mnuMainSRH_6" cellpadding="0" cellspacing="0" border="0" width="100%">
					<tr>
						<td style="width:100%;"><a class="mnuMainSRH_1 mnuMainSRH_5" href="javascript:__doPostBack('mnuMainSRH','Operaciones\\028')">
                                <div style="width:150px; height:15px;">
                                    Recontratación
                                </div>
                            </a></td>
					</tr>
				</table></td>
			</tr><tr onmouseover="Menu_HoverDynamic(this)" onmouseout="Menu_Unhover(this)" onkeyup="Menu_Key(event)" id="mnuMainSRHn13">
				<td><table class="mnuMainSRH_6" cellpadding="0" cellspacing="0" border="0" width="100%">
					<tr>
						<td style="width:100%;"><a class="mnuMainSRH_1 mnuMainSRH_5" href="javascript:__doPostBack('mnuMainSRH','Operaciones\\036')">
                                <div style="width:150px; height:15px;">
                                    Formatos
                                </div>
                            </a></td>
					</tr>
				</table></td>
			</tr><tr onmouseover="Menu_HoverDynamic(this)" onmouseout="Menu_Unhover(this)" onkeyup="Menu_Key(event)" id="mnuMainSRHn14">
				<td><table class="mnuMainSRH_6" cellpadding="0" cellspacing="0" border="0" width="100%">
					<tr>
						<td style="width:100%;"><a class="mnuMainSRH_1 mnuMainSRH_5" href="javascript:__doPostBack('mnuMainSRH','Operaciones\\038')">
                                <div style="width:150px; height:15px;">
                                    Eventos
                                </div>
                            </a></td>
					</tr>
				</table></td>
			</tr>
		</table><div class="mnuMainSRH_6 mnuMainSRH_0" id="mnuMainSRHn1ItemsUp" onmouseover="PopOut_Up(this)" onmouseout="PopOut_Stop(this)" style="text-align:center;">
			<img src="/SistemaRH/WebResource.axd?d=yPXcCl0umkcn8_vpOxx4R5JbQrtsRxWXZhXuKokrBEZWh43IS0bhjqvS9ZNrRSPiejlsbQvQ04xoyCax12iXIps5WJE1&amp;t=635082980141708196" alt="Desplazar hacia arriba" />
		</div><div class="mnuMainSRH_6 mnuMainSRH_0" id="mnuMainSRHn1ItemsDn" onmouseover="PopOut_Down(this)" onmouseout="PopOut_Stop(this)" style="text-align:center;">
			<img src="/SistemaRH/WebResource.axd?d=DMyJ5P6GjBoIaturO39jxoOn0Sv-v3knwPsHQdqxbLeeJWL3igQRDWL7K0oxDGK2DAHZLQRnUiDVep2nGFMop9-eh201&amp;t=635082980141708196" alt="Desplazar hacia abajo" />
		</div>
	</div><div id="mnuMainSRHn11Items" class="mnuMainSRH_0">
		<table border="0" cellpadding="0" cellspacing="0">
			<tr onmouseover="Menu_HoverDynamic(this)" onmouseout="Menu_Unhover(this)" onkeyup="Menu_Key(event)" id="mnuMainSRHn15">
				<td><table class="mnuMainSRH_6" cellpadding="0" cellspacing="0" border="0" width="100%">
					<tr>
						<td style="width:100%;"><a class="mnuMainSRH_1 mnuMainSRH_5" href="javascript:__doPostBack('mnuMainSRH','Operaciones\\Ajuste de sueldo\\003')">
                                <div style="width:150px; height:15px;">
                                    Modificación
                                </div>
                            </a></td>
					</tr>
				</table></td>
			</tr><tr onmouseover="Menu_HoverDynamic(this)" onmouseout="Menu_Unhover(this)" onkeyup="Menu_Key(event)" id="mnuMainSRHn16">
				<td><table class="mnuMainSRH_6" cellpadding="0" cellspacing="0" border="0" width="100%">
					<tr>
						<td style="width:100%;"><a class="mnuMainSRH_1 mnuMainSRH_5" href="javascript:__doPostBack('mnuMainSRH','Operaciones\\Ajuste de sueldo\\004')">
                                <div style="width:150px; height:15px;">
                                    Anual
                                </div>
                            </a></td>
					</tr>
				</table></td>
			</tr>
		</table><div class="mnuMainSRH_6 mnuMainSRH_0" id="mnuMainSRHn11ItemsUp" onmouseover="PopOut_Up(this)" onmouseout="PopOut_Stop(this)" style="text-align:center;">
			<img src="/SistemaRH/WebResource.axd?d=yPXcCl0umkcn8_vpOxx4R5JbQrtsRxWXZhXuKokrBEZWh43IS0bhjqvS9ZNrRSPiejlsbQvQ04xoyCax12iXIps5WJE1&amp;t=635082980141708196" alt="Desplazar hacia arriba" />
		</div><div class="mnuMainSRH_6 mnuMainSRH_0" id="mnuMainSRHn11ItemsDn" onmouseover="PopOut_Down(this)" onmouseout="PopOut_Stop(this)" style="text-align:center;">
			<img src="/SistemaRH/WebResource.axd?d=DMyJ5P6GjBoIaturO39jxoOn0Sv-v3knwPsHQdqxbLeeJWL3igQRDWL7K0oxDGK2DAHZLQRnUiDVep2nGFMop9-eh201&amp;t=635082980141708196" alt="Desplazar hacia abajo" />
		</div>
	</div><div id="mnuMainSRHn2Items" class="mnuMainSRH_0">
		<table border="0" cellpadding="0" cellspacing="0">
			<tr onmouseover="Menu_HoverDynamic(this)" onmouseout="Menu_Unhover(this)" onkeyup="Menu_Key(event)" id="mnuMainSRHn17">
				<td><table class="mnuMainSRH_6" cellpadding="0" cellspacing="0" border="0" width="100%">
					<tr>
						<td style="width:100%;"><a class="mnuMainSRH_1 mnuMainSRH_5" href="javascript:__doPostBack('mnuMainSRH','Personal\\005')">
                                <div style="width:150px; height:15px;">
                                    Datos personales
                                </div>
                            </a></td>
					</tr>
				</table></td>
			</tr>
		</table><div class="mnuMainSRH_6 mnuMainSRH_0" id="mnuMainSRHn2ItemsUp" onmouseover="PopOut_Up(this)" onmouseout="PopOut_Stop(this)" style="text-align:center;">
			<img src="/SistemaRH/WebResource.axd?d=yPXcCl0umkcn8_vpOxx4R5JbQrtsRxWXZhXuKokrBEZWh43IS0bhjqvS9ZNrRSPiejlsbQvQ04xoyCax12iXIps5WJE1&amp;t=635082980141708196" alt="Desplazar hacia arriba" />
		</div><div class="mnuMainSRH_6 mnuMainSRH_0" id="mnuMainSRHn2ItemsDn" onmouseover="PopOut_Down(this)" onmouseout="PopOut_Stop(this)" style="text-align:center;">
			<img src="/SistemaRH/WebResource.axd?d=DMyJ5P6GjBoIaturO39jxoOn0Sv-v3knwPsHQdqxbLeeJWL3igQRDWL7K0oxDGK2DAHZLQRnUiDVep2nGFMop9-eh201&amp;t=635082980141708196" alt="Desplazar hacia abajo" />
		</div>
	</div><div id="mnuMainSRHn3Items" class="mnuMainSRH_0">
		<table border="0" cellpadding="0" cellspacing="0">
			<tr onmouseover="Menu_HoverDynamic(this)" onmouseout="Menu_Unhover(this)" onkeyup="Menu_Key(event)" id="mnuMainSRHn18">
				<td><table class="mnuMainSRH_6" cellpadding="0" cellspacing="0" border="0" width="100%">
					<tr>
						<td style="width:100%;"><a class="mnuMainSRH_1 mnuMainSRH_5" href="javascript:__doPostBack('mnuMainSRH','Laboral\\006')">
                                <div style="width:150px; height:15px;">
                                    Datos empresa
                                </div>
                            </a></td>
					</tr>
				</table></td>
			</tr><tr onmouseover="Menu_HoverDynamic(this)" onmouseout="Menu_Unhover(this)" onkeyup="Menu_Key(event)" id="mnuMainSRHn19">
				<td><table class="mnuMainSRH_6" cellpadding="0" cellspacing="0" border="0" width="100%">
					<tr>
						<td style="width:100%;"><a class="mnuMainSRH_1 mnuMainSRH_5" href="javascript:__doPostBack('mnuMainSRH','Laboral\\033')">
                                <div style="width:150px; height:15px;">
                                    Pensión alimenticia
                                </div>
                            </a></td>
					</tr>
				</table></td>
			</tr><tr onmouseover="Menu_HoverDynamic(this)" onmouseout="Menu_Unhover(this)" onkeyup="Menu_Key(event)" id="mnuMainSRHn20">
				<td><table class="mnuMainSRH_6" cellpadding="0" cellspacing="0" border="0" width="100%">
					<tr>
						<td style="width:100%;"><a class="mnuMainSRH_1 mnuMainSRH_5" href="javascript:__doPostBack('mnuMainSRH','Laboral\\034')">
                                <div style="width:150px; height:15px;">
                                    Apoyo a estudios
                                </div>
                            </a></td>
					</tr>
				</table></td>
			</tr><tr onmouseover="Menu_HoverDynamic(this)" onmouseout="Menu_Unhover(this)" onkeyup="Menu_Key(event)" id="mnuMainSRHn21">
				<td><table class="mnuMainSRH_6" cellpadding="0" cellspacing="0" border="0" width="100%">
					<tr>
						<td style="width:100%;"><a class="mnuMainSRH_1 mnuMainSRH_5" href="javascript:__doPostBack('mnuMainSRH','Laboral\\035')">
                                <div style="width:150px; height:15px;">
                                    Compensaciones
                                </div>
                            </a></td>
					</tr>
				</table></td>
			</tr>
		</table><div class="mnuMainSRH_6 mnuMainSRH_0" id="mnuMainSRHn3ItemsUp" onmouseover="PopOut_Up(this)" onmouseout="PopOut_Stop(this)" style="text-align:center;">
			<img src="/SistemaRH/WebResource.axd?d=yPXcCl0umkcn8_vpOxx4R5JbQrtsRxWXZhXuKokrBEZWh43IS0bhjqvS9ZNrRSPiejlsbQvQ04xoyCax12iXIps5WJE1&amp;t=635082980141708196" alt="Desplazar hacia arriba" />
		</div><div class="mnuMainSRH_6 mnuMainSRH_0" id="mnuMainSRHn3ItemsDn" onmouseover="PopOut_Down(this)" onmouseout="PopOut_Stop(this)" style="text-align:center;">
			<img src="/SistemaRH/WebResource.axd?d=DMyJ5P6GjBoIaturO39jxoOn0Sv-v3knwPsHQdqxbLeeJWL3igQRDWL7K0oxDGK2DAHZLQRnUiDVep2nGFMop9-eh201&amp;t=635082980141708196" alt="Desplazar hacia abajo" />
		</div>
	</div><div id="mnuMainSRHn4Items" class="mnuMainSRH_0">
		<table border="0" cellpadding="0" cellspacing="0">
			<tr onmouseover="Menu_HoverDynamic(this)" onmouseout="Menu_Unhover(this)" onkeyup="Menu_Key(event)" id="mnuMainSRHn22">
				<td><table class="mnuMainSRH_6" cellpadding="0" cellspacing="0" border="0" width="100%">
					<tr>
						<td style="width:100%;"><a class="mnuMainSRH_1 mnuMainSRH_5" href="javascript:__doPostBack('mnuMainSRH','Complementaria\\007')">
                                <div style="width:150px; height:15px;">
                                    Datos médicos
                                </div>
                            </a></td>
					</tr>
				</table></td>
			</tr><tr onmouseover="Menu_HoverDynamic(this)" onmouseout="Menu_Unhover(this)" onkeyup="Menu_Key(event)" id="mnuMainSRHn23">
				<td><table class="mnuMainSRH_6" cellpadding="0" cellspacing="0" border="0" width="100%">
					<tr>
						<td style="width:100%;"><a class="mnuMainSRH_1 mnuMainSRH_5" href="javascript:__doPostBack('','');">
                                <div style="width:150px; height:15px;">
                                    Gastos médicos
                                </div>
                            </a></td>
					</tr>
				</table></td>
			</tr><tr onmouseover="Menu_HoverDynamic(this)" onmouseout="Menu_Unhover(this)" onkeyup="Menu_Key(event)" id="mnuMainSRHn24">
				<td><table class="mnuMainSRH_6" cellpadding="0" cellspacing="0" border="0" width="100%">
					<tr>
						<td style="width:100%;"><a class="mnuMainSRH_1 mnuMainSRH_5" href="javascript:__doPostBack('mnuMainSRH','Complementaria\\008')">
                                <div style="width:150px; height:15px;">
                                    Familiares
                                </div>
                            </a></td>
					</tr>
				</table></td>
			</tr><tr onmouseover="Menu_HoverDynamic(this)" onmouseout="Menu_Unhover(this)" onkeyup="Menu_Key(event)" id="mnuMainSRHn25">
				<td><table class="mnuMainSRH_6" cellpadding="0" cellspacing="0" border="0" width="100%">
					<tr>
						<td style="width:100%;"><a class="mnuMainSRH_1 mnuMainSRH_5" href="javascript:__doPostBack('mnuMainSRH','Complementaria\\009')">
                                <div style="width:150px; height:15px;">
                                    Escolaridad
                                </div>
                            </a></td>
					</tr>
				</table></td>
			</tr>
		</table><div class="mnuMainSRH_6 mnuMainSRH_0" id="mnuMainSRHn4ItemsUp" onmouseover="PopOut_Up(this)" onmouseout="PopOut_Stop(this)" style="text-align:center;">
			<img src="/SistemaRH/WebResource.axd?d=yPXcCl0umkcn8_vpOxx4R5JbQrtsRxWXZhXuKokrBEZWh43IS0bhjqvS9ZNrRSPiejlsbQvQ04xoyCax12iXIps5WJE1&amp;t=635082980141708196" alt="Desplazar hacia arriba" />
		</div><div class="mnuMainSRH_6 mnuMainSRH_0" id="mnuMainSRHn4ItemsDn" onmouseover="PopOut_Down(this)" onmouseout="PopOut_Stop(this)" style="text-align:center;">
			<img src="/SistemaRH/WebResource.axd?d=DMyJ5P6GjBoIaturO39jxoOn0Sv-v3knwPsHQdqxbLeeJWL3igQRDWL7K0oxDGK2DAHZLQRnUiDVep2nGFMop9-eh201&amp;t=635082980141708196" alt="Desplazar hacia abajo" />
		</div>
	</div><div id="mnuMainSRHn23Items" class="mnuMainSRH_0">
		<table border="0" cellpadding="0" cellspacing="0">
			<tr onmouseover="Menu_HoverDynamic(this)" onmouseout="Menu_Unhover(this)" onkeyup="Menu_Key(event)" id="mnuMainSRHn26">
				<td><table class="mnuMainSRH_6" cellpadding="0" cellspacing="0" border="0" width="100%">
					<tr>
						<td style="width:100%;"><a class="mnuMainSRH_1 mnuMainSRH_5" href="javascript:__doPostBack('mnuMainSRH','Complementaria\\Gastos médicos\\026')">
                                <div style="width:150px; height:15px;">
                                    Nuevo
                                </div>
                            </a></td>
					</tr>
				</table></td>
			</tr><tr onmouseover="Menu_HoverDynamic(this)" onmouseout="Menu_Unhover(this)" onkeyup="Menu_Key(event)" id="mnuMainSRHn27">
				<td><table class="mnuMainSRH_6" cellpadding="0" cellspacing="0" border="0" width="100%">
					<tr>
						<td style="width:100%;"><a class="mnuMainSRH_1 mnuMainSRH_5" href="javascript:__doPostBack('mnuMainSRH','Complementaria\\Gastos médicos\\027')">
                                <div style="width:150px; height:15px;">
                                    Modificar
                                </div>
                            </a></td>
					</tr>
				</table></td>
			</tr>
		</table><div class="mnuMainSRH_6 mnuMainSRH_0" id="mnuMainSRHn23ItemsUp" onmouseover="PopOut_Up(this)" onmouseout="PopOut_Stop(this)" style="text-align:center;">
			<img src="/SistemaRH/WebResource.axd?d=yPXcCl0umkcn8_vpOxx4R5JbQrtsRxWXZhXuKokrBEZWh43IS0bhjqvS9ZNrRSPiejlsbQvQ04xoyCax12iXIps5WJE1&amp;t=635082980141708196" alt="Desplazar hacia arriba" />
		</div><div class="mnuMainSRH_6 mnuMainSRH_0" id="mnuMainSRHn23ItemsDn" onmouseover="PopOut_Down(this)" onmouseout="PopOut_Stop(this)" style="text-align:center;">
			<img src="/SistemaRH/WebResource.axd?d=DMyJ5P6GjBoIaturO39jxoOn0Sv-v3knwPsHQdqxbLeeJWL3igQRDWL7K0oxDGK2DAHZLQRnUiDVep2nGFMop9-eh201&amp;t=635082980141708196" alt="Desplazar hacia abajo" />
		</div>
	</div><div id="mnuMainSRHn5Items" class="mnuMainSRH_0">
		<table border="0" cellpadding="0" cellspacing="0">
			<tr onmouseover="Menu_HoverDynamic(this)" onmouseout="Menu_Unhover(this)" onkeyup="Menu_Key(event)" id="mnuMainSRHn28">
				<td><table class="mnuMainSRH_6" cellpadding="0" cellspacing="0" border="0" width="100%">
					<tr>
						<td style="width:100%;"><a class="mnuMainSRH_1 mnuMainSRH_5" href="javascript:__doPostBack('mnuMainSRH','Incidencias\\010')">
                                <div style="width:150px; height:15px;">
                                    Nueva
                                </div>
                            </a></td>
					</tr>
				</table></td>
			</tr><tr onmouseover="Menu_HoverDynamic(this)" onmouseout="Menu_Unhover(this)" onkeyup="Menu_Key(event)" id="mnuMainSRHn29">
				<td><table class="mnuMainSRH_6" cellpadding="0" cellspacing="0" border="0" width="100%">
					<tr>
						<td style="width:100%;"><a class="mnuMainSRH_1 mnuMainSRH_5" href="javascript:__doPostBack('mnuMainSRH','Incidencias\\011')">
                                <div style="width:150px; height:15px;">
                                    Modificar
                                </div>
                            </a></td>
					</tr>
				</table></td>
			</tr>
		</table><div class="mnuMainSRH_6 mnuMainSRH_0" id="mnuMainSRHn5ItemsUp" onmouseover="PopOut_Up(this)" onmouseout="PopOut_Stop(this)" style="text-align:center;">
			<img src="/SistemaRH/WebResource.axd?d=yPXcCl0umkcn8_vpOxx4R5JbQrtsRxWXZhXuKokrBEZWh43IS0bhjqvS9ZNrRSPiejlsbQvQ04xoyCax12iXIps5WJE1&amp;t=635082980141708196" alt="Desplazar hacia arriba" />
		</div><div class="mnuMainSRH_6 mnuMainSRH_0" id="mnuMainSRHn5ItemsDn" onmouseover="PopOut_Down(this)" onmouseout="PopOut_Stop(this)" style="text-align:center;">
			<img src="/SistemaRH/WebResource.axd?d=DMyJ5P6GjBoIaturO39jxoOn0Sv-v3knwPsHQdqxbLeeJWL3igQRDWL7K0oxDGK2DAHZLQRnUiDVep2nGFMop9-eh201&amp;t=635082980141708196" alt="Desplazar hacia abajo" />
		</div>
	</div><div id="mnuMainSRHn6Items" class="mnuMainSRH_0">
		<table border="0" cellpadding="0" cellspacing="0">
			<tr onmouseover="Menu_HoverDynamic(this)" onmouseout="Menu_Unhover(this)" onkeyup="Menu_Key(event)" id="mnuMainSRHn30">
				<td><table class="mnuMainSRH_6" cellpadding="0" cellspacing="0" border="0" width="100%">
					<tr>
						<td style="width:100%;"><a class="mnuMainSRH_1 mnuMainSRH_5" href="javascript:__doPostBack('mnuMainSRH','Reportes\\029')">
                                <div style="width:150px; height:15px;">
                                    Premio de Puntualidad
                                </div>
                            </a></td>
					</tr>
				</table></td>
			</tr><tr onmouseover="Menu_HoverDynamic(this)" onmouseout="Menu_Unhover(this)" onkeyup="Menu_Key(event)" id="mnuMainSRHn31">
				<td><table class="mnuMainSRH_6" cellpadding="0" cellspacing="0" border="0" width="100%">
					<tr>
						<td style="width:100%;"><a class="mnuMainSRH_1 mnuMainSRH_5" href="javascript:__doPostBack('mnuMainSRH','Reportes\\030')">
                                <div style="width:150px; height:15px;">
                                    Aguinaldo
                                </div>
                            </a></td>
					</tr>
				</table></td>
			</tr><tr onmouseover="Menu_HoverDynamic(this)" onmouseout="Menu_Unhover(this)" onkeyup="Menu_Key(event)" id="mnuMainSRHn32">
				<td><table class="mnuMainSRH_6" cellpadding="0" cellspacing="0" border="0" width="100%">
					<tr>
						<td style="width:100%;"><a class="mnuMainSRH_1 mnuMainSRH_5" href="javascript:__doPostBack('mnuMainSRH','Reportes\\032')">
                                <div style="width:150px; height:15px;">
                                    Prima Vacacional
                                </div>
                            </a></td>
					</tr>
				</table></td>
			</tr><tr onmouseover="Menu_HoverDynamic(this)" onmouseout="Menu_Unhover(this)" onkeyup="Menu_Key(event)" id="mnuMainSRHn33">
				<td><table class="mnuMainSRH_6" cellpadding="0" cellspacing="0" border="0" width="100%">
					<tr>
						<td style="width:100%;"><a class="mnuMainSRH_1 mnuMainSRH_5" href="javascript:__doPostBack('mnuMainSRH','Reportes\\031')">
                                <div style="width:150px; height:15px;">
                                    Retardos
                                </div>
                            </a></td>
					</tr>
				</table></td>
			</tr><tr onmouseover="Menu_HoverDynamic(this)" onmouseout="Menu_Unhover(this)" onkeyup="Menu_Key(event)" id="mnuMainSRHn34">
				<td><table class="mnuMainSRH_6" cellpadding="0" cellspacing="0" border="0" width="100%">
					<tr>
						<td style="width:100%;"><a class="mnuMainSRH_1 mnuMainSRH_5" href="javascript:__doPostBack('mnuMainSRH','Reportes\\039')">
                                <div style="width:150px; height:15px;">
                                    Apoyo a estudios
                                </div>
                            </a></td>
					</tr>
				</table></td>
			</tr><tr onmouseover="Menu_HoverDynamic(this)" onmouseout="Menu_Unhover(this)" onkeyup="Menu_Key(event)" id="mnuMainSRHn35">
				<td><table class="mnuMainSRH_6" cellpadding="0" cellspacing="0" border="0" width="100%">
					<tr>
						<td style="width:100%;"><a class="mnuMainSRH_1 mnuMainSRH_5" href="javascript:__doPostBack('mnuMainSRH','Reportes\\015')">
                                <div style="width:150px; height:15px;">
                                    Cumpleaños
                                </div>
                            </a></td>
					</tr>
				</table></td>
			</tr><tr onmouseover="Menu_HoverDynamic(this)" onmouseout="Menu_Unhover(this)" onkeyup="Menu_Key(event)" id="mnuMainSRHn36">
				<td><table class="mnuMainSRH_6" cellpadding="0" cellspacing="0" border="0" width="100%">
					<tr>
						<td style="width:100%;"><a class="mnuMainSRH_1 mnuMainSRH_5" href="javascript:__doPostBack('mnuMainSRH','Reportes\\016')">
                                <div style="width:150px; height:15px;">
                                    General
                                </div>
                            </a></td>
					</tr>
				</table></td>
			</tr><tr onmouseover="Menu_HoverDynamic(this)" onmouseout="Menu_Unhover(this)" onkeyup="Menu_Key(event)" id="mnuMainSRHn37">
				<td><table class="mnuMainSRH_6" cellpadding="0" cellspacing="0" border="0" width="100%">
					<tr>
						<td style="width:100%;"><a class="mnuMainSRH_1 mnuMainSRH_5" href="javascript:__doPostBack('mnuMainSRH','Reportes\\017')">
                                <div style="width:150px; height:15px;">
                                    Personal
                                </div>
                            </a></td>
					</tr>
				</table></td>
			</tr><tr onmouseover="Menu_HoverDynamic(this)" onmouseout="Menu_Unhover(this)" onkeyup="Menu_Key(event)" id="mnuMainSRHn38">
				<td><table class="mnuMainSRH_6" cellpadding="0" cellspacing="0" border="0" width="100%">
					<tr>
						<td style="width:100%;"><a class="mnuMainSRH_1 mnuMainSRH_5" href="javascript:__doPostBack('mnuMainSRH','Reportes\\018')">
                                <div style="width:150px; height:15px;">
                                    Sueldo
                                </div>
                            </a></td>
					</tr>
				</table></td>
			</tr><tr onmouseover="Menu_HoverDynamic(this)" onmouseout="Menu_Unhover(this)" onkeyup="Menu_Key(event)" id="mnuMainSRHn39">
				<td><table class="mnuMainSRH_6" cellpadding="0" cellspacing="0" border="0" width="100%">
					<tr>
						<td style="width:100%;"><a class="mnuMainSRH_1 mnuMainSRH_5" href="javascript:__doPostBack('','');">
                                <div style="width:150px; height:15px;">
                                    Incidencia
                                </div>
                            </a></td>
					</tr>
				</table></td>
			</tr><tr onmouseover="Menu_HoverDynamic(this)" onmouseout="Menu_Unhover(this)" onkeyup="Menu_Key(event)" id="mnuMainSRHn40">
				<td><table class="mnuMainSRH_6" cellpadding="0" cellspacing="0" border="0" width="100%">
					<tr>
						<td style="width:100%;"><a class="mnuMainSRH_1 mnuMainSRH_5" href="javascript:__doPostBack('mnuMainSRH','Reportes\\022')">
                                <div style="width:150px; height:15px;">
                                    Estatus empleado
                                </div>
                            </a></td>
					</tr>
				</table></td>
			</tr><tr onmouseover="Menu_HoverDynamic(this)" onmouseout="Menu_Unhover(this)" onkeyup="Menu_Key(event)" id="mnuMainSRHn41">
				<td><table class="mnuMainSRH_6" cellpadding="0" cellspacing="0" border="0" width="100%">
					<tr>
						<td style="width:100%;"><a class="mnuMainSRH_1 mnuMainSRH_5" href="javascript:__doPostBack('mnuMainSRH','Reportes\\023')">
                                <div style="width:150px; height:15px;">
                                    Prestaciones
                                </div>
                            </a></td>
					</tr>
				</table></td>
			</tr><tr onmouseover="Menu_HoverDynamic(this)" onmouseout="Menu_Unhover(this)" onkeyup="Menu_Key(event)" id="mnuMainSRHn42">
				<td><table class="mnuMainSRH_6" cellpadding="0" cellspacing="0" border="0" width="100%">
					<tr>
						<td style="width:100%;"><a class="mnuMainSRH_1 mnuMainSRH_5" href="javascript:__doPostBack('mnuMainSRH','Reportes\\024')">
                                <div style="width:150px; height:15px;">
                                    Directorio de fotos
                                </div>
                            </a></td>
					</tr>
				</table></td>
			</tr><tr onmouseover="Menu_HoverDynamic(this)" onmouseout="Menu_Unhover(this)" onkeyup="Menu_Key(event)" id="mnuMainSRHn43">
				<td><table class="mnuMainSRH_6" cellpadding="0" cellspacing="0" border="0" width="100%">
					<tr>
						<td style="width:100%;"><a class="mnuMainSRH_1 mnuMainSRH_5" href="javascript:__doPostBack('mnuMainSRH','Reportes\\025')">
                                <div style="width:150px; height:15px;">
                                    Correos
                                </div>
                            </a></td>
					</tr>
				</table></td>
			</tr>
		</table><div class="mnuMainSRH_6 mnuMainSRH_0" id="mnuMainSRHn6ItemsUp" onmouseover="PopOut_Up(this)" onmouseout="PopOut_Stop(this)" style="text-align:center;">
			<img src="/SistemaRH/WebResource.axd?d=yPXcCl0umkcn8_vpOxx4R5JbQrtsRxWXZhXuKokrBEZWh43IS0bhjqvS9ZNrRSPiejlsbQvQ04xoyCax12iXIps5WJE1&amp;t=635082980141708196" alt="Desplazar hacia arriba" />
		</div><div class="mnuMainSRH_6 mnuMainSRH_0" id="mnuMainSRHn6ItemsDn" onmouseover="PopOut_Down(this)" onmouseout="PopOut_Stop(this)" style="text-align:center;">
			<img src="/SistemaRH/WebResource.axd?d=DMyJ5P6GjBoIaturO39jxoOn0Sv-v3knwPsHQdqxbLeeJWL3igQRDWL7K0oxDGK2DAHZLQRnUiDVep2nGFMop9-eh201&amp;t=635082980141708196" alt="Desplazar hacia abajo" />
		</div>
	</div><div id="mnuMainSRHn39Items" class="mnuMainSRH_0">
		<table border="0" cellpadding="0" cellspacing="0">
			<tr onmouseover="Menu_HoverDynamic(this)" onmouseout="Menu_Unhover(this)" onkeyup="Menu_Key(event)" id="mnuMainSRHn44">
				<td><table class="mnuMainSRH_6" cellpadding="0" cellspacing="0" border="0" width="100%">
					<tr>
						<td style="width:100%;"><a class="mnuMainSRH_1 mnuMainSRH_5" href="javascript:__doPostBack('mnuMainSRH','Reportes\\Incidencia\\019')">
                                <div style="width:150px; height:15px;">
                                    Historial
                                </div>
                            </a></td>
					</tr>
				</table></td>
			</tr><tr onmouseover="Menu_HoverDynamic(this)" onmouseout="Menu_Unhover(this)" onkeyup="Menu_Key(event)" id="mnuMainSRHn45">
				<td><table class="mnuMainSRH_6" cellpadding="0" cellspacing="0" border="0" width="100%">
					<tr>
						<td style="width:100%;"><a class="mnuMainSRH_1 mnuMainSRH_5" href="javascript:__doPostBack('mnuMainSRH','Reportes\\Incidencia\\020')">
                                <div style="width:150px; height:15px;">
                                    Estadístico
                                </div>
                            </a></td>
					</tr>
				</table></td>
			</tr><tr onmouseover="Menu_HoverDynamic(this)" onmouseout="Menu_Unhover(this)" onkeyup="Menu_Key(event)" id="mnuMainSRHn46">
				<td><table class="mnuMainSRH_6" cellpadding="0" cellspacing="0" border="0" width="100%">
					<tr>
						<td style="width:100%;"><a class="mnuMainSRH_1 mnuMainSRH_5" href="javascript:__doPostBack('mnuMainSRH','Reportes\\Incidencia\\021')">
                                <div style="width:150px; height:15px;">
                                    Concentrado
                                </div>
                            </a></td>
					</tr>
				</table></td>
			</tr>
		</table><div class="mnuMainSRH_6 mnuMainSRH_0" id="mnuMainSRHn39ItemsUp" onmouseover="PopOut_Up(this)" onmouseout="PopOut_Stop(this)" style="text-align:center;">
			<img src="/SistemaRH/WebResource.axd?d=yPXcCl0umkcn8_vpOxx4R5JbQrtsRxWXZhXuKokrBEZWh43IS0bhjqvS9ZNrRSPiejlsbQvQ04xoyCax12iXIps5WJE1&amp;t=635082980141708196" alt="Desplazar hacia arriba" />
		</div><div class="mnuMainSRH_6 mnuMainSRH_0" id="mnuMainSRHn39ItemsDn" onmouseover="PopOut_Down(this)" onmouseout="PopOut_Stop(this)" style="text-align:center;">
			<img src="/SistemaRH/WebResource.axd?d=DMyJ5P6GjBoIaturO39jxoOn0Sv-v3knwPsHQdqxbLeeJWL3igQRDWL7K0oxDGK2DAHZLQRnUiDVep2nGFMop9-eh201&amp;t=635082980141708196" alt="Desplazar hacia abajo" />
		</div>
	</div>    
                    </div>
                
</div>
            
            </div>
            <div style="text-align: left;">
                <div id="pnlUserControl">
	
                
</div>
            </div>
        </div>
        <div id="tdProcessData" style="width: 930px; font-family: Arial;
            padding: 30px 15px 10px 15px; display: none;">
            <table style="border-spacing: 0px; border-style: none; border-width: 0px; width: 100%;">
                <tr>
                    <td colspan="2">
                        <br />
                        <br />
                        <br />
                        <div class="titular" style="background-image: url(Images/titular_bg01.jpg); height: 20px;
                            padding-top: 5px; text-align: left;">
                            Procesando información
                        </div>
                        <table style="border-spacing: 0px; border-style: none; border-width: 0px;" class="data">
                            <tr>
                                <td valign="middle">
                                    <div align="center">
                                        <img src="Images/ProcessData.png" alt="Error" width="80px" height="80px" hspace="6" />
                                    </div>
                                </td>
                                <td valign="middle" style="text-align:left;">
                                    <br />
                                    <br />
                                    <div class="titulo-azul-mensaje-error" style="text-align:left;">
                                        <span id="Label18">Procesando información</span>
                                    </div>
                                    <br />
                                    El sistema se encuentra procesando información, por favor espere un momento.
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <div style="height: 1px; background-color: Navy;">
                        </div>
                    </td>
                </tr>
                <tr>
                    <td style="height: 5px;" colspan="2">
                    </td>
                </tr>
            </table>
        </div>
        <div id="tdSesionEXP" style="width: 930px; font-family: Arial;
            padding: 30px 15px 10px 15px; display: none; text-align:left; ">
            <table style="border-spacing: 0px; border-style: none; border-width: 0px; width: 100%;">
                <tr>
                    <td colspan="2">
                        <br />
                        <br />
                        <br />
                        <div class="titular" style="background-image: url(Images/titular_bg01.jpg); height: 20px;
                            padding-top: 5px;">
                            Sesión finalizada
                        </div>
                        <table style="border-spacing: 0px; border-style: none; border-width: 0px;" class="data">
                            <tr>
                                <td valign="middle">
                                    <div align="center">
                                        <img src="Images/Desconectar.png" alt="Error" width="100px" height="100px" hspace="6" />
                                    </div>
                                </td>
                                <td valign="middle">
                                    <br />
                                    <br />
                                    <div class="titulo-azul-mensaje-error">
                                        <span id="lblNombreExcepcion">Su sesión ha terminado por inactividad.</span>
                                    </div>
                                    <br />
                                    Por favor, Ingrese nuevamente al sistema.
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <div style="height: 1px; background-color: Navy;">
                        </div>
                    </td>
                </tr>
                <tr>
                    <td style="height: 5px;" colspan="2">
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <div style="text-align: right; float: right; margin-right: 10px;" class="buttonHover">
                            <div id="UpdatePanel188">
	
                                    <input type="submit" name="Button2" value="Regresar" onclick="javascript:WebForm_DoPostBackWithOptions(new WebForm_PostBackOptions(&quot;Button2&quot;, &quot;&quot;, false, &quot;&quot;, &quot;Default.aspx&quot;, false, false))" id="Button2" title="Regresar" class="boton" style="margin: 10px;" />
                                
</div>
                        </div>
                    </td>
                </tr>
            </table>
        </div>
        <div id="foot" style="background: #2473ae; font-family:Arial; color:#fff; font-size:12px; height:40px;">
            <p>Todos los derechos reservados © 2013 Grupo Parlamentario del PAN</p>
        </div>
    </div>
    

<script type="text/javascript">
//<![CDATA[
javascript:ShowDiv('3');var mnuMainSRH_Data = new Object();
mnuMainSRH_Data.disappearAfter = 500;
mnuMainSRH_Data.horizontalOffset = 2;
mnuMainSRH_Data.verticalOffset = 0;
mnuMainSRH_Data.hoverClass = 'mnuMainSRH_10';
mnuMainSRH_Data.hoverHyperLinkClass = 'mnuMainSRH_9';
mnuMainSRH_Data.staticHoverClass = 'mnuMainSRH_8';
mnuMainSRH_Data.staticHoverHyperLinkClass = 'mnuMainSRH_7';

theForm.oldSubmit = theForm.submit;
theForm.submit = WebForm_SaveScrollPositionSubmit;

theForm.oldOnSubmit = theForm.onsubmit;
theForm.onsubmit = WebForm_SaveScrollPositionOnSubmit;
Sys.Application.initialize();
//]]>
</script>
</form>
</body>
</html>
