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
    
    public void startIntake(double speed1, double speed2) {
    		RobotMap.intakeMotor1.set(speed1);
    		RobotMap.intakeMotor2.set(speed2);
    }
    
    public void stopIntake() {
    	
    	RobotMap.intakeMotor1.set(0);
		RobotMap.intakeMotor2.set(0);
    	
    	
    }
   
    
   
}

