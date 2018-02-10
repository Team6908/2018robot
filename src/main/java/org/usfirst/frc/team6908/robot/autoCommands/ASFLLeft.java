package org.usfirst.frc.team6908.robot.autoCommands;

import org.usfirst.frc.team6908.robot.commands.AutoDrive;
import org.usfirst.frc.team6908.robot.commands.TurnRobot;


import edu.wpi.first.wpilibj.command.CommandGroup;

public class ASFLLeft extends CommandGroup {

	public ASFLLeft() {
	addSequential(new AutoDrive(197));
    	addSequential(new TurnRobot(25));
	}

}
