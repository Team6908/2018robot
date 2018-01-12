package org.usfirst.frc.team6908.robot.commands;

import org.usfirst.frc.team6908.robot.Robot;
import org.usfirst.frc.team6908.robot.commands.vision.PixyPacket;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class VDrive extends Command {

    public VDrive() {
        requires(Robot.pPacket);
    }


	private void requires(PixyPacket pPacket) {
		// TODO Auto-generated method stub
		
	}


	// Called just before this Command runs the first time
    protected void initialize() {
    		System.out.println("Starting Auto Drive with Vision. Press Button 8 to move robot forwards.");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		if(Robot.pPacket.x >= 160) {
    			Robot.drivetrain.Drive(.5, -0.25);
    			System.out.println("Box DetecTed RIGHT of Pixy");
    		}
    		if(Robot.pPacket.x <= 130) {
    			Robot.drivetrain.Drive(-0.25, .5);
    			System.out.println("Box DetecTed LEFT of Pixy");
    		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
