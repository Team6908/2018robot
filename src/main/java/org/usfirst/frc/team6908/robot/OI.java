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
	
	public static Joystick Joystick1;
	public static Joystick Joystick2;
	
	public Button exampleCommand;
	public Button RaiseLeftRamp;
	public Button LeftRampLower;
	public Button RaiseRightRamp;
	public Button RightRampLower;	
	public Button FondleRampsUp;
	public Button FondleRampsDown;
	
	public OI() {
		Joystick1 = new Joystick(0);
		Joystick2 = new Joystick(1);
		
		//Ramp deploy buttons
		RaiseRightRamp = new JoystickButton(Joystick1, button9);
		RightRampLower = new JoystickButton(Joystick1, button10);
		RaiseLeftRamp = new JoystickButton(Joystick1, button11);
		LeftRampLower = new JoystickButton(Joystick1, button12);
		//Ramp fondle buttons
		FondleRampsUp = new JoystickButton(Joystick1, button7);
		FondleRampsDown = new JoystickButton(Joystick1, button8);
		
		RaiseLeftRamp.whileHeld(new RaiseLeftRamp());
		LeftRampLower.whileHeld(new LowerLeftRamp());
		RaiseRightRamp.whileHeld(new RaiseRightRamp());
		RightRampLower.whileHeld(new LowerRightRamp());
		FondleRampsUp.whileHeld(new FondleUpRamps());
		FondleRampsDown.whileHeld(new FondleDownRamps());
	}
}
