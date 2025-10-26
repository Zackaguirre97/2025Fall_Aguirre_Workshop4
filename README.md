# 🚗 Dealership Management System
```
A simple Java console application for managing vehicle inventory and customer interactions at a dealership.  
The system allows users to view, add, remove, and purchase vehicles, with data saved and loaded from files.
```
---

## 📋 Features
```
- View all vehicles currently in the dealership’s inventory  
- Filter vehicles by make, model, price range, or type  
- Search for a vehicle by VIN  
- Add new vehicles to the inventory  
- Remove or purchase vehicles  
- Save and load dealership data  
- User-friendly command-line interface  
```
---

## 🧠 How It Works
```
The app uses a text-based menu to navigate different operations.  
Dealership data is stored locally and can be saved or loaded using the `DealershipFileManager` class.

**Core Classes:**
- `Dealership` – Stores the list of vehicles and provides methods to manage them  
- `Vehicle` – Represents an individual car with properties like VIN, make, model, price, and year  
- `DealershipFileManager` – Handles file input/output  
- `UserInterface` – Provides menu options and user interaction logic  
```
---

## 📂 Project Structure

```
DealershipManagementSystem/
│
├── src/
│   ├── com/dealership/
│   │   ├── Main.java
│   │   ├── Dealership.java
│   │   ├── Vehicle.java
│   │   ├── DealershipFileManager.java
│   │   ├── UserInterface.java
│   │   └── ... other supporting files
│
├── resources/
│   ├── dealership-data.txt
│   ├── screenshots/
│
└── README.md
```

---

## 🖼️ Screenshots

```
- **Main Menu:**  
  ![Main Menu](resources/screenshots/main-menu.png)

- **Add Vehicle:**  
  ![Add Vehicle](resources/screenshots/add-vehicle.png)

- **Purchase Vehicle:**  
  ![Purchase Vehicle](resources/screenshots/purchase-vehicle.png)

- **View All Vehicles:**  
  ![View All Vehicles](resources/screenshots/view-all.png)
```
---

## 💾 Data Persistence
```
Vehicle data is saved to a local file using the `DealershipFileManager` class.  
When the app starts, it loads the data automatically from the file (if available).
```
---

## 🔧 Technologies Used
```
- **Language:** Java  
- **Version Control:** Git  
- **IDE:** IntelliJ IDEA / VS Code / Eclipse  
```
---

## 👨‍💻 Author
```
**Zackery Aguirre**  
Year Up Software Track – Application Development  
```
