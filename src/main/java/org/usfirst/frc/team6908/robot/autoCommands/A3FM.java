package org.usfirst.frc.team6908.robot.autoCommands;

import org.usfirst.frc.team6908.robot.commands.AutoDrive; 
import org.usfirst.frc.team6908.robot.commands.TurnRobot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class A3FM extends CommandGroup {

    public A3FM(String colorOrder) {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.
    	

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	    	
    	switch(colorOrder.charAt(0)){
    		case 'L':
    	    	addSequential(new AutoDrive(8));
    	    	addSequential(new TurnRobot(-35));
    	    	addSequential(new AutoDrive(59));
    	    	addSequential(new TurnRobot(35));
    	    	addSequential(new AutoDrive(20));
    	    	break;
    		case 'R':
    	    	addSequential(new AutoDrive(8));
    	    	addSequential(new TurnRobot(35));
    	    	addSequential(new AutoDrive(59));
    	    	addSequential(new TurnRobot(-35));
    	    	addSequential(new AutoDrive(20));
    	    	break;
    	}
    } 
}
