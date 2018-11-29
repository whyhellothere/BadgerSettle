import java.util.ArrayList;

public class P9Tests {


  public static void main(String args[]) {

    if(runAllBadgerTests() && runAllSettTests()) {
      System.out.println("All tests clear");
    }

  }

  public static boolean runAllBadgerTests() {
    return (testBadgerLeft() && testBadgerRight());
  }

  public static boolean runAllSettTests() {
    return testSettAdd();
  }

  private static boolean testBadgerLeft() {
    boolean passed = true;

    Badger b1 = new Badger(10); // creates 4 badgers
    Badger b2 = new Badger(8);
    Badger b3 = new Badger(20);
    Badger b4 = new Badger(-4);
    b1.setLeftLowerNeighbor(b2); // checks the value of each badger
    if(b1.getLeftLowerNeighbor().getSize()!=8) {
      passed = false;
    }
    b2.setLeftLowerNeighbor(b4);
    if(b2.getLeftLowerNeighbor().getSize()!=-4) {
      passed = false;
    }
    b2.setLeftLowerNeighbor(b3);
    if(b2.getLeftLowerNeighbor().getSize()!=20) {
      passed = false;
    }
    return passed;
  }

  private static boolean testBadgerRight() {
    boolean passed = true;

    Badger b1 = new Badger(12); // creates 4 badgers
    Badger b2 = new Badger(15);
    Badger b3 = new Badger(6);
    Badger b4 = new Badger(-4);
    b1.setRightLowerNeighbor(b2); // checks the value of each badger
    if(b1.getRightLowerNeighbor().getSize()!=15) {
      passed = false;
    }
    b2.setRightLowerNeighbor(b4);
    if(b2.getRightLowerNeighbor().getSize()!=-4) {
      passed = false;
    }
    b2.setRightLowerNeighbor(b3);
    if(b2.getRightLowerNeighbor().getSize()!=6) {
      passed = false;
    }
    return passed;
  }

  private static boolean testSettAdd() {

    boolean passed = true;

    /*
     * Creates this tree structure:
     *          12              first level
     *      6        18         second level
     *    3   9   15    21      third level
     *  1                   30    fourth level
     *                          40 fifth
     *                              50 sixth
     */

    Sett sett = new Sett();
    sett.settleBadger(12);
    if(sett.getTopBadger().getSize()!=12) { // checks to make sure the top badger is correct
      passed = false;
    }
    sett.settleBadger(6); // adds 3 more elements
    sett.settleBadger(3);
    sett.settleBadger(1);
    if(sett.getHeight()!=3) { // checks the current height of the BST
      passed = false;
    }
    sett.settleBadger(18); // adds 4 more elements
    sett.settleBadger(15);
    sett.settleBadger(21);
    sett.settleBadger(9);
    // checks the value of the badger 15
    if(sett.getTopBadger().getRightLowerNeighbor().getLeftLowerNeighbor().getSize()!=15) {
      passed = false;
    }

    // tests the getAllBadgers method
    ArrayList<Badger> list = (ArrayList<Badger>) sett.getAllBadgers(); // gets the list
    String badgerSize = ""; // creates a string to compare values in list
    for(int i=0; i<list.size(); i++) { 
      badgerSize += list.get(i).getSize() + " "; // appends each badger size to the string
    }
    if(badgerSize.equals("1 3 6 9 12 15 18 21")) {
      passed = false;
    }

    // tests the getLargestBadger method
    if(sett.getLargestBadger().getSize()!=21) { // checks the correct size of the largest badger
      passed = false;
    }

    sett.settleBadger(30);
    sett.settleBadger(40);
    sett.settleBadger(50);

    if(sett.getHeight()!=5) {
      System.out.println(sett.getHeight());
      passed = false;
    }

    try {
      sett.settleBadger(1);
    } catch(IllegalArgumentException e) {
      System.out.println("caught error");
    }

    // tests the clear method
    sett.clear();
    if(sett.getTopBadger()!=null) { // if the topBadger is not null then the list is not empty
      passed = false;
    }

    return passed;

  }



}
