// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.opencv.imgproc.Moments;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.CvSink;
import edu.wpi.first.cscore.CvSource;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class VisionProcessor extends SubsystemBase {
  /** Creates a new VisionProcessor. */

  int visionXLocation = 0;
  int visionYLocation = 0;

  Alliance color;

  UsbCamera camera;

  CvSink cvSink;
  CvSource outputStream;

  Mat source, hsvmat, coreOutput;

  public VisionProcessor() {
    color = DriverStation.getAlliance();
    camera = CameraServer.startAutomaticCapture();
    cvSink = CameraServer.getVideo();
    outputStream = CameraServer.putVideo("Vision", Constants.CAMERA_WIDTH, Constants.CAMERA_HEIGHT);
    source = new Mat();
    hsvmat = new Mat();
    coreOutput = new Mat();
    camera.setResolution(Constants.CAMERA_WIDTH, Constants.CAMERA_HEIGHT);
    
  }

  @Override
  public void periodic() {

    if (cvSink.grabFrame(source) == 0) {
      return;
    }

    Imgproc.cvtColor(source, hsvmat, Imgproc.COLOR_RGB2HSV_FULL);

    if (color.equals(Alliance.Blue)) {
      Core.inRange(hsvmat, new Scalar(120, Integer.MIN_VALUE, Integer.MIN_VALUE),
          new Scalar(140, Integer.MAX_VALUE, Integer.MAX_VALUE), coreOutput);
    } else if (color.equals(Alliance.Red)) {
      Core.inRange(hsvmat, new Scalar(120, Integer.MIN_VALUE, Integer.MIN_VALUE),
          new Scalar(140, Integer.MAX_VALUE, Integer.MAX_VALUE), coreOutput);
    } else {
      Core.inRange(hsvmat, new Scalar(120, Integer.MIN_VALUE, Integer.MIN_VALUE),
          new Scalar(140, Integer.MAX_VALUE, Integer.MAX_VALUE), coreOutput);
    }

    List<MatOfPoint> contours = new ArrayList<MatOfPoint>();

    Imgproc.findContours(coreOutput, contours, new Mat(), Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE);
    double maxArea = 0;
    MatOfPoint maxContour = new MatOfPoint();
    Iterator<MatOfPoint> each = contours.iterator();
    while (each.hasNext()) {

      MatOfPoint wrapper = each.next();
      double area = Imgproc.contourArea(wrapper);
      if (area > maxArea) {
        maxArea = area;
        maxContour = wrapper;
      }
    }

    visionXLocation = 160;
    visionYLocation = 160;

    if (maxArea != 0) {
      Moments m = Imgproc.moments(maxContour, false);
      int x = (int) (m.get_m10() / m.get_m00());
      int y = (int) (m.get_m01() / m.get_m00());
      Imgproc.circle(source, new Point(x, y), 10, new Scalar(255, 0, 0));
      visionXLocation = x;
      visionYLocation = y;
    }

    outputStream.putFrame(source);

    SmartDashboard.putNumber("visionXLocation", visionXLocation);
    SmartDashboard.putNumber("getX", getX());
  }

  public double getX() {
    return ((double) visionXLocation) * 2.0 / Constants.CAMERA_WIDTH - 1.0;
  }

  public double getY() {
    return ((double) visionYLocation) * 2.0 / Constants.CAMERA_HEIGHT - 1.0;
  }
}
