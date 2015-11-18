/*
 *  The programs contain in this file and its associate are
 *  properties of Indigenous Corp. 
 *  On any ocassion you need to make modification or
 *  take some part of this file for personal or organisational use,
 *  a prior permission is require from Indigenous Corp
 */

package GUIExercises;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Haleem
 */
public class TemperatureConverter extends JFrame
{
    private JTextField input, displayResult;
    private double convertedValue;
    private JRadioButton[] fromConversionType, toConversionType;
    private ButtonGroup fromButtonGroup, toButtonGroup;
    private JLabel intro, fromSelectionText, outro;
    private JButton convertButton;
    
    public TemperatureConverter()
    {   // begins the constructor
        super( "DengrDev Temperature converter" ); 
        setLayout( new FlowLayout( FlowLayout.CENTER , 5, 10 ) ); // sets the layout to a FlowLayout
        getContentPane().setBackground( Color.BLACK ); // sets background of the frame
        
        intro = new JLabel( "Input your value here: " ); // A JLabel for giving users instruction
        intro.setForeground( Color.GREEN ); // sets the color of the JLabel
        intro.setFont( new Font( "Serif" , Font.BOLD, 14) ); // sets the font of the JLabel
        add(intro); // adds JLabel intro to the Frame 
        
        
        
        // initializes input TextField with 14 columns long to recieve input from users
        input = new JTextField( "14.00", 14 ); 
        input.setFont( new Font( "Serif" , Font.BOLD, 14) ); // sets the font of input TextField
        add( input ); // add input to the frame
        
        // initializes selectionText 
        fromSelectionText = new JLabel( "Select the type you are converting to:" );
        fromSelectionText.setForeground( Color.GREEN  );
        fromSelectionText.setFont( new Font( "Serif" , Font.BOLD, 14) );
        add( fromSelectionText );
        
        // intializes fromConversionType radioButton to an array of 3 element
        fromConversionType = new JRadioButton[ 3 ];
        // intializes fromButtonGroup
        fromButtonGroup = new ButtonGroup();
        
        
        // starts intialization of fromCelcius radioButton
        fromConversionType[ 0 ] = new JRadioButton( "Celcius", true );
        fromConversionType[ 0 ].setForeground(Color.GREEN);
        fromButtonGroup.add( fromConversionType[ 0 ] );
        add( fromConversionType[ 0 ] );
        // ends intialization of fromCelcius radioButton
        
        // starts intialization of fromFerhenheit radioButton
        fromConversionType[ 1 ] = new JRadioButton( "Farhenheit", false );
        fromConversionType[ 1 ].setForeground(Color.GREEN);
        fromButtonGroup.add( fromConversionType[ 1 ] );
        add( fromConversionType[ 1 ] );
        // ends intialization of fromFerhenheit radioButton
        
        // ends intialization of fromKelvin radioButton
        fromConversionType[ 2 ] = new JRadioButton( "Kelvin", false );
        fromConversionType[ 2 ].setForeground(Color.GREEN);
        fromButtonGroup.add( fromConversionType[ 2 ] );
        add( fromConversionType[ 2 ] );
        // ends intialization of fromKelvin radioButton
        
        
        
        
        toConversionType = new JRadioButton[ 3 ];
        toButtonGroup = new ButtonGroup();
        
        // starts intialization of toCelcius radioButton
        toConversionType[ 0 ] = new JRadioButton( "Celcius", false );
        toConversionType[ 0 ].setForeground(Color.GREEN);
        toButtonGroup.add( toConversionType[ 0 ] );
        add( toConversionType[ 0 ] );
        // ends intialization of celcius radioButton
        
        // starts intialization of toFerhenheit radioButton
        toConversionType[ 1 ] = new JRadioButton( "Farhenheit", false );
        toConversionType[ 1 ].setForeground(Color.GREEN);
        toButtonGroup.add( toConversionType[ 1 ] );
        add( toConversionType[ 1 ] );
        // ends intialization of toFerhenheit radioButton
        
        // starts intialization of toKelvin radioButton
        toConversionType[ 2 ] = new JRadioButton( "Kelvin", true );
        toConversionType[ 2 ].setForeground(Color.GREEN);
        toButtonGroup.add( toConversionType[ 2 ] );
        add( toConversionType[ 2 ] );
        // ends intialization of toKelvin radioButton
        
        // starts intialization of convertButton
        convertButton = new JButton( "    CONVERT    " );
        convertButton.setBorderPainted( true );
        add( convertButton );
        // ends intialization of convertButton
        
        
        // starts intialization of displayResult TextField
        displayResult = new JTextField( "CHECK RESULT HERE", 14 );
        displayResult.setBackground( Color.WHITE );
        displayResult.setForeground( Color.RED );
        displayResult.setEditable( false );
        displayResult.setFont( new Font( "Serif" , Font.BOLD, 14) );
        add( displayResult );
        // ends intialization of displayResult TextField
        
        // starts intialization of outro JLabel
        
        outro = new JLabel( "As designed by Haleem " );
        outro.setForeground( Color.RED );
        outro.setFont( new Font( "Serif" , Font.BOLD, 14) );
        add( outro );
        // ends intialization of outro JLabel
        
        convertValues();
        
    } // ends the constructor
     
    private class ConvertButtonHandler implements ActionListener
    {
        private double value;
        
        private ConvertButtonHandler( double inValue )
        {
            value = inValue;
        }
        
        @Override
        public void actionPerformed( ActionEvent event )
        {
            displayResult.setText( ""+ value );
        }

    }
    
    
    private void convertValues() 
    { // starts method convertValues
    // this if else block is expected to make approriate calculations 
        // based on the types selected from the two types of the provided radioButtons
        if ( fromConversionType[ 0 ].isSelected()&& // if from celcius and 
                toConversionType[ 1 ].isSelected() ) // to ferhenheit are both selected
        {
            convertButton.addActionListener( 
                    new ConvertButtonHandler( // invoke the ConvertButton
                            celciusToFerhenheit( // this method is called and passed a double value
                            Double.parseDouble( // parses the input textField to a double value
                                input.getText() // gets the text in input textField
                            )
                        )
                     ) 
            );
        } 
        else if ( fromConversionType[ 0 ].isSelected()&& // if from celcius and 
                toConversionType[ 2 ].isSelected() ) // to kelvin are both selected
        { // starts if
            convertButton.addActionListener( 
                    new ConvertButtonHandler( 
                        celciusToKelvin( 
                            Double.parseDouble( 
                                input.getText()
                            )
                        )
                     ) 
            );
        } // ends if
        else if ( fromConversionType[ 1 ].isSelected()&& // if from ferhenheit and 
                toConversionType[ 0 ].isSelected() ) // to celcius are both selected
        {
            convertButton.addActionListener( 
                    new ConvertButtonHandler( 
                            ferhenheitToCelcius(
                            Double.parseDouble( 
                                input.getText()
                            )
                        )
                     ) 
            );
        } 
        else if ( fromConversionType[ 1 ].isSelected()&& // if from ferhenheit and 
                toConversionType[ 2 ].isSelected() ) // to kelvin are both selected
        {
            convertButton.addActionListener( 
                    new ConvertButtonHandler( 
                        ferhenheitToKelvin( 
                            Double.parseDouble( 
                                input.getText()
                            )
                        )
                     ) 
            );
        } 
        else if ( fromConversionType[ 2 ].isSelected()&& // if from kelvin and 
                toConversionType[ 0 ].isSelected() ) // to celcius are both selected
        {
            convertButton.addActionListener( 
                    new ConvertButtonHandler( 
                        kelvinToCelcius( 
                            Double.parseDouble( 
                                input.getText()
                            )
                        )
                     ) 
            );
        } 
        else if ( fromConversionType[ 2 ].isSelected()&& // if from kelvin and 
                toConversionType[ 1 ].isSelected() ) // to ferhenheit are both selected
        {
            convertButton.addActionListener( 
                    new ConvertButtonHandler( 
                            kelvinToFerhenheit(
                            Double.parseDouble( 
                                input.getText()
                            )
                        )
                     ) 
            );
        } 
        else 
        { // some conversion type are not supported so the need for this if
            displayResult.setText( " Type not supported " );
        } 
    
    } // ends method convertValues
    
    // Methods that are expected to make respective calculations for the specified 
    // types of conversion types brgins here
    // Not all methods have the expected formula, just a demo formula 
    // to check if they are working fine... 
    private double celciusToKelvin( double value )
    {
        double convertedValue = value + 273.15;
        return  convertedValue;
    }
    
    private double kelvinToCelcius( double value )
    {
        convertedValue = value + 273.15;
        return  convertedValue;
    }
    
    private double celciusToFerhenheit( double value )
    {
        donvertedValue = value + 273.15;
        return  convertedValue;
    }
    
    private double ferhenheitToCelcius ( double value )
    {
        convertedValue = value + 273.15;
        return  convertedValue;
    }
    
    private double ferhenheitToKelvin( double value )
    {
        convertedValue = value + 273.15;
        return  cconvertedValue;
    }
    
    private double kelvinToFerhenheit( double value )
    {
        convertedValue = value + 273.15;
        return  convertedValue;
    }
} // ends TemperatureConverter class
