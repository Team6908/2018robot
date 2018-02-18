package org.usfirst.frc.team6908.robot.commands;

import org.usfirst.frc.team6908.robot.RobotMap; 

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ServoRelease extends Command {
	

    public ServoRelease() {

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    		setTimeout(1);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		RobotMap.servo.setAngle(-80);
    		SmartDashboard.putNumber("eRelease", RobotMap.servo.get());
    		
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    		return isTimedOut();
       
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
