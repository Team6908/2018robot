package org.usfirst.frc.team6908.robot.commands;

import org.usfirst.frc.team6908.robot.Robot;
import org.usfirst.frc.team6908.robot.RobotConstants;
import org.usfirst.frc.team6908.robot.RobotMath;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//@SuppressWarnings("unused")
public class ArcadeDrive extends Command {

	private double throttle;
	private double turn;
	private double acceleration;
	private double throttleAcc = 1;
	private double turnAcc = 1;
	private double leftMtr;
	private double rightMtr;
	
    public ArcadeDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Gets Y and X axes
    	throttle = Robot.oi.Joystick1.getY();
    	turn = Robot.oi.Joystick1.getX();
    	//Gets slider value
    	acceleration = Robot.oi.Joystick1.getThrottle();
     	//Normalizes input from slider
    	throttleAcc = RobotMath.normalize(RobotConstants.maxAxis, RobotConstants.minAxis, RobotConstants.lowRangeThrottle, RobotConstants.highRangeThrottle, acceleration);
    	turnAcc = RobotMath.normalize(RobotConstants.maxAxis, RobotConstants.minAxis, RobotConstants.lowRangeTurn, RobotConstants.highRangeTurn, acceleration);
    	//Displays acceleration values on smartdashboard
    	SmartDashboard.putNumber("throttleAcc", throttleAcc); 
    	SmartDashboard.putNumber("turnAcc", turnAcc);
	    //Scales the throttle/turn values with the acceleration values by multiplication 
        leftMtr = throttle*throttleAcc + turn*turnAcc;
        rightMtr = throttle*throttleAcc - turn*turnAcc;
        //Sets values to motors
        Robot.drivetrain.setLeftMotors(leftMtr);
        Robot.drivetrain.setRightMotors(rightMtr);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	throttle = 0;
    	turn = 0;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }

}
