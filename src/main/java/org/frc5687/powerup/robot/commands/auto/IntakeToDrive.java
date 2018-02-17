package org.frc5687.powerup.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.frc5687.powerup.robot.Constants;
import org.frc5687.powerup.robot.commands.MoveArmToSetpointPID;
import org.frc5687.powerup.robot.commands.MoveCarriageToSetpointPID;
import org.frc5687.powerup.robot.subsystems.Arm;
import org.frc5687.powerup.robot.subsystems.Carriage;

/**
 * Created by Ben Bernard on 2/4/2018.
 */
public class IntakeToDrive extends CommandGroup {
    public IntakeToDrive(Carriage carriage, Arm arm) {
        int ENCODER_CLEAR_BUMPERS = carriage.isCompetitionBot() ? Constants.Carriage.ENCODER_CLEAR_BUMPERS_COMP : Constants.Carriage.ENCODER_CLEAR_BUMPERS_PROTO;
        // If the carriage is low enough to restrict arm movement due to bumpers, wait until the carriage is up
        if (carriage.getPos() < ENCODER_CLEAR_BUMPERS) {
            addSequential(new MoveCarriageToSetpointPID(carriage, ENCODER_CLEAR_BUMPERS));
        }

        addParallel(new MoveArmToSetpointPID(arm, Constants.Arm.Pot.BOTTOM));

        int ENCODER_DRIVE = carriage.isCompetitionBot() ? Constants.Carriage.ENCODER_DRIVE_COMP : Constants.Carriage.ENCODER_DRIVE_PROTO;
        addSequential(new MoveCarriageToSetpointPID(carriage, ENCODER_DRIVE));

    }
}

