import React, { Component } from 'react';
import axios from 'axios';
import logo from './logo.svg';
import './App.css';

class EliminarEquipo extends Component {

  constructor(props){
    super(props);
    
    this.state = {nameT:'',
                  fundation:'',
                  tittles:''}; 

     this.eliminarEquipoVista = this.eliminarEquipoVista.bind(this);             

  }

  
    eliminarEquipoVista(){

      var nameParameter=document.getElementById("name").value;
      
      if(nameParameter.length !== 0 ){

        var querystring = require('querystring');

      axios.post('http://localhost:8080/_ah/api/echo/v1/deleteTeam/'+nameParameter,
         querystring.stringify({
            idLeague: '1'
    })
        )
      .then(res => {

            this.setState({nameT: res.data.teamName});
            this.setState({fundation: res.data.fundationYear});
            this.setState({tittles: res.data.cantidadDeTitulos});

            alert('Equipo Borrado!!!');

    });
      

    }else{
        alert('Debes llenar el campo para poder eliminar el equipo');
    }
  }



  render() {
    return (
      <div className="App">
        <div className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h2>Eliminar un equipo por su nombre</h2>
        </div>
         
  <div>
          <label id="Nombre">Name:</label>
          <input type="text" id="name" /> 
          <br/>
          
          <button onClick={this.eliminarEquipoVista.bind()}> Delete </button>

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






export default EliminarEquipo;