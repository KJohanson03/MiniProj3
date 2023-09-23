package mProj3;
/*
 * @author Kevin Johanson 9/19/2023
 * a class that centers a TextBlock 
 * 
 */
public class Centered implements TextBlock{
	TextBlock tBlock;
	int width;
	
	//
	// Constructor for Centered 
	// creates a Centered object with width w and TextBlock block
	//
	public Centered(TextBlock block, int w) {
		tBlock = block;
		width = w;
	}
	
	
	
	
////////////////Methods ////////////////////
	   /**
	    * compares instances 
	    */	
	  public boolean eqv(TextBlock cmp) {
		  cmp = (Centered) cmp;
		  return ((cmp instanceof Centered) && this.tBlock.eqv((((Centered) cmp).tBlock))); // recursively calls eqv
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
	  
	  /*  Centers the TextLine
	  * 
	  */	  
	  public String row(int i) throws Exception {
			String leftResult = "";
			String rightResult = "";
			
			if ((i < 0) && (i > this.height())) { // checks to see if i is invalid
				throw new Exception("invalid row " + i); 
			} else if (this.width > this.tBlock.width() ) { // if width is greater than the textLine add spaces before the string until its truncWidth length 
			   for (int x = 0; x < (this.width - this.tBlock.width()); x++ ) {
				  leftResult = leftResult.concat(" "); // adds left space
				  x++;
				  if ( x < (this.width - this.tBlock.width())) { // if we still need to add space
					  rightResult = rightResult.concat(" "); //adds right space 
					  
				  }

			   }
			   
			   leftResult = leftResult.concat(this.tBlock.row(i));
			   String finalResult = leftResult.concat(rightResult);
			   return finalResult;
		  	} else {
		  		String result = this.tBlock.row(i);
		  		double cCat = this.tBlock.width() - this.width;
		  		double lCat = Math.ceil(cCat/2.0);  // the amount of char that needs to be taken away from the left side of the string
		  		double rCat = Math.floor(cCat/2.0); // the amount of char that needs to be taken away from the right side of the string
		  		

		  		
		  		result = result.substring(0,this.tBlock.width() - (int) rCat); // substrings the textLine string to the length of width - rCat
		  		result = result.substring((int)lCat, this.tBlock.width() - (int) rCat); // substrings the textLine string to the length of width - lCat from left to right

		  		
		  		//result = this.tBlock.row(i);
		  		//result = result.substring(this.tBlock.width()-this.width, this.tBlock.width()); // substrings the textLine string to the length of width from left to right
		  		return result;
		  	}
	  }
}