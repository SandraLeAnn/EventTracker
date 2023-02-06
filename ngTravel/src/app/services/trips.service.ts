
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, throwError } from 'rxjs';
import { Observable } from 'rxjs/internal/Observable';

import { environment } from 'src/environments/environment';
import { Trip } from '../models/trip';

@Injectable({
  providedIn: 'root'
})
export class TripsService {

  private url = environment.baseUrl + 'api/trips';

  constructor(private http: HttpClient) { }

  // getHttpOptions() {
  //   let options = {
  //     headers: {
  //       Authorization: 'Basic ' + this.auth.getCredentials(),
  //       'X-Requested-With': 'XMLHttpRequest',
  //     },
  //   };
  //   return options;
  // }

   public index(): Observable<Trip[]> {
    return this.http.get<Trip[]>(this.url).pipe(
        catchError((err:any) => {
          console.log(err);
           return throwError(
             () =>
             new Error("Error")
           );
        })
      );
    }

    public create(newTrip : Trip){
      return this.http.post<Trip[]>(this.url, newTrip)
      .pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError('Error creating new trip.');
        })
      )

    }

public show(id: number){
  return this.http.get<Trip>(this.url + "/" + id).pipe(
    catchError((err: any) => {
      console.log(err);
      return throwError('Error displaying trip.');
    })
  )
}
public update(updatedTrip: Trip, id: number) {

  return this.http.put<Trip>(this.url + "/" + id, updatedTrip)
  .pipe(

    catchError((err : any)=>{
      console.log(err);
      return throwError('Error updating trip.');

    })
  )
}
public disable(id: number, trip: Trip) {
  return this.http.put<Trip>(this.url + "/delete/" + id,trip)
  .pipe(
    catchError((err : any) =>{
      console.log(err);
      return throwError("Error deleting trip.")

    })
  )
}
    //find all, show(id), update(id, trip), create(trip),destroy(id)

  }
