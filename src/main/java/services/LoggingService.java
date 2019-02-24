/*-------------------------------------------------------------------------------------------------
| *** UNCLASSIFIED ***
|--------------------------------------------------------------------------------------------------
| U.S. Army Research, Development, and Engineering Command
| Aviation and Missile Research, Development, and Engineering Center
| Software Engineering Directorate, Redstone Arsenal, AL
|--------------------------------------------------------------------------------------------------
| Export-Control Act Warning: Warning - This Document contains technical data whose export is
| restricted by the Arms Export Control Act (Title 22, U.S.C., Sec 2751, et seq) or the Export
| Administration Act of 1979, as amended, Title 50, U.S.C., App. 2401 et seq. Violations of these
| export laws are subject to severe criminal penalties. Disseminate in accordance with provisions
| of DoD Directive 5230.25.
|--------------------------------------------------------------------------------------------------
| Distribution Statement C:  Distribution authorized to U.S. Government Agencies and their
| contractors, Export Controlled, Critical Technology, 13 Feb 2017. Other request for this document
| shall be referred to U.S. Army Aviation and Missile Research Development and Engineering Center
| Software Engineering Directorate, Attn: RDMR-BAW, Redstone Arsenal, AL 35898.
--------------------------------------------------------------------------------------------------*/

package services;

import common.Service;

/**
 * LoggingService provides a simplified means of sending log messages to the terminal.
 */
public class LoggingService extends Service
{
  private static LoggingService instance;
  private Logger logger;

  private boolean messageLoggingEnabled = true;
  private boolean errorLoggingEnabled = false;

  private LoggingService()
  {
    logger = newLogger(getClass());
  }

  /**
   * Returns the singleton instance of the LoggingService
   *
   * @return LoggingService singleton
   */
  public static LoggingService getInstance()
  {
    if (instance == null)
    {
      instance = new LoggingService();
    }
    return instance;
  }
  /**
   * Creates a new {@link Logger} object
   *
   * @param clazz the {@link Class} requesting the {@link Logger}
   *
   * @return the new {@link Logger}
   */
  public Logger newLogger(Class clazz)
  {
    Logger newLogger = new Logger().setId(clazz.getSimpleName());
    return newLogger;
  }

  public void setMessageLoggingEnabled(boolean messageLoggingEnabled)
  {
    this.messageLoggingEnabled = messageLoggingEnabled;
  }

  public void setErrorLoggingEnabled(boolean errorLoggingEnabled)
  {
    this.errorLoggingEnabled = errorLoggingEnabled;
  }

  /**
   * Logger hides the log formatting when logging messages to the console
   */
  public class Logger
  {
    private String id;

    private Logger setId(String id)
    {
      this.id = "[" + id + "]";
      return this;
    }

    /**
     * Sends a message to the console prefixed by the {@link Logger} id
     *
     * @param message the log message
     */
    public void log(String message, String error)
    {
      if (messageLoggingEnabled)
      {
        System.out.println(id + " :: " + message);
        if(errorLoggingEnabled)
        {
          System.out.println("id :: " + error);
        }
      }
    }
  }
}
