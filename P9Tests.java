//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Access Control
// Files: User.Java, AccessControlTest.java, AccessControl.java
// Course: CS300, Fall, 2018
//
// Author: Daniel Chu
// Email: dchu22@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Tolga Beser
// Partner Email: tbeser@wisc.edu
// Partner Lecturer's Name: Gary Dahl
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _x_ Write-up states that pair programming is allowed for this assignment.
// _x_ We have both read and understand the course Pair Programming Policy.
// _x_ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: N/A
// Online Sources: N/A
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.ArrayList;

/**
 * Testing method for Sett and Badger classes. Runs methods that check implementation
 *
 */
public class P9Tests {

  /**
   * Main method that runs all the tests
   * @param args - strings of code that run it
   */
  public static void main(String args[]) {

    if(runAllBadgerTests() && runAllSettTests()) { // if both are true tests are passed
      System.out.println("All tests clear");
    }

  }

  /**
   * Runs tests on Badger class
   * @return boolean describing if test passed
   */
  public static boolean runAllBadgerTests() {
    return (testBadgerLeft() && testBadgerRight());
  }

  /**
   * Runs test on Sett class
   * @return boolean describing if test passed
   */
  public static boolean runAllSettTests() {
    return testSettAdd();
  }

  /**
   * Adds several badgers to left nodes, and checks if values are correct
   * @return boolean describing if tests passed
   */
  private static boolean testBadgerLeft() {
    boolean passed = true; // boolean that is returned

    Badger b1 = new Badger(10); // creates 4 badgers
    Badger b2 = new Badger(8);
    Badger b3 = new Badger(20);
    Badger b4 = new Badger(-4);
    b1.setLeftLowerNeighbor(b2); // sets the badger to left node
    if(b1.getLeftLowerNeighbor().getSize()!=8) { // checks the value of each badger
      passed = false; // returns false if value incorrect
    }
    b2.setLeftLowerNeighbor(b4); // sets the badger to left node
    if(b2.getLeftLowerNeighbor().getSize()!=-4) { // checks the value of each badger
      passed = false; // returns false if value incorrect
    }
    b2.setLeftLowerNeighbor(b3); // sets the badger to left node
    if(b2.getLeftLowerNeighbor().getSize()!=20) { // checks the value of each badger
      passed = false; // returns false if value incorrect
    }
    return passed;
  }

  /**
   * Adds several badgers to right nodes and checks if values are correct
   * @return boolean describing if tests passed
   */
  private static boolean testBadgerRight() {
    boolean passed = true; // boolean that is returned

    Badger b1 = new Badger(12); // creates 4 badgers
    Badger b2 = new Badger(15);
    Badger b3 = new Badger(6);
    Badger b4 = new Badger(-4);
    b1.setRightLowerNeighbor(b2); // sets the badger to left node
    if(b1.getRightLowerNeighbor().getSize()!=15) { // checks the value of each badger
      passed = false; // returns false if value incorrect
    }
    b2.setRightLowerNeighbor(b4); // sets the badger to left node
    if(b2.getRightLowerNeighbor().getSize()!=-4) { // checks the value of each badger
      passed = false; // returns false if value incorrect
    }
    b2.setRightLowerNeighbor(b3); // sets the badger to left node
    if(b2.getRightLowerNeighbor().getSize()!=6) { // checks the value of each badger
      passed = false; // returns false if value incorrect
    }
    return passed;
  }

  /**
   * Tests all methods of Sett. All methods are tested here because the tree is created here
   * @return boolean describing if test passed
   */
  private static boolean testSettAdd() {

    boolean passed = true; // boolean that is returned

    /*
     * Creates this tree structure:
     *          12              first level
     *      6        18         second level
     *    3   9   15    21      third level
     *  1                 30    fourth level
     *                      40  fifth
     *                       50 sixth
     */

    Sett sett = new Sett();
    sett.settleBadger(12);
    if(sett.getTopBadger().getSize()!=12) { // checks to make sure the top badger is correct
      passed = false;
    }
    sett.settleBadger(6); // adds 3 more elements
    sett.settleBadger(3);
    sett.settleBadger(1);
    if(sett.getHeight()!=4) { // checks the current height of the BST
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

    sett.settleBadger(30); // adds 3 more badgers on the right side of the tree
    sett.settleBadger(40);
    sett.settleBadger(50);

    if(sett.getHeight()!=6) { // checks the height
      passed = false;
    }

    try { // tests to make sure same size badgers are caught
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
