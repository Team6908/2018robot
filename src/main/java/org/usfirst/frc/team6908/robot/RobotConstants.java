package org.usfirst.frc.team6908.robot;

public class RobotConstants {
	public static final float lowRangeTurn = .3f;
	public static final float highRangeTurn = 1f;
	public static final float lowRangeThrottle = .3f;
	public static final float highRangeThrottle = 1f;
	public static final int minAxis = -1;
	public static final int maxAxis = 1;
	public static final float elevatorExtendSpeed = .6f;
	public static final float joystickDeadzone = .1f;
	public static final float elevatorP = -.011f;
	public static final float elevatorI = 0f;
	public static final float elevatorD = 0f;
	public static final int elevatorTolerance = 5;
	public static final int baseHeight = 0;
	public static final double switchHeight = -12350.75;
	public static final double scaleHeight = -22631.5;
	public static final int joystick1Port = 0;
	public static final int joystick2Port = 1;
	public static final float minFlywheelThrottle = 1f;//Speed for outwards push
	public static final float maxFlywheelThrottle = -1f;//Speed for inwards pull
	public static boolean fondleVector = true;

	//RoboRIO ports
	public static final int frontLeftTalon = 1;
	public static final int frontRightTalon = 2;
	public static final int backLeftTalon = 0;
	public static final int backRightTalon = 3;
	public static final int elevatorVictor = 1;
	public static final int leftFlywheelSpark = 4;
	public static final int rightFlywheelSpark = 5;
	
	//Joystick Button ports
	public static final int trigger = 1;
	public static final int thumbButton = 2;
	public static final int button3 = 3;
	public static final int button4 = 4;
	public static final int button5 = 5;
	public static final int button6 = 6;
	public static final int button7 = 7;
	public static final int button8 = 8;
	public static final int button9 = 9;
	public static final int button10 = 10;
	public static final int button11 = 11;
	public static final int button12 = 12;
	public static final int button13 = 13;

}
