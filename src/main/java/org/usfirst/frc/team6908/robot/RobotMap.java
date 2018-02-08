package org.usfirst.frc.team6908.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.VictorSP;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
//	Drivetrain Motor Controllers
	public static WPI_TalonSRX frontLeftT = new WPI_TalonSRX(1);
	public static WPI_TalonSRX backLeftT = new WPI_TalonSRX(0);
	public static WPI_TalonSRX frontRightT = new WPI_TalonSRX(2);
	public static WPI_TalonSRX backRightT = new WPI_TalonSRX(3);
	
	//Ramp Winch Motor Controllers
	public static VictorSP leftRamp = new VictorSP(0);
	public static Spark rightRamp = new Spark(1);
	
	//Ramp Drop Motor Variables
//	public static VictorSP rampDropController = new VictorSP(1);
	
	//Ramp Release Motor Variables
	public static VictorSP rampReleaseController = new VictorSP(1);
	public static DigitalInput releaseSwitch = new DigitalInput(0);
	
	//Ramp Limit Switches
	public static DigitalInput LeftRampLimit = new DigitalInput(4);
	public static DigitalInput RightRampLimit = new DigitalInput(5);
	
}
