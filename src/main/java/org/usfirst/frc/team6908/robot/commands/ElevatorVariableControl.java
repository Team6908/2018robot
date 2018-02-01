package org.usfirst.frc.team6908.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team6908.robot.Robot;

/**
 *
 */
public class ElevatorVariableControl extends Command {
	public ElevatorVariableControl() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.elevator);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		double control = Robot.oi.Joystick2.getY();//reading in y-axis of 2nd joystick
		SmartDashboard.putNumber("elevatorControl", control);//outputting joystick values to dashboard
		Robot.elevator.extend(control/2);//sending speed to elevator motor
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
