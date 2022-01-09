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
  // camera.setResolution(10, 10);

  CvSink cvSink;
  CvSource outputStream;
  // CvSource outputStream = CameraServer.putVideo("Vision", 10, 10);

  Mat source, hsvmat, coreOutput;

  public VisionProcessor() {
    color = DriverStation.getAlliance();
    camera = CameraServer.startAutomaticCapture();
    cvSink = CameraServer.getVideo();
    outputStream = CameraServer.putVideo("Vision", Constants.cameraWidth, Constants.cameraHeight);
    source = new Mat();
    hsvmat = new Mat();
    coreOutput = new Mat();
    camera.setResolution(Constants.cameraWidth, Constants.cameraHeight);
    /*
     * Alliance color = DriverStation.getAlliance();
     * new Thread(() -> {
     * 
     * UsbCamera camera = CameraServer.startAutomaticCapture();
     * camera.setResolution(Constants.cameraWidth, Constants.cameraHeight);
     * // camera.setResolution(10, 10);
     * 
     * CvSink cvSink = CameraServer.getVideo();
     * CvSource outputStream = CameraServer.putVideo("Vision",
     * Constants.cameraWidth, Constants.cameraHeight);
     * // CvSource outputStream = CameraServer.putVideo("Vision", 10, 10);
     * 
     * Mat source = new Mat();
     * Mat hsvmat = new Mat();
     * Mat coreOutput = new Mat();
     * 
     * while(!Thread.interrupted()) {
     * if(cvSink.grabFrame(source) == 0) {
     * continue;
     * }
     * 
     * Imgproc.cvtColor(source, hsvmat, Imgproc.COLOR_RGB2HSV_FULL);
     * 
     * // Imgproc.GaussianBlur(hsvmat, blurOutput, new Size(9, 9), 0, 0);
     * // Imgproc.blur(hsvmat, blurOutput, new Size(9,9));
     * // Imgproc.erode(blurOutput, erodeOutput, new Size(5,5));
     * // Imgproc.medianBlur(hsvmat, blurOutput, 9);
     * 
     * if(color.equals(Alliance.Blue)) {
     * Core.inRange(hsvmat, new Scalar(120,Integer.MIN_VALUE,Integer.MIN_VALUE), new
     * Scalar(140,Integer.MAX_VALUE,Integer.MAX_VALUE), coreOutput);
     * } else if(color.equals(Alliance.Red)) {
     * Core.inRange(hsvmat, new Scalar(120,Integer.MIN_VALUE,Integer.MIN_VALUE), new
     * Scalar(140,Integer.MAX_VALUE,Integer.MAX_VALUE), coreOutput);
     * } else {
     * Core.inRange(hsvmat, new Scalar(120,Integer.MIN_VALUE,Integer.MIN_VALUE), new
     * Scalar(140,Integer.MAX_VALUE,Integer.MAX_VALUE), coreOutput);
     * }
     * // 115 to 130
     * // 105 to 130 was also good
     * 
     * List<MatOfPoint> contours = new ArrayList<MatOfPoint>();
     * 
     * Imgproc.findContours(coreOutput, contours, new Mat(), Imgproc.RETR_EXTERNAL,
     * Imgproc.CHAIN_APPROX_SIMPLE);
     * double maxArea = 0;
     * MatOfPoint maxContour = new MatOfPoint();
     * Iterator<MatOfPoint> each = contours.iterator();
     * while (each.hasNext()) {
     * 
     * MatOfPoint wrapper = each.next();
     * double area = Imgproc.contourArea(wrapper);
     * if (area > maxArea) {
     * maxArea = area;
     * maxContour = wrapper;
     * }
     * }
     * 
     * visionXLocation = 160;
     * visionYLocation = 160;
     * // SmartDashboard.putNumber("DB/String 0", 160);
     * // SmartDashboard.putNumber("DB/String 1", 160);
     * 
     * if (maxArea != 0) {
     * Moments m = Imgproc.moments(maxContour, false);
     * int x = (int) (m.get_m10() / m.get_m00());
     * int y = (int) (m.get_m01() / m.get_m00());
     * Imgproc.circle(source, new Point(x, y), 10, new Scalar(255, 0, 0));
     * // SmartDashboard.putNumber("DB/String 0", x);
     * // SmartDashboard.putNumber("DB/String 1", y);
     * visionXLocation = x; // Global variables so we can use them anywhere
     * visionYLocation = y;
     * }
     * 
     * outputStream.putFrame(source);
     * 
     * SmartDashboard.putNumber("visionXLocation", visionXLocation);
     * SmartDashboard.putNumber("getX", getX());
     * }
     * }).start();
     */
  }

  @Override
  public void periodic() {

    if (cvSink.grabFrame(source) == 0) {
      return;
    }

    Imgproc.cvtColor(source, hsvmat, Imgproc.COLOR_RGB2HSV_FULL);

    // Imgproc.GaussianBlur(hsvmat, blurOutput, new Size(9, 9), 0, 0);
    // Imgproc.blur(hsvmat, blurOutput, new Size(9,9));
    // Imgproc.erode(blurOutput, erodeOutput, new Size(5,5));
    // Imgproc.medianBlur(hsvmat, blurOutput, 9);

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
    // 115 to 130
    // 105 to 130 was also good

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
    // SmartDashboard.putNumber("DB/String 0", 160);
    // SmartDashboard.putNumber("DB/String 1", 160);

    if (maxArea != 0) {
      Moments m = Imgproc.moments(maxContour, false);
      int x = (int) (m.get_m10() / m.get_m00());
      int y = (int) (m.get_m01() / m.get_m00());
      Imgproc.circle(source, new Point(x, y), 10, new Scalar(255, 0, 0));
      // SmartDashboard.putNumber("DB/String 0", x);
      // SmartDashboard.putNumber("DB/String 1", y);
      visionXLocation = x; // Global variables so we can use them anywhere
      visionYLocation = y;
    }

    outputStream.putFrame(source);

    SmartDashboard.putNumber("visionXLocation", visionXLocation);
    SmartDashboard.putNumber("getX", getX());
  }

  public double getX() {
    return ((double) visionXLocation) * 2.0 / Constants.cameraWidth - 1.0;
  }

  public double getY() {
    return ((double) visionYLocation) * 2.0 / Constants.cameraHeight - 1.0;
  }
}
