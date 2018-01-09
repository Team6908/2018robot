package org.usfirst.frc.team6908.robot;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Talon;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;

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
	//These can all be changed to be more descriptive of what they do,
	//but are currently named for ease of initialization
	
	
	public static Spark frontLeft = new Spark(1);
	public static Spark frontRight = new Spark(2);
	public static Spark backLeft = new Spark(3);
	public static Spark backRight = new Spark(4);
}
