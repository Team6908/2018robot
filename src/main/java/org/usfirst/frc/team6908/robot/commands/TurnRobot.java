package org.usfirst.frc.team6908.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6908.robot.Robot;
import org.usfirst.frc.team6908.robot.subsystems.DriveTrain;

/**
 *
 */
public class  TurnRobot extends Command {
	private double turnAngle;

    public TurnRobot(double angle) {
        requires(Robot.drivetrain);
        turnAngle = angle;
    }

    protected void initialize() {
        DriveTrain.rotater.enable();
        DriveTrain.rotater.setSetpoint(turnAngle + DriveTrain.gyro.getAngle());
        DriveTrain.rotater.setAbsoluteTolerance(2);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return DriveTrain.rotater.onTarget();
    }

    protected void end() {
        DriveTrain.rotater.disable();
    }

    protected void interrupted() {
        end();
        
    }
}