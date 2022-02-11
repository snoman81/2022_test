// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: RobotContainer.

package frc.robot;

import frc.robot.commands.*;
import frc.robot.subsystems.*;
import frc.robot.util.JoystickPOVButton;
import frc.robot.util.XboxControllerAxisButton;
import frc.robot.util.XboxPOVButton;
import oi.limelightvision.limelight.frc.LimeLight;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.*;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  private static RobotContainer m_robotContainer = new RobotContainer();

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
// The robot's subsystems
    public final Climber m_climber = new Climber();
    public final ele m_ele = new ele();
    public final intake m_intake = new intake();
    public final DriveTrain m_driveTrain = new DriveTrain();
    public final HDrive m_hDrive = new HDrive();
    public final Pneumatics m_pneumatics = new Pneumatics();

// Joysticks
private final XboxController operator = new XboxController(1);
private final Joystick driver = new Joystick(0);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    private final LimeLight myLimeLight = new LimeLight();

  
  // A chooser for autonomous commands
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
  * The container for the robot.  Contains subsystems, OI devices, and commands.
  */
  private RobotContainer() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
    // Smartdashboard Subsystems
    SmartDashboard.putData(m_intake);
    SmartDashboard.putData(m_driveTrain);


    // SmartDashboard Buttons
    SmartDashboard.putData("P retract", new Pretract( m_pneumatics ));
    SmartDashboard.putData("P extend", new Pextend( m_pneumatics ));
    SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
    SmartDashboard.putData("DriveDistance", new DriveDistance( m_driveTrain ));
    SmartDashboard.putData("intakeRun: my_In", new intakeRun(1, m_intake));
    SmartDashboard.putData("intakeRun: my_Out", new intakeRun(-1, m_intake));
    SmartDashboard.putData("ele run: up", new elerun(1, m_ele));
    SmartDashboard.putData("ele run: down", new elerun(-1, m_ele));
    SmartDashboard.putData("HDrive Run: Left", new HDriveRun(1, m_hDrive));
    SmartDashboard.putData("HDrive Run: Right", new HDriveRun(-1, m_hDrive));

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
    // Configure the button bindings
    configureButtonBindings();

    // Configure default commands
        // _BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND
  


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND
    m_driveTrain.setDefaultCommand(new DriveWithJoySticks(() ->  -driver.getRawAxis(1), () ->  driver.getRawAxis(2) , m_driveTrain) );

    // Configure autonomous sendable chooser
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

    m_chooser.setDefaultOption("Autonomous Command", new AutonomousCommand());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

    SmartDashboard.putData("Auto Mode", m_chooser);
  }

  public static RobotContainer getInstance() {
    return m_robotContainer;
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
        
        // Create some buttons
        final XboxControllerAxisButton eledownbuttonRT = new XboxControllerAxisButton(operator, 3);        
        eledownbuttonRT.whenHeld(new elerun(-1, m_ele) ,true);
        SmartDashboard.putData("ele down buttonRT",new elerun(-1, m_ele) );

        final JoystickButton eleupbuttonRB = new JoystickButton(operator, XboxController.Button.kRightBumper.value);        
        eleupbuttonRB.whenHeld(new elerun(1, m_ele) ,true);
        SmartDashboard.putData("ele up buttonRB",new elerun(1, m_ele) );

        final XboxControllerAxisButton intakeoutbuttonLT = new XboxControllerAxisButton(operator, 2);        
        intakeoutbuttonLT.whenHeld(new intakeRun(-1, m_intake) ,true);
        SmartDashboard.putData("intake out buttonLT",new intakeRun(-1, m_intake) );

        final JoystickButton intatkerunbuttonLB = new JoystickButton(operator, XboxController.Button.kLeftBumper.value);        
        intatkerunbuttonLB.whenHeld(new intakeRun(1, m_intake) ,true);
        SmartDashboard.putData("intatke run buttonLB",new intakeRun(1, m_intake) );

        final JoystickButton climberDown12 = new JoystickButton(driver, 12);        
        climberDown12.whenHeld(new ClimbRun(-1, m_climber) ,true);
        SmartDashboard.putData("Climber Down12",new ClimbRun(-1, m_climber) );

        final JoystickButton climberup11 = new JoystickButton(driver, 11);        
        climberup11.whenHeld(new ClimbRun(1, m_climber) ,true);
        SmartDashboard.putData("Climber up11",new ClimbRun(1, m_climber) );

        final JoystickPOVButton hDriveRight_POVE = new JoystickPOVButton(driver, 90);        
        hDriveRight_POVE.whenHeld(new HDriveRun(1.0, m_hDrive) ,true);
        SmartDashboard.putData("HDrive Right_POVE",new HDriveRun(0, m_hDrive) );

        final JoystickPOVButton hDriveLeft_POVW = new JoystickPOVButton(driver, 270);        
        hDriveLeft_POVW.whenHeld(new HDriveRun(-1.0, m_hDrive) ,true);
        SmartDashboard.putData("HDrive Left_POVW",new HDriveRun(0, m_hDrive) );
        
      final JoystickButton LimeLIghtStear_BTN = new JoystickButton(driver, 7);
      //LimeLIghtStear_BTN.whenHeld(new drivewithLimelightStear(() ->  -driver.getRawAxis(1), myLimeLight , m_driveTrain) )
      
      final JoystickButton pextendButton4 = new JoystickButton(driver, 4);        
      pextendButton4.whenPressed(new Pextend( m_pneumatics ) ,true);
      SmartDashboard.putData("P extend Button 4",new Pextend( m_pneumatics ) );

      final JoystickButton pretract3 = new JoystickButton(driver, 3);        
      pretract3.whenPressed(new Pretract( m_pneumatics ) ,true);
      SmartDashboard.putData("P retract 3",new Pretract( m_pneumatics ) );;

    // _BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS
  }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
public Joystick getDriver() {
        return driver;
    }

public XboxController getOperator() {
      return operator;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public LimeLight getLimeLight(){
        return myLimeLight;
    }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
  */
  public Command getAutonomousCommand() {
    // The selected command will be run in autonomous
    return m_chooser.getSelected();
  }
  

}

