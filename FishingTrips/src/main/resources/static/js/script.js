console.log('script.js is loaded')

window.addEventListener('load', function(e){
	console.log('Page loaded')
	init();
	console.log('init loaded')
});

function init(){
	
	loadTrips();
	document.newTripForm.submit.addEventListener('click', createTrip);
	

}

function loadTrips(){
	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/trips');
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4) {
			if(xhr.status === 200){
				let tripsList = JSON.parse(xhr.responseText);
				console.log(tripsList);
				displayTrips(tripsList);
			}
			}
			else {
			
		}
	};
	xhr.send();
}

function displayTrips(tripsList){

	let tripTable = document.getElementById("tripTable")
		tripTable.textContent ="";
		let tableHead = document.createElement("thead");
		let headerRow = document.createElement("tr");
		let nameHeader = document.createElement("th");
		let descriptionHeader = document.createElement("th");
		let locationHeader = document.createElement("th");
		let totalPriceHeader = document.createElement("th");
		let startDateHeader = document.createElement("th");
		let endDateHeader = document.createElement("th");
		let activeHeader = document.createElement("th");

		nameHeader.textContent = "Name";
		descriptionHeader.textContent = "Description";
		locationHeader.textContent = "Location";
		totalPriceHeader.textContent = "Total Price";
		startDateHeader.textContent = "Start Date";
		endDateHeader.textContent = "End Date";
		activeHeader.textContent = "Active";

		headerRow.appendChild(nameHeader);
		headerRow.appendChild(descriptionHeader);
		headerRow.appendChild(locationHeader);
		headerRow.appendChild(totalPriceHeader);
		headerRow.appendChild(startDateHeader);
		headerRow.appendChild(endDateHeader);
		headerRow.appendChild(activeHeader);

		tableHead.appendChild(headerRow);
		tripTable.appendChild(tableHead);

	let tbody = document.createElement("tbody");
	tripTable.appendChild(tbody);
	
	for(let trip of tripsList) {

		if(trip.active == true ){
		
		let tr = document.createElement('tr');

		let tdId = document.createElement("td");
		let tdName = document.createElement('td');
		let tdDescription = document.createElement('td');
    	let tdLocation = document.createElement('td');
		let tdTotalPrice = document.createElement('td');
		let tdStartDate = document.createElement('td');
		let tdEndDate = document.createElement('td');
		let tdActive = document.createElement('td');


		tdId.textContent = trip.id;
    	tdName.textContent = trip.name;
		tdDescription.textContent = trip.description;
		tdLocation.textContent = trip.location;
    	tdTotalPrice.textContent = trip.totalPrice;
		tdStartDate.textContent = trip.startDate;
		tdEndDate.textContent = trip.endDate;
		tdActive.textContent = trip.active;

    	
    	
    	
    	tr.appendChild(tdName);
		tr.appendChild(tdDescription);
    	tr.appendChild(tdLocation);
    	tr.appendChild(tdTotalPrice);
    	tr.appendChild(tdStartDate);
		tr.appendChild(tdEndDate);
		tr.appendChild(tdActive);
    	tr.addEventListener("click", function(e){
			 displayTripDetails(trip);

		});
		tbody.appendChild(tr);
    	
    	
	}
}

	let agDiv = document.getElementById('agDiv');


	let h1 = document.createElement('h1');
		let count = 0
	for(let trip of tripsList) {
		if(trip.active == true){
		count = count + 1;
		
		}
	
	}
	h1.textContent = "Number of trips " + count;
		agDiv.appendChild(h1);
	console.log(tripAmount);
	
	
	
	
	
	
}

	function displayTripDetails(trip){
	let detailDiv = document.getElementById('TripDetails')
	detailDiv.textContent = "";
	let h1 = document.createElement('h1');
	h1.textContent = "Trip Info";
	detailDiv.appendChild(h1);
		
		let tbody = document.getElementsByTagName('tbody')[0];
			tbody.textContent = "";

		let tr = document.createElement('tr');

		let tdName = document.createElement('td');
		let tdDescription = document.createElement('td');
    	let tdLocation = document.createElement('td');
		let tdTotalPrice = document.createElement('td');
		let tdStartDate = document.createElement('td');
		let tdEndDate = document.createElement('td');
		let tdActive = document.createElement('td');

    	
    	tdName.textContent = trip.name;
		tdDescription.textContent = trip.description;
		tdLocation.textContent = trip.location;
    	tdTotalPrice.textContent = trip.totalPrice;
		tdStartDate.textContent = trip.startDate;
		tdEndDate.textContent = trip.endDate;
		tdActive.textContent = trip.tdActive;

		
		let updateBtn = document.createElement('button');
		
		updateBtn.id = trip.id;
		updateBtn.type = 'submit';
		updateBtn.textContent = 'Update Trip';
		updateBtn.addEventListener('click', function(e){
			editTripForm(trip);
		

		})
		let disableBtn = document.createElement('button');
		
		disableBtn.id = trip.id;
		disableBtn.type = 'submit';
		disableBtn.textContent = 'Disable Trip';
		disableBtn.addEventListener('click', function(e){
			disableTripForm(trip);
		

		})

    	
	
    	
    	tbody.appendChild(tr);
    	tr.appendChild(tdName);
		tr.appendChild(tdDescription);
    	tr.appendChild(tdLocation);
    	tr.appendChild(tdTotalPrice);
    	tr.appendChild(tdStartDate);
		tr.appendChild(tdEndDate);
		tr.appendChild(tdActive);
		tr.appendChild(updateBtn);
		tr.appendChild(disableBtn);


		
	}
	



		function editTripForm(trip){
			let updateDiv = document.createElement('div');
			  updateDiv.textContent = "";
			let updateForm = document.createElement('form');
      	updateForm.id = 'updateform'

		  let nameLabel =document.createElement('label');
		  nameLabel.name = "name"
		  nameLabel.textContent = "name: "
	
		  let updateName = document.createElement('input');
		  updateName.id = 'name';
		  updateName.placeholder = 'name';
		  updateName.value = trip.name;
	
		  let descriptionLabel = document.createElement('label');
		  descriptionLabel.name = "description"
		  descriptionLabel.textContent = "Description: "
	
		  let updateDescription = document.createElement('input');
		  updateDescription.id = 'description';
		  updateDescription.placeholder = 'Description';
		  updateDescription.type ="text";
		  updateDescription.value = trip.description;
	
		  let locationLabel = document.createElement('label');
		  locationLabel.name = 'location';
		  locationLabel.textContent = "Location: "
	
		  let updateLocation = document.createElement('input');
		  updateLocation.id = 'location';
		  updateLocation.placeholder = 'Location';
		  updateLocation.type = "text";
		  updateLocation.value = trip.location;

		  let totalPriceLabel = document.createElement('label');
		  totalPriceLabel.name = 'totalPrice';
		  totalPriceLabel.textContent = "Total Price: "
	
		  let updateTotalPrice = document.createElement('input');
		  updateTotalPrice.id = 'totalPrice';
		  updateTotalPrice.placeholder = 'Total Price';
		  updateTotalPrice.type = "text";
		  updateTotalPrice.value = trip.totalPrice;
	
		  let startDateLabel = document.createElement('label');
		  startDateLabel.name = 'startDate';
		  startDateLabel.textContent = "Start Date: "
	
		  let updateStartDate = document.createElement('input');
		  updateStartDate.id = 'startDate';
		  updateStartDate.placeholder = 'Start Date';
		  updateStartDate.type = "text";
		  updateStartDate.value = trip.startDate;
	
		  let endDateLabel = document.createElement('label');
		  endDateLabel.name = 'endDate';
		  endDateLabel.textContent = "End Date: "
	
		  let updateEndDate = document.createElement('input');
		  updateEndDate.id = 'endDate';
		  updateEndDate.placeholder = 'End Date';
		  updateEndDate.type = "text";
		  updateEndDate.value = trip.endDate;


		  let activeLabel = document.createElement('label');
		  activeLabel.name = 'active';
		  activeLabel.textContent = "Active: "
		 
	
		  let updateActive = document.createElement('input');
		  updateActive.id = 'active';
		  updateActive.placeholder = 'active';
		  updateActive.type = "text";
		  updateActive.value = trip.active;
	
		  let updateButton = document.createElement('button');
		  updateButton.id = updateButton;
		  updateButton.type = 'button'
		  updateButton.textContent = "Submit Update";

		  
	

		  updateForm.appendChild(nameLabel);
		  updateForm.appendChild(updateName);
		  updateForm.appendChild(descriptionLabel);
		  updateForm.appendChild(updateDescription);
		  updateForm.appendChild(locationLabel);
		  updateForm.appendChild(updateLocation);
		  updateForm.appendChild(totalPriceLabel);
		  updateForm.appendChild(updateTotalPrice);
		  updateForm.appendChild(startDateLabel);
		  updateForm.appendChild(updateStartDate);
		  updateForm.appendChild(endDateLabel)
		  updateForm.appendChild(updateEndDate)
		  updateForm.appendChild(activeLabel)
		  updateForm.appendChild(updateActive);
		  updateForm.appendChild(updateButton);
		  updateDiv.appendChild(updateForm);
		  detailDiv.appendChild(updateDiv);
		
			updateButton.addEventListener('click', function(e){
					e.preventDefault();

				let updateTrip = {
			id: trip.id,
			name: updateForm.name.value,
			description: updateForm.description.value,
			location: updateForm.location.value,
			totalPrice: updateForm.totalPrice.value,
			startDate: updateForm.startDate.value,
			endDate: updateForm.endDate.value,
			active: updateForm.active.value
		  
		   
		};
		console.log(updateTrip);
		let xhr = new XMLHttpRequest();
			
		xhr.open("PUT", "api/trips/" + trip.id);
		
		xhr.setRequestHeader("Content-type", "application/json");
		
		xhr.onreadystatechange = function() {
			if (xhr.readyState === 4) {
				if (xhr.status === 201) {
					let data = JSON.parse(xhr.responseText);
					console.log(data);
					loadTrips();
				}
				else {
					console.error("PUT request failed.");
							console.error(xhr.status + ': ' + xhr.responseText);
				  }
			}
		};

		detailDiv.textContent ="";
		let tripJson = JSON.stringify(updateTrip);
		xhr.send(tripJson);

			})


		}

		function disableTripForm(trip){
			let disableDiv = document.createElement('div');
			disableDiv.textContent = "";

			let disableForm = document.createElement('form');
			disableForm.id = 'disableForm'

			let activeLabel =document.createElement('label');
			activeLabel.name = "active"
			activeLabel.textContent = "active: "
			activeLabel.hidden = 'true';
	
		  let updateActive = document.createElement('input');
		  updateActive.id = 'active';
		  updateActive.placeholder = 'active';
		  updateActive.value = 'false';
	
	
		  let disableButton = document.createElement('button');
		  disableButton.id = disableButton;
		  disableButton.type = 'button'
		  disableButton.textContent = "Delete";


		  
		  disableForm.appendChild(updateActive)
		  disableForm.appendChild(disableButton);

	
		  disableDiv.appendChild(disableForm);
		  detailDiv.appendChild(disableDiv);
		
			disableButton.addEventListener('click', function(e){
					e.preventDefault();

				let disableTrip = {
			id: trip.id,
			active: disableForm.active.value,
	
		  
		   
		};
		console.log(disableTrip);
		let xhr = new XMLHttpRequest();
			
		xhr.open("PUT", "api/trips/" + trip.id);
		
		xhr.setRequestHeader("Content-type", "application/json");
		
		xhr.onreadystatechange = function() {
			if (xhr.readyState === 4) {
				if (xhr.status === 201) {
					let data = JSON.parse(xhr.responseText);
					console.log(data);
					loadTrips();
				}
				else {
					console.error("PUT request failed.");
							console.error(xhr.status + ': ' + xhr.responseText);
				  }
			}
		};

		detailDiv.textContent ="";
		let tripJson = JSON.stringify(disableTrip);
		xhr.send(tripJson);

			})


		}


		function createTrip(e) {
			e.preventDefault();
			let newTrip = {
				name: document.newTripForm.name.value,
				description: document.newTripForm.description.value,
				location: document.newTripForm.location.value,
				totalPrice: document.newTripForm.totalPrice.value,
				startDate: document.newTripForm.startDate.value,
				endDate: document.newTripForm.endDate.value,
			   image: document.newTripForm.image.value,
			   active: document.newTripForm.active.value
			
			};
				let xhr = new XMLHttpRequest();
				xhr.open('POST', 'api/trips');
				xhr.onreadystatechange = function() {
					console.log(xhr.readyState);
	
					if (xhr.readyState === 4) {
						console.log(xhr.status);
						if (xhr.status === 200 || xhr.status === 201) {
							let newTrip = JSON.parse(xhr.responseText);
							console.log(newTrip);
							loadTrips();
						} else {
							displayError('Failed to create new trip' + xhr.status);
						}
					}
				};
				xhr.setRequestHeader("Content-type", "application/json");
				document.newTripForm.reset();
				xhr.send(JSON.stringify(newTrip));
			}

