import React, { Component } from 'react';
import axios from 'axios';
import logo from './logo.svg';
import './App.css';

class EditarEquipo extends Component {

  constructor(props){
    super(props);
    
    this.state = {nameT:'',
                  fundation:'',
                  tittles:''}; 

     this.editarEquipoVista = this.editarEquipoVista.bind(this);             

  }

  
    editarEquipoVista(){

      var nameParameter=document.getElementById("name").value;
      var fundationParameter=document.getElementById("fundation").value;
      var cupsParameter=document.getElementById("cups").value;
      var leagueParameter=document.getElementById("league").value;

      if(nameParameter.length !== 0 && fundationParameter.length !== 0 && cupsParameter.length !== 0 && leagueParameter.length !== 0 ){

        var querystring = require('querystring');

      axios.post('http://localhost:8080/_ah/api/echo/v1/editTeam/'+nameParameter+'?cantidadDeTitulos='+cupsParameter+'&fundationYear='+fundationParameter,
         querystring.stringify({
            idLeague: leagueParameter
    })
        )
      .then(res => {

            this.setState({nameT: res.data.teamName});
            this.setState({fundation: res.data.fundationYear});
            this.setState({tittles: res.data.cantidadDeTitulos});

            alert('Equipo editado!!!');

    });
      

    }else{
        alert('Debes llenar todos los campos para poder editar el equipo');
    }
  }



  render() {
    return (
      <div className="App">
        <div className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h2>Editar un equipo</h2>
        </div>
         
  <div>
          <label id="Nombre">Name:</label>
          <input type="text" id="name" /> 
          <br/>
          <label id="Anofundacion">FundationYear:</label>
          <input type="text" id="fundation" />
          <br/>
          <label id="CantidadTitulos">Cups:</label>
          <input type="text" id="cups" />
          <br/>
          <label id="League">League:</label>
          <input type="text" id="league" />
          <br/>
          <button onClick={this.editarEquipoVista.bind()}> edit </button>

            <div className='well'>
     {
           <div>
                      Nombre de equipo:<br/>
                        <p>{this.state.nameT}</p>
                        Año de fundacion:<br/>
                        <p>{this.state.fundation}</p>
                        Titulos Ganados:<br/>
                        <p>{this.state.tittles}</p>
                      </div>
                      
                 
          }
    </div>

  </div>

      </div>




    );
  }
}






export default EditarEquipo;