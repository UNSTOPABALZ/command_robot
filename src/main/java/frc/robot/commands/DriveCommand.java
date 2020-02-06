/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;


public class DriveCommand extends CommandBase {
  double m_time, m_lSpeed, m_rSpeed;

  public DriveCommand(double time,double lSpeed, double rSpeed) {
    m_time = time;
    m_lSpeed = lSpeed;
    m_rSpeed = rSpeed;
    requires(Robot.DriveSystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Robot.DriveSystem.setleft(m_lSpeed);
    Robot.DriveSystem.setright(m_rSpeed);
    setTimeout(m_time);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.DriveSystem.setleft(0);
    Robot.DriveSystem.setright(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return isTimedOut();
  }
}