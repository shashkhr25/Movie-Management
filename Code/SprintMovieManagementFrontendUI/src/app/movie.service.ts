import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ThrowStmt } from '@angular/compiler';
import { MovieConstantsService } from './movie-constants.service';
import { BookingForm } from './Model/BookingForm';

@Injectable({
  providedIn: 'root'
})

/*************************************************************************************************************************
 *          @author          Shashwat khare, Gaurav vasasali, anand raj, chaitanya kumar, madan mohan reddy
 *          Description      This is a angular service file.
 *         Version             3.0
 *         Created Date    25-APR-2020
 *************************************************************************************************************************/
export class MovieService {

  constructor(private http: HttpClient) { 
  }
  
  public searchMovie(name: String) : Observable<any>{
    return this.http.get(MovieConstantsService.searchMovieUrl+name) ;
  }

  public searchShowsScreenName(screenName: String){
    return this.http.get(MovieConstantsService.searchShowsForScreen+screenName);
  }

  public showsForScreenMovieDate(screenName: String, movieId: number, movieDate:Date){
    return this.http.get(MovieConstantsService.searchShowsScreenMovieDate+screenName+"/"+movieId+"/"+movieDate);
  }

  public showsForScreenDate(screenName:String, movieDate:Date){
    return this.http.get(MovieConstantsService.searchShowsScreenDate+screenName+"/"+movieDate);
  }

  public showsForMovieDate(movieId:number, movieDate:Date){
    return this.http.get(MovieConstantsService.searchShowsMovieDate+movieId+"/"+movieDate);
  }



  public viewmovies(){
    return this.http.get(MovieConstantsService.viewmovies);
  }

  public viewnewmovies(){
    return this.http.get(MovieConstantsService.viewnewmovies);
  }


  public displayshows(movieId: number):Observable<any>{
    return this.http.get(MovieConstantsService.viewshows+movieId);
  }

  public displayscreens(movieId: number){
    return this.http.get(MovieConstantsService.viewscreens+movieId);
  }


  public bookmovie(form: BookingForm){
    return this.http.post(MovieConstantsService.bookmovie,form);
  }

  public cancelbooking(bookingId: String){
    return this.http.get(MovieConstantsService.cancelbooking+bookingId);
  }


  public searchDetails(contact:String) : Observable<any>
  {
    return this.http.get(MovieConstantsService.searchBookingDetails+contact);
  }

}
