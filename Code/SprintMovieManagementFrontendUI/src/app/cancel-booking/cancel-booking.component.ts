import { Component, OnInit } from '@angular/core';
import { MovieService } from '../movie.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-cancel-booking',
  templateUrl: './cancel-booking.component.html',
  styleUrls: ['./cancel-booking.component.css']
})
export class CancelBookingComponent implements OnInit {

  bookingId;

  msg;
  errorMessage:String;

  showError:Boolean;
  showMessage:Boolean;

  constructor(private service: MovieService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.paramMap.subscribe(params=>{
      this.bookingId=params.get("bookingId");
    })

    this.service.cancelbooking(this.bookingId).subscribe(
      data=>{this.msg=data, this.showMessage=true},
      error=>{this.errorMessage=error.error.message, this.showError=true}
    )
  }

}
