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
	public Joystick Joystick1;
	public Joystick Joystick2;
	
	public static Button botStatic;
	public static Button switchStatic;
	public static Button scaleStatic;
	
	public OI() {
		Joystick1 = new Joystick(RoboC.joystick1Port);
		Joystick2 = new Joystick(RoboC.joystick2Port);
		
		botStatic = new JoystickButton(Joystick2, RoboC.button7);
		switchStatic = new JoystickButton(Joystick2, RoboC.button9);
		scaleStatic = new JoystickButton(Joystick2, RoboC.button11);
		
		botStatic.whenPressed(new StaticHeightControl(RoboC.baseHeight));
		switchStatic.whenPressed(new StaticHeightControl(RoboC.switchHeight));
		scaleStatic.whenPressed(new StaticHeightControl(RoboC.scaleHeight));
	}
}
