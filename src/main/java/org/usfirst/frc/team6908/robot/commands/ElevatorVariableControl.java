package org.usfirst.frc.team6908.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team6908.robot.Robot;
import org.usfirst.frc.team6908.robot.RobotMap;

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
		System.out.println(control);
		SmartDashboard.putNumber("elevatorControl", control);//outputting joystick values to dashboard
		if(control < -0.1) {
			Robot.elevator.extend(0.4);
		} else if (control > 0.1) {
			Robot.elevator.extend(-0.4);
		} else {
			Robot.elevator.disable();
		}
		SmartDashboard.putNumber("Encoder", RobotMap.elevatorEncoder.getDistance());
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		if((Robot.oi.Joystick2.getY() > 0.1 && Robot.oi.Joystick2.getY() < .1) || (Robot.elevator.ePID.get() < 0 && Robot.elevator.isAtBottom())) {
			return true;
		}
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
