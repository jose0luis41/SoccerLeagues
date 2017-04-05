package com.example.echo;

import com.example.echo.League;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-05T11:59:08")
@StaticMetamodel(Team.class)
public class Team_ { 

    public static volatile SingularAttribute<Team, String> teamName;
    public static volatile SingularAttribute<Team, League> leagueidLeague;
    public static volatile SingularAttribute<Team, Integer> cantidadDeTitulos;
    public static volatile SingularAttribute<Team, Integer> fundationYear;

}