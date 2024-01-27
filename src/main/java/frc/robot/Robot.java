
package frc.robot;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Robot extends TimedRobot {
  private final CANSparkMax m_leftMotor = new CANSparkMax(1, MotorType.kBrushless);
  private final CANSparkMax m_rightMotor = new CANSparkMax(2, MotorType.kBrushless);

  private final Joystick m_stick = new Joystick(0);

  DutyCycleEncoder encodere = new DutyCycleEncoder(0);
  
  AnalogPotentiometer encoderExterno = new AnalogPotentiometer(0,180,30);
  
  public Robot() { }

  @Override
  public void robotInit() { }

  @Override
  public void teleopPeriodic() {
    double axis1 = m_stick.getRawAxis(1);
    double axis5 = m_stick.getRawAxis(5);

    m_leftMotor.set(axis1);
    m_rightMotor.set(axis5);

    encodere.setDistancePerRotation(5.0);
    encodere.getDistance();
    //robles
    encodere.close();
 
      double enc = encoderExterno.get();
      encoderExterno.close();
   
    SmartDashboard.putNumber("Encoder", enc);
      
    
}}