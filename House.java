/* This is a stub for the House class */
import java.util.ArrayList;
// By adding "extends Building" we can use 
// what exist in Building.java without having to rewrite it here 
public class House extends Building implements HouseRequirements {
  private ArrayList<Student> residents; // The <Student> tells Java what kind of data we plan to store IN the ArrayList
  private boolean hasDiningRoom;
  private boolean hasElevator;
  
  /**
   * Constructor for the House class.
   * @param name The name of the house 
   * @param address The physical location of the house
   * @param nFloors The number of floors in the house
   * @param hasDiningRoom A boolean indicating if the house has a dining hall 
   */
  public House (String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator ) {
    super(name, address, nFloors); //Pass the basics to the Building class
    this.residents = new ArrayList<Student>();
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
    System.out.println("You have built a house: 🏠");
  
  }

  //overloading
  public House(String name, String address){
    super(name, address, 1); // this will default nFloors to 1
    this.hasElevator = false; //this will default it to having no elevator
  }

  /**
    * Accessor for hasDiningRoom
    * @return true if the house has a dining room, false other 
    */
    public boolean hasDiningRoom(){
      return this.hasDiningRoom;
    }
    
    /**
     * Accessor for the number of residents
     * @return the number of students currently in the residents list
     */
    public int nResidents(){
      return this.residents.size();
    }

    public void moveIn(Student s){
      this.residents.add(s);
    }

    public Student moveOut(Student s){
      this.residents.remove(s);
      return s;
    }

    public boolean isResident(Student s){
      return this.residents.contains(s);
    }

    //overide
    public void showOptions(){
        super.showOptions();
    }

    //overide
      public void goToFloor(int n){
        if (this.hasElevator){
            super.goToFloor(n);
        } else {
            if (Math.abs(n- this.activeFloor)<=1){
                super.goToFloor(n);
            } else{
                System.out.println("Invalid move: This building has no elevator.");
            }
        }

        }


  public static void main(String[] args) {
    House myHouse = new House("Lamont", "1 Chapin Way",  4, true,true);
    Student person = new Student("Adline", "12345", 2027);
    myHouse. moveIn(person);

    System.out.println("Is Adline a resident? " + myHouse.isResident(person));
    System.out.println("Number of residents: " + myHouse.nResidents());


    //testing the overload and overriding
      Library myHome = new Library("Yoland King", "Smith College", 4, false);
      myHome.showOptions();
      myHome.enter();
      myHome.goToFloor(2);
      myHome.goToFloor(4); //expectomg to get an error message since there is no elevator 
    }

}
