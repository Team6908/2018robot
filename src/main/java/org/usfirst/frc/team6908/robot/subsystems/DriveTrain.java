package org.usfirst.frc.team6908.robot.subsystems;

import org.usfirst.frc.team6908.robot.*;
import org.usfirst.frc.team6908.robot.commands.*;
import org.usfirst.frc.team6908.robot.subsystems.*;

//import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 *
 */
public class DriveTrain extends Subsystem {
    
    SpeedControllerGroup rightMotors = new SpeedControllerGroup(RobotMap.frontRight, RobotMap.backRight);
    SpeedControllerGroup leftMotors = new SpeedControllerGroup(RobotMap.frontLeft, RobotMap.backLeft);
    SpeedControllerGroup allMotors = new SpeedControllerGroup(RobotMap.frontLeft,RobotMap.backLeft,RobotMap.frontRight,RobotMap.backRight);
    ADXRS450_Gyro gyro = RobotMap.gyro;
    public Encoder rightEncoder = RobotMap.rightEncoder;
    public Encoder leftEncoder = RobotMap.leftEncoder;
    public PIDController rightPID = new PIDController(0.035, 0.0, 0.0, rightEncoder, rightMotors);
    public PIDController leftPID = new PIDController(0.035, 0.0, 0.0, leftEncoder, leftMotors);
    public PIDController gyroPID = new PIDController(0.035, 0.0, 0.0, gyro, allMotors);
    
    public DriveTrain() {
       
   
    	
    	rightMotors.setName("Right");
    	leftMotors.setName("Left");
    	gyro.setName("NAV-X");
    	
    	SmartDashboard.putData(gyro);
    	SmartDashboard.putData(leftEncoder);
    	SmartDashboard.putData(rightEncoder);
    	SmartDashboard.putData(rightMotors);
    	SmartDashboard.putData(leftMotors);

    	
    	gyro.setName("Gyro", "spin me");
    	
       
    }
    
    public void initDefaultCommand() {
    
        // Set the default command for a subsystem here. 
        //setDefaultCommand(new MySpecialCommand()); 
    }
    public double getGyroAngle(){
        return gyro.getAngle();
    }
    public void resetGyro(){
        gyro.reset();
    }
   /* protected double returnPIDInput() {
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
    }*/
}