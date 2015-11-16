/*
 *  The programs contain in this file and its associate are
 *  properties of Indigenous Corp. 
 *  On any ocassion you need to make modification or
 *  take some part of this file for personal or organisational use,
 *  a prior permission is require from Indigenous Corp
 */
package GUIEcercises;

import javax.swing.JFrame;

/**
 *
 * @author Haleem
 */
public class ColorListTest extends JFrame
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        ColorList colorList = new ColorList();
        colorList.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        colorList.setSize( 200, 220 );
        colorList.setVisible(true);
        
    }
    
}
