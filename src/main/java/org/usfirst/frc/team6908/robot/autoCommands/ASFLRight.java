package org.usfirst.frc.team6908.robot.autoCommands;

import org.usfirst.frc.team6908.robot.commands.*;import org.usfirst.frc.team6908.robot.commands.TurnRobot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ASFLRight extends CommandGroup {

	public ASFLRight() {
		
	addSequential(new AutoDrive(196));
    	addSequential(new TurnRobot(-90));
    	addSequential(new AutoDrive(158));
    	addSequential(new TurnRobot(90));
    	addSequential(new AutoDrive(20));
    	addSequential(new TurnRobot(90));

	
	
	}

}
