import { Expense } from './../models/expense';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, throwError } from 'rxjs';
import { Observable } from 'rxjs/internal/Observable';

import { environment } from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})
export class ExpenseService {

  private url = environment.baseUrl + 'api/expenses';

  constructor(private http: HttpClient) { }


  public index(): Observable<Expense[]> {
    return this.http.get<Expense[]>(this.url).pipe(
        catchError((err:any) => {
          console.log(err);
           return throwError(
             () =>
             new Error("Error")
           );
        })
      );
    }

    public create(newExpense : Expense){
      return this.http.post<Expense[]>(this.url, newExpense)
      .pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError('Error creating new expense.');
        })
      )

    }

    public show(id: number){
      return this.http.get<Expense>(this.url + "/" + id).pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError('Error displaying expense.');
        })
      )
    }
    public update(updatedExpense: Expense, id: number) {

      return this.http.put<Expense>(this.url + "/" + id, updatedExpense)
      .pipe(

        catchError((err : any)=>{
          console.log(err);
          return throwError('Error updating trip.');

        })
      )
    }

    public disable(id: number, expense: Expense) {
      return this.http.put<Expense>(this.url + "/delete/" + id, expense)
      .pipe(
        catchError((err : any) =>{
          console.log(err);
          return throwError("Error deleting trip.")

        })
      )
    }
}
