package org.usfirst.frc.team6908.robot.subsystems;

import org.usfirst.frc.team6908.robot.*;
import org.usfirst.frc.team6908.robot.autoPID.DeltaEncoders;
import org.usfirst.frc.team6908.robot.autoPID.MoveForward;
import org.usfirst.frc.team6908.robot.autoPID.Rotate;
import org.usfirst.frc.team6908.robot.commands.ArcadeDrive;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrain extends Subsystem {
    
	double leftMtr, rightMtr;
	
    public static SpeedControllerGroup rightMotors = new SpeedControllerGroup(RobotMap.frontRight, RobotMap.backRight);
    public static SpeedControllerGroup leftMotors = new SpeedControllerGroup(RobotMap.frontLeft, RobotMap.backLeft);
    public static SpeedControllerGroup allMotors = new SpeedControllerGroup(RobotMap.frontLeft, RobotMap.backLeft, RobotMap.frontRight, RobotMap.backRight);
    public static AHRS gyro = RobotMap.gyro;
    public static Encoder rightEncoder = RobotMap.rightEncoder;
    public static Encoder leftEncoder = RobotMap.leftEncoder;
    public static PIDController rightPID = new PIDController(0.02, 0.0, 0.0, rightEncoder, rightMotors);
    public static PIDController leftPID = new PIDController(0.02, 0.0, 0.0, leftEncoder, leftMotors);
    public static PIDController gyroPID = new PIDController(0.02,0.0,0.0,gyro,allMotors);
    
    public static DeltaEncoders encoderdifference = new DeltaEncoders();
    
    public static Rotate turnit = new Rotate();
    public static MoveForward move = new MoveForward();
    
    public static PIDController rotater = new PIDController(0.01,0.0001,0.0,gyro,turnit);
    public static PIDController forward = new PIDController(-0.02,0.0,0.0,rightEncoder,rightMotors);
    public static PIDController driftfix = new PIDController(-0.025,0.0,0.0,encoderdifference,leftMotors);
    
    public DriveTrain() {
    	gyro.reset();
    	
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
    	
    }
    
    public void initDefaultCommand() {
    	setDefaultCommand(new ArcadeDrive());
    	RobotMap.frontRight.setInverted(true);
		RobotMap.backRight.setInverted(true);
    }
    
	public void setLeftMotors (double speed) {
		RobotMap.frontLeft.set(speed);
		RobotMap.backLeft.set(speed);
	}
	
	public void setRightMotors (double speed) {
		RobotMap.frontRight.set(speed);
		RobotMap.backRight.set(speed);
	}
	
	public void Drive(double throttle, double turn) {
		//Converts throttle and turn values into left and right tank drive values
		leftMtr = throttle + turn;
        rightMtr = throttle - turn;
        //Sets values to motors
        Robot.drivetrain.setLeftMotors(leftMtr);
        Robot.drivetrain.setRightMotors(rightMtr);
	
    }
}
