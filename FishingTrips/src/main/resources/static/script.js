console.log('script.js is loaded')

window.addEventListener('load', function(evt){
	console.log('Page loaded')
	init();
});

function init(){
	loadTrips();
	
}

function loadTrips(){
	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/trips');
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4) {
			if(xhr.status === 200){
				let standList = JSON.parse(xhr.reponseText);
				console.log(standList);
				displayTrips(standList);
			}
			else {
				
			}
		}
	};
	xhr.send();
}

function displayTrips(tripsStandList){
	
}
