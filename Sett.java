import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * This class represents a Sett, where a group of Badgers live together. Each Sett is organized 
 * as a BST of Badger nodes.
 *
 */
public class Sett {

  private Badger topBadger; // top of the BST

  /**
   * Constructs an empty Sett.
   */
  public Sett() {
    topBadger = null;
  }

  /**
   * Empties this Sett, to no longer contain any Badgers.
   */
  public void clear() {
    topBadger = null; // removing topBadger causes references to other badgers to be lost
  }

  /**
   * Counts how many Badgers live in this Sett.
   * @return The number of Badgers living in this Sett.
   */
  public int countBadger() {
    return countHelper(topBadger);
  }

  /**
   * This recursive helper method is used to help count the number of Badgers in this Sett.
   * @param current - The current Badger that is the root of a (sub) tree that we are counting the number of Badgers within.
   * @return the number of Badgers living in the Sett rooted at the current Badger.
   */
  private int countHelper(Badger current) {
    if(current.getLeftLowerNeighbor()==null) { // if the left is empty
      if(current.getRightLowerNeighbor()==null) { // if the right is also empty
        return 1; // bottom of the branch. return 1
      }
      else { // if the right is not empty
        return countHelper(current.getRightLowerNeighbor())+1; // increment value and recurse
      }
    } else { // if the left is not empty
      if(current.getRightLowerNeighbor()!=null) {
        return countHelper(current.getLeftLowerNeighbor()) 
            + countHelper(current.getRightLowerNeighbor());
      } else {
        return countHelper(current.getLeftLowerNeighbor())+1; // increment value and recurse
      }
    }
  }

  /**
   * Finds a Badger of a specified size in this Sett.
   * @param size - The size of the Badger object to search for and return.
   * @return The Badger found with the specified size.
   * @throws java.util.NoSuchElementException - When there is no Badger in this Sett with the
   * specified size. The message within this exception must read "WARNING: failed to find a 
   * badger with size {size} in the sett", where {size} needs to be replaced with the specified
   * size parameter.
   */
  public Badger findBadger(int size) {
    Badger found = findHelper(topBadger, size);
    return found;
  }

  /**
   * This recursive helper method is used to help find a Badger within this Sett.
   * @param current - The current Badger that is the root of a (sub) tree that we are searching for a Badger with the specified size within.
   * @param size - The size of the Badger object to search for and return.
   * @return The Badger found with the specified size.
   * @throws java.util.NoSuchElementException - When there is no Badger in this Sett with the
   * specified size. The message within this exception must read "WARNING: failed to find a 
   * badger with size {size} in the sett", where {size} needs to be replaced with the specified
   * size parameter.
   */
  private Badger findHelper(Badger current, int size) {
    if(current==null) { // if the topBadger is null, it throws
      throw new NoSuchElementException("WARNING: failed to find a badger with size " + size 
          + " in the sett");
    }
    if(current.getSize()<size) { // compares the current badger's size to the size
      if(current.getRightLowerNeighbor()==null) { // if right tree null, no badger of size exists
        throw new NoSuchElementException("WARNING: failed to find a badger with size " + size 
            + " in the sett");
      } else {
        return findHelper(current.getRightLowerNeighbor(), size); // recursive call
      }
    } else if(current.getSize()>size){ // compares the current badger's size to the size
      if(current.getLeftLowerNeighbor()==null) { // if left tree null, no badger of size exists
        throw new NoSuchElementException("WARNING: failed to find a badger with size " + size 
            + " in the sett");
      } else {
        return findHelper(current.getLeftLowerNeighbor(), size); // recursive call
      }
    } else {
      return current; // returns the badger 
    }
  }


  /**
   * Gets all Badgers living in the Sett as a list in ascending order of their size: smallest one
   * in the front (at index zero), through the largest one at the end (at index size-1).
   * @return A list of all Badgers living in the Sett in ascending order by size.
   */
  public List<Badger> getAllBadgers(){
    // locally creates a list to return
    List<Badger> allBadgers = new ArrayList<Badger>(countBadger()); 
    getAllHelper(topBadger, allBadgers);
    return allBadgers;
  }

  /**
   * This recursive helper method is used to help collect the Badgers within this Sett into a List.
   * @param current - The current Badger that is the root of a (sub) tree that we are collecting all contained Badgers within, into the allBadgers List.
   * @param allBadgers - The list of all Badgers living in the Sett that is rooted at the current Badger node. The contents of this list should be in ascending order by Badger size.
   */
  public void getAllHelper(Badger current, List<Badger> allBadgers) {
    // the method goes left > current > right
    if(current.getLeftLowerNeighbor()!=null) { // if left is not null, recursive calls with left
      getAllHelper(current.getLeftLowerNeighbor(), allBadgers);
    }
    allBadgers.add(current); // adds the current value 
    if(current.getRightLowerNeighbor()!=null) { // if right is not null, recursive calls with right
      getAllHelper(current.getRightLowerNeighbor(), allBadgers);
    }
  }

  /**
   * Computes the height of the Sett, as the number of nodes from root to the deepest leaf Badger node.
   * @return The depth of this Sett.
   */
  public int getHeight() {
    return getHeightHelper(topBadger);
  }

  /**
   * This recursive helper method is used to help compute the height of this Sett.
   * @param current - The current Badger that is the root of a (sub) tree that we are calculating the height of.
   * @return The height of the (sub) tree that we are calculating.
   */
  private int getHeightHelper(Badger current) {
    if (current == null) { // if null the branch is ended
      return 0; // adds 0
    } else { // recursive calls both sides and checks for larger, then increments by one
      return Math.max(getHeightHelper(current.getLeftLowerNeighbor()),
          getHeightHelper(current.getRightLowerNeighbor())) + 1;
    }
  }

  /**
   * Retrieves the largest Badger living in this Sett.
   * @return The largest Badger living in this Sett.
   */
  public Badger getLargestBadger() {
    Badger current = topBadger;
    while(current.getRightLowerNeighbor()!=null) { // loops through rightmost badger
      current = current.getRightLowerNeighbor();
    }
    return current; // returns rightmost badger at bottom
  }

  /**
   * Retrieve the top Badger within this Sett (the one that was settled first).
   * @return The Badger living on the top of the current Sett.
   */
  public Badger getTopBadger() {
    return topBadger;
  }

  /**
   * Checks whether this Sett is empty.
   * @return true if this Sett is empty, false otherwise.
   */
  public boolean isEmpty() {
    return topBadger == null;
  }

  /**
   * Creates a new Badger object with the specified size, and inserts them into this Sett (BST).
   * @param size - The size of the new Badger that will be settled.
   * @throws java.lang.IllegalArgumentException - When a Badger with the specified size already 
   * exists within this Sett. The message in this exception must read: "WARNING: failed to 
   * settle the badger with size {size}, as there is already a badger with the same size in this 
   * sett", where {size} needs to be replaced with the specified size parameter.
   */
  public void settleBadger(int size) {

    settleHelper(topBadger, new Badger(size)); // starts recursive loop with new badger

  }

  /**
   * This recursive helper method is used to help settle a new Badger within this Sett.
   * @param current - The current Badger (previously settled within this Sett) that we are 
   * considering settling the newBadger beneath (either to its left or right).
   * @param newBadger  - The new Badger that needs to be settled within this Sett.
   * @throws java.lang.IllegalArgumentException - When a Badger with the specified size already 
   * exists within this Sett. The message in this exception must read: "WARNING: failed to settle 
   * the badger with size {size}, as there is already a badger with the same size in this sett", 
   * where {size} needs to be replaced with the specified size parameter.
   */
  private void settleHelper(Badger current, Badger newBadger) {
    if (isEmpty()) { // checks if the list is empty
      topBadger = newBadger; // sets top badger to the new badger
    }
    if (current != null && newBadger != null) { // check for no null values
      if (newBadger.getSize() == current.getSize()) { // throws if size already exists
        throw new java.lang.IllegalArgumentException(
            "WARNING: failed to settle the badger with size " + newBadger.getSize()
                + ", as there is already a badger with the same size in this sett");
      }
      if (newBadger.getSize() > current.getSize()) { // if new badger greater than current
        if (current.getRightLowerNeighbor() == null) { // if there is no further node
          current.setRightLowerNeighbor(newBadger);
        } else { // otherwise recursive call with lower node
          settleHelper(current.getRightLowerNeighbor(), newBadger);
        }
      } else { // if new badger less than current node
        if (current.getLeftLowerNeighbor() == null) { // if there is no further node
          current.setLeftLowerNeighbor(newBadger); 
        } else { // otherwise recursive call with lower node
          settleHelper(current.getLeftLowerNeighbor(), newBadger);
        }
      }
    }
  }

}
