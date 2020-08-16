import { Component, OnInit } from '@angular/core';
import { MovieService } from '../movie.service';
import { NgForm } from '@angular/forms';
import { formArrayNameProvider } from '@angular/forms/src/directives/reactive_directives/form_group_name';

@Component({
  selector: 'app-search-shows',
  templateUrl: './search-shows.component.html',
  styleUrls: ['./search-shows.component.css'],
 
})
/*************************************************************************************************************************
 *          @author          Shashwat khare
 *          Description      This is a type script file to the search movie component, which contacts with movie service.
 *         Version             1.0
 *         Created Date    25-APR-2020
 *************************************************************************************************************************/
export class SearchShowsComponent implements OnInit {

  screenname:String;
  moviedate:Date;

  show: any;

  toggleShowList;

  errorMsg:string;
  showError:boolean;

  constructor(private service: MovieService) { }

  ngOnInit() {
  }

  searchShow(form: NgForm){
    this.showError=false;
    this.toggleShowList=false;
    
    if(this.screenname!=null && this.moviedate==null){
      this.service.searchShowsScreenName(this.screenname).subscribe(data=>{this.show=data,this.toggleShowList=true},
        error=>{this.errorMsg=error.error.message, this.showError=true});
    }

    if(this.screenname!=null && this.moviedate!=null){
      this.service.showsForScreenDate(this.screenname,this.moviedate).subscribe(data=>{this.show=data,this.toggleShowList=true},
        error=>{this.errorMsg=error.error.message, this.showError=true}
        );
    }
    form.resetForm();
  }
}
