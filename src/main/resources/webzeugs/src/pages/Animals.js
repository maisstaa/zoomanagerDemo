import React, { Component } from "react";
import { TextField, Button,  } from '@material-ui/core/';
import SaveIcon from '@material-ui/icons/Save';
import EnhancedTable from "../components/AnimalTable";
import axios from "axios";
import DeleteIcon from '@material-ui/icons/Delete';

class Animals extends Component {
  
  constructor(props) {
    super(props);
    this.state = { 
      fullDataArray: [],
      rows: [],
      nameField: '',
      classField: '',
      speciesField: '',
      ageField: '',
      genderField: '',
      costsField: '',
    }

    this.handleNameChange = this.handleNameChange.bind(this);
    this.handleClassChange = this.handleClassChange.bind(this);
    this.handleSpeciesChange = this.handleSpeciesChange.bind(this);
    this.handleAgeChange = this.handleAgeChange.bind(this);
    this.handleGenderChange = this.handleGenderChange.bind(this);
    this.handleCostsChange = this.handleCostsChange.bind(this);
    this.updateRows = this.updateRows.bind(this);
  }

  updateRows(array) {
    this.setState({rows: array})
    console.log(this.state.rows);
    console.log(array);
  }

  handleNameChange = event => {
    this.setState({
      nameField: event.target.value})
  }
 
  handleClassChange = event => {
    this.setState({
      classField: event.target.value})
  }
  
  handleSpeciesChange = event => {
    this.setState({
      speciesField: event.target.value})
  }
  
  handleAgeChange = event => {
    this.setState({
      ageField: event.target.value})
  }
  
  handleGenderChange = event => {
    this.setState({
      genderField: event.target.value})
  }
  
  handleCostsChange = event => {
    this.setState({
      costsField: event.target.value})
  }

  addAnimal = event => {

    event.preventDefault();

    const animal = {
      name: this.state.nameField,
      animalClass: this.state.classField,
      species: this.state.speciesField,
      age: parseInt(this.state.ageField),
      gender: JSON.parse(this.state.genderField),
      costs: parseInt(this.state.costsField) 
    };


    axios.post('http://localhost:8080/api/animals', { 
      animalClass: this.state.classField,
      animalSpecies: this.state.speciesField,
      animalName: this.state.nameField,
      age: this.state.ageField,
      animalGender: this.state.genderField,
      costOfRationPerMonth: this.state.costsField 
     })
    .then((response => {
      console.log(response);
    }, (error) => {
      console.log(error);
    }))

    const currentState = this.state.rows;
    currentState.push(animal);
    this.setState({rows: currentState});
  };

  deleteAnimal = event => {

    event.preventDefault();

  }

  componentDidMount() {
    
    axios.get('http://localhost:8080/api/animals')
      .then(response => response.data)
      .then(data => {
        this.setState({fullDataArray: data});
        console.log(this.state.fullDataArray);
    
        const dataArray = []; 
    
        data.forEach(el => {
          dataArray.push(createData(el.animalName, el.animalClass,el.animalSpecies,el.age,el.animalGender,el.costOfRationPerMonth))
        }); 

        console.log(dataArray)
        this.setState({rows: dataArray});   
    });
  }
  
  render() {
    return (
      <div>
        <form>
          <h3>Tier anlegen</h3>
          <TextField className="outlined-basic" label="Name" value={this.state.nameField} onChange={this.handleNameChange} variant="outlined" required={true}/>
          <TextField className="outlined-basic" label="Art" value={this.state.classField} onChange={this.handleClassChange} variant="outlined" required={true}/>
          <TextField className="outlined-basic" label="Spezies" value={this.state.speciesField} onChange={this.handleSpeciesChange} variant="outlined" required={true}/>
          <TextField className="outlined-basic" label="Alter" value={this.state.ageField} onChange={this.handleAgeChange} variant="outlined" required={true}/>
          <TextField className="outlined-basic" label="Geschlecht" value={this.state.genderField} onChange={this.handleGenderChange} variant="outlined" required={true}/>
          <TextField className="outlined-basic" label="Rationskosten" value={this.state.costsField} onChange={this.handleCostsChange} variant="outlined" required={true}/>
          
          <Button
            variant="contained"
            color="primary"
            size="small"
            startIcon={<SaveIcon />}
            onClick={this.addAnimal}
          >
            save
          </Button>

          <Button
            variant="contained"
            color="primary"
            size="small"
            startIcon={<DeleteIcon />}
            onClick={this.deleteAnimal}
          >
            löschen
          </Button>

        </form>
        <EnhancedTable 
          data={this.state.rows} 
          action={this.updateRows}
        >
        </EnhancedTable>
      </div>
    )
  }
}

function createData(name, animalClass, species, age, gender, costs) {
  return { name, animalClass, species, age, gender, costs };
}

export default Animals;