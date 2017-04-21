/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.echo;


import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author joseluissacanamboy
 */
@Entity
@Table(name = "Team")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Team.findAll", query = "SELECT t FROM Team t")
    , @NamedQuery(name = "Team.findByTeamName", query = "SELECT t FROM Team t WHERE t.teamName = :teamName")
    , @NamedQuery(name = "Team.findByCantidadDeTitulos", query = "SELECT t FROM Team t WHERE t.cantidadDeTitulos = :cantidadDeTitulos")
    , @NamedQuery(name = "Team.findByFundationYear", query = "SELECT t FROM Team t WHERE t.fundationYear = :fundationYear")})
public class Team implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "teamName", nullable = false, length = 30)
    private String teamName;
    @Basic(optional = false)
    @Column(name = "cantidadDeTitulos", nullable = false)
    private int cantidadDeTitulos;
    @Basic(optional = false)
    @Column(name = "fundationYear", nullable = false)
    private int fundationYear;
    
    @JoinColumn(name = "League_idLeague", referencedColumnName = "idLeague", nullable = false)
    @ManyToOne(optional = false)
    private League leagueidLeague;

    public Team() {
    }

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public Team(League league, String teamName, int cantidadDeTitulos, int fundationYear) {
        this.leagueidLeague = league;
        this.teamName = teamName;
        this.cantidadDeTitulos = cantidadDeTitulos;
        this.fundationYear = fundationYear;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getCantidadDeTitulos() {
        return cantidadDeTitulos;
    }

    public void setCantidadDeTitulos(int cantidadDeTitulos) {
        this.cantidadDeTitulos = cantidadDeTitulos;
    }

    public int getFundationYear() {
        return fundationYear;
    }

    public void setFundationYear(int fundationYear) {
        this.fundationYear = fundationYear;
    }

    public League getLeagueidLeague() {
        return leagueidLeague;
    }

    public void setLeagueidLeague(League leagueidLeague) {
        this.leagueidLeague = leagueidLeague;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teamName != null ? teamName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Team)) {
            return false;
        }
        Team other = (Team) object;
        if ((this.teamName == null && other.teamName != null) || (this.teamName != null && !this.teamName.equals(other.teamName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.backend.Team[ teamName=" + teamName + " ]";
    }
    
}