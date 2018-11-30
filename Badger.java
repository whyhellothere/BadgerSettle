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
