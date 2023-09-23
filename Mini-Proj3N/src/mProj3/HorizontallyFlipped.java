package mProj3;

/**
 * The horizontal composition of two text blocks.
 * 
 * @author Kevin Johanson
 * Code snippets taken from SamR CSC 207
 * @version 1.3 of February 2019
 */
public class HorizontallyFlipped implements TextBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The left portion of the composition.
   */
  TextBlock left;

  /**
   * The right portion of the composition.
   */
  TextBlock right;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new block by composing left and right side by side.
   */
  public HorizontallyFlipped(TextBlock left, TextBlock right) {
    this.left = right;
    this.right = left;
  } // HorizontallyFlipped

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * compares instances 
   */	
 public boolean eqv(TextBlock cmp) {
	  cmp = (HorizontallyFlipped) cmp;
	  return (((cmp instanceof RightJustified) && this.left.eqv((((HorizontallyFlipped) cmp).left))) // checks the left path then right then calls both recursively
			  && this.right.eqv((((HorizontallyFlipped) cmp).right)));
 }


  /**
   * Get one row from the block.
   * 
   * @pre 0 <= i < this.height()
   * @exception Exception if the precondition is not met
   */
  public String row(int i) throws Exception {
    int lh = this.left.height();
    int rh = this.right.height();
    int h = Math.max(lh, rh);

    // Sanity check
    if ((i < 0) || (i >= h)) {
      throw new Exception("Invalid row " + i);
    } // if the row is invalid

    String result;
    if (i < lh) {
      result = this.left.row(i);
    } else {
      result = TBUtils.spaces(this.left.width());
    }
    if (i < rh) {
      result = result.concat(this.right.row(i));
    } else {
      result = result.concat(TBUtils.spaces(this.right.width()));
    }

    return result;
  } // row(int)

  /**
   * Determine how many rows are in the block.
   */
  public int height() {
    // The height is the greater of the heights of the left and right
    // blocks.
    return Math.max(this.left.height(), this.right.height());
  } // height()

  /**
   * Determine how many columns are in the block.
   */
  public int width() {
    // The number of columns is the width of the left plus the
    // width of the right.
    return this.left.width() + this.right.width();
  } // width()

} // class HorizontallyFlipped
