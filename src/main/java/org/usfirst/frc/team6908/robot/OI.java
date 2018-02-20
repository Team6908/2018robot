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

	public static Button fondleIn;
	public static Button fondleOut;
	public static Button botStatic;
	public static Button switchStatic;
	public static Button scaleStatic;
	public static Button iAmSoHungry;
	
	public OI() {
		Joystick1 = new Joystick(RobotConstants.joystick1Port);
		Joystick2 = new Joystick(RobotConstants.joystick2Port);
		
		fondleIn = new JoystickButton(Joystick1, RobotConstants.trigger);
		fondleOut = new JoystickButton(Joystick2,RobotConstants.trigger);
		botStatic = new JoystickButton(Joystick2, RobotConstants.button7);
		switchStatic = new JoystickButton(Joystick2, RobotConstants.button9);
		scaleStatic = new JoystickButton(Joystick2, RobotConstants.button11);
		iAmSoHungry = new JoystickButton(Joystick1, RobotConstants.button6);
		
		fondleIn.whileHeld(new FondleCubeIn());
		fondleOut.whileHeld(new FondleCubeOut());
		botStatic.whenPressed(new StaticHeightControl(RobotConstants.baseHeight));
		switchStatic.whenPressed(new StaticHeightControl(RobotConstants.switchHeight));
		scaleStatic.whenPressed(new StaticHeightControl(RobotConstants.scaleHeight));
		iAmSoHungry.whenPressed(new ServoRelease());
	}	
	
}
