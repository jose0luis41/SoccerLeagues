
package com.example.echo;

import java.io.Serializable;
import java.util.*;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.persistence.EntityManager;
import com.example.persistence.ClassEntityManagerFactory;
import com.google.appengine.repackaged.org.codehaus.jackson.annotate.JsonIgnore;
/**
 *
 * @author joseluissacanamboy
 */
@Entity
@Table(name = "League")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "League.findAll", query = "SELECT l FROM League l")
    , @NamedQuery(name = "League.findByIdLeague", query = "SELECT l FROM League l WHERE l.idLeague = :idLeague")})
public class League implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idLeague", nullable = false)
    private Integer idLeague;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "leagueidLeague")
    private List<Team> teamList;

    public League() {
    }

    public League(Integer idLeague) {
        this.idLeague = idLeague;
    }

    public Integer getIdLeague() {
        return idLeague;
    }

    public void setIdLeague(Integer idLeague) {
        this.idLeague = idLeague;
    }

    
 
    
    
    @XmlTransient
    public List<Team> getTeamList() {
        
        EntityManager em = ClassEntityManagerFactory.get().createEntityManager(); 
        
        return em.createNamedQuery("Team.findAll",Team.class).getResultList();
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLeague != null ? idLeague.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof League)) {
            return false;
        }
        League other = (League) object;
        if ((this.idLeague == null && other.idLeague != null) || (this.idLeague != null && !this.idLeague.equals(other.idLeague))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.backend.League[ idLeague=" + idLeague + " ]";
    }
    
	public Team searchTeamWithName(String teamName){
            EntityManager em = ClassEntityManagerFactory.get().createEntityManager();   
            em.getTransaction().begin();
 
            Team teamTmp = em.find(Team.class, teamName);
             em.getTransaction().commit();
             
             return teamTmp;
	}

	public Team deleteTeam(Team team){
		Team found = null;
		boolean end = false;
		for(int i = 0; i < teamList.size()-1 && !end;i++){
			found = teamList.get(i);
			if(found.getTeamName().contains(team.getTeamName())){
				end = true;
				teamList.remove(i);
			}
				
		}
		return found;
	}

	public Team editTeam(League league, String name, int cantidadDeTitulos,int fundationYear){
		return null;
	}

	public Team createTeam(League league, String name, int cantidadDeTitulos,int fundationYear){
           
             return null;
	}
    
    
}