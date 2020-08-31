import React, { Component } from "react";
import axios from "axios";
import EnclosureTable from "../components/EnclosureTable";
import { TextField, Button,  } from '@material-ui/core/';
import SaveIcon from '@material-ui/icons/Save';

class Enclosures extends Component {
    
    constructor(props) {
        super(props);
        this.state = {
            enclosureList: [],
            costsField: '',
            nameField: ''
        }
        this.handleNameChange = this.handleNameChange.bind(this);
        this.handleCostsChange = this.handleCostsChange.bind(this);
    }

    handleNameChange = event => {
        this.setState({
            nameField: event.target.value})
    }

    handleCostsChange = event => {
        this.setState({
            costsField: event.target.value})
    }

    componentDidMount() {
        axios.get('http://localhost:8080/api/enclosures')
          .then(response => response.data)
          .then(data => {
            this.setState({enclosureList: data});
            console.log(this.state.enclosureList);
        });
    }

    addEnclosure = event => {
        event.preventDefault();

        const newEnclosure = {
            name: this.state.nameField,
            costs: parseInt(this.state.costsField) 
        };

        axios.post('http://localhost:8080/api/enclosures', {
            name: this.state.nameField,
            costs: parseInt(this.state.costsField) 
        })
        .then(response => {
            console.log(response);
        }, (error) => {
            console.log(error);
        })

        const newState = this.state.enclosureList;
        newState.push(newEnclosure);
        this.setState({enclosureList: newState});
    }
    
    render() {
        return(
            <div>
                <EnclosureTable
                    data={this.state.enclosureList}
                >
                </EnclosureTable>
                <Button
                    variant="contained"
                    color="primary"
                    size="small"
                    startIcon={<SaveIcon />}
                    onClick={this.addEnclosure}
                >
                    Neues Gehege anlegen
                </Button>
                <TextField className="outlined-basic" label="Name" value={this.state.nameField} onChange={this.handleNameChange} variant="outlined" required={true}/>
                <TextField className="outlined-basic" label="Kosten" value={this.state.costsField} onChange={this.handleCostsChange} variant="outlined" required={true}/>
            </div>
         );
    }
}

export default Enclosures;