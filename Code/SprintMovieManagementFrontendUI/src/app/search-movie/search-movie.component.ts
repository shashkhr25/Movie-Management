import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { MovieService } from '../movie.service';
import { combineLatest } from 'rxjs';

/*************************************************************************************************************************
 *          @author          Shashwat khare
 *          Description      This is a type script file to the search movie component, which contacts with movie service.
 *         Version             1.0
 *         Created Date    25-APR-2020
 *************************************************************************************************************************/
@Component({
  selector: 'app-search-movie',
  templateUrl: './search-movie.component.html',
  styleUrls: ['./search-movie.component.css']
})
export class SearchMovieComponent implements OnInit {


  movieList:any ;
  name:string;
  toggleMovieList:boolean =false;

  errorMsg: string;
  showError:boolean;

  constructor(private movieService :MovieService) {
  }

  ngOnInit() {
 }

  searchMovie(form: NgForm){
    this.showError=false;
    this.toggleMovieList=false;
    
    this.movieService.searchMovie(this.name).subscribe(
     data=>{this.movieList=data,this.toggleMovieList=true},
     error=>{this.errorMsg=error.error.message, this.showError=true}
    );
     form.resetForm();
  }

}
