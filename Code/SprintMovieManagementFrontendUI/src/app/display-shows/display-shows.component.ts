import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MovieService } from '../movie.service';
import { Show } from '../Model/show';

@Component({
  selector: 'app-display-shows',
  templateUrl: './display-shows.component.html',
  styleUrls: ['./display-shows.component.css']
})
export class DisplayShowsComponent implements OnInit {


  movieId;
  shows:any;

  errorMsg:String;
  showMovieShows:boolean;
  showError:boolean;
  constructor(private service: MovieService, private route: ActivatedRoute) { 
  }

  ngOnInit() {
    this.route.paramMap.subscribe(params=>{
       this.movieId= params.get('movieId');
       this.service.displayshows(this.movieId).subscribe(
        data=>{this.shows=data,this.showMovieShows=true},
        error=>{this.errorMsg=error.error.message,this.showError=true}
        );
    })
   
     
  }

}
