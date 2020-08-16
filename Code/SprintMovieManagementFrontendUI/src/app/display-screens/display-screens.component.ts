import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MovieService } from '../movie.service';

@Component({
  selector: 'app-display-screens',
  templateUrl: './display-screens.component.html',
  styleUrls: ['./display-screens.component.css']
})
export class DisplayScreensComponent implements OnInit {

  movieId;
  screens:any;

  errorMsg:String;
  showError:boolean;
  showScreens:boolean;

  constructor(private service: MovieService, private route: ActivatedRoute) { 
  }

  ngOnInit() {
    this.route.paramMap.subscribe(params=>{
      this.movieId= params.get('movieId');
      
    this.service.displayscreens(this.movieId).subscribe(
      data=>{this.screens=data, this.showScreens=true},
      error=>{this.errorMsg=error.error.message,this.showError=true}
      )
    })
  }
}
