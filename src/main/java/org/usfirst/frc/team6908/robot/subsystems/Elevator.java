package org.usfirst.frc.team6908.robot.subsystems;

import org.usfirst.frc.team6908.robot.Robot;
import org.usfirst.frc.team6908.robot.RobotMap;
import org.usfirst.frc.team6908.robot.commands.ArcadeDrive;
import org.usfirst.frc.team6908.robot.commands.ElevatorVariableControl;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 *
public class Elevator extends PIDSubsystem {
	
	public Elevator() {
	super("DriveTrain", 0.02, 0.0, 0.0);
		// TODO Auto-generated constructor stub
	}

	public Encoder elevatorEncoder = RobotMap.elevatorEncoder;
	public PIDController ePID = new PIDController(0.1, 0.0, 0.0, elevatorEncoder, RobotMap.elevator);//assigning PID values to Elevator Motor
	
    public void extend(double speed) {
    		RobotMap.elevator.set(speed);//elevator motor speed control function
    }
    
    public void disable() {
    		RobotMap.elevator.set(0);
    }
   
    
    public void initDefaultCommand() {
    		setDefaultCommand(new ElevatorVariableControl());
    }	
    
    public boolean isAtBottom() {
    		return RobotMap.elevatorSwitch.get();
    }

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return RobotMap.elevatorEncoder.get();
	}

	@Override
	protected void usePIDOutput(double output) {
		RobotMap.elevator.pidWrite(output);
	}
    
}
**/

public class Elevator extends PIDSubsystem {

	Encoder elevatorEncoder = RobotMap.elevatorEncoder;
	PIDController ePID = new PIDController(0.1, 0.0, 0.0, elevatorEncoder, RobotMap.elevator);//assigning PID values to Elevator Motor

	public Elevator(double p, double i, double d) {
		
    	super("Elevator", 0.01, 0.0, 0.0);
    	Robot.elevator.ePID.setAbsoluteTolerance(5);
		Robot.elevator.ePID.enable();
		Robot.elevator.ePID.setOutputRange(-.5, .5);
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
}

