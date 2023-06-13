document.getElementById("ConsultaDB").addEventListener("click", findAllPats);

async function findAllPats(){

    var myJson= await getPats();

    var table = document.createElement("table");
    table.className="table table-striped align-middle";
    var rows=myJson.length;
    if (rows>0){
        var cells=_keys(myJson[0])
    }
    if (cells.length > 1) {
        var thead=table.createTHead();
        var rowh = thead.insertRow(0);
        for (var j = 0; j < cells.length; j++) {
            var cell = rowh.insertCell(-1);
            cell.innerHTML = cells[j];
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
    var dvCSV = document.getElementById("dvCSV");
    dvCSV.innerHTML = "";
    dvCSV.appendChild(table);
    }

}


async function getPats(){

    const response = await fetch('http://localhost:8080/pat/lista');
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
