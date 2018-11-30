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

/**
 * This class represents a Badger which is designed to live in a Sett. Each Badger object represents a single node within a BST (known as a Sett).
 *
 */
public class Badger {

  private Badger leftLowerNeighbor; // left node of this badger
  private Badger rightLowerNeighbor; // right node of this badger
  private final int size; // the size of the badger
  
  /**
   * Creates a new Badger with specified size.
   * @param size - The size of the newly constructed Badger object.
   */
  public Badger(int size) {
    leftLowerNeighbor = null; // assigns neighbor values to null
    rightLowerNeighbor = null;
    this.size = size;
  }
  
  /**
   * Retrieves neighboring badger that is smaller than this one.
   * @return The left lower neighbor of current badger.
   */
  public Badger getLeftLowerNeighbor() {
    return leftLowerNeighbor;
  }
  
  /**
   * Retrieves neighboring badger that is larger than this one.
   * @return The right lower neighbor of current badger.
   */
  public Badger getRightLowerNeighbor() {
    return rightLowerNeighbor;
  }
  
  /**
   * Retrieves the size of this badger.
   * @return The size of current badger.
   */
  public int getSize() {
    return size;
  }
  
  /**
   * Changes this badger's lower left neighbor.
   * @param badger - The new left lower neighbor of current badger.
   */
  public void setLeftLowerNeighbor(Badger badger) {
    leftLowerNeighbor = badger;
  }
  
  /**
   * Changes this badger's lower right neighbor.
   * @param badger - The new right lower neighbor of current badger.
   */
  public void setRightLowerNeighbor(Badger badger) {
    rightLowerNeighbor = badger;
  }
  
}
