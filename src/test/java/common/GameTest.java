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

package common;

import org.junit.Test;

import java.util.Scanner;

import ecs.common.EntityModel;
import ecs.components.Sprite;
import services.LoggingService;
import services.SceneManager;

public class GameTest extends common.Game
{
  @Override
  protected void load()
  {
    promptForInput("Enter ZipCode: ");
  }

  @Override
  protected void unload()
  {

  }

  public static void main(String[] args)
  {
    promptForInput("Enter Integer: ");
  }

  private class TestScene extends ecs.common.Scene
  {
    public TestScene()
    {
      this.prefabs.add(Player.class);
    }
  }

  private class Player extends EntityModel
  {
    public Player()
    {
      this.components.add(Sprite.class);
    }
  }

  private static void promptForInput(String prompt)
  {
    Boolean error = false;
    String userInp = "";
    Scanner console = new Scanner(System.in);
    do {
      System.out.print(prompt);
      userInp = console.nextLine();
      // validate:
    } while (error == true);

    System.out.println("Input: " + Float.parseFloat(userInp));
  }

  private static boolean checkInt(String input)
  {
    try
    {
      Integer.parseInt(input);
      return true;
    }
    catch (Exception e)
    {
      return false;
    }
  }
}
