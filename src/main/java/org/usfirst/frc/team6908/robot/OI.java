package org.usfirst.frc.team6908.robot;

import edu.wpi.first.wpilibj.Joystick; 
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team6908.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */ 
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways: 

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());

	public static int oTrigger = 1;
	public static int oThumbButton = 2;
	public static int oButton3 = 3;
	public static int oButton4 = 4;
	public static int oButton5 = 5;
	public static int oButton6 = 6;
	public static int oButton7 = 7;
	public static int oButton8 = 8;
	public static int oButton9 = 9;
	public static int oButton10 = 10;
	public static int oButton11 = 11;
	public static int oButton12 = 12;
	public static int oButton13 = 13;
	
	public Joystick Joystick1;
	public Joystick Joystick2;

	public JoystickButton trigger;
	public JoystickButton button3;
	
	public OI() {
		
		Joystick1 = new Joystick(0);
		Joystick2 = new Joystick(1);
		
		trigger = new JoystickButton(Joystick1, oTrigger);
		button3 = new JoystickButton(Joystick1, oButton3);
		
		button3.whenPressed(new ChangeDirection());
		trigger.whileHeld(new FondleCube());
		
	}	
	
}
