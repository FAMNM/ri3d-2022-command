// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class CargoPusher extends SubsystemBase {

  Servo cargoPusher;
  Servo cargoPusher2;

  /** Creates a new CargoPusher. */
  public CargoPusher() {

    cargoPusher = new Servo(0); // NOT COLORED IN HEAT SYNC
    cargoPusher2 = new Servo(1); // COLORED IN HEAT SYNC (BLACK SHARPIE ON WHITE)
  
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putString("DB/String 0", "Servo 1 Location: " + cargoPusher.get());
    SmartDashboard.putString("DB/String 1", "Servo 2 Location: " + cargoPusher2.get());

  }

  public void servoOn() {

    cargoPusher.set(Constants.SERVO_1_ACTIVE_LOCATION);
    cargoPusher2.set(Constants.SERVO_2_ACTIVE_LOCATION);

  }

  public void servoOff() {

    cargoPusher.set(Constants.SERVO_1_INACTIVE_LOCATION);
    cargoPusher2.set(Constants.SERVO_2_INACTIVE_LOCATION);

  }



}
