/*
 *  The programs contain in this file and its associate are
 *  properties of Indigenous Corp. 
 *  On any ocassion you need to make modification or
 *  take some part of this file for personal or organisational use,
 *  a prior permission is require from Indigenous Corp
 */
package GUIExercises;

import GUIEcercises.TemperatureConverter;
import javax.swing.JFrame;

/**
 *
 * @author Haleem
 */
public class TemTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        TemperatureConverter converter = new TemperatureConverter();
        converter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        converter.setSize( 290, 300);
        converter.setVisible(true);
    }
}
