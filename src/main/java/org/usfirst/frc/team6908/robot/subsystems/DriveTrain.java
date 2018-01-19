package org.usfirst.frc.team6908.robot.subsystems;

import org.usfirst.frc.team6908.robot.RobotMap;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
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
       
        super("DriveTrain", 0.0, 0.0, 0.0);
        setAbsoluteTolerance(10.0);
        getPIDController().setContinuous(true);
        LiveWindow.addActuator("Drive Train", "PIDSubsystem Controller", getPIDController());
    
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
        // e.g. yourMotor.set(output);
    	output*=.5;
        frontRight.pidWrite(output);
        backRight.pidWrite(output);
        frontLeft.pidWrite(output);
        backLeft.pidWrite(output);
    }
}