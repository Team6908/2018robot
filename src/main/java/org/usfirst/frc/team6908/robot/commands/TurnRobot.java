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
        DriveTrain.gyroPID.enable();
        DriveTrain.gyroPID.setSetpoint(turnAngle + DriveTrain.gyro.getAngle());
        DriveTrain.gyroPID.setAbsoluteTolerance(2);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return DriveTrain.gyroPID.onTarget();
    }

    protected void end() {
        DriveTrain.gyroPID.disable();
    }

    protected void interrupted() {
        end();
        
    }
}