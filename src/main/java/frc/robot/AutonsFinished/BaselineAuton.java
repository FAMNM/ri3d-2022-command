// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.AutonsFinished;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Constants;
import frc.robot.commands.MoveForward;
import frc.robot.commands.ShootBall;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class BaselineAuton extends SequentialCommandGroup {
  /** Creates a new BaselineAuton. */
  public BaselineAuton() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new ShootBall(Constants.SHOOTER_HIGH_SPEED),
      new ParallelDeadlineGroup(
        new WaitCommand(2), // Deadline command --- change 2 to correct time
        new MoveForward())
    );
  }
}
