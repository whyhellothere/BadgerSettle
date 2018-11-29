
public class Badger {

  private Badger leftLowerNeighbor;
  private Badger rightLowerNeighbor;
  private final int size;
  
  public Badger(int size) {
    leftLowerNeighbor = null; // assigns neighbor values to null
    rightLowerNeighbor = null;
    this.size = size;
  }
  
  public Badger getLeftLowerNeighbor() {
    return leftLowerNeighbor;
  }
  
  public Badger getRightLowerNeighbor() {
    return rightLowerNeighbor;
  }
  
  public int getSize() {
    return size;
  }
  
  public void setLeftLowerNeighbor(Badger badger) {
    leftLowerNeighbor = badger;
  }
  
  public void setRightLowerNeighbor(Badger badger) {
    rightLowerNeighbor = badger;
  }
  
  
  
}
