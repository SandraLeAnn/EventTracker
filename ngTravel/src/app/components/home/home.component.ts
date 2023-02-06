import { ExpenseService } from './../../services/expense.service';
import { Expense } from './../../models/expense';
import { TripsService } from '../../services/trips.service';
import { Component, OnInit } from '@angular/core';
import { Trip } from 'src/app/models/trip';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  trips: Trip[] = [];

  newTrip: Trip = new Trip();

  editTrip: Trip | null = null;

  selected: Trip | null = null;

  display: boolean = false;
  displayUpdate: boolean =false;

  tripExpenses: Expense[] = [];

  newExpense: Expense = new Expense();

  editExpense: Expense | null = null;

  selectedExpense: Expense | null = null;
  displayExpense: boolean = false;
  displayExpenseForm: boolean = false;

  constructor( private TripsService: TripsService, private ExpenseService: ExpenseService){
  }

  ngOnInit(){
    this.reload();
    this.reloadExpense();
  }

  reload(){
    this.TripsService.index().subscribe({
      next: (data) => {
        this.trips = data;
        console.log(this.trips);

      },
      error: (oof: any) =>{
        console.error('Error loading trip list:');
        console.error(oof);
      }
    });


  }
  reloadExpense(){
    this.ExpenseService.index().subscribe({
      next: (data) => {
        this.tripExpenses = data;
        console.log(this.tripExpenses);

      },
      error: (oof: any) =>{
        console.error('Error loading trip list:');
        console.error(oof);
      }
    });


  }



  //  ---------------------     TRIPS     --------------------
  showTrip(id:number){
    this.TripsService.show(id).subscribe({
      next: (data: Trip) => {
        this.selected = data;
        console.log(this.trips);

      },
      error: (oof: any) =>{
        console.error('Error loading trip list:');
        console.error(oof);
      }
    });
  }




    addTrip(newTrip : Trip){
  this.TripsService.create(newTrip).subscribe(
  success=>{
    this.reload();
    this.newTrip = new Trip();
  },
  error => console.log("Adding Oberservable got an error")
  );
  }

  updateTrip(updatedTrip : Trip, id: number){
  this.TripsService.update(updatedTrip, id).subscribe({
    next: (data: Trip) =>{
      this.reload();
      this.newTrip = updatedTrip;
      console.log(this.editTrip);
      if(this.selected){
        this.selected = Object.assign({}, updatedTrip)
      }

    }
  })

}
disableTrip(id: number, trip: Trip){
  this.TripsService.disable(id, trip).subscribe({
    next: (data: Trip) =>{
      this.reload();

      console.log(this.disableTrip);
      if(this.selected){
        this.selected.id = Object.assign({}, id)
      }

    }
  })

}

  //  ---------------------     Expenses     --------------------



  showExpenses(id:number){
    this.ExpenseService.show(id).subscribe({
      next: (data: Expense) => {
        this.selectedExpense = data;
        console.log(this.tripExpenses);

      },
      error: (oof: any) =>{
        console.error('Error loading expense list:');
        console.error(oof);
      }
    });
  }


  selectThisExpense(expense:Expense) {

      this.selectedExpense = expense;
  }




}

