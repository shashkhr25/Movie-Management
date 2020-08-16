import { BrowserModule } from '@angular/platform-browser';
import { NgModule, Component } from '@angular/core';
import { NgForm, FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing/app-routing.module';
import { SearchPageComponent } from './search-page/search-page.component';
import { SearchShowsComponent } from './search-shows/search-shows.component';
import { RecentMovieComponent } from './recent-movie/recent-movie.component';
import { MovieComponent } from './movie/movie.component';
import { DisplayShowsComponent } from './display-shows/display-shows.component';
import { DisplayScreensComponent } from './display-screens/display-screens.component';
import { BookMovieComponent } from './book-movie/book-movie.component';
import { BookingDetailsComponent } from './booking-details/booking-details.component';
import { CancelBookingComponent } from './cancel-booking/cancel-booking.component';
import { SearchMovieComponent } from './search-movie/search-movie.component';

@NgModule({
  declarations: [
    AppComponent,
    SearchMovieComponent,
    SearchPageComponent,
    SearchShowsComponent,
    RecentMovieComponent,
    MovieComponent,
    DisplayShowsComponent,
    DisplayScreensComponent,
    BookMovieComponent,
    BookingDetailsComponent,
    CancelBookingComponent


  ],
  imports: [
    BrowserModule, FormsModule,  HttpClientModule, AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
