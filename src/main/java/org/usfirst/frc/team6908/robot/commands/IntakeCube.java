package org.usfirst.frc.team6908.robot.commands;
import org.usfirst.frc.team6908.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class IntakeCube extends Command {

    public IntakeCube() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	 requires(Robot.intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.oi.joystick.getRawButton(3)) {
    		Robot.intake.startIntake(1, -1);
    	} 
    	else {
    		Robot.intake.startIntake(-1, 1);
    	}
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    		Robot.intake.stopIntake();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	
    		end();
    }
}
