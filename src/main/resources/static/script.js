const BASE_URL="/api";
//load room
function loadRoom()
{
	fetch(`${BASE_URL}/rooms`)
	.then(response => response.json())
	.then(rooms=>
		{
			const container=document.getElementById('roomContainer')
			container.innerHTML=``;
			rooms.forEach(room =>
				{
					container.innerHTML+= `
					<div  class="col-md-4 mb-4">
					<div class="card">
					<img src="pexels-vinod-c-1862669-5860693.jpg" class="card-img-top" alt="Room Image">
					<div class="card-body">
					<h5 class="card-title">RoomNo:${room.roomNo}(ID:${room.roomId})</h5>
					<p class="card-text">Type:${room.roomType}</p>
					<p class="card-text">Price:${room.PricePerNight}/night</p>
					<p class="card-text">Available:${room.Available ?"yes":"no"}</p>
					</div>
					</div>
					</div>
					`;})
				;})
				.catch(error => console.error('room fetch error',error))
}

//loadBooking
function loadBooking()
{
	fetch(`${BASE_URL}/bookings`)
	.then(response => response.json())
	.then(bookings=>
		{
			const container=document.getElementById('BookingContainer');
			container.innerHTML =``;
			bookings.forEach(booking =>
				{
					container.innerHTML +=`
					<div class="col-md-4 mb-4">
					<div class="card">
					<div class="card-body">
					<h5 class="my-5 card-title">Booking ID: ${booking.bookingId}</h5>
					<p class="card-text">RoomNo:${booking.room.roomNo}(ID:${booking.room.roomId})</p>
					<p class="card-text">UserName:${booking.user.username}</p>
					<p class="card-text">CheckInDate:${booking.checkInDate}</p>
					<p class="card-text">CheckOutDate:${booking.checkOutDate}</p>
					<p class="card-text">Status:<strong>${booking.status}</strong></p>
					<p class="card-text">Total Price:${booking.totalprice}</p>
					
					${booking.status==='CONFIRMED'
						?`<button class="btn btn-danger cancelBtn" data-id="${booking.bookingId}">CANCEL BOOKING</button>`
					:``}
					</div>
					</div>
					</div>
					`;})
;
document.querySelectorAll('.cancelBtn').forEach(btn=>
	{
		btn.addEventListener('click',()=> cancelBooking(btn.dataset.id));
	});	
})
.catch(error =>console.error('booking found error',error));
}

document.getElementById('bookingForm').addEventListener('submit', function (e) {
    e.preventDefault();

    const roomId = document.getElementById('roomId').value;
    const userId = document.getElementById('userId').value;
    const checkInDate = document.getElementById('checkInDate').value;
    const checkOutDate = document.getElementById('checkOutDate').value;

    const url = `${BASE_URL}/bookings?roomId=${roomId}&userId=${userId}&checkInDate=${checkInDate}&checkOutDate=${checkOutDate}`;

    fetch(url, { method: 'POST' })
        .then(response => {
            if (!response.ok) {
                return response.json().then(err => { throw new Error(err.message); });
            }
            return response.json();
        })
        .then(data => {
            document.getElementById('bookingMessage').innerHTML =
                `<div class="alert alert-success mt-3">Booking successful! Booking ID: ${data.bookingId}</div>`;
            loadRoom();
            loadBooking();
        })
        .catch(error => {
            document.getElementById('bookingMessage').innerHTML =
                `<div class="alert alert-danger mt-3">Error: ${error.message}</div>`;
        });
});

//cancelBooking
function cancelBooking(bookingId)
{
    fetch(`${BASE_URL}/bookings/${bookingId}/cancel`, { method: 'PUT' })
        .then(response => response.text())
        .then(message => {
            alert(message);
            loadRoom();
            loadBooking();
        })
        .catch(error => console.error('Error cancelling booking', error));
}


loadRoom();
loadBooking();
