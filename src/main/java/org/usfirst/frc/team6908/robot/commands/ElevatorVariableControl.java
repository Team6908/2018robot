package org.usfirst.frc.team6908.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team6908.robot.Robot;
import org.usfirst.frc.team6908.robot.RobotMap;
import org.usfirst.frc.team6908.robot.RobotConstants;


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
		if(control < -RobotConstants.joystickDeadzone) {
			Robot.elevator.extend(RobotConstants.elevatorExtendSpeed);
		} else if (control > RobotConstants.joystickDeadzone) {
			Robot.elevator.extend(-RobotConstants.elevatorExtendSpeed);
		} else {
			Robot.elevator.disable();
		}
		SmartDashboard.putNumber("Encoder", RobotMap.elevatorEncoder.getDistance());
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		//Creates dead zone on joystick
		if(((Robot.oi.Joystick2.getY() > RobotConstants.joystickDeadzone && Robot.oi.Joystick2.getY() < RobotConstants.joystickDeadzone))) {
			return true;
		}
		//Checks for top and bottom limit switches while the motors are still active
		else if((Robot.elevator.getPIDController().get() > 0 && Robot.elevator.isAtTop()) || (Robot.elevator.getPIDController().get() < 0 && Robot.elevator.isAtBottom())) {
			return true;
		}
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.elevator.disable();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
