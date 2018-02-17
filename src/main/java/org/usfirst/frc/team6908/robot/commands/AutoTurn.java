package org.usfirst.frc.team6908.robot.commands;

import org.usfirst.frc.team6908.robot.Robot;
import org.usfirst.frc.team6908.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

public class AutoTurn extends Command {
	
	private static final double AUTO_DRIVE_CORRECT_COEFF = 0.02;
	private double targetAngle;
	private double gyroAngle;
	private double driveAngle;
	private static final double speed = 0.4;

	public AutoTurn(double target) {
//		distance = ((dist / (6*Math.PI)) * 255);
		targetAngle = target;
		requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	DriveTrain.gyro.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	gyroAngle = DriveTrain.gyro.getAngle();
		driveAngle = -gyroAngle * AUTO_DRIVE_CORRECT_COEFF;
		
		
		//System.out.println("Time (sec) = " + String.format("%.1f",currentPeriodSec) + " Angle =" + String.format("%.2f",driveAngle));

		Robot.drivetrain.Drive(0, speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(targetAngle>0) {
    		return (DriveTrain.gyro.getAngle() >= targetAngle);
    	}
    	else {
    		return(DriveTrain.gyro.getAngle() <= targetAngle);
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.Drive(0.0, 0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
        
    }

}
