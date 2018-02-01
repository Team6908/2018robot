package org.usfirst.frc.team6908.robot.subsystems;

import org.usfirst.frc.team6908.robot.DeltaEncoders;
import org.usfirst.frc.team6908.robot.DummyOutput;
import org.usfirst.frc.team6908.robot.Robot;
import org.usfirst.frc.team6908.robot.RobotMap;

import org.usfirst.frc.team6908.robot.commands.ArcadeDrive;
import org.usfirst.frc.team6908.robot.commands.TankDrive;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

@SuppressWarnings("unused")
public class DriveTrain extends Subsystem {


	DummyOutput dumdum = new DummyOutput();
	DeltaEncoders EncoderDrift = new DeltaEncoders();
	Encoder encoder = RobotMap.leftEncoder;
	
	public PIDController DriftFix = new PIDController(0.003,0.0,0.0,EncoderDrift,dumdum);
	public PIDController EncodePID = new PIDController(0.0,0.0,0.0,encoder,dumdum);
	
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ArcadeDrive());
		RobotMap.frontRightT.setInverted(true);
		RobotMap.backRightT.setInverted(true);
		
		/*RobotMap.frontRight.setName("Drive Motors", "frontRight");
		RobotMap.frontLeft.setName("Drive Motors", "frontLeft");
		RobotMap.backRight.setName("Drive Motors", "backRight");
		RobotMap.backLeft.setName("Drive Motors", "backLeft");
		
		LiveWindow.add(RobotMap.frontRight);
		LiveWindow.add(RobotMap.frontLeft);
		LiveWindow.add(RobotMap.backRight);
		LiveWindow.add(RobotMap.backLeft);*/
		
	}
	
	public void Drive (double throttle, double turn) {
        setLeftMotors(throttle + turn);
        setRightMotors(throttle - turn);
	}
	
	public void setLeftMotors (double speed) {
		RobotMap.frontLeftT.set(speed);
		RobotMap.backLeftT.set(speed); 
		SmartDashboard.putNumber("speed", speed);
	}
	
	public void setRightMotors (double speed) {
		RobotMap.frontRightT.set(speed);
		RobotMap.backRightT.set(speed);
	}

}
