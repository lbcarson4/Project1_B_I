(window.onload = () => {
    let xhttp = new XMLHttpRequest();
    xhttp.responseType = '';
    xhttp.open('GET', 'http://localhost:8080/ERS_Application_JDBC/TableView.do', true);

    xhttp.onreadystatechange = () => {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            let r = xhttp.responseText;
            let reim = JSON.parse(r);
            setReimValues(reim);
        }
    }
    xhttp.send();
})();

function setReimValues(reim) {
	let table = document.querySelector('tbody');
    for (let i = 0; i < reim.length; i++) {    	
        let tr = table.appendChild(document.createElement('tr'));
        let values = Object.values(reim[i]);
        for (var j = 0; j < values.length; j++) {
        	if (j < 4  || j > 6) {
        		let td = tr.appendChild(document.createElement('td'));
        		if ((j === 2 || j === 3) && values[j] !== null) {
        			td.innerHTML = new Date(values[j]).toString().slice(0,25);
            	} else {
            		td.innerHTML = values[j];
            	}
        	}
        }
        tr.addEventListener('click', (url) => {
        	popUpWindow = window.open('', 'popUpWindow', 'height=350,width=400,left=1450,top=200,resizable=0,scrollbars=0,toolbar=0,menubar=0,location=0,directories=0,status=yes');
        	popUpWindow.document.write('<h1>Description:</h1>');
       		popUpWindow.document.write(reim[i].description);
       		setTimeout(() => {popUpWindow.close();},5000);
        });
    }
}

function searchTable() {
	  // Declare variables
	  let input, filter, table, tr, td, i, txtValue;
	  input = document.getElementById("myInput");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("myTable");
	  tr = table.getElementsByTagName("tr");

	  // Loop through all table rows, and hide those who don't match the search query
	  for (i = 0; i < tr.length; i++) {
	    td = tr[i].getElementsByTagName("td")[document.getElementById("type").value];
	    if (td) {
	      txtValue = td.textContent || td.innerText;
	      if (txtValue.toUpperCase().indexOf(filter) > -1) {
	        tr[i].style.display = "";
	      } else {
	        tr[i].style.display = "none";
	      }
	    } 
	  }
}