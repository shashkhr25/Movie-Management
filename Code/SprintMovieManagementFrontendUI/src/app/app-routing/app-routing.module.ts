import { NgModule } from '@angular/core';
import { SearchPageComponent } from '../search-page/search-page.component';
import { SearchShowsComponent } from '../search-shows/search-shows.component';
import { RecentMovieComponent } from '../recent-movie/recent-movie.component';
import { MovieComponent } from '../movie/movie.component';
import { DisplayShowsComponent } from '../display-shows/display-shows.component';
import { DisplayScreensComponent } from '../display-screens/display-screens.component';
import { BookMovieComponent } from '../book-movie/book-movie.component';
import { BookingDetailsComponent } from '../booking-details/booking-details.component';
import { CancelBookingComponent } from '../cancel-booking/cancel-booking.component';
import { SearchMovieComponent } from '../search-movie/search-movie.component';
import { RouterModule, Routes} from '@angular/router';

const appRoutes:Routes=[
  {path:'',component:RecentMovieComponent},
  {path:'displayshows/:movieId',component:DisplayShowsComponent},
  {path:'displayscreens/:movieId',component:DisplayScreensComponent},
  {path:'displayAllMovies', component: MovieComponent},
  {path:'bookingDetails',component:BookingDetailsComponent},
  {path:'book/:showId',component:BookMovieComponent},
  {path:'searchMovie',component:SearchMovieComponent},
  {path:'searchPage',component:SearchPageComponent},
  {path:'searchShow',component:SearchShowsComponent},
  {path:'cancelBooking/:bookingId',component:CancelBookingComponent}]
  
@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
