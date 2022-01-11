// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;


public class ElevatorControl extends CommandBase {

  XboxController manipulator = new XboxController(1);

  /** Creates a new ElevatorControl. */
  public ElevatorControl() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.elevator);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    RobotContainer.elevator.elevatorStop();

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    if (Math.abs(manipulator.getRawAxis(1)) <= 0.15) {

      RobotContainer.elevator.elevatorScaled(0);

    } else {

      // RobotContainer
      RobotContainer.elevator.elevatorScaled(manipulator.getRawAxis(1));
      // RobotContainer.elevator.elevatorUp();

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
