package org.usfirst.frc.team6908.robot.autoCommands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6908.robot.autoCommands.*;

public class Selectables extends Command {

	Command LeftCommand;
	Command RightCommand;
	String Data;
	
	public Selectables(Command LeftOption, Command RightOption, String GameData) {
		LeftCommand = LeftOption;
		RightCommand = RightOption;
		Data = GameData;
	}
	
	public void execute() {
		switch(Data.charAt(0)) {
		case 'L':
			LeftCommand.start();
			break;
		case 'R':
			RightCommand.start();
			break;
		}
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

}
