window.onload= findDocumentLinks();

async function findDocumentLinks(){


var urlForm = '/static-docs/LIVE-DOCS/Cli2/';
var pathForm = '/archivos/lista-Cli2';
var aFormClass="list-group-item list-group-item-action";
var pilFormClass="badge bg-info rounded-pill";
var fileList = await getFiles(pathForm);
document.getElementById("lista-cli").innerHTML = "";


fileList.forEach(function(file){
        var urlAnchor=urlForm+file['fileName'];
        var tempText=file['fileName'].split('.')

        if (tempText.length != 2){  // control de nombre de archivo
        console.log("Error en codificacion de nombre en:" + file['fileName']);
        } else {

            var anchorText= tempText[0];
            var pillText=tempText[1];

            var anchor=document.createElement("a");
            anchor.className=aFormClass;
            anchor.innerHTML=anchorText+" ";
            anchor.href=urlAnchor;

            var pill=document.createElement("span");
            pill.className=pilFormClass;
            pill.innerHTML=pillText;

            anchor.appendChild(pill);
            document.getElementById("lista-cli").appendChild(anchor);
        }
})
//document.getElementById("formularios").style.height= document.getElementById("lista-form").style.height+"100px"

}


async function getFiles(path){
var urlDomain = 'http://' + window.location.host + path;
    const response = await fetch(urlDomain);
    const myFiles = await response.json();

return myFiles
}