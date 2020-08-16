import { Component, OnInit } from '@angular/core';
import { MovieService } from '../movie.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-booking-details',
  templateUrl: './booking-details.component.html',
  styleUrls: ['./booking-details.component.css']
})
export class BookingDetailsComponent implements OnInit {

  contact:String;
  bookingList:any;

  errorMsg:String;
  showBookingDetails:boolean;
  showError:boolean;

  today=new Date();

  constructor(private service: MovieService) { }

  ngOnInit() {
  }

  searchDetails(form: NgForm)
  {
    this.service.searchDetails(this.contact).subscribe(
      data=>{this.bookingList=data,this.showBookingDetails=true},
      error=>{this.errorMsg=error.error.message,this.showError=true}
      )  
      form.resetForm();
  } 


}
