import { Movie } from './movie'
export class Show{
    showId:number;
    showName:string;
    seats:number;
    showDate:string;
    screenName:string;
    screenImg:string;
    movie:Movie = new Movie();
}