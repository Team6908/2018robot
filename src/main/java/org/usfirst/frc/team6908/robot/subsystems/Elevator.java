package org.usfirst.frc.team6908.robot.subsystems;

import org.usfirst.frc.team6908.robot.RobotMap;
import org.usfirst.frc.team6908.robot.commands.ElevatorVariableControl;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class Elevator extends PIDSubsystem {

	public Encoder elevatorEncoder;

	public Elevator(double p, double i, double d, int tolerance, float range) {
		
    	super("ePID", p, i, d);
    	setAbsoluteTolerance(tolerance);
    	setOutputRange(-range, range);
    	
    	elevatorEncoder = RobotMap.elevatorEncoder;
		// TODO Auto-generated constructor stub
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new ElevatorVariableControl());
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return RobotMap.elevatorEncoder.get();
    }

    protected void usePIDOutput(double output) {
    		RobotMap.elevator.pidWrite(output);
    }
    
    public void extend(double speed) {
    		RobotMap.elevator.set(speed);
    }
    
    public boolean isAtBottom() {
		return RobotMap.botElevatorLimit.get();
    }
    
    public boolean isAtTop() {
    	return RobotMap.topElevatorLimit.get();
    }
    
}