package org.usfirst.frc.team6908.robot.commands;

import org.usfirst.frc.team6908.robot.Robot;
import org.usfirst.frc.team6908.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

public class AutoDrive extends Command {
	
	private double distance;

	public AutoDrive(double dist) {
		distance = ((dist / (6*Math.PI)) * 255);
		requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
//   		Robot.drivetrain.leftEncoder.reset();
//   		Robot.drivetrain.rightEncoder.reset();
//   		Robot.drivetrain.rightPID.setAbsoluteTolerance(2);
//   		Robot.drivetrain.leftPID.setAbsoluteTolerance(2);
///*    	Robot.drivetrain.rightPID.setOutputRange(0.0,0.7);
//        Robot.drivetrain.leftPID.setOutputRange(0.0,0.7);		*/
//        Robot.drivetrain.rightPID.enable();
//        Robot.drivetrain.leftPID.enable();
//        Robot.drivetrain.rightPID.setOutputRange(-0.61, 0.61);
//        Robot.drivetrain.leftPID.setOutputRange(-0.6, 0.6);
//        Robot.drivetrain.rightPID.setSetpoint(-distance-4);
//        Robot.drivetrain.leftPID.setSetpoint(distance);
    	
    	DriveTrain.leftEncoder.reset();
		DriveTrain.rightEncoder.reset();
    	DriveTrain.forward.enable();
    	DriveTrain.driftfix.enable();
    	DriveTrain.forward.setAbsoluteTolerance(10);
    	DriveTrain.driftfix.setAbsoluteTolerance(10);
    	DriveTrain.forward.setSetpoint(distance);
    	DriveTrain.driftfix.setSetpoint(0);
    	DriveTrain.forward.setOutputRange(-0.6, 0.6);
    	DriveTrain.driftfix.setOutputRange(-0.6, 0.6);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(DriveTrain.forward.onTarget()){
    		return true;
    	}
    	else{
    		return false;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	DriveTrain.forward.disable();
        DriveTrain.driftfix.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
        
    }

}
