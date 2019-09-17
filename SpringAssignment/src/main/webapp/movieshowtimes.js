(window.onload = () => {
    let xhttp = new XMLHttpRequest();
    xhttp.responseType = '';
    xhttp.open('GET', 'http://localhost:9005/SpringAssignment/getAllShowtimes.do', true);

    xhttp.onreadystatechange = () => {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            let r = xhttp.responseText;
            let movies = JSON.parse(r);
            let table = document.querySelector('tbody');
            setMovieValues(movies, table);
        }
    }
    xhttp.send();
});

function setMovieValues(movies, table) {
    for (let i = 0; i < movies.length; i++) {    	
        let tr = table.appendChild(document.createElement('tr'));
        let values = Object.values(movies[i]);
        for (var j = 0; j < values.length; j++) {
        	let td = tr.appendChild(document.createElement('td'));
           	td.innerHTML = values[j];
        }
    }
}

function myFunction() {
	let xhttp2 = new XMLHttpRequest();
	xhttp2.responseType = '';
	let movieName = document.getElementById("movieInput").value;
	console.log(movieName);
    xhttp2.open('GET', 'http://localhost:9005/SpringAssignment/' + movieName + '/getMovie.do', true);
    
    xhttp2.onreadystatechange = function() {
    	if (xhttp2.readyState == 4 && xhttp2.status == 200) {
    		let movies = JSON.parse(xhttp2.responseText);
    		let showtimes = Object.values(movies[0]);
    		let para = document.createElement("p");
    		let node = document.createTextNode("Movie Showtimes: " + showtimes);
    		para.appendChild(node);

    		let element = document.getElementById("showTimes");
    		element.appendChild(para);
    	}
    }
    xhttp2.send();
}