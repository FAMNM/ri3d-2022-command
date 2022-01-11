// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Elevator extends SubsystemBase {

  WPI_VictorSPX elevatorMotor;

  /** Creates a new Elevator. */
  public Elevator() {

    elevatorMotor = new WPI_VictorSPX(2);
    elevatorMotor.configNeutralDeadband(0.001);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void elevatorUp() {

    elevatorMotor.set(Constants.ELEVATOR_SPEED);
    // elevatorMotor.set(.01);

  }

  public void elevatorDown() {

    elevatorMotor.set(-1 * Constants.ELEVATOR_SPEED);
    // elevatorMotor.set(-.01);

  }

  public void elevatorScaled(double scale) {

    // elevatorMotor.set(scale * Constants.ELEVATOR_SPEED);
    elevatorMotor.set(scale * Constants.ELEVATOR_SPEED);

  }

  public void elevatorStop() {

    elevatorMotor.set(0);

  }

}
