package mProj3;
/*
 * @author Kevin Johanson 9/19/2023
 * a class that truncates textBlocks
 * 
 */

public class Truncated implements TextBlock{
	
	TextBlock tBlock;
	int truncWidth;
	
	//
	// Constructor for Truncated 
	// creates a Truncated object with width w and TextBlock block
	//
	public Truncated (TextBlock block, int w) {
		
		this.tBlock = block;
		this.truncWidth = w;
		
	}

//////////////// Methods ////////////////////
	   /**
	    * compares instances 
	    */	
	  public boolean eqv(TextBlock cmp) {
		  cmp = (Truncated) cmp;
		  return ((cmp instanceof Truncated) && this.tBlock.eqv((((Truncated) cmp).tBlock))); // calls eqv recursively
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
	    return this.truncWidth;
	  } // width()	
	
	  
	  /**
	   * truncates the TextBlock
	   * 
	   * @exception Exception if the row number is invalid.
	   */
	  public String row(int i) throws Exception {

		String result = this.tBlock.row(i);
		
		if ((i < 0) && (i > this.height())) { // checks to see if i is invalid
			throw new Exception("invalid row " + i); 
		} else if (truncWidth > this.tBlock.width() ) { // if truncWidth is greater than the textLine add spaces onto the string until its truncWidth length 
		   for (int x = 0; x < (truncWidth - this.tBlock.width()); x++ ) {
			  result = result.concat(" ");

		   }
		   return result;
	  	} else {

	  		result = result.substring(0,truncWidth); // substrings the textLine string to the length of truncWidth
	  		return result;
	  	}
	  
	  } // row(int)
}
