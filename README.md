# TST-E1 Einsendeaufgabe – Testen
**Name:** Tuana Aydin  
**Modul:** Softwaretechnik  
**Sprache:** Java | Eclipse | JUnit 5 | Mockito  

---

## A1 – Unit-Tests für eigenen Code (Calculator)

Getestet wird eine `Calculator`-Klasse mit den vier Grundrechenarten.
Besonderes Merkmal: mindestens ein Test prüft eine Exception (Division durch Null).

**Testklasse:** `swt.calculator.CalculatorTest`  
**9 Tests, davon 1 Exception-Test:** `testDivide_byZero_throwsException()`

Der Exception-Test ist ein White-Box-Test: Die testende Person kennt 
die interne Absicherung der Methode und prüft gezielt, ob bei Division 
durch 0 eine `IllegalArgumentException` mit der richtigen Nachricht geworfen wird.

<img width="1440" height="900" alt="Bildschirmfoto 2026-07-01 um 20 51 43" src="https://github.com/user-attachments/assets/dcd40adb-b587-44fb-b85f-f24b3b1e9448" />



---

## A2 – TDD Shopping Cart

Entwicklung eines Warenkorbs im TDD-Modus (Red → Green → Refactor).

### Features und TDD-Zyklen

**Feature 1:** Leerer Warenkorb hat Gesamtpreis 0
<img width="1440" height="900" alt="Bildschirmfoto 2026-07-01 um 21 16 58" src="https://github.com/user-attachments/assets/afefa034-b80c-42ea-bc6b-32cff5f5dd76" />


<img width="1440" height="900" alt="Bildschirmfoto 2026-07-01 um 21 19 19" src="https://github.com/user-attachments/assets/d3fc5e20-0a37-4b43-b3c2-5155a0b37101" />



**Feature 2:** Artikel hinzufügen + Gesamtpreis berechnen

<img width="1440" height="900" alt="Bildschirmfoto 2026-07-01 um 21 42 23" src="https://github.com/user-attachments/assets/77669aea-70cb-4c3b-91ed-17d38f6e45db" />


<img width="1440" height="900" alt="Bildschirmfoto 2026-07-01 um 21 45 32" src="https://github.com/user-attachments/assets/c0b05309-32ea-4074-bc69-2abe487c841d" />


**Feature 3:** clear() + Validierungen (leerer Name, negativer Preis, Menge=0)
<img width="1440" height="900" alt="Bildschirmfoto 2026-07-01 um 22 07 52" src="https://github.com/user-attachments/assets/c25c1e51-1139-4e79-994b-0084cc5fd3a2" />


<img width="1440" height="900" alt="Bildschirmfoto 2026-07-01 um 22 23 51" src="https://github.com/user-attachments/assets/86119726-f44d-4e25-9ae6-bbd836be9f33" />


### Git-History (Red → Green Abfolge)


<img width="1440" height="900" alt="Bildschirmfoto 2026-07-01 um 22 25 49" src="https://github.com/user-attachments/assets/659c8464-2b87-4ff7-b24b-bfcb238ca17a" />


---

## A3 – Mocking (OrderService mit Mockito)

### Gemockte Methode
`OrderRepository.save()` und `OrderRepository.findById()` –  
Datenbankzugriffe des `OrderService`.

### Begründung der Mock-Wahl
Eine echte Datenbankverbindung ist im Unit-Test unerwünscht, weil sie 
langsam, nicht immer verfügbar und schwer reproduzierbar ist. Außerdem 
würden Testdaten echte Tabellen verunreinigen. Durch das Mocken des 
`OrderRepository` mit Mockito kann die Logik des `OrderService` isoliert, 
deterministisch und ohne externe Abhängigkeiten geprüft werden.

### Mock-Durchlauf (4 Tests grün)


<img width="1440" height="900" alt="Bildschirmfoto 2026-07-01 um 22 36 28" src="https://github.com/user-attachments/assets/e67ea757-42d4-4185-a948-0a832c85885f" />


---

## KI-Nutzung

KI-Werkzeug: Claude (Anthropic)

**Prompt (Beispiel für ShoppingCart):**  
„Erstelle in Java eine Klasse ShoppingCart mit den Methoden addItem(), 
getTotal(), getItemCount() und clear(). Schreibe dazu JUnit-5-Tests im TDD-Stil."

**KI-Ausgabe:**  
Die KI lieferte eine funktionierende Grundimplementierung mit 
Stream-basierter Preisberechnung und Tests für Normalfälle.

**Meine Kritik – Edge-Cases die die KI übersehen hat:**

1. **Negativer Preis:** Keine Validierung für `price < 0` – ich habe 
   einen Guard `if (price < 0) throw new IllegalArgumentException(...)` ergänzt.

2. **Menge = 0:** Die KI erlaubte `quantity = 0` ohne Exception – 
   ich habe `if (quantity <= 0)` ergänzt.

3. **Leerer Name:** Die KI prüfte nur auf `null`, nicht auf Leerzeichen 
   (`"  "`). Ich habe auf `name.isBlank()` erweitert.

---

## Repository-Link
https://github.com/tuanaaaydin/swt-tst-e1
