Build:
cd ...\Pragmatic-Coders
mvn clean package

Test
mvn test

Uruchamianie
java -jar target\checkout-api-1.0.0.jar

Testowanie w Postman:

Lista produktów (składowane w aplikacji)
Produkt	Cena jednostkowa	Ilość promocyjna	Cena promocyjna
A	40.0			3			30.0
B	10.0			2			7.5
C	30.0			4			20.0
D	25.0			2			23.5

URL:
http://localhost:8080/api/checkout/calculate
POST
Headers:
Content-Type: application/json
zapytanie:
{
  "productId": "A",
  "quantity": 3
}

Skanowanie produktu (dodanie do koszyka):
POST
http://localhost:8080/api/checkout/scan
Body:
{
  "productId": "B",
  "quantity": 1
}

Sprawdzenie aktualnej sumy:
GET
http://localhost:8080/api/checkout/total

Zakończenie zakupów i wygenerowanie paragonu:
POST
http://localhost:8080/api/checkout/checkout
