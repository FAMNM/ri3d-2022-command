// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class TankDrive extends CommandBase {

  XboxController driver = new XboxController(0);
  
  /** Creates a new TankDrive. */
  public TankDrive() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    if (Math.abs(driver.getRawAxis(5)) < .1 && Math.abs(driver.getRawAxis(1)) < .1) {

      RobotContainer.driveTrain.tankDrive(0, 0);

    } else {

      RobotContainer.driveTrain.tankDrive(driver.getRawAxis(5), driver.getRawAxis(1));

    }


  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
