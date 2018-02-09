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
	public static WPI_TalonSRX frontLeftT = new WPI_TalonSRX(1);
	public static WPI_TalonSRX frontRightT = new WPI_TalonSRX(2);
	public static WPI_TalonSRX backLeftT = new WPI_TalonSRX(0);
	public static WPI_TalonSRX backRightT = new WPI_TalonSRX(3);
	
	public static VictorSP elevator = new VictorSP(0);
	public static Encoder elevatorEncoder = new Encoder(0,1);
	
	public static DigitalInput botElevatorLimit = new DigitalInput(8);
	public static DigitalInput topElevatorLimit = new DigitalInput(9);
}
