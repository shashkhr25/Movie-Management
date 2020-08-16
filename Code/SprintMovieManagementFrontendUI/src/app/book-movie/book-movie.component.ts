import { Component, OnInit, ViewChild } from '@angular/core';
import { BookingForm } from '../Model/BookingForm';
import { NgForm } from '@angular/forms';
import { MovieService } from '../movie.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-book-movie',
  templateUrl: './book-movie.component.html',
  styleUrls: ['./book-movie.component.css']
})
export class BookMovieComponent implements OnInit {

  bookForm: BookingForm= new BookingForm();
  msg;
  errorMsg:String;
  showMessage:boolean;
  showError:boolean;

  showId;

  @ViewChild('Form')
  form:NgForm;

  constructor(private service : MovieService, private route: ActivatedRoute) { }

  ngOnInit() {
      this.route.paramMap.subscribe(params=>{
      this.showId=params.get('showId');
      this.bookForm.showId=this.showId;
    })
  }

  bookMovie(){
    this.service.bookmovie(this.bookForm).subscribe(
      data=>{this.msg=data,this.showMessage=true},
      error=>{this.errorMsg=error.error.message,this.showError=true}
      );
    this.form.resetForm();
  }

}
