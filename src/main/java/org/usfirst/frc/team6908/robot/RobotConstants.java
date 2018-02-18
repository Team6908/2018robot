package org.usfirst.frc.team6908.robot;

public class RobotConstants {
	//Acceleration multipliers
	public static final double LOW_RANGE_TURN = .3;
	public static final double HIGH_RANGE_TURN = 1;
	public static final double LOW_RANGE_THROTTLE = .3;
	public static final double HIGH_RANGE_THROTTLE = 1;
	//Elevator
	public static final double elevatorExtendSpeed = .6;
	public static final double joystickDeadzone = .1;
	public static final double elevatorP = -.011;
	public static final double elevatorI = 0;
	public static final double elevatorD = 0;
	public static final int elevatorTolerance = 5;
	public static final int baseHeight = 0;
	public static final double switchHeight = -12350.75;
	public static final double scaleHeight = -22631.5;
	//Intake
	public static final double minFlywheelThrottle = 1;//Speed for outwards push
	public static final double maxFlywheelThrottle = -1;//Speed for inwards pull
	
	public static final int minAxis = -1;
	public static final int maxAxis = 1;


	//RoboRIO ports
		//Drivetrain
		public static final int frontLeftTalon = 1;
		public static final int frontRightTalon = 2;
		public static final int backLeftTalon = 0;
		public static final int backRightTalon = 3;
		//Elevator
		public static final int elevatorVictor = 1;
		public static final int botElevatorLimit = 9;
		public static final int topElevatorLimit = 8;
		//Intake
		public static final int leftFlywheelSpark = 4;
		public static final int rightFlywheelSpark = 5;
	
	//Joystick Button ports
	public static final int joystick1Port = 0;
	public static final int joystick2Port = 1;
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
