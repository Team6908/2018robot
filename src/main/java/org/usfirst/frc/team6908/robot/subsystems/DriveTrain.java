package org.usfirst.frc.team6908.robot.subsystems;

import org.usfirst.frc.team6908.robot.RobotMap;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 *
 */
public class DriveTrain extends PIDSubsystem {
    
    SpeedController frontRight = RobotMap.frontRight;
    SpeedController backRight = RobotMap.backRight;
    SpeedController frontLeft = RobotMap.frontLeft;
    SpeedController backLeft = RobotMap.backLeft;
    ADXRS450_Gyro gyro = RobotMap.gyro;
    
    
    public DriveTrain() {
       
    	super("DriveTrain", 0.03, 0.0, 0.0);
    	
//    	RobotMap.frontRight.setName("Drive Motos", "FR");
//    	RobotMap.frontLeft.setName("Drive Motos", "FLL");
//    	RobotMap.backRight.setName("Drive Motos", "BR");
//    	RobotMap.backLeft.setName("Drive Motos", "BadLanguage");
    	
    	LiveWindow.addSensor("Gyro", " ", gyro);
    	LiveWindow.addActuator("pee", "pid", getPIDController());
    	
    	gyro.setName("Gyro", "spin me");
    	
        setAbsoluteTolerance(2.0);
//        getPIDController().setContinuous(false);
//        getPIDController().setName("PID", "Piddyboi");
//        LiveWindow.add(getPIDController());
//        LiveWindow.add(gyro);
//        LiveWindow.add(RobotMap.backLeft);
//        LiveWindow.add(RobotMap.frontLeft);
//        LiveWindow.add(RobotMap.backRight);
//        LiveWindow.add(RobotMap.backLeft);
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
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage
        return gyro.getAngle();
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output)
        frontRight.pidWrite(output);
        backRight.pidWrite(output);
        frontLeft.pidWrite(output);
        backLeft.pidWrite(output);
    }
}