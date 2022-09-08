// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.AutonsFinished.BaselineAuton;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.CargoDown;
import frc.robot.commands.CargoUp;
import frc.robot.commands.ControlShooter;
import frc.robot.commands.ElevatorControl;
import frc.robot.commands.RunIntake;
import frc.robot.commands.RunIntakeReverse;
import frc.robot.commands.ShootBall;
import frc.robot.commands.TankDrive;
import frc.robot.commands.WinchControl;
import frc.robot.subsystems.CargoPusher;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.VisionProcessor;
import frc.robot.subsystems.Winch;
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


  private final XboxController driver = new XboxController(0);
  private final XboxController manipulator = new XboxController(1);

  private final JoystickButton driverA = new JoystickButton(driver, 1);
  private final JoystickButton driverB = new JoystickButton(driver, 2);
  private final JoystickButton driverX = new JoystickButton(driver, 3);
  private final JoystickButton driverY = new JoystickButton(driver, 4);
  private final JoystickButton driverLeftButton = new JoystickButton(driver, 5);
  private final JoystickButton driverRightButton = new JoystickButton(driver, 6);
  private final JoystickButton driverBack = new JoystickButton(driver, 7);
  private final JoystickButton driverStart = new JoystickButton(driver, 8);
  private final JoystickButton driverJoystickButtonLeft = new JoystickButton(driver, 9);
  private final JoystickButton driverJoystickButtonRight = new JoystickButton(driver, 10);

  private final JoystickButton manipulatorA = new JoystickButton(manipulator, 1);
  private final JoystickButton manipulatorB = new JoystickButton(manipulator, 2);
  private final JoystickButton manipulatorX = new JoystickButton(manipulator, 3);
  private final JoystickButton manipulatorY = new JoystickButton(manipulator, 4);
  private final JoystickButton manipulatorRightButton = new JoystickButton(manipulator, 5);
  private final JoystickButton manipulatorLeftButton = new JoystickButton(manipulator, 6);
  private final JoystickButton manipulatorBack = new JoystickButton(manipulator, 7);
  private final JoystickButton manipulatorStart = new JoystickButton(manipulator, 8);
  private final JoystickButton manipulatorJoystickButtonLeft = new JoystickButton(manipulator, 9);
  private final JoystickButton manipulatorJoystickButtonRight = new JoystickButton(manipulator, 10);


  public static DriveTrain driveTrain = new DriveTrain();
  // public static VisionProcessor visionProcessor = new VisionProcessor();
  public static Shooter shooter = new Shooter();
  public static CargoPusher cargoPusher = new CargoPusher();
  public static Intake intake = new Intake();
  public static Elevator elevator = new Elevator();
  public static Winch winch = new Winch();
  

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

    // Default Commands
    // driveTrain.setDefaultCommand(new ArcadeDrive());
    driveTrain.setDefaultCommand(new TankDrive());
    shooter.setDefaultCommand(new ControlShooter());
    elevator.setDefaultCommand(new ElevatorControl());
    winch.setDefaultCommand(new WinchControl());
    
    
    // Button Bindings
    // driverRightButton.whenHeld(new TrackBall());
    driverStart.whenPressed(new ShootBall(Constants.SHOOTER_HIGH_SPEED));
    // driverBack.whenPressed(new ShootBall(Constants.SHOOTER_LOW_SPEED));
    driverA.whenPressed(new CargoUp());
    driverB.whenPressed(new CargoDown());
    driverRightButton.whileHeld(new RunIntake());
    driverLeftButton.whileHeld(new RunIntakeReverse());
    // driverJoystickButtonRight.whenPressed(new TankDrive());
    // driverJoystickButtonLeft.whenPressed(new ArcadeDrive());
    // manipulatorY.whenPressed(new BaselineAuton());

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
    // return new BaselineAuton();
  }
}
