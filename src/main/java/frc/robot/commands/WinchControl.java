// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class WinchControl extends CommandBase {
  
  XboxController manipulator = new XboxController(1);

  /** Creates a new WinchControl. */
  public WinchControl() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.winch);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    if (manipulator.getRawAxis(5) < -0.15) {

      RobotContainer.winch.robotDescend();

    } else if (manipulator.getRawAxis(5) > 0.15) {

      // RobotContainer
      RobotContainer.winch.robotClimb();

    } else {

      RobotContainer.winch.stopWinch();

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
