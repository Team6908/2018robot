package org.usfirst.frc.team6908.robot.commands;

import org.usfirst.frc.team6908.robot.Robot;
import org.usfirst.frc.team6908.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class pneumaticControl extends Command {

    public pneumaticControl() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    		requires(Robot.pneumatics);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		Robot.pneumatics.startSolenoid();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    		
    		return RobotMap.solenoid.get();
        //return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    		Robot.pneumatics.stopSolenoid();
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
