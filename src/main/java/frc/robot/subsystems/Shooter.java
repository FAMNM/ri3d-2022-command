// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {

  WPI_VictorSPX upperWheel;
  WPI_VictorSPX lowerWheel;


  /** Creates a new Shooter. */
  public Shooter() {

    upperWheel = new WPI_VictorSPX(4);
    lowerWheel = new WPI_VictorSPX(5);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void startWheels() {

    upperWheel.set(Constants.SHOOTER_TOP_WHEEL_SPEED);
    lowerWheel.set(-Constants.SHOOTER_TOP_WHEEL_SPEED);

  }

  public void stopWheels() {

    upperWheel.set(0);
    lowerWheel.set(0);

  }

  public void setWheels(double speed) {
    upperWheel.set(speed);
    lowerWheel.set(-speed);
  }


}
