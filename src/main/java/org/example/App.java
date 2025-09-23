package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "HELlO MOTO!!!!" );
        int mateo = 2;
        System.out.println("This is mateo: "+ mateo);

        Car bmw001 = new Car("1", "BMW", "M3", "1234", 2022, 100.0);
        System.out.print("This is my BMW: "+ bmw001.toString());

        System.out.print("\n" + bmw001.getBrand());

        Car bmw003 = new Car();
        bmw003.setBrand("BMW");
        System.out.print("\n"+ bmw003.toString());

        bmw001.setBrand("Mercedes");
        System.out.print("\n"+ bmw001.toString());

        // The next line will throw an error because the constructor is not defined
        // Car bmw004 = new Car("3", "BMW");

    }
}
