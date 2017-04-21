import React, { Component } from 'react';
import axios from 'axios';
import logo from './logo.svg';
import './App.css';

class ConsultarEquipo extends Component {

  constructor(props){
    super(props);
    
    this.state = {nameT:'',
                  fundation:'',
                  tittles:''}; 

     this.consultarEquipoVista = this.consultarEquipoVista.bind(this);             

  }

  
    consultarEquipoVista(){

      var parameter=document.getElementById("name").value;
      if(parameter.length !== 0){

      axios.post('http://localhost:8080/_ah/api/echo/v1/consultarTeam?name='+parameter)
      .then(res => {

            this.setState({nameT: res.data.teamName});
            this.setState({fundation: res.data.fundationYear});
            this.setState({tittles: res.data.cantidadDeTitulos});

    });
      

    }else{
        alert('Debes escribir el nombre del equipo que quieres buscar');
    }
  }



  render() {
    return (
      <div className="App">
        <div className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h2>Consultar un equipo por su nombre</h2>
        </div>
         
  <div>
          <label id="Nombre">Name:</label>
          <input type="text" id="name" />
          <button onClick={this.consultarEquipoVista.bind()}> click me </button>

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






export default ConsultarEquipo;