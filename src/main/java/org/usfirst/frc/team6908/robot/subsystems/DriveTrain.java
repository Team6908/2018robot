package org.usfirst.frc.team6908.robot.subsystems;

import org.usfirst.frc.team6908.robot.*;
import org.usfirst.frc.team6908.robot.commands.ArcadeDrive;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 *
 */
public class DriveTrain extends PIDSubsystem {
    
    public static SpeedControllerGroup rightMotors = new SpeedControllerGroup(RobotMap.frontRight, RobotMap.backRight);
    public static SpeedControllerGroup leftMotors = new SpeedControllerGroup(RobotMap.frontLeft, RobotMap.backLeft);
    AHRS gyro = RobotMap.gyro;
    public static Encoder rightEncoder = RobotMap.rightEncoder;
    public static Encoder leftEncoder = RobotMap.leftEncoder;
    public static PIDController rightPID = new PIDController(0.02, 0.0, 0.0, rightEncoder, rightMotors);
    public static PIDController leftPID = new PIDController(0.02, 0.0, 0.0, leftEncoder, leftMotors);
        
    public DriveTrain() {
    	    	
    	super("DriveTrain", 0.02, 0.0, 0.0);
    	
    	gyro.reset();

    	getPIDController().setContinuous(false);
    	
    	rightMotors.setName("Right");
    	leftMotors.setName("Left");
    	
    	SmartDashboard.putData(gyro);
    	SmartDashboard.putData(leftEncoder);
    	SmartDashboard.putData(rightEncoder);
    	SmartDashboard.putData(rightMotors);
    	SmartDashboard.putData(leftMotors);
    	SmartDashboard.putData(leftPID);
    	SmartDashboard.putData(rightPID);
    	
    	gyro.setName("Gyro", "spin me");
    	
        setAbsoluteTolerance(2);
    }
    
    @Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ArcadeDrive());
		
	}
    
    public double getGyroAngle(){
        return gyro.getAngle();
    }
    public void resetGyro(){
        gyro.reset();
    }
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage
        return gyro.getAngle();
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output)
        leftMotors.pidWrite(output);
        rightMotors.pidWrite(output);
    }
    
    public void setLeftMotors (double speed) {
		RobotMap.frontLeft.set(speed);
		RobotMap.backLeft.set(speed); 
		SmartDashboard.putNumber("speed", speed);
	}
	
	public void setRightMotors (double speed) {
		RobotMap.frontRight.set(speed);
		RobotMap.backRight.set(speed);
	}
    
}