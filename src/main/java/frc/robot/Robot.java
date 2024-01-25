package frc.robot;

import edu.wpi.first.util.sendable.SendableRegistry;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class Robot extends TimedRobot {
  private final CANSparkMax m_leftMotor = new CANSparkMax(1, MotorType.kBrushless);
  private final CANSparkMax m_rightMotor = new CANSparkMax(2, MotorType.kBrushless);

  private final Joystick m_stick = new Joystick(0);

  public Robot() { }

  @Override
  public void robotInit() { }

  @Override
  public void teleopPeriodic() {
    double axis1 = m_stick.getRawAxis(1);
    double axis5 = m_stick.getRawAxis(5);

    m_leftMotor.set(axis1);
    m_rightMotor.set(axis5);

  }
}