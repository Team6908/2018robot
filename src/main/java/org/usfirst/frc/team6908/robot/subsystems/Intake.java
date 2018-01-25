package org.usfirst.frc.team6908.robot.subsystems;

import org.usfirst.frc.team6908.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Intake extends Subsystem {
	


    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void startIntake() {
    		RobotMap.intakeMotor1.set(.5);
    		RobotMap.intakeMotor2.set(.5);
    }
    
    public void stopIntake() {
    	
    	RobotMap.intakeMotor1.set(0);
		RobotMap.intakeMotor2.set(0);
    	
    	
    }
   
    
   
}

