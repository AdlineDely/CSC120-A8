import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        
        myMap.addBuilding(new House("King House", "180 Elm St", 4, true, true));
        myMap.addBuilding(new House("Scales House", "170 Elm St", 4, true,true));

        myMap.addBuilding(new House("Cutter House", "10 prospect st"));
        myMap.addBuilding(new House("Ziskind", "10 prospect st"));

        myMap.addBuilding(new Library("Neilson Library", "7 Neilson Way", 4, true));
        myMap.addBuilding(new Library("Hillyer Art LIbrary", "20 Elm St", 2, false));

        myMap.addBuilding(new Cafe("Compass Cafe", "Compass Cafe", 1, 5, 5, 5,10));
        myMap.addBuilding(new Cafe("Camouse Center", "Campus center", 3, 5, 5, 5,10));

        myMap.addBuilding(new Building("Ford Hall", "100 Green St",4));
        myMap.addBuilding(new Building("McConnell Hall", "7 College Ln",4));

        System.out.println(myMap);
    }
    
}
