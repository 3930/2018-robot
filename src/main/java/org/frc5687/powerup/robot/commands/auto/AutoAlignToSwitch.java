package org.frc5687.powerup.robot.commands.auto;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.frc5687.powerup.robot.subsystems.DriveTrain;

public class AutoAlignToSwitch extends Command {

    private DriveTrain driveTrain;
    private double speed;

    public AutoAlignToSwitch(DriveTrain driveTrain, double speed) {
        this.driveTrain = driveTrain;
        this.speed = speed;
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        double angleOffset = SmartDashboard.getNumber("tx", 0);
        if (angleOffset > 0) {
            driveTrain.tankDrive(speed, -speed);
        } else if (angleOffset < 0) {
            driveTrain.tankDrive(-speed, speed);
        }
    }

    @Override
    protected boolean isFinished() {
        return SmartDashboard.getNumber("tv", 0) == 0 || Math.abs(SmartDashboard.getNumber("tx", 0)) < 0.5;
    }
}