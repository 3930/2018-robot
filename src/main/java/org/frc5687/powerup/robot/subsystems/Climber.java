package org.frc5687.powerup.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.frc5687.powerup.robot.Constants;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.frc5687.powerup.robot.RobotMap;
import org.frc5687.powerup.robot.OI;
import org.frc5687.powerup.robot.commands.DriveClimber;

public class Climber extends Subsystem {

    private VictorSP motor;

    private OI oi;

    public Climber(OI oi) {
        motor = new VictorSP(RobotMap.Climber.MOTOR);
        motor.setName("Climber");
        this.oi = oi;
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new DriveClimber(this, oi));
    }

    public void drive(double speed) {
        speed *= (Constants.Climber.MOTOR_INVERT ? -1 : 1);
        SmartDashboard.putNumber("Climber/rawSpeed", speed);
        SmartDashboard.putNumber("Climber/speed", speed * (Constants.Climber.MOTOR_INVERT ? -1 : 1));
        motor.set(speed);
    }
}