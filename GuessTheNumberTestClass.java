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
public class GuessTheNumberTestClass
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        GuessTheNumber guessTheNumber = new GuessTheNumber();
        guessTheNumber.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guessTheNumber.setSize(220, 250);
        guessTheNumber.setVisible(true);
    }
    
}
