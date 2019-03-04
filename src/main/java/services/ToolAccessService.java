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

import java.util.HashMap;

import common.Service;
import common.ServiceLocator;
import ui.Window;

public class ToolAccessService extends Service
{
  private static ToolAccessService instance = null;
  private final LoggingService.Logger logger = ServiceLocator.getInstance().resolve(LoggingService.class).newLogger(getClass());

  private HashMap<Class<? extends Window>, Window> tools = new HashMap<>();

  public static ToolAccessService getInstance()
  {
    if (instance == null)
    {
      instance = new ToolAccessService();
    }
    return instance;
  }

  public boolean isToolRunning(Class<? extends Window> tool)
  {
    return tools.containsKey(tool);
  }

  public void startTool(Class<? extends Window> tool)
  {
    if (!isToolRunning(tool))
    {
      try
      {
        Window toolInstance = tool.newInstance();
        toolInstance.load();
        tools.put(tool, toolInstance);
      }
      catch (InstantiationException | IllegalAccessException e)
      {
        logger.log("Failed to start " + getClass().getSimpleName(), null);
      }
    }
  }
}
