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

/**
 * Service objects are defined by their need to be available widely to the internal system. To be
 * qualified as a service, the extending class should provide a clearly defined and purposeful
 * ability to other objects in the Ecs.
 *
 * Services should attempt to keep dependencies on other services as minimal
 * as possible to avoid dependency management issues, specifically when it comes to the order in
 * which services are started.
 *
 * Seeing as a service is accessed widely in the Ecs, it is injected into the {@link ServiceLocator}
 * which makes accessing the service trivial.
 */
public abstract class Service
{
  protected Service()
  {
    ServiceLocator.getInstance().inject(this);
  }
}
