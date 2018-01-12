package org.usfirst.frc.team6908.robot.commands;

import org.usfirst.frc.team6908.robot.Robot;
import org.usfirst.frc.team6908.robot.RobotMap;
import org.usfirst.frc.team6908.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

@SuppressWarnings("unused")
public class ArcadeDrive extends Command {

	private double throttle;
	private double turn;
	private double acceleration;
	
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
    	throttle = Robot.oi.Joystick1.getY();
    	turn = Robot.oi.Joystick1.getX();
    	acceleration = Robot.oi.Joystick1.getThrottle();
    	double throttleAcc = (((-0.8 * (acceleration +1)) / 2) + 1);
    	double turnAcc = (((-.5 * (acceleration+1)) / 2)+1);
    	SmartDashboard.putNumber("throttleAcc", throttleAcc);
    	SmartDashboard.putNumber("turnAcc", turnAcc);
	    
        double leftMtr = throttle*throttleAcc;
        double rightMtr = turn*turnAcc;
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
