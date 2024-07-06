# AlgoSort

AlgoSort is a web application that demonstrates various sorting algorithms and provides a RESTful API for sorting operations.

## Features

- Implements Quick Sort, Heap Sort, Merge Sort, Radix Sort, and Bucket Sort algorithms
- RESTful API following HATEOAS principles
- Simple web interface for sorting input
- CRUD operations for sort results

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven
- Apache Tomcat 9 or higher

### Building the Project

1. Clone the repository
2. Navigate to the project directory
3. Run `mvn clean package`

### Deploying the Application

1. Copy the generated WAR file from the `target` directory to your Tomcat's `webapps` directory
2. Start Tomcat
3. Access the application at `http://localhost:8080/algosort`

## API Endpoints

- POST /api/sort: Perform a sorting operation
- GET /api/sort: Retrieve all sort results
- GET /api/sortresults/{id}: Retrieve a specific sort result
- PUT /api/sortresults/{id}: Update a sort result
- DELETE /api/sortresults/{id}: Delete a sort result

## Contributing

Please read CONTRIBUTING.md for details on our code of conduct, and the process for submitting pull requests.

## License

This project is licensed under the MIT License - see the LICENSE.md file for details