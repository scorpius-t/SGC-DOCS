window.onload=findAll();

async function findAll(){

//var listaUsuarios= new Set();

var myJson= await getUsers();
generarTabla(myJson,"dvCSV");

//myJson.foreach(function(user)){
////    listaUsuarios.add(user[username]);
//})

myJson= await getLogAttemps();
generarTabla(myJson,"dvCSV2");
//myJson.foreach(function(user)){
////    listaUsuarios.add(user["username"]);
//})

 var select = document.getElementById("lista-usuarios");


}

async function generarTabla(myJson,nombreTabla){




    var table = document.createElement("table");
    table.className="table table-striped align-middle";
    table.id="tabla-consulta";
    var rows=myJson.length;
    if (rows>0){
        var cellsHeader=_keys(myJson[0])
    }
    if (cellsHeader.length > 1) {
        var thead=table.createTHead();
        thead.className="sticky-top bg-primary text-light fw-semibold"
        var rowh = thead.insertRow(0);
        for (var j = 0; j < cellsHeader.length; j++) {
            var cell = rowh.insertCell(-1);
            cell.innerHTML = buscarHeaderTabla(cellsHeader[j]);
            cell.className="encabezado"
        }
    var tbody=table.createTBody();
    for (var i = 0; i < rows; i++) {
        var cells = myJson[i].length;

            var row = tbody.insertRow(-1);
            for (var propt in myJson[i]){
                var cell = row.insertCell(-1);

                    cell.innerHTML=myJson[i][propt];

            }

    }
    var dvCSV = document.getElementById(nombreTabla);
    dvCSV.innerHTML = "";
    dvCSV.appendChild(table);
    }

}

function downloadExcel(){

    // var tableToExcel = (function() {

    //     var uri = 'data:application/vnd.ms-excel;base64,'
    //       , template = '<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40"><head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head><body><table>{table}</table></body></html>'
    //       , base64 = function(s) { return window.btoa(unescape(encodeURIComponent(s))) }
    //       , format = function(s, c) { return s.replace(/{(\w+)}/g, function(m, p) { return c[p]; }) }
    //     return function(table, name) {
    //       if (!table.nodeType) table = document.getElementById(table)
    //       var ctx = {worksheet: name || 'Worksheet', table: table.innerHTML}
    //       window.location.href = uri + base64(format(template, ctx))
    //     }
    //   })()

    // var blob = new Blob([document.getElementById('tabla-consulta').innerHTML], {
    //     type: "text/plain;charset=utf-8;"
    // });
    // var link=window.URL.createObjectURL(blob);
    // window.location.href=link;

    // var location = 'data:application/vnd.ms-excel;base64,';
	// var excelTemplate = '<html> ' +
	// 	'<head> ' +
	// 	'<meta http-equiv="content-type" content="text/plain; charset=UTF-8"/> ' +
	// 	'</head> ' +
	// 	'<body> ' +
	// 	document.getElementById("tabla-consulta").innerHTML +
	// 	'</body> ' +
	// 	'</html>'
	// window.location.href = location + window.btoa((unescape(encodeURIComponent(excelTemplate))));

    // var table = document.getElementById('tabla-consulta'); // id of table
    // var tableHTML = table.outerHTML;
    // var fileName = 'Consulta.xls';

    // var msie = window.navigator.userAgent.indexOf("MSIE ");

    // // If Internet Explorer
    // if (msie > 0 || !!navigator.userAgent.match(/Trident.*rv\:11\./)) {
    //     dummyFrame.document.open('txt/html', 'replace');
    //     dummyFrame.document.write(tableHTML);
    //     dummyFrame.document.close();
    //     dummyFrame.focus();
    //     return dummyFrame.document.execCommand('SaveAs', true, fileName);
    // }
    // //other browsers
    // else {
    //     var a = document.createElement('a');
    //     tableHTML = tableHTML.replace(/  /g, '').replace(/ /g, '%20'); // replaces spaces
    //     a.href = 'data:application/vnd.ms-excel;charset=utf-8,' + tableHTML;
    //     a.setAttribute('download', fileName);
    //     document.body.appendChild(a);
    //     a.click();
    //     document.body.removeChild(a);
    // }
}

function btoa_utf8(value) {
    return btoa(
        String.fromCharCode(
            ...new TextEncoder('utf-8')
                   .encode(value)
        )
    );
}

async function getUsers(){
    var urlDomain = 'http://' + window.location.host + '/admin/lista-usuarios';
    const response = await fetch(urlDomain);
    const myJson = await response.json();

    return myJson;
}
async function getLogAttemps(){
    var urlDomain = 'http://' + window.location.host + '/admin/lista-log-fails';
    const response = await fetch(urlDomain);
    const myJson = await response.json();

    return myJson;
}


//  busqueda de nombreatributos
  function _keys(obj)
   {
      if (!isObject(obj)) return [];
      if (Object.keys) return Object.keys(obj);
      var keys = [];
      for (var key in obj) if (_.has(obj, key)) keys.push(key);
      return keys;
    }
  function isObject(obj)
  {
      var type = typeof obj;
      return type === 'function' || type === 'object' && !!obj;
    }
//conversor titulo de tabla - Mas sencillo editar acá que por DB
function buscarHeaderTabla(textoABuscar){
    var texto="";

        switch (textoABuscar){
        case "id":
            texto="ID";
            break
        case "pat":         // TABLA PAT
            texto="PAT";
            break
        case "prioridad":
            texto="Prioridad";
            break;
        case "estado":
            texto="Estado";
            break;
        case "porcCompletado":
            texto="% Completado";
            break;
        case "asignadoA":
            texto="Asignado a";
            break;
        case "titulo":
            texto="Título";
            break;
        case "fechaDeApertura":
            texto="Fecha de \n apertura";
        case "fechaDeCierre":
            texto="Fecha de \n cierre";
            break;
        case "periodo":
            texto="Período";
            break;
        case "hsResolucion":
            texto="Horas de\n resolución";
            break;
        case "categoria":
            texto="Categoría";
            break;
        case "tipoDoc1":
            texto="Tipo\n Doc1";
            break;
        case "codif1":
            texto="Cod 1";
            break;
        case "estado1":
            texto="Estado 1";
            break;
        case "fecha1":
            texto="Fecha 1";
            break;
        case "tipoDoc2":
            texto="Tipo\n Doc2";
            break;
        case "codif2":
            texto="Cod 2";
            break;
        case "estado2":
            texto="Estado 2";
            break;
        case "fecha2":
            texto="Fecha 2";
            break;
        case "tipoDoc3":
            texto="Tipo\n Doc3";
            break;
        case "codif3":
            texto="Cod 3";
            break;
        case "estado3":
            texto="Estado 3";
            break;
        case "fecha3":
            texto="Fecha 3";
            break;
        case "tipoDoc4":
            texto="Tipo\n Doc4";
            break;
        case "codif4":
            texto="Cod 4";
            break;
        case "estado4":
            texto="Estado 4";
            break;
        case "fecha4":
            texto="Fecha 4";
            break;
        case "tipoDoc5":
            texto="Tipo\n Doc5";
            break;
        case "codif5":
            texto="Cod 5";
            break;
        case "estado5":
            texto="Estado 5";
            break;
        case "fecha5":
            texto="Fecha 5";
            break;
        case "observaciones":
            texto="Observaciones";
            break;
        case "tipoDeDocumento":      // TABLA DISTRIBUCION DOCUMENTOS
                texto="Tipo de\n Documento";
                break;
        case "codificacion":
                texto="Codificación";
                break;
        case "rdd":
                texto="RDD";
                break;
        case "cliente":
                texto="Cliente";
                break;
        case "fechaDistribucion":
                texto="Fecha de\n Distribución";
                break;
        case "fechaRecepcion":
                texto="Fecha de \n Recepción";
                break;
        case "ior":
                texto="IOR";
                break;
        case "respuestaIor":
                texto="Respuesta\n IOR";
                break;
        case "cierreIor":
                texto="Cierre IOR";
                break;
        case "registroEnvio":
                texto="Registro de Envío";
                break;
        case "isActive":
                texto="Activo";
                break;
        case "role":
                texto="Rol";
                break;
        case "nombre":
                texto="Usuario";
                break;
        case "username":
                texto="Usuario";
                break;
        case "attempts":
                texto="Intentos";
                break;
        default:
            texto=textoABuscar;
            break
        }

    return texto;
}