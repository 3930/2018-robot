package org.frc5687.powerup.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.frc5687.powerup.robot.Constants;
import org.frc5687.powerup.robot.OI;
import org.frc5687.powerup.robot.subsystems.Intake;

/**
 * Command for controlling each side of the drive train with a joystick
 */
public class DriveIntake extends Command {
    private Intake intake;
    private OI oi;

    public DriveIntake(Intake intake, OI oi) {
        requires(intake);
        this.intake = intake;
        this.oi = oi;
    }

    @Override
    protected void execute() {
        double left = oi.getLeftIntakeSpeed();
        double right = oi.getRightIntakeSpeed();

        intake.drive(left, right);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
