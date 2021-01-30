import React from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import AppNavBar from "../src/Components/AppNavBar";
import CustomerList from "./Components/CustomerList";
import CustomerEdit from "./Components/CustomerEdit";
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
                <Route path='/' exact={true} component={Home}/>
                <Route path='/customers' component={CustomerList}/>
                <Route path='/customers/new'  component={CustomerEdit}/>
                <Route path='/customers/:id' component={CustomerEdit}/>
            </Switch>
        </Router>
      </div>
  );
}

export default App;
