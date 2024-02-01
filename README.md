# Multi-tier-Online-Book-Store

# Architecture
1. **Catalog Server**: This is a specialized microservice focused on maintaining a database with comprehensive details about books. The database includes key information like the book's title, its availability, pricing, and subject matter. The Catalog Server is built as a standalone process and offers a RESTful API for various operations. These operations include searching for books based on their subject or specific item numbers and modifying book information as needed.

2. **Order Server**: This microservice is in charge of processing and managing customer orders. It establishes communication with both the Catalog Server and the Front-End Server to streamline the buying process. The Order Server is optimized for handling transactions and presents a unified operation interface, commonly through a RESTful API, to execute purchase-related tasks.

3. **Frontend Server**: Serving as the primary interface for user interactions, the Front-End Server coordinates the communication between the user interface and backend services. It operates as a microservice and provides a diverse range of user functionalities through a RESTful API. This server ensures smooth user experience by effectively managing the flow of requests and responses within the system.

# Implementation
This project was developed using java and the spring boot framework. The choice of the CSV file .

# APIs
**FrontEnd APIs**
| URL | Method | Description |
|----------|----------|----------|
| `/info/:item_id` | `Get` | get information about a book by its `<item_id>` |
| `/search/:topic` | `Get` | , returns all matching books itemNumber and tittle. |
| `/purchase/:book_id` | `Post` | buy a book by its `<book_id>` |

**Catalog Server APIs** 
| URL | Method | Description |
|----------|----------|----------|
| `/info/:item_number` | `Get` | query all information about a book by its `<item_number>`, returns `JSON` object represinting matching books information. |
| `/search/:topic` | `Get` | query all the books with the specified `<topic>`, returns `JSON` object represinting matching books information. |
| `/:book_id` | `Post` | update the stock for book by its `<book_id>` |

**Order Server APIs** 
| URL | Method | Description |
|----------|----------|----------|
| `/purchase/:book_id` | `Post` | send query for catalog server to buy a book by its `<book_id>` |

# usage
frontend => 8080 <br>
catalog_server => 8081 <br>
order_server => 8082 <br>

# Testing
Frontend address: `http://localhost:8080`.<br>

catalog-server address: `http://localhost:8081`.<br>

order-server address: `http://localhost:8082`.<br>



**Search for books by topic**
`http://localhost:8081/search/distributed%20systems`<br>
![search di](https://github.com/yazan258/DOS-final-project/assets/79420539/6fab067f-229d-43cb-b7f8-b60316b4eec4)

**inforamtion about a selected book**
`http://localhost:8081/info/1`<br>
![info](https://github.com/yazan258/DOS-final-project/assets/79420539/52950ea3-158b-46b7-8c7f-0ab2655f8964)

**purchase Books**
`http://localhost:8082/purchase/2`<br>
![purchase](https://github.com/yazan258/DOS-final-project/assets/79420539/dc606d12-9222-42be-b662-8df9fe1b2f25)

**frontend screen shots**
![3](https://github.com/yazan258/DOS-final-project/assets/79420539/b1c8eb20-bebe-4d72-ac02-dbcba8fc7fd6)


