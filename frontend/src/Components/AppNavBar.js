import React, {Component}  from 'react';
import {
    BrowserRouter as Router,
    Switch, Route, Link
} from 'react-router-dom'
import CustomerList from "./CustomerList";
import AgreementList from "./AgreementList";
import AgreementServiceList from "./AgreementServiceList";

const padding = {
    padding: 20,
    fontSize: 50,
};

var customers = [{name:"a"}, {name: "b"}];
var agreements = [{id: 1, customer:customers[0], type: 100}, {id:2, customer:customers[1], type: 100}]
var services = [{id: 1, agreement:agreements[0], type: 100, fee: 23.50}, {id: 2, agreement:agreements[1], type: 50, fee: 123.50}]

export default class AppNavbar extends Component {


    render() {

        return <Router>
            <div>
                <Link style={padding}  to="/customers">customers</Link>
                <Link style={padding}  to="/agreements">agreements</Link>
                <Link style={padding}  to="/services">services</Link>
            </div>
            <Switch>
                <Route exact path="/">
                </Route>
                <Route exact path="/customers">
                    <CustomerList customers={customers}></CustomerList>
                </Route>
                <Route path="/agreements">
                    <AgreementList agreements ={agreements}/>
                </Route>
                <Route path="/services">
                    <AgreementServiceList services = {services}/>
                </Route>
            </Switch>
        </Router>
    }
}
