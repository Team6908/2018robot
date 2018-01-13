package org.usfirst.frc.team6908.robot.subsystems;

import org.usfirst.frc.team6908.robot.commands.pneumaticControl;
import org.usfirst.frc.team6908.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pneumatics extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	boolean enabled = RobotMap.C.enabled();
	boolean pressureSwitch = RobotMap.C.getPressureSwitchValue();
	double current = RobotMap.C.getCompressorCurrent();
	private int i = 1;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    		setDefaultCommand(new pneumaticControl());
    			enabled = false;
    		}

    public void enableCompressor() {
    		i++;
    		if(i%2 == 0) {
    			RobotMap.C.start();
    			System.out.println("Compressor has been enabled");
    			enabled = true;
    		}else {
    			System.out.println("Compressor has been disabled");
    			enabled = false;
    		}
    		
    }
}


