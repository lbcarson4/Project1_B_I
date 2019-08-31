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
});

function setReimValues(reim) {
	let table = document.querySelector('tbody');
    for (let i = 0; i < reim.length; i++) {    	
        var tr = table.appendChild(document.createElement('tr'));
        var values = Object.values(reim[i]);
        for (var j = 0; j < values.length; j++) {
        	
        	if (j < 4  || j > 6) {
        		console.log(values[j]);
        		var td = tr.appendChild(document.createElement('td'));
        		
        		if ((j === 2 || j === 3) && values[j] !== null) {
            		td.innerHTML = new Date(values[j]).toISOString().slice(0, 10);
            	} else {
            		td.innerHTML = values[j];
            	}
        	}
        }
    }
}



         
