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
	
	//Joystick Button ports
	public static int trigger = 1;
	public static int thumbButton = 2;
	public static int button3 = 3;
	public static int button4 = 4;
	public static int button5 = 5;
	public static int button6 = 6;
	public static int button7 = 7;
	public static int button8 = 8;
	public static int button9 = 9;
	public static int button10 = 10;
	public static int button11 = 11;
	public static int button12 = 12;
	public static int button13 = 13;
	
	public Joystick Joystick1;
	public Joystick Joystick2;
	
	public Button exampleCommand;
	public Button LeftRampDeploy;
	public Button RightRampDeploy;
	
	public OI() {
		Joystick1 = new Joystick(0);
		Joystick2 = new Joystick(1);
		
		//exampleCommand = new JoystickButton(TankDrive1, RobotMap.trigger);
		
		//exampleCommand.whenPressed(new ExampleCommand());
		
		LeftRampDeploy = new JoystickButton(Joystick1, button11);
		RightRampDeploy = new JoystickButton(Joystick1, button12);
		
		LeftRampDeploy.whileHeld(new RaiseLeftRamp());
		LeftRampDeploy.whileHeld(new RaiseRightRamp());
		
		
		
		//System.out.println(TankDrive1.getX());
	}
}
