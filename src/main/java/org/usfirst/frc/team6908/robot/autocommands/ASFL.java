package org.usfirst.frc.team6908.robot.autocommands;

import edu.wpi.first.wpilibj.command.Command;

public class ASFL extends Selectables {

	static Command Left = new ASFLLeft();
	static Command Right = new ASFLRight();
	
    public ASFL(String gameData) {
        super(Left,Right,gameData);
    }

}
