package org.usfirst.frc.team6908.robot.subsystems;

import org.usfirst.frc.team6908.robot.RobotMap;
import org.usfirst.frc.team6908.robot.commands.ArcadeDrive;
import org.usfirst.frc.team6908.robot.commands.ElevatorVariableControl;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {
	
	public Encoder elevatorEncoder = RobotMap.elevatorEncoder;
	public PIDController ePID = new PIDController(0.01, 0.0, 0.0, elevatorEncoder, RobotMap.elevator);//assigning PID values to Elevator Motor
	
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
}

