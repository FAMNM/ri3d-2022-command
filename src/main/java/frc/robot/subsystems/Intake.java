// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {

  WPI_VictorSPX intake;

  /** Creates a new Intake. */
  public Intake() {

    intake = new WPI_VictorSPX(1);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setSpeed(double speed) {

    intake.set(speed);

  }

}
