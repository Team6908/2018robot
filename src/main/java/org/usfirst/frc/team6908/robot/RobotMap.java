package org.usfirst.frc.team6908.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI.Port;

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
	
	public static WPI_TalonSRX frontLeft = new WPI_TalonSRX(2);
	public static WPI_TalonSRX frontRight = new WPI_TalonSRX(1);
	public static WPI_TalonSRX backLeft = new WPI_TalonSRX(3);
	public static WPI_TalonSRX backRight = new WPI_TalonSRX(0);
	
	public static AHRS gyro = new AHRS(Port.kMXP);
	public static Encoder rightEncoder = new Encoder(0,1);
	public static Encoder leftEncoder = new Encoder(2,3);
	
}
