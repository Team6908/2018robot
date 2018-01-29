package org.usfirst.frc.team6908.robot.commands;

import org.usfirst.frc.team6908.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveStraight extends Command {

	public DriveStraight() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.drivetrain);
		Robot.drivetrain.DriftFix.enable();
		Robot.drivetrain.DriftFix.setSetpoint(0);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.drivetrain.Drive(0.5, Robot.drivetrain.DriftFix.get());
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.drivetrain.DriftFix.disable();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}

}