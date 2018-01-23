package org.usfirst.frc.team6908.robot.commands;

import org.usfirst.frc.team6908.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutoDrive extends Command {

	public AutoDrive() {
		requires(Robot.drivetrain);
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.leftenc.reset();
    	Robot.drivetrain.rightenc.reset();
    	Robot.drivetrain.rightPID.setAbsoluteTolerance(5);
    	Robot.drivetrain.leftPID.setAbsoluteTolerance(5);
/*    	Robot.drivetrain.rightPID.setOutputRange(0.0,0.7);
        Robot.drivetrain.leftPID.setOutputRange(0.0,0.7);*/
        Robot.drivetrain.rightPID.enable();
        Robot.drivetrain.leftPID.enable();
        Robot.drivetrain.rightPID.setSetpoint(-255);
        Robot.drivetrain.leftPID.setSetpoint(255);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(Robot.drivetrain.rightPID.onTarget() && Robot.drivetrain.leftPID.onTarget()){
    		return true;
    	}
    	else{
    		return false;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.rightPID.disable();
        Robot.drivetrain.leftPID.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
        
    }

}
