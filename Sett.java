import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Sett {

  private Badger topBadger;

  public Sett() {
    topBadger = null;
  }

  public void clear() {
    topBadger = null; // removing topBadger causes references to other badgers to be lost
  }

  public int countBadger() {
    return countHelper(topBadger);
  }

  private int countHelper(Badger current) {
    if(current.getLeftLowerNeighbor()==null) { // if the left is empty
      if(current.getRightLowerNeighbor()==null) { // if the right is also empty
        return 1; // bottom of the branch. return 1
      }
      else { // if the right is not empty
        return countHelper(current.getRightLowerNeighbor())+1; // increment return value and recurse
      }
    } else { // if the left is not empty
      if(current.getRightLowerNeighbor()!=null) {
        return countHelper(current.getLeftLowerNeighbor()) + countHelper(current.getRightLowerNeighbor());
      } else {
        return countHelper(current.getLeftLowerNeighbor())+1; // increment return value and recurse
      }
    }
  }

  public Badger findBadger(int size) {
    Badger found = findHelper(topBadger, size);
    return found;
  }

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


  public List<Badger> getAllBadgers(){
    // locally creates a list to return
    List<Badger> allBadgers = new ArrayList<Badger>(countBadger()); 
    getAllHelper(topBadger, allBadgers);
    return allBadgers;
  }

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

  public int getHeight() {
    return getHeightHelper(topBadger);
  }

  private int getHeightHelper(Badger current) {
    if (current == null) {
      return 0;
    } else {
      return Math.max(getHeightHelper(current.getLeftLowerNeighbor()),
          getHeightHelper(current.getRightLowerNeighbor())) + 1;
    }
  }

  public Badger getLargestBadger() {
    Badger current = topBadger;
    while(current.getRightLowerNeighbor()!=null) { // loops through rightmost badger
      current = current.getRightLowerNeighbor();
    }
    return current; // returns rightmost badger at bottom
  }

  public Badger getTopBadger() {
    return topBadger;
  }

  public boolean isEmpty() {
    return topBadger == null;
  }

  public void settleBadger(int size) {

    settleHelper(topBadger, new Badger(size)); // starts recursive loop with new badger

  }

  private void settleHelper(Badger current, Badger newBadger) {
    if (topBadger == null) {
      topBadger = newBadger;
    }
    if (current != null && newBadger != null) {
      if (newBadger.getSize() == current.getSize()) {
        throw new java.lang.IllegalArgumentException(
            "WARNING: failed to settle the badger with size " + newBadger.getSize()
                + ", as there is already a badger with the same size in this sett");
      }
      if (newBadger.getSize() > current.getSize()) {
        if (current.getRightLowerNeighbor() == null) {
          current.setRightLowerNeighbor(newBadger);
        } else {
          settleHelper(current.getRightLowerNeighbor(), newBadger);
        }
      } else {
        if (current.getLeftLowerNeighbor() == null) {
          current.setLeftLowerNeighbor(newBadger);
        } else {
          settleHelper(current.getLeftLowerNeighbor(), newBadger);
        }
      }
    }
  }

}
