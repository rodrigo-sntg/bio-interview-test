**Bionexo - Interview Test**

**Brief Explanation:**

MedicineFinder is a search tool to find medicines which have been bought already and are on they way to be delivered.
It aggregates medicine results initially from 2 different suppliers (BestSupplier and WorseSupplier).

**Test duration:**

Try to not spend more than a day to complete this test. You can submit an incomplete solution, but you must explain what are the next steps missing briefly. 

**What is needed:**

Use this GitHub repository as a base to implement your solution to the test.
The result should be a JSON response which aggregates a list of medicines ordered by price which is composed of the attributes:

**Medicine Finder API**

**Request**

| Name | Description |
| ------ | ------ |
| origin | 3 first letters of a country(eg. BRA, ARG, VEN) |
| destination | 3 first letters of a country(eg. BRA, ARG, VEN) |
| departureDate | ISO_LOCAL_DATE format |
| estimatedArrival | ISO_LOCAL_DATE format |
| numberOfMedicine | Maximum 10 |

**Response**

| Name | Description |
| ------ | ------ |
| medicineName | Name of the medicine |
| supplier | Eg: BestSupplier or WorseSupplier |
| totalPrice | Total price rounded to 2 decimals |
| departureCountry | 3 first letters of a country(eg. BRA, ARG, VEN) |
| destinationCountry | 3 first letters of a country(eg. BRA, ARG, VEN) |
| departureDate | ISO_DATE_TIME format |
| estimatedArrival | ISO_DATE_TIME format |

The service should connect to both suppliers using HTTP.

**BestSupplier API**

**Request**

| Name | Description |
| ------ | ------ |
| origin | 3 first letters of a country(eg. BRA, ARG, VEN) |
| destination | 3 first letters of a country(eg. BRA, ARG, VEN) |
| departureDate | ISO_LOCAL_DATE format |
| estimatedArrival | ISO_LOCAL_DATE format |
| quantityCount| Number of medicines |

**Response**


| Name | Description |
| ------ | ------ |
| medicineName | Name of the medicine |
| price | Total price |
| medicineType | P for pill and L for liquid |
| departureCountryCode | Eg: BRA |
| destinationCountryCode | Eg: ARG |
| departureDate | ISO_LOCAL_DATE_TIME format |
| estimatedArrival | ISO_LOCAL_DATE_TIME format |

**WorstSupplier API**

**Request**

| Name | Description |
| ------ | ------ |
| departFrom | 3 first letters of a country(eg. BRA, ARG, VEN) |
| arriveTo | 3 first letters of a country(eg. BRA, ARG, VEN) |
| outboundDate |ISO_LOCAL_DATE format |
| inboundDate | ISO_LOCAL_DATE format |
| numberOfMedicines | Number of medicines |

**Response**

| Name | Description |
| ------ | ------ |
| medicine | Name of the medicine |
| totalBasePrice | Price without tax(doesn't include discount) |
| tax | Tax which needs to be added to the price |
| discount | Discount which needs to be subtracted from the price(in percentage) |
| departureCountryName | 3 first letters of a country(eg. BRA, ARG, VEN) |
| arrivalCountryName | 3 first letters of a country(eg. BRA, ARG, VEN) |
| outboundDateTime | ISO_INSTANT format |
| inboundDateTime | ISO_INSTANT format |

**What has to be done:**

- A solution that meets the above requirements.
- The APIs implementation should be the closest to a production environment, and in the way you think it would be better implemented 
(As said before, if there is missing something, there is no problem).

You can change any part of the code. In this case, add a comment saying why and what has been changed.
