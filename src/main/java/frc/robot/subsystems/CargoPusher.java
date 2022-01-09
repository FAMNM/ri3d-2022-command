// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class CargoPusher extends SubsystemBase {

  Servo cargoPusher;

  /** Creates a new CargoPusher. */
  public CargoPusher() {

    cargoPusher = new Servo(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void servoOn() {

    cargoPusher.set(1);

  }

  public void servoOff() {

    cargoPusher.set(0);

  }



}
