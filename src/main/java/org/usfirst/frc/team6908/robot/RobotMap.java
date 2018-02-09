package org.usfirst.frc.team6908.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.VictorSP;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
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

	//These can all be changed to be more descriptive of what they do,
	//but are currently named for ease of initialization
	
	
	/*public static Spark frontLeft = new Spark(1);
	public static Spark frontRight = new Spark(2);
	public static Spark backLeft = new Spark(3);
	public static Spark backRight = new Spark(4);*/
	
	public static WPI_TalonSRX frontLeftT = new WPI_TalonSRX(1);
	public static WPI_TalonSRX frontRightT = new WPI_TalonSRX(2);
	public static WPI_TalonSRX backLeftT = new WPI_TalonSRX(0);
	public static WPI_TalonSRX backRightT = new WPI_TalonSRX(3);
	
	public static VictorSP elevator = new VictorSP(0);
	public static Encoder elevatorEncoder = new Encoder(0,1);
	
	public static DigitalInput botElevatorLimit = new DigitalInput(8);
	public static DigitalInput topElevatorLimit = new DigitalInput(9);
}
