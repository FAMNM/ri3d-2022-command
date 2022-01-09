// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.TrackBall;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.VisionProcessor;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...


  private final XboxController xboxLeft = new XboxController(0);
  private final XboxController xboxRight = new XboxController(1);

  private final JoystickButton xboxLA = new JoystickButton(xboxLeft, 1);
  private final JoystickButton xboxLB = new JoystickButton(xboxLeft, 2);
  private final JoystickButton xboxLX = new JoystickButton(xboxLeft, 3);
  private final JoystickButton xboxLY = new JoystickButton(xboxLeft, 4);
  private final JoystickButton xboxLLeftButton = new JoystickButton(xboxLeft, 5);
  private final JoystickButton xboxLRightButton = new JoystickButton(xboxLeft, 6);
  private final JoystickButton xboxLBack = new JoystickButton(xboxLeft, 7);
  private final JoystickButton xboxLStart = new JoystickButton(xboxLeft, 8);
  private final JoystickButton xboxLJoystickButtonLeft = new JoystickButton(xboxLeft, 9);
  private final JoystickButton xboxLJoystickButtonRight = new JoystickButton(xboxLeft, 10);

  private final JoystickButton xboxRA = new JoystickButton(xboxRight, 1);
  private final JoystickButton xboxRB = new JoystickButton(xboxRight, 2);
  private final JoystickButton xboxRX = new JoystickButton(xboxRight, 3);
  private final JoystickButton xboxRY = new JoystickButton(xboxRight, 4);
  private final JoystickButton xboxRRightButton = new JoystickButton(xboxRight, 5);
  private final JoystickButton xboxRLeftButton = new JoystickButton(xboxRight, 6);
  private final JoystickButton xboxRBack = new JoystickButton(xboxRight, 7);
  private final JoystickButton xboxRStart = new JoystickButton(xboxRight, 8);
  private final JoystickButton xboxRJoystickButtonLeft = new JoystickButton(xboxRight, 9);
  private final JoystickButton xboxRJoystickButtonRight = new JoystickButton(xboxRight, 10);


  public static DriveTrain driveTrain = new DriveTrain();
  public static VisionProcessor visionProcessor = new VisionProcessor();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    driveTrain.setDefaultCommand(new ArcadeDrive());
    xboxLRightButton.whenHeld(new TrackBall());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
