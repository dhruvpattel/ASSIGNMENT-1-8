public class Main {
    public static void main(String[] args) {
        // Creating employees
        Manager serge = new Manager("Serge", 1990, 5000, 100, 4, 30);
        Manager cindy = new Manager("Cindy", 1979, 6000, 80, 6, 20);
        Programmer paul = new Programmer("Paul", 1998, 3000, 75, 3);
        Tester pierre = new Tester("Pierre", 1992, 4000, 50, 124);
        Programmer matt = new Programmer("Matt", 1986, 3500, 100, 5);
        Programmer sarah = new Programmer("Sarah", 1991, 4000, 100, 3);

        // Creating vehicles for employees
        Car sergeCar = new Car("Lamborghini", "Custom Plate", "White", "Family", Gear.MANUAL, CarType.SPORT);
        Car cindyCar = new Car("BMW", "Custom Plate", "Black", "Family", Gear.AUTOMATIC, CarType.SEDAN);
        Motorcycle paulMotorcycle = new Motorcycle("Kawasaki", "Custom Plate", "Yellow", "Race Motorcycle", false);
        Motorcycle pierreMotorcycle = new Motorcycle("Honda", "Custom Plate", "Black", "Not for Race", true);
        Car mattCar = new Car("Mazda", "Custom Plate", "White", "Family", Gear.AUTOMATIC, CarType.SUV);
        Car sarahCar = new Car("Renault Clio", "Custom Plate", "Blue", "Family", Gear.MANUAL, CarType.HATCHBACK);

        // Assigning vehicles to employees
        serge.setVehicle(sergeCar);
        cindy.setVehicle(cindyCar);
        paul.setVehicle(paulMotorcycle);
        pierre.setVehicle(pierreMotorcycle);
        matt.setVehicle(mattCar);
        sarah.setVehicle(sarahCar);

        // Create and assign contracts
        Contract sergeContract = new Permanent(17, 6000.0, 2, true, 500.0);
        Contract cindyContract = new Permanent(19, 5000.0, 3, false, 400.0);
        Contract paulContract = new Temporary(30, 60.0);
        Contract pierreContract = new Permanent(20, 4000.0, 1, true, 300.0);
        Contract mattContract = new Temporary(60, 50.0);
        Contract sarahContract = new Permanent(19, 4500.0, 4, true, 200.0);

        // Assign contracts to employees
        serge.setContract(sergeContract);
        cindy.setContract(cindyContract);
        paul.setContract(paulContract);
        pierre.setContract(pierreContract);
        matt.setContract(mattContract);
        sarah.setContract(sarahContract);

        // Displaying the information
        System.out.println("-------------------------");
        System.out.println("Employees description:");
        System.out.println("-------------------------");
        System.out.println(serge.employeeInfo());
        System.out.println(cindy.employeeInfo());
        System.out.println(paul.employeeInfo());
        System.out.println(pierre.employeeInfo());
        System.out.println(matt.employeeInfo());
        System.out.println(sarah.employeeInfo());
        System.out.println("-------------------------");
        System.out.println("Contracts:");
        System.out.println("-------------------------");
        System.out.println(serge.contractInfo());
        System.out.println(cindy.contractInfo());
        System.out.println(paul.contractInfo());
        System.out.println(pierre.contractInfo());
        System.out.println(matt.contractInfo());
        System.out.println(sarah.contractInfo());
        System.out.println("-------------------------");
    }
}