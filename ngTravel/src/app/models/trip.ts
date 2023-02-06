import { Expense } from './expense';
export class Trip {

  id: number;
  name: string;
  description: string;
  location: string;
  totalPrice: number;
  startDate: string;
  endDate: string;
  image: string;
  active: number;
  expenses: Expense[];


  constructor(
  id: number = 0,
  name: string = '',
  description: string = '',
  location: string = '',
  totalPrice: number = 0,
  startDate: string = '',
  endDate: string = '',
  image: string = '',
  active: number = 0,
  expenses: Expense[] = new Array


  ) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.location = location;
    this.totalPrice =totalPrice;
    this.startDate = startDate;
    this.endDate = endDate;
    this.image = image;
    this.active = active;
    this.expenses = expenses;

  }

}
