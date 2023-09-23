package mProj3;
/*
 * @author Kevin Johanson 9/19/2023
 * a class that right justifies a TextBlock 
 * 
 */
public class RightJustified implements TextBlock{
	TextBlock tBlock;
	int width;
	
	
	//
	// Constructor for RightJustified 
	// creates a R object with width w and TextBlock block
	//
	public RightJustified(TextBlock block, int w) {
		this.tBlock = block;
		this.width = w;
	}
	
////////////////Methods ////////////////////
	
	   /**
	    * compares instances 
	    */	
	  public boolean eqv(TextBlock cmp) {
		  cmp = (RightJustified) cmp;
		  return ((cmp instanceof RightJustified) && this.tBlock.eqv((((RightJustified) cmp).tBlock))); // recursively calls eqv
	  }
	  	
	  /**
	   * Determine how many rows are in the block.
	   * 
	   */
	  public int height() {
	    return this.tBlock.height();
	  } // height()
	  
	  
	  /**
	   * Determine how many columns are in the block.
	   * 
	   */
	  public int width() {
	    return this.tBlock.width();
	  } // height()
	  
	  
	 /*
	  * Right justified the TextLine
	  * 
	  */
	  public String row(int i) throws Exception {
			String result = "";
			
			if ((i < 0) && (i > this.height())) { // checks to see if i is invalid
				throw new Exception("invalid row " + i); 
			} else if (this.width > this.tBlock.width() ) { // if width is greater than the textLine add spaces before the string until its truncWidth length 
			   for (int x = 0; x < (this.width - this.tBlock.width()); x++ ) {
				  result = result.concat(" ");

			   }
			   result = result.concat(this.tBlock.row(i));
			   return result;
		  	} else {
		  		result = this.tBlock.row(i);
		  		result = result.substring(this.tBlock.width()-this.width, this.tBlock.width()); // substrings the textLine string to the length of width from left to right
		  		return result;
		  	}
		  
	  
	  }
}
