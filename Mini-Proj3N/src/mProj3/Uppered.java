package mProj3;

/*
 * @author Kevin Johanson 9/19/2023
 * a class that UpperCases textBlocks
 * 
 */

public class Uppered implements TextBlock{
	
	TextBlock tBlock;
	
	//
	// Constructor for Uppered 
	// creates a Uppered object which uppercases every letter thats lowercase 
	// in a TextLine and leaves everything else the same
	//
	public Uppered (TextBlock block) {
		
		this.tBlock = block;

	}

//////////////// Methods ////////////////////
	   /**
	    * compares instances 
	    */	
	  public boolean eqv(TextBlock cmp) {
		  cmp = (Uppered) cmp;
		  return ((cmp instanceof Uppered) && this.tBlock.eqv((((Uppered) cmp).tBlock)));// calls eqv recursively
	  }
	  
	  /**
	   * Determine how many rows are in the block.
	   */
	  public int height() {
	    return this.tBlock.height();
	  } // height()

	  /**
	   * Determine how many columns are in the block.
	   */
	  public int width() {
	    return this.tBlock.width();
	  } // width()	
	
	  
	  /**
	   * Uppercases the TextBlock
	   * 
	   * @exception Exception if the row number is invalid.
	   */
	  public String row(int i) throws Exception {

		String text = this.tBlock.row(i);
		char textArr[] = text.toCharArray();
		
		if ((i < 0) && (i > this.height())) { // checks to see if i is invalid
			throw new Exception("invalid row " + i); 
		} else {
			for (int x = 0; x < textArr.length ; x++ ) {
				if (Character.isLowerCase(textArr[x])) {
					textArr[x] = Character.toUpperCase(textArr[x]);
				}
			}
		}
		String newString = new String(textArr);
		return newString;
	  } // row(int)
}
