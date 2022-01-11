// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    // Drive Train Motors
    public static final int DRIVE_TRAIN_MOTOR_1 = 0;
    public static final int DRIVE_TRAIN_MOTOR_2 = 1;
    public static final int DRIVE_TRAIN_MOTOR_3 = 2;
    public static final int DRIVE_TRAIN_MOTOR_4 = 3;

    public static final int CAMERA_WIDTH = 320;
    public static final int CAMERA_HEIGHT = 240;

    public static final double SHOOTER_TOP_WHEEL_SPEED = .3;
    public static final double SHOOTER_BOTTOM_WHEEL_SPEED = .3;

    // public static final double SHOOTER_HIGH_SPEED = 0.85; CHANGE BACK FOR FINAL ROBOT
    public static final double SHOOTER_HIGH_SPEED = 0.3;
    public static final double SHOOTER_LOW_SPEED = 0.3;

    public static final double INTAKE_SPEED = .5;

    public static final double SERVO_1_ACTIVE_LOCATION = .3;
    public static final double SERVO_1_INACTIVE_LOCATION = 0;
    // public static final double SERVO_1_ACTIVE_LOCATION = .05;
    // public static final double SERVO_1_INACTIVE_LOCATION = .5;

    // public static final double SERVO_2_ACTIVE_LOCATION= 0.05;
    // public static final double SERVO_2_INACTIVE_LOCATION = .45;
    public static final double SERVO_2_ACTIVE_LOCATION= 0.45;
    public static final double SERVO_2_INACTIVE_LOCATION = .8;

    public static final double ELEVATOR_SPEED = .3;

    public static final double WINCH_SPEED = 1;

}
