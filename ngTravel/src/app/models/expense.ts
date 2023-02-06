export class Expense {
  id: number;
  name: string;
  description: string;
  date: string;
  price: number;
  image: string;
  active: number;
  location: string;

  constructor(
  id: number = 0,
  name: string = '',
  description: string = '',
  date: string = '',
  price: number = 0,
  image: string = '',
  active: number = 0,
  location: string = ''


  ) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.date = date;
    this.price =price;
    this.image = image;
    this.active = active;
    this.location = location;

  }
}
