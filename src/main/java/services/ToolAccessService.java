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
import java.util.Map;

import common.Service;
import common.ServiceLocator;
import javafx.application.Platform;

public class ToolAccessService extends Service
{
//  private LoggingService.Logger logger = ServiceLocator.getInstance().resolve(LoggingService.class).newLogger(getClass());
//  private static ToolAccessService instance = null;
//
//  private Map<Class<? extends Tool>, Tool> runningTools = new HashMap<>();
//
//  public static ToolAccessService getInstance()
//  {
//    if (instance == null)
//    {
//      instance = new ToolAccessService();
//    }
//    return instance;
//  }
//
//  public void launchTool(Class<? extends Tool> toolType)
//  {
//    if(!runningTools.containsKey(toolType))
//    {
//      Platform.runLater(() ->
//      {
//        try
//        {
//          Tool newTool = toolType.newInstance();
//          runningTools.put(toolType, newTool);
//        }
//        catch (InstantiationException | IllegalAccessException e)
//        {
//          e.printStackTrace();
//        }
//      });
//    }
//    else
//    {
//      logger.log("Tool already running!", null);
//    }
//  }
//
//  public <T extends Tool> T access(Class<? extends T> type)
//  {
//    if(runningTools.containsKey(type))
//    {
//      return (T)runningTools.get(type);
//    }
//    else
//    {
//      logger.log(type.getSimpleName() + " is not running. Launch tool first.", null);
//      return null;
//    }
//  }
}
