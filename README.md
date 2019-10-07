**Test Explanation:**

On My approach I have just created some simple REST api, exposing the endpoints for WorseSupplier,
BestSupplier, MedicineFinder and Country, so anywhere we can use the CRUD operations for the
Suppliers and get the merge of the suppliers with the MedicineFinder and get the list of Countries and it's alpha3code.

If I have time enough I would like to implement the Spring Security and some validations,
but I put some personal goal of doing this test in 8 hours of coding, after this, no
more coding, I have passed my own schedule in 1 hour though.
All the test took me 9 hours of coding + planning how to solve the problem.

The backend took me something like 8 hours, plus 1 hour with the Angular project to list the
results of MedicineFinder.

To run the web view, please see the https://github.com/rodrigo-sntg/bio-web and follow the instructions.

To access swagger API documentation, access http://localhost:8080/swagger-ui.html#/ with the code running.

**WHAT HAS BEEN DONE:**
It's been done some endpoints simulating apis of two different sources of suppliers, the BestSupplierApi and the WorseSupplierApi. I'have dismembered the Supplier's Request and Response in One single model object, so I can save on database using h2database in memory.

On the start of the application I have created a simple code to generate suppliers randomly and using an free api to get countries code, providing this in my own api by the route /countries.

On the Worse and the Best apis, I have created the CRUD operations for both.
I would like to use some object oriented approach and some code reuse, but I have considered that it would be two different apis providing this informations.

For the main challenge, I have found some common attributes in worseSupplierResponse and bestSupplierResponse, combining this attributes and providing this infos in MedicineFinderResponse, this is what is sent to my web view in Angular.
