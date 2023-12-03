import java.time.LocalDate;

// Vehicle Class
class Vehicle {
    private String make;
    private String plate;
    private String color;
    private String category;

    public Vehicle(String make, String plate, String color, String category) {
        this.make = make;
        this.plate = plate;
        this.color = color;
        this.category = category;
    }

    public String getMake() {
        return make;
    }

    public String getPlate() {
        return plate;
    }

    public String getColor() {
        return color;
    }

    public String getCategory() {
        return category;
    }
}

// Car Class
enum Gear { MANUAL, AUTOMATIC }

enum CarType { SPORT, SUV, HATCHBACK, MINIVAN, SEDAN }

class Car extends Vehicle {
    private Gear gear;
    private CarType type;

    public Car(String make, String plate, String color, String category, Gear gear, CarType type) {
        super(make, plate, color, category);
        this.gear = gear;
        this.type = type;
    }

    public Gear getGear() {
        return gear;
    }

    public CarType getType() {
        return type;
    }
}

// Motorcycle Class
class Motorcycle extends Vehicle {
    private boolean hasSidecar;

    public Motorcycle(String make, String plate, String color, String category, boolean hasSidecar) {
        super(make, plate, color, category);
        this.hasSidecar = hasSidecar;
    }

    public boolean hasSidecar() {
        return hasSidecar;
    }
}

// Contract Interface
interface Contract {
    double accumulatedSalary();
    String getDescription();
    String getDetails();

}

// Permanent Contract Class
class Permanent implements Contract {
    private int daysWorked;
    private double monthlySalary;
    private int children;
    private boolean married;
    private double monthlyChildAllowance;

    public Permanent(int daysWorked, double monthlySalary, int children, boolean married, double monthlyChildAllowance) {
        this.daysWorked = daysWorked;
        this.monthlySalary = monthlySalary;
        this.children = children;
        this.married = married;
        this.monthlyChildAllowance = monthlyChildAllowance;
    }

    public double accumulatedSalary() {
        return daysWorked * (monthlySalary + (married ? (children > 1 ? children * monthlyChildAllowance : monthlyChildAllowance) : 0)) / 20;
    }

    public String getDescription() {
        return "a permanent employee";
    }

    public String getDetails() {
        return String.format("he is %s and he/she has %d children.\nHe/She has worked for %d days and upon contract his/her monthly salary is %.1f.",
                (married ? "married" : "not married"), children, daysWorked, monthlySalary);
    }
}

// Temporary Contract Class
class Temporary implements Contract {
    private int hoursWorked;
    private double hourlySalary;

    public Temporary(int hoursWorked, double hourlySalary) {
        this.hoursWorked = hoursWorked;
        this.hourlySalary = hourlySalary;
    }

    public double accumulatedSalary() {
        return hoursWorked * hourlySalary;
    }

    public String getDescription() {
        return "a temporary employee";
    }

    public String getDetails() {
        return String.format("he is a temporary employee with %.1f hourly salary and he has worked for %d hours", hourlySalary, hoursWorked);
    }
}

// Employee Hierarchy
class Employee {
    private final String name;
    private final int birthYear;
    private final double monthlyIncome;
    private double occupationRate;
    private Vehicle vehicle;

    private Contract contract; // New field to hold Contract information

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public String contractInfo() {
        if (contract != null) {
            return getName() + " is " + contract.getDescription() + ".\n" + contract.getDetails();
        }
        return "";
    }



    public Employee(String name, int birthYear, double monthlyIncome, double occupationRate) {
        this.name = name;
        this.birthYear = birthYear;
        this.monthlyIncome = monthlyIncome;
        setOccupationRate(occupationRate); // Ensure occupation rate within range
        System.out.println("We have a new employee: " + this.name);
    }

    public int getAge() {
        return LocalDate.now().getYear() - birthYear;
    }

    public double getOccupationRate() {
        return occupationRate;
    }

    public void setOccupationRate(double occupationRate) {
        if (occupationRate < 10) {
            this.occupationRate = 10;
        } else if (occupationRate > 100) {
            this.occupationRate = 100;
        } else {
            this.occupationRate = occupationRate;
        }
    }

    public String getName() {
        return name;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public double annualIncome() {
        return 12 * getMonthlyIncome() * (getOccupationRate() / 100);
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public String employeeInfo() {
        StringBuilder info = new StringBuilder();
        info.append("-------------------------\n");
        info.append("Name: ").append(getName()).append("\n");
        info.append("Age: ").append(getAge()).append("\n");
        if (vehicle != null) {
            info.append("Employee has a ").append(vehicle.getClass().getSimpleName()).append("\n");
            info.append("- make: ").append(vehicle.getMake()).append("\n");
            info.append("- plate: ").append(vehicle.getPlate()).append("\n");
            info.append("- color: ").append(vehicle.getColor()).append("\n");
            info.append("- category: ").append(vehicle.getCategory()).append("\n");
            if (vehicle instanceof Car) {
                Car car = (Car) vehicle;
                info.append("- gear type: ").append(car.getGear()).append("\n");
                info.append("- type: ").append(car.getType()).append("\n");
            } else if (vehicle instanceof Motorcycle) {
                Motorcycle motorcycle = (Motorcycle) vehicle;
                info.append("- with sidecar: ").append(motorcycle.hasSidecar()).append("\n");
            }
        }
        info.append(getName()).append(" has an Occupation rate: ").append(getOccupationRate()).append("%");
        return info.toString();
    }
}

class Manager extends Employee {
    private final int travelledDays;
    private final int newClients;

    public Manager(String name, int birthYear, double monthlyIncome, double occupationRate, int travelledDays, int newClients) {
        super(name, birthYear, monthlyIncome, occupationRate);
        this.travelledDays = travelledDays;
        this.newClients = newClients;
    }

    // Additional getters for Manager-specific attributes
    public int getTravelledDays() {
        return travelledDays;
    }

    public int getNewClients() {
        return newClients;
    }

    @Override
    public double annualIncome() {
        return super.annualIncome() + (500 * getNewClients()) + (100 * getTravelledDays());
    }
}

class Tester extends Employee {
    private final int bugsSolved;

    public Tester(String name, int birthYear, double monthlyIncome, double occupationRate, int bugsSolved) {
        super(name, birthYear, monthlyIncome, occupationRate);
        this.bugsSolved = bugsSolved;
    }

    // Additional getter for Tester-specific attribute
    public int getBugsSolved() {
        return bugsSolved;
    }
}

class Programmer extends Employee {
    private final int projectsCompleted;

    public Programmer(String name, int birthYear, double monthlyIncome, double occupationRate, int projectsCompleted) {
        super(name, birthYear, monthlyIncome, occupationRate);
        this.projectsCompleted = projectsCompleted;
    }

    // Additional getter for Programmer-specific attribute
    public int getProjectsCompleted() {
        return projectsCompleted;
    }

    @Override
    public double annualIncome() {
        return super.annualIncome() + (200 * getProjectsCompleted());
    }
}