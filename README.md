
<!-- PROJECT LOGO -->

<!-- TABLE OF CONTENTS -->

<details>
  <summary>Table of Contents</summary>
  <ul>
    <li>
      <a href="#about-the-project">About Event Tracker Project</a>
  </ul>
      <ul>
        <li><a href="#technologies-used">Technologies Used</a></li>
      </ul>
    </li>
  <ul>
    <li><a href="#howitworks">How It Works</a></li>
  </ul>  
  <ul>
    <li><a href="#contact">Contact</a></li>
  </ul>

  <ul>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
    </ul>

</details>

<!-- ABOUT THE PROJECT -->

## About Event Tracker Project


<p>
This project tracks a users fishing and travel experiences across the globe. A user has the ability to create a travel experience and the expenses associated with it. They are also able to update and delete their experiences and expenses as well as their personal profile.
 </p>



<p align="right">(<a href="#top">back to top</a>)</p>

### Technologies Used
-   [Eclipse](https://spring.io/tools)
-   [Atom Text Editor](https://atom.io/)
-   [Java](https://www.java.com/en/)
-   [GITHUB](https://github.com)
-   JSON
-   Javascript  
-   REST
-   MySQL
-   Repositories

<p align="right">(<a href="#top">back to top</a>)</p>

## How It Works

<p>
The event tracker I created is specific to tracking a users fishing/travel habits and expenses associated with it.
This event tracker uses repositories in combination with services to avoid needing to used jpql queries in order to find data within the database. I implemented optional to locate an object by id. Which was then used in various crud operations for each entity. I used json in my postman to test the database connection and crud operations across all entities. While testing mapping with postman I had to use json ignore within my entities in order to prevent serialization. At this time the event tracker is successfully preforming full crud.
</P>

| HTTP Verb | URI                  | Request Body | Response Body | Purpose |
|-----------|----------------------|--------------|---------------|---------|
| GET       | `/api/trips`     |              | Collection of representations of all trips  | **List** or **collection** endpoint |
| GET       | `/api/trips/1`   |              | Representation of trip `1` | **Retrieve** endpoint |
| POST      | `/api/trips/1`     | Representation of a new trip | New trip created | **Create** endpoint |
| PUT       | `/api/trip/1`   | Representation of a  trip `1` | Updates trip with ID `1`| **Replace** endpoint |
| PUT       | `/api/trip/delete/1`   | Representation of a  trip `1` | Disables trip with ID `1`| **Replace** endpoint |
| GET       | `/api/user`     |              | Collection of representations of all user  | **List** or **collection** endpoint |
| GET       | `/api/user/1`   |              | Representation of user with ID `1` | **Retrieve** endpoint |
| POST      | `/api/user/1`     | Representation of a new user | New user created | **Create** endpoint |
| PUT       | `/api/user/1`   | Representation of a  user `1` | Updates user with ID `1`| **Replace** endpoint |
| PUT       | `/api/user/delete/1`   | Representation of a  user `1` | Disables user with ID `1`| **Replace** endpoint |
| GET       | `/api/expenses`     |              | Collection of representations of all expenses  | **List** or **collection** endpoint |
| GET       | `/api/expenses/1`   |              | Representation of expenses with ID `1` | **Retrieve** endpoint |
| POST      | `/api/expenses/1`     | Representation of a new expense | New expenses created | **Create** endpoint |
| PUT       | `/api/expenses/1`   | Representation of a  expenses with ID `1` | Updates expense with ID `1`| **Replace** endpoint |
| PUT       | `/api/expenses/delete/1`   | Representation of a  expense with ID `1` | Disables expense with ID `1`| **Replace** endpoint |


<p align="right">(<a href="#top">back to top</a>)</p>

## What I Learned
<p>
This project has helped me gain a better understanding of repositories and the how to use repositories in combination with services. Using postman to test my mapping connection helped me recognize errors within my code and where to fix them. Using postman for this project allowed my to gain more experience using it and testing data using json requests to send and receive data to the database.
</p>



## Contact

<strong>Developer on Project</strong>

<h4>Sandra Harpole</h4>
<ul>
<li>
<a href="https://www.linkedin.com/in/sandra-harpole/">
LinkedIn
</a>
</li>
<li><a href="https://github.com/SandraLeAnn">Github</a></li>
<li> E-mail: sharpnw21@gmail.com </li>
</ul>


Project Link: [EventTrackerProject](https://github.com/SandraLeAnn/EventTracker)

<p align="right">(<a href="#top">back to top</a>)</p>
