/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSystem extends SubsystemBase {

    public SpeedController frontLeft = new PWMVictorSPX(Constants.frontLeftMotor);
    public SpeedController rearLeft = new PWMVictorSPX(Constants.rearLeftMotor);
    public SpeedController frontRight = new PWMVictorSPX(Constants.frontRightMotor);
    public SpeedController rearRight = new PWMVictorSPX(Constants.rearRightMotor);
    public SpeedControllerGroup right = new SpeedControllerGroup(frontRight, rearRight);
    public SpeedControllerGroup left = new SpeedControllerGroup(frontLeft, rearLeft);

    public DifferentialDrive robotDrive = new DifferentialDrive(left, right);

    public void manualDrive(double move, double turn) {
      robotDrive.arcadeDrive(move,turn);
    }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
