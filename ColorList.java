/*
 *  The programs contain in this file and its associate are
 *  properties of Indigenous Corp. 
 *  On any ocassion you need to make modification or
 *  take some part of this file for personal or organisational use,
 *  a prior permission is require from Indigenous Corp
 */

package GUIEcercises;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

/**
 *
 * @author Haleem
 */
public class ColorList extends JFrame
{
    private JComboBox colorJComboBox;
    private JRadioButton[] colorRadioButtons;
    private JButton[] colorButton;
    private String[] colorNames = { "Kindly select a color","Black", "Blue", 
        "Cyan", "Dark Gray", "Gray", "Green", "Light Green", 
        "Magenta", "Orange", "pink", "Red","White", "Yellow"  },
            // initializes names for colors
            
            radioButtonNames = { "Background", "Foreground" }, 
            // initializes names for combobox
            
            bottonNames = { "Ok", "Cancel" } // initializes names for buttons
            ; // end arrays of string type
    
    private static final Color[] colors = 
    {
        Color.BLACK, Color.BLUE, 
        Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY,
        Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, 
        Color.YELLOW
    };
    
    @SuppressWarnings("unchecked")
    public ColorList()
    {
        super( "Color List" );
        setLayout( new FlowLayout( FlowLayout.CENTER, 4, 5) );
        
        colorJComboBox = new JComboBox( colorNames );
        add( colorJComboBox );
        
        colorRadioButtons = new JRadioButton[ radioButtonNames.length ];
        
        colorRadioButtons[ 0 ] = new JRadioButton( radioButtonNames[ 0 ], true );
        colorRadioButtons[ 1 ] = new JRadioButton( radioButtonNames[ 1 ],false );        
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add( colorRadioButtons[ 0 ] );
        buttonGroup.add( colorRadioButtons[ 1 ] );
        add( colorRadioButtons[ 0 ] );
        add(colorRadioButtons[ 1 ] );
        
        colorButton = new JButton[ bottonNames.length ];
        colorButton[ 0 ] = new JButton( bottonNames[ 0 ] );
        colorButton[ 1 ] = new JButton( bottonNames[ 1 ] );
        add( colorButton[ 0 ] );
        add( colorButton[ 1 ] );
        
        // No action handler yet... 
        // I'm still looking for a way out to get the action hadler provided...
        // Don't know which to choose between ItemListener and ActionListener
        // but still runs with its test class and displays as expected
        // Thanks
        
    }
}
