import React, { Component } from "react";
import './App.css';

import NavBar from './components/NavBar'

import Home from './pages/Home';
import Animals from './pages/Animals';
import Staff from './pages/Staff';
import Shops from './pages/Shops';
import Transactions from './pages/Transactions';
import Enclosures from './pages/Enclosures';
import { Route, HashRouter } from "react-router-dom";

class App extends Component {
  render() {

    return (
      <HashRouter>

        <div 
          style= {
            {
              backgroundColor: '#eeeeee'
            }
          }
        >
          <NavBar/>
          <div className="content">
            <Route exact path="/" component={Home}/>
            <Route path="/animals" component={Animals}/>
            <Route path="/staff" component={Staff}/>
            <Route path="/shops" component={Shops}/>
            <Route path="/transactions" component={Transactions}/>
            <Route path="/enclosures" component={Enclosures}/>
          </div>
        </div>
        
      </HashRouter>
    );
  }
}

export default App;
