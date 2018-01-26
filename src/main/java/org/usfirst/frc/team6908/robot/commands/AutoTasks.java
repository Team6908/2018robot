package org.usfirst.frc.team6908.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoTasks extends CommandGroup {

    public AutoTasks() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
//    	addSequential(new TurnRobot(345));
//    	addSequential(new TurnRobot(75));
    	addSequential(new AutoDrive(10));
    	addSequential(new TurnRobot(45));
    	addSequential(new AutoDrive(80));
    	addSequential(new TurnRobot(-45));



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
    }
}
