window.onload= findDocumentLinks();

async function findDocumentLinks(){

var urlManual1 = '/static-docs/LIVE-DOCS/Manual1/';
var pathManual1 = '/archivos/lista-Manual1';
var fileList = await getFiles(pathManual1);
document.getElementById("manual1").href = urlManual1 + fileList[0]['fileName'];

var urlManual2 = '/static-docs/LIVE-DOCS/Manual2/';
var pathManual2 = '/archivos/lista-Manual2';
var fileList = await getFiles(pathManual2);
document.getElementById("manual2").href = urlManual2 + fileList[0]['fileName'];

var urlManual3 = '/static-docs/LIVE-DOCS/Manual3/';
var pathManual3 = '/archivos/lista-Manual3';
var fileList = await getFiles(pathManual3);
document.getElementById("manual3").href = urlManual3 + fileList[0]['fileName'];


var urlForm = '/static-docs/LIVE-DOCS/Form/';
var pathForm = '/archivos/lista-Formularios';
var aFormClass="list-group-item list-group-item-action";
var pilFormClass="badge bg-info rounded-pill";
var fileList = await getFiles(pathForm);
document.getElementById("lista-form").innerHTML = "";


fileList.forEach(function(file){
        var urlAnchor=urlForm+file['fileName'];
        var tempText=file['fileName'].split('_')

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
        document.getElementById("lista-form").appendChild(anchor);
})
//document.getElementById("formularios").style.height= document.getElementById("lista-form").style.height+"100px"

}


async function getFiles(path){
var urlDomain = 'http://' + window.location.host + path;
    const response = await fetch(urlDomain);
    const myFiles = await response.json();

return myFiles
}