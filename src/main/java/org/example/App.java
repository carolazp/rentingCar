package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        /*
        Here there are principal methods: main
        STATIC method: it can be called without creating an instance of the class
        */
        System.out.println("Starting code...");

        //testingPrint();
        //testCar();
        testBooking();

        System.out.println("\nFinished!");
    }

    public static void testingPrint(){
        System.out.println( "HELlO MOTO!!!!" );
        int mateo = 2;
        System.out.println("This is mateo: "+ mateo);
    }

    public static void testCar() {
        System.out.println("Testing car...");

        // first car: bmw001
        Car bmw001 = new Car("1", "BMW", "M3", "1234", 2022, 100.0);
        System.out.println("This is my BMW: " + bmw001.toString());
        System.out.println(bmw001.getBrand());
        bmw001.setBrand("Mercedes");
        System.out.println("Changing Brand: " + bmw001.toString());
        System.out.println("Age of the car: " + bmw001.carAge());

        // second car: bmw003
        Car bmw003 = new Car();
        bmw003.setBrand("BMW");
        bmw003.setYear(2000);
        System.out.println("\n" + bmw003.toString());
        System.out.println("This is the age of the car: " + bmw003.carAge());
        /*
        carAge() is a method of the Car class
        therefore, it needs to be called on an instance of the Car class
        */

        // The next line will throw an error because the constructor is not defined
        // Car bmw004 = new Car("3", "BMW");

    }

    public static void testBooking(){

        System.out.println("Testing booking...");

        Car bmw003 = new Car();
        bmw003.setBrand("BMW");
        bmw003.setYear(2000);
        System.out.println("\n" + bmw003.toString());
        System.out.println("This is the age of the car: " + bmw003.carAge());

        Booking booking001 = new Booking("001a", true , 9 , 100.2, bmw003);
        System.out.println("new booking: " + booking001.toString());

        Car audi001 = new Car("1", "audi", "a3", "1x821d", 2022, 10000.1);
        Booking booking002 = new Booking();
        booking002.setId("002b");
        booking002.setActive(true);
        booking002.setDays(5);
        booking002.setPrice(50.3);
        booking002.setCar(audi001);
        System.out.println("\nThis is my new booking: " + booking002.toString());
        /*
        RESULT:
        This is my new booking:
        Booking {id='002b', isActive=true, days=5,
                price=50.3, car=Car{id='1', brand='audi', model='a3', plate='1x821d', year=2022, price=10000.1}}
        */

    }
}
