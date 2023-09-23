package mProj3;

import java.io.PrintWriter;

/**
 * A series of experiments with the text block layout classes.
 * 
 * @author Samuel A. Rebelsky
 * @version 1.3 of September 2019
 */
public class TBExpt {
  // +------+--------------------------------------------------------------
  // | Main |
  // +------+

  public static void main(String[] args) throws Exception {
    // Prepare for input and output
    PrintWriter pen = new PrintWriter(System.out, true);

    // Create a block to use
    TextBlock block = new TextLine("Farm House");
    
    // Create a block to use
    TextBlock blockBottom = new TextLine("Hello");    

    // Print out the block
    TBUtils.print(pen, block);

    // Test for eqv
    Truncated eqv1 = new Truncated(block,3);    

    // test for eqv
    Truncated eqv2 = new Truncated(block,10);      
    
    // Print out the block
    System.out.println(eqv1.eqv(eqv2));
    
    // create a Truncated object 
    Truncated trunc = new Truncated(block, 10);
    
    // Print out the block
    TBUtils.print(pen, trunc);
    
    // create a Truncated object 
    RightJustified right = new RightJustified(block, 2);
    
    // Print out the block
    TBUtils.print(pen, right);
    
    // create a Centered object 
    Centered center = new Centered(block, 30);
    
    // Print out the block
    TBUtils.print(pen, center);
    
    // create a VerticallyFlipped object 
    VerticallyFlipped vComp = new VerticallyFlipped(block, blockBottom);
    
    // Print out the block
    TBUtils.print(pen, vComp);
    
    // create a HorizontallyFlipped object 
    HorizontallyFlipped hComp = new HorizontallyFlipped(block, blockBottom);
    
    // Print out the block
    TBUtils.print(pen, hComp);    
    
    // create a HorizontallyFlipped object 
    Uppered upper = new Uppered(block);
    
    // Print out the block
    TBUtils.print(pen, upper);    
    
    // Clean up after ourselves.
    pen.close();
  } // main(String[])

} // class TBExpt
