document.getElementById("ConsultaDB").addEventListener("click", findAll);

async function findAll(){

    var e = document.getElementById("tipo-consulta");
    var opcionConsulta = e.options[e.selectedIndex].value;

    switch(opcionConsulta){
        case "pat":
            var myJson= await getPats();
            break;
        case "distribDocs":
            var myJson= await getDistribDocs();
            break;
        default:
            var myJson= await getPats();
            console.log("opcion no valida")
            break;
    }

    var listIntegrantes =await getIntegrantes();


    var table = document.createElement("table");
    table.className="table table-striped align-middle";
    var rows=myJson.length;
    if (rows>0){
        var cellsHeader=_keys(myJson[0])
    }
    if (cellsHeader.length > 1) {
        var thead=table.createTHead();
        var rowh = thead.insertRow(0);
        for (var j = 0; j < cellsHeader.length; j++) {
            var cell = rowh.insertCell(-1);
            cell.innerHTML = buscarHeaderTabla(cellsHeader[j]);
        }
    var tbody=table.createTBody();
    for (var i = 0; i < rows; i++) {
        var cells = myJson[i].length;

            var row = tbody.insertRow(-1);
            for (var propt in myJson[i]){
                var cell = row.insertCell(-1);
                if (propt =="asignadoA"){
                    cell.innerHTML=buscarIntegrante(listIntegrantes,myJson[i][propt])
                } else {
                    cell.innerHTML=myJson[i][propt];
                }
            }

    }
    var dvCSV = document.getElementById("dvCSV");
    dvCSV.innerHTML = "";
    dvCSV.appendChild(table);
    }

}


async function getPats(){
    var urlDomain = 'http://' + window.location.host + '/pat/lista';
    const response = await fetch(urlDomain);
    const myJson = await response.json();

    return myJson;
}
async function getIntegrantes(){
    var urlDomain = 'http://' + window.location.host + '/integrantes/lista';
    const response = await fetch(urlDomain);
    const myJson = await response.json();

    return myJson;
}

async function getDistribDocs(){
    var urlDomain = 'http://' + window.location.host + '/distribDocs/lista';
    const response = await fetch(urlDomain);
    const myJson = await response.json();

    return myJson;
}


//busqueda integrantes
function buscarIntegrante(objList, numId){

    for (var i=0; i < objList.length; i++){
        if (objList[i]["id"] == numId){
        return (objList[i]["nombre"]+" "+objList[i]["apellidos"])
        }

    }


return "Integrante no encontrado"
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
        case "CierreIor":
                texto="Cierre IOR";
                break;
        case "registroEnvio":
                texto="Registro de Envío";
                break;
        default:
            texto=textoABuscar;
            break
        }

    return texto;
}