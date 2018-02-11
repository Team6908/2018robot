package org.usfirst.frc.team6908.robot.subsystems;

import org.usfirst.frc.team6908.robot.RobotConstants;
import org.usfirst.frc.team6908.robot.RobotMap;
import org.usfirst.frc.team6908.robot.commands.ElevatorVariableControl;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class Elevator extends PIDSubsystem {

	Encoder elevatorEncoder = RobotMap.elevatorEncoder;
	public PIDController ePID = new PIDController(RobotConstants.elevatorP, RobotConstants.elevatorI, RobotConstants.elevatorD, elevatorEncoder, RobotMap.elevator);//assigning PID values to Elevator Motor

	public Elevator() {
		
    	super("Elevator", RobotConstants.elevatorP, RobotConstants.elevatorI, RobotConstants.elevatorD);
    		
		// TODO Auto-generated constructor stub
	}

	// Initialize your subsystem here
    public void Elevator() {
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	
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
		// TODO Auto-generated method stub
		return false;
	}
    
}

