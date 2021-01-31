import React from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';

import AppNavBar from "../src/Components/AppNavBar";
import CustomerList from "./Components/CustomerList";
import Customer from "./Components/Customer";
import Agreement from "./Components/Agreement";
import Home from "./Components/Home";

function App() {
  const padding = {
    padding: 20,
    fontSize: 50,
  };


  return (
    <div className="mystyle" >
      <AppNavBar/>
        <Router>
            <Switch>
                <Route exact path='/'  component={Home}/>
                <Route exact path='/customers'  component={CustomerList}/>
                <Route exact path='/customer/:id'  component={Customer}/>
                <Route exact path='/agreement/:id'  component={Agreement}/>
            </Switch>
        </Router>
      </div>
  );
}

export default App;
