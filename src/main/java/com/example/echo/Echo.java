/*
 * Copyright (c) 2016 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not  use this file except in compliance with the License. You may obtain a
 * copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.example.echo;


import com.example.persistence.ClassEntityManagerFactory;
import java.util.List;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import javax.persistence.EntityManager;

/** The Echo API which Endpoints will be exposing. */
// [START echo_api_annotation]
@Api(
    name = "echo",
    version = "v1"
  
    // [END_EXCLUDE]
    )
// [END echo_api_annotation]
public class Echo {


  private League league;

  /**
   * Echoes the received message back. If n is a non-negative integer, the message is copied that
   * many times in the returned message.
   *
   * Note that name is specified and will override the default name of "{class name}.{method
   * name}". For example, the default is "echo.echo".
   *
   * Note that httpMethod is not specified. This will default to a reasonable HTTP method
   * depending on the API method name. In this case, the HTTP method will default to POST.
   */
  // [START echo_method]
  @ApiMethod(name = "showTeams")
  public List<Team> getAllTeams() {
     EntityManager em = ClassEntityManagerFactory.get().createEntityManager();   
     em.getTransaction().begin();
 
     League tmp = em.find(League.class, 1);
     em.getTransaction().commit();
  
    return tmp.getTeamList();
  }


 @ApiMethod(name = "consultarTeam", path="consultarTeam")
  public Team consultarTeam(@Named("name") String name) {
     EntityManager em = ClassEntityManagerFactory.get().createEntityManager();   
     em.getTransaction().begin();
 
     League tmp = em.find(League.class, 1);
     em.getTransaction().commit();
  

     Team t = tmp.searchTeamWithName(name);
     return t;
  }

  @ApiMethod(name = "deleteTeam", path="deleteTeam/{name}")
  public Team deleteTeam(@Named("name") String name) {

   EntityManager em = ClassEntityManagerFactory.get().createEntityManager();   
   em.getTransaction().begin();
   Team found = em.find(Team.class, name);
    
   em.remove(found);
   em.getTransaction().commit();
   return found;
  }

  @ApiMethod(httpMethod = ApiMethod.HttpMethod.PUT,name = "editTeam", path="editTeam/{name}")
  public Team editTeam(League league, @Named("name") String name, @Named("cantidadDeTitulos") int cantidadDeTitulos,@Named("fundationYear") int fundationYear) {

     EntityManager em = ClassEntityManagerFactory.get().createEntityManager();   
     em.getTransaction().begin();
 
       
       League found = em.find(League.class, league.getIdLeague());
       Team teamFound = em.find(Team.class,name);
       teamFound.setCantidadDeTitulos(cantidadDeTitulos);
       teamFound.setLeagueidLeague(found);
       teamFound.setFundationYear(fundationYear);
       em.persist(teamFound);
       em.getTransaction().commit();
       em.refresh(teamFound);
       return teamFound;
  }

  @ApiMethod(httpMethod = ApiMethod.HttpMethod.POST,name = "createTeam", path="createTeam/success")
  public Team createTeam(League league, @Named("name") String name, @Named("cantidadDeTitulos") int cantidadDeTitulos,@Named("fundationYear") int fundationYear) {

       EntityManager em = ClassEntityManagerFactory.get().createEntityManager();   
       em.getTransaction().begin();
 
       
       League found = em.find(League.class, league.getIdLeague());
       
       Team tmp = new Team(found, name, cantidadDeTitulos, fundationYear);
       em.persist(tmp);
       em.getTransaction().commit();
       return tmp;
  }




}

