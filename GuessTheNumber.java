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
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;
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
public class GuessTheNumber extends JFrame
{
    private int guessedNumber; // value guessed by the program
    private int userInput; // for storing user input
    private static int userGuessAmount = 0, correctAnswerGuess = 0;
    private JTextField inputField; // for accepting input
    private JLabel instructionLabel; // giving the users instruction
    private JLabel guessStatus;
    private JLabel showGuessedNumber;
    private JLabel showNumberofTimesUseGuessed;
    private JLabel correctGuessLabel;
    private JLabel correctGuessedNumber;
    private JButton button;
    private JRadioButton yesRadioButton, noRadioButton;
    private ButtonGroup buttonGroup;
    
    public GuessTheNumber()
    {
        super( "A guess program" );
        setLayout( new FlowLayout() );
        
        correctGuessLabel = new JLabel( "WOW! YOU MADE IT" );
        correctGuessLabel.setVisible( false );
        add( correctGuessLabel );
        
        correctGuessedNumber = new JLabel( 
                "You made it in your " + userGuessAmount + " guess" );
        correctGuessedNumber.setVisible( false );
        add( correctGuessedNumber );
        
        instructionLabel = new JLabel( 
                "Can you guess my secret number?" );
        instructionLabel.setFont( new Font( "Serif" ,Font.PLAIN, 14) );                    
        instructionLabel.setForeground(Color.RED);
        add( instructionLabel );
        
        buttonGroup = new ButtonGroup();
        
        yesRadioButton = new JRadioButton( "YES!", false );
        buttonGroup.add( yesRadioButton );
        add( yesRadioButton );
        yesRadioButton.addItemListener( new RadioButtonHandler() );
        
        noRadioButton = new JRadioButton( "NO!" , true );
        buttonGroup.add( noRadioButton );
        add( noRadioButton );
        noRadioButton.addItemListener( new RadioButtonHandler() );
        
        
        inputField = new JTextField( "0", 10 );
        add( inputField );
        
        showNumberofTimesUseGuessed = new JLabel( 
                "This is your" + userGuessAmount + " guess" );
        add( showNumberofTimesUseGuessed );
        
        button = new JButton( "GUESS!" );
        add( button );
        
        
        guessStatus = new JLabel( ); 
        add( guessStatus );
        
        showGuessedNumber = new JLabel();
        showGuessedNumber.setVisible( false );
        add(showGuessedNumber);
        
        
        inputField.setVisible( false );
        button.setVisible( false );
        guessStatus.setVisible( false );
        showNumberofTimesUseGuessed.setVisible( false );
        
        run();
    }
    
    private class RadioButtonHandler implements ItemListener
    {

        @Override
        public void itemStateChanged(ItemEvent event) 
        {
            if ( yesRadioButton.isSelected() ) 
            {
                yesRadioButtonSelected();
            }
            else if ( noRadioButton.isSelected() ) 
            {
                noRadioButtonSelected();
            }
        }
        
    }
    
    private class ButtonHandler implements ActionListener
    {
        int guessedValue;
        private ButtonHandler( int number )
        {
            guessedValue = number;
        }
        
        @Override
        public void actionPerformed(ActionEvent event) 
        {
            
            userInput = Integer.parseInt( inputField.getText() );
            
            showGuessedNumber.setText( "       " + guessedNumber );
            showGuessedNumber.setVisible( true );
            
            checkInput();
            if ( event.getActionCommand() == "pLAY AGAIN!" ) 
            {
                runAgain();
            }
        }
        
    }
    
    private void run ()
    {
        Random random = new Random();
        guessedNumber = 1 + random.nextInt( 1000 );
        guessStatus.setText("You are yet to make a guess");
        
        button.addActionListener( 
                new ButtonHandler( 
                        guessedNumber 
                ) 
        );
        
        
        
    }
    
    private void checkInput()
    {
        
        
        if ( userInput == guessedNumber  && userInput != 0 )
        {
        
            if ( userGuessAmount <= 3 ) 
            {
                userGuessAmount++; 
                correctAnswerGuess = userGuessAmount;
                correctGuessLabel.setText( "CORRECT! You are a genius" );
                correctGuessLabel.setVisible( true );
                correctGuessedNumber.setVisible( true );
                
            }
            else if ( userGuessAmount > 3 )
            {
                userGuessAmount++;
                correctAnswerGuess = userGuessAmount;
                inputField.setVisible( false );
                guessStatus.setText( "CORRECT! You are a great" );
                correctGuessLabel.setVisible( true );
                correctGuessedNumber.setVisible( true );
                
            }
            
            playAgain();
            
        }
        else if ( userInput > guessedNumber  && userInput != 0  ) 
        {
            if ( userInput <= guessedNumber + 10 ) 
            {
                amountOfGuesses();
                instructionLabel.setText( "Just some FIGURES!!!" );
                setRadioButtonVisibilityToFalse();
                guessStatus.setText( "Try harder, Just some figures lower" );
            }
            else if ( userInput >= guessedNumber + 10 )
            {
                amountOfGuesses();
                guessHint();
                setRadioButtonVisibilityToFalse();
                guessStatus.setText( " Whoops, You are too too high! " );
                
            }
            
            button.setText( "TRY AGAIN" );
        }
        else if ( userInput < guessedNumber && userInput != 0 )
        {
            if ( userInput > guessedNumber - 10 ) 
            {
                amountOfGuesses();
                instructionLabel.setText( "Just some FIGURES!!!" );
                setRadioButtonVisibilityToFalse();
                guessStatus.setText( "Try harder, Just some figures higher" );
            }
            else if ( userInput < guessedNumber - 10 )
            {
                amountOfGuesses();
                guessHint();
                setRadioButtonVisibilityToFalse();
                guessStatus.setText( " Whoops, You are too too low! " );
            }   
            button.setText( "TRY AGAIN" );
        }
        else if ( userInput == 0)
        {
            setRadioButtonVisibilityToFalse();
            guessStatus.setText( " Enter a Valid value > 0 " );
            showNumberofTimesUseGuessed.setVisible( true );
        }
    }
    
    private void guessHint()
    {
        int upperGuessedNumberValue = guessedNumber + 10,
                lowerGuessedNumberValue = guessedNumber - 10;
        instructionLabel.setText( 
                        "The number is within" + lowerGuessedNumberValue 
                                + " and " + upperGuessedNumberValue );
        instructionLabel.setVisible( true );
    }
    
    private void yesRadioButtonSelected()
    {
        setRadioButtonVisibilityToFalse();
        instructionLabel.setText( "NOW GUESS!!!!!!" );
        noRadioButton.setVisible( false );
        inputField.setVisible( true );
        showNumberofTimesUseGuessed.setVisible( true );
        guessStatus.setVisible( true );
        button.setVisible( true );
    }
    
    private void amountOfGuesses()
    {
        userGuessAmount++;
        correctAnswerGuess = userGuessAmount;
        if (userGuessAmount == 1) 
        {
            showNumberofTimesUseGuessed.setText(  
            "You've already made" + userGuessAmount + " guess"  );
        }
        else
            showNumberofTimesUseGuessed.setText(  
            "You've already made" + userGuessAmount + " guesses"  );
        
    }
    
    private void noRadioButtonSelected()
    {
        setRadioButtonVisibilityToTrue();
        showNumberofTimesUseGuessed.setVisible( false );
        inputField.setVisible( false );
        guessStatus.setVisible( false );
        button.setVisible( false );
    }
    
    private void setRadioButtonVisibilityToTrue()
    {
        yesRadioButton.setVisible( true );
        noRadioButton.setVisible( true );
    }
    
    private void setRadioButtonVisibilityToFalse()
    {
        yesRadioButton.setVisible( false );
            noRadioButton.setVisible( false );
    }
    
    private void playAgain()
    {
        instructionLabel.setVisible( false );
        inputField.setVisible( false );
        guessStatus.setVisible( false );
        showNumberofTimesUseGuessed.setVisible( false );
        inputField.setText( "0" );
        instructionLabel.setText( "Do you want to play Again?" );
        setRadioButtonVisibilityToTrue();
        button.setText( "pLAY AGAIN!" );
    }
    
    private void runAgain()
    {
        correctGuessLabel.setVisible( false );
        correctGuessedNumber.setVisible( false );
        instructionLabel.setVisible( true );
        inputField.setVisible( true );
        showNumberofTimesUseGuessed.setVisible( true );
        guessStatus.setVisible( true );
        
        inputField.setEditable( true );
        showNumberofTimesUseGuessed.setVisible( true );
        userGuessAmount = 0;
        showNumberofTimesUseGuessed.setText(   
        "This is your" + userGuessAmount + " guess"   );
        instructionLabel.setText( "NOW GUESS!!!!!!" );
        button.setText(" GUESS! ");
        run();
    }
}
