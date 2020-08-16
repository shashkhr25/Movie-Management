import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
/*************************************************************************************************************************
 *          @author          Shashwat khare, Gaurav vasasali, anand raj, chaitanya kumar, madan mohan reddy
 *          Description      This is a angular constants service file.
 *         Version             3.0
 *         Created Date    25-APR-2020
 *************************************************************************************************************************/
export class MovieConstantsService {

    public static base_url= "http://localhost:8083/moviemanagement/";

    public static searchMovieUrl =MovieConstantsService.base_url+"searchmovie/"; 
    public static searchShowsForScreen = MovieConstantsService.base_url+"showsforscreen/";
    public static searchShowsScreenMovieDate =  MovieConstantsService.base_url+"viewshowsforscreenmoviedt/";
    public static searchShowsScreenDate = MovieConstantsService.base_url+"viewshowsforscreendt/";
    public static searchShowsMovieDate= MovieConstantsService.base_url+"viewshowsfordatemovieid/"; 
    
    
    public static viewmovies =MovieConstantsService.base_url+"viewmovies/"; 
    public static viewnewmovies = MovieConstantsService.base_url+"viewnewmovies/";
  

    public static viewshows =MovieConstantsService.base_url+"viewshows/"; 
    public static viewscreens =MovieConstantsService.base_url+"viewscreen/"; 

    public static bookmovie= MovieConstantsService.base_url +"booking/";
    public static cancelbooking= MovieConstantsService.base_url+ "cancelbooking/";

    public static searchBookingDetails = MovieConstantsService.base_url+'getbooking/';

  
  constructor() { }
}
