import React, { Component } from 'react';
import axios from 'axios';
import logo from './logo.svg';
import './App.css';

class MostrarEquipo extends Component {

  constructor(props){
    super(props);

    this.state = {
      teams: []
    };
  };

 componentDidMount(){
    axios.get('http://localhost:8080/_ah/api/echo/v1/teamcollection')
      .then(res => {
          console.log(res.data.items);

          const teams = res.data.items.map(obj => obj);
                    console.log(teams);

          this.setState({ teams });
      });
  };

  render() {
    return (
      <div className="App">
        <div className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h2>Hola</h2>
        </div>
          <ul>
          {this.state.teams.map( team => 
            <li key={team.teamName}>{team.teamName}</li>
            )};
          </ul>
      </div>




    );
  }
}






export default MostrarEquipo;
