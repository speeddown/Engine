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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TimerTask;

import common.Service;
import common.ServiceLocator;
import events.Event;
import events.IEventListener;

public class EventManager extends Service
{
  private LoggingService.Logger logger;

  private static EventManager instance = null;

  private static HashMap<Class<? extends Event>, List<IEventListener>> listenerMap = new HashMap<>();
  private static Queue<Event> pendingEvents = new PriorityQueue<>();

  private long updateInterval = 200;
  private Object lock = new Object();

  public static EventManager getInstance()
  {
    if(instance == null)
    {
      instance = new EventManager();
    }
    return instance;
  }

  private EventManager()
  {
    logger = ServiceLocator.getInstance().resolve(LoggingService.class).newLogger(getClass());
    ServiceLocator.getInstance().inject(this);
    start();
  }

  public void addListener(Class<? extends Event> eventType, IEventListener listener)
  {
    if(!listenerMap.keySet().contains(eventType))
    {
      listenerMap.put(eventType, new ArrayList<>());
    }
    listenerMap.get(eventType).add(listener);
  }

  public void addEvent(Event event)
  {
    pendingEvents.add(event);
  }

  public void postEvent()
  {
    Event event = pendingEvents.poll();
    if(event != null)
    {
      List<IEventListener> listeners = listenerMap.get(event.getClass());
      if(listeners.size() > 0)
      {
        event.getHandler().handle(event, listenerMap.get(event.getClass()));
      }
    }
  }

  private void start()
  {
    TimerTask task = new TimerTask()
    {
      @Override
      public void run()
      {
        logger.log("Event polling started", null);
        while(true)
        {
          if(!pendingEvents.isEmpty())
          {
            postEvent();
          }
          else
          {
            try
            {
              wait(updateInterval);
            }
            catch (InterruptedException e)
            {
              e.printStackTrace();
            }
          }
        }
      }
    };
  }
}
