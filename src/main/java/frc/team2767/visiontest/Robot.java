package frc.team2767.visiontest;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.team2767.visiontest.control.Controls;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.strykeforce.thirdcoast.deadeye.DeadeyeService;
import org.strykeforce.thirdcoast.telemetry.TelemetryController;
import org.strykeforce.thirdcoast.telemetry.TelemetryService;

public class Robot extends TimedRobot {
  //  public static final DriveSubsystem DRIVE = new DriveSubsystem();

  public static final TelemetryService TELEMETRY = new TelemetryService(TelemetryController::new);
  public static final DeadeyeService DEADEYE = new DeadeyeService();

  // Controls initialize Commands so this should be instantiated last to prevent
  // NullPointerExceptions in commands that require() Subsystems above.
  public static final Controls CONTROLS = new Controls();

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Override
  public void robotInit() {
    logger.info("Today is {}", new Date());
    TELEMETRY.start();
    DEADEYE.enableConnectionEventLogging(true);
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }
}
