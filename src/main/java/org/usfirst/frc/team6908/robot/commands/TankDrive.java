package org.usfirst.frc.team6908.robot.commands;

import org.usfirst.frc.team6908.robot.Robot;
import org.usfirst.frc.team6908.robot.RobotConstants;
import org.usfirst.frc.team6908.robot.RobotMath;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TankDrive extends Command {
	
	private double leftSideSpeed;
	private double rightSideSpeed;
	private double acceleration;
	
	public TankDrive() {
		//put dependencies of the subsystem here
		requires(Robot.drivetrain); //requires the drivetrain object instantiated in Robot.java
	}
	
	protected void initialize() {
		
	}
	
	protected void execute() {
		//gets Y and X axis values
		leftSideSpeed = Robot.oi.Joystick1.getY();
		rightSideSpeed = Robot.oi.Joystick2.getY();
		//gets slider value
		acceleration = Robot.oi.Joystick1.getThrottle();
		//normalizes slider value 
    	acceleration = RobotMath.normalize(RobotConstants.minAxis, RobotConstants.maxAxis, RobotConstants.lowRangeThrottle, RobotConstants.highRangeThrottle, acceleration);
    	//displays acceleration values on smartdashboard
    	SmartDashboard.putNumber("Acceleration", acceleration);
        //sets values to motors
        Robot.drivetrain.setLeftMotors(rightSideSpeed*acceleration);
        Robot.drivetrain.setLeftMotors(leftSideSpeed*acceleration);
		
	}

    // Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

    // Called once after isFinished returns true
    protected void end() {
    	leftSideSpeed = 0;
    	rightSideSpeed = 0;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
	
}
