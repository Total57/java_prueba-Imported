package frc.robot;

import edu.wpi.first.util.sendable.SendableRegistry;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.AbsoluteEncoder;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.revrobotics.AnalogInput;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class Robot extends TimedRobot {
  private final CANSparkMax m_leftMotor = new CANSparkMax(1, MotorType.kBrushless);
  private final CANSparkMax m_rightMotor = new CANSparkMax(2, MotorType.kBrushless);

  private final Joystick m_stick = new Joystick(0);

  public class AnalogInput {
  private final AnalogInput absoluteEncoder;

  public AnalogInput getAbsoluteEncoder() {

    return absoluteEncoder;
  }

  public AnalogInput(AnalogInput absoluteEncoder) {
    this.absoluteEncoder = absoluteEncoder;
    absoluteEncoder = new AnalogInput(absoluteEncoder);
  } 
  }
  
  private RelativeEncoder encoder_r ;
  private RelativeEncoder encoder_l ;


  public Robot() {

   }

  
   @Override
  public void robotInit() {
  
   }

  @Override
  public void teleopPeriodic() {
 
    double axis1 = m_stick.getRawAxis(1);
    double axis5 = m_stick.getRawAxis(5);

    m_leftMotor.set(axis1);
    m_rightMotor.set(axis5); 
     
    encoder_r = m_leftMotor.getEncoder();
    encoder_l = m_rightMotor.getEncoder();

    double angle = absoluteEncoder.getVoltage();

    SmartDashboard.putNumber("Encoder motor derecho", encoder_r.getPosition());
    SmartDashboard.putNumber("Encoder motor izquierdo", encoder_l.getPosition());

    //SmartDashboard.putNumber("Encoder externo", );


  }
}