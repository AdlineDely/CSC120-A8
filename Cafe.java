/* This is a stub for the Cafe class */

/**
 * Represents a Cafe builidng that manges inventory for coffee, sugar, cream, and cups.
 */
public class Cafe extends Building implements CafeRequirements {
    private int nCoffeeOunces; // The number of ounces of coffee remaining
    private int nSugarPackets; // The number of sugar packets remaining
    private int nCreams; // The number of "splashes" of cream remaining
    private int nCups; // The number of cups remaining
    
    /**
     * Constructor for the Cafe class.
     * @param name name The name of the cafe
     * @param address The physical location of the cafe 
     * @param nFloors The number of floors
     * @param nCoffee The starting ounces of coffee
     * @param nSugar The starting number of sugar packets 
     * @param nCream The starting number of cream splashes
     * @param nCups The starting number of cups 
     */
    
    public Cafe(String name, String address, int nFloors, int nCoffee, int nSugar, int nCream, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffee;
        this.nSugarPackets = nSugar;
        this.nCreams = nCream;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * Sells a cup of coffee and decreases inventory. 
     * If inventory is too low, it triggers a restock.
     * @param size 
     * @param nSugar
     * @param nCream
     */
    public void sellCoffee(int size, int nSugar, int nCream) {
        // Check if ANY of the items are insufficient using || (OR)
        if (this.nCoffeeOunces < size || 
            this.nSugarPackets < nSugar || 
            this.nCreams < nCream || 
            this.nCups < 1) {
            
            this.restock(100, 100, 100, 100);
        }
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugar;
        this.nCreams -= nCream;
        this.nCups -= 1;

        System.out.println("Coffee sold! Reamining cups: " + this.nCups);
    }

    //overload 
    public void sellCoffee(int size){
        this.sellCoffee(size, 0,0);
    }

    private void restock(int nCoffee, int nSugar, int nCream, int nCups){
        this.nCoffeeOunces += nCoffee;
        this.nSugarPackets += nSugar;
        this.nCreams += nCream;
        this.nCups += nCups;
        System.out.println("Inventory restocked!");
    }

    //overide
    public void showOptions(){
        super.showOptions();
        System.out.println(" + sellCoffe(size, nSugar, nCream");
        System.out.println(" + restock(nCoffee, nSugar, nCream, nCups)");
    }
    
    public static void main(String[] args) {
        Cafe compass = new Cafe("Compass Cafe", "1 college Ln", 1, 1, 25, 25, 5);
        compass.sellCoffee(12,2,1);

        System.out.println("Requesting a huge order...");
        compass.sellCoffee(200,10,10);

        //testing
        Cafe myCafe = new Cafe("Compass", "Smith Campus", 1, 50, 30, 30, 50);
        System.out.println("All I care about is the size....");
        myCafe.sellCoffee(16,2,2);
        myCafe.sellCoffee(12);
    
    }
    
}
