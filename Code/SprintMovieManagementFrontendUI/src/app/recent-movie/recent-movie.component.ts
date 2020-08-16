import { Component, OnInit } from '@angular/core';
import { MovieService } from '../movie.service';

@Component({
  selector: 'app-recent-movie',
  templateUrl: './recent-movie.component.html',
  styleUrls: ['./recent-movie.component.css']
})
export class RecentMovieComponent implements OnInit {

  movies: any;

  errorMsg:string;
  showRecentMovies:boolean;
  showError:boolean;

  constructor(private service: MovieService) { }

  ngOnInit() {
    this.service.viewnewmovies().subscribe(
      data=>{this.movies=data,this.showRecentMovies=true},
      error=>{this.errorMsg=error.error.message,this.showError=true}      
      );
  }


}
