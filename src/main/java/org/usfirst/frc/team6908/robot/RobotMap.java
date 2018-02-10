package org.usfirst.frc.team6908.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DigitalInput;

import edu.wpi.first.wpilibj.Spark;  
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.VictorSP;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

//import com.kauailabs.navx.frc.AHRS;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static WPI_TalonSRX frontLeftT = new WPI_TalonSRX(RobotConstants.frontLeftTalon);
	public static WPI_TalonSRX frontRightT = new WPI_TalonSRX(RobotConstants.frontRightTalon);
	public static WPI_TalonSRX backLeftT = new WPI_TalonSRX(RobotConstants.backLeftTalon);
	public static WPI_TalonSRX backRightT = new WPI_TalonSRX(RobotConstants.backRightTalon);
	
	public static VictorSP elevator = new VictorSP(RobotConstants.elevatorVictor);
	public static Encoder elevatorEncoder = new Encoder(4, 5);
	
	public static Spark leftFlywheel = new Spark(RobotConstants.leftFlywheelSpark);
	public static Spark rightFlywheel = new Spark(RobotConstants.rightFlywheelSpark);
	
	public static DigitalInput botElevatorLimit = new DigitalInput(8);
	public static DigitalInput topElevatorLimit = new DigitalInput(9);
}
