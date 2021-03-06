// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Winch extends SubsystemBase {

  WPI_VictorSPX winch;
  /** Creates a new Winch. */
  public Winch() {

    winch = new WPI_VictorSPX(3);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void robotClimb() {

    winch.set(Constants.WINCH_SPEED);

  }

  public void robotDescend() {

    winch.set(-1 * Constants.WINCH_SPEED);

  }

  public void stopWinch() {

    winch.set(0);

  }
}
