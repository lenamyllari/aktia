import React, {Component} from 'react';
import {Link} from "react-router-dom";
import {Table} from "reactstrap";

export default class  Customer extends Component{

    emptyItem = {
        name: '',
        ssn: '',
    };


        state = {
            customer: this.emptyItem,
            customerId: null,
            name: '',
            ssn: '',
            agreements: [],
            isLoading: false,

        };

    static getDerivedStateFromProps(props, state) {
        if (props.match.params.id !== state.customerId) {
            return {
                customerId: props.match.params.id,
            };
        }
        // Return null to indicate no change to state.
        return null;
    }
    componentDidMount() {
        this.setState({isLoading: true, customerId: this.props.match.params.id});
        console.log("id " + this.state.customerId)
        console.log("id props " + this.props.match.params.id)
        fetch('/api/customers/' + this.state.customerId)
            .then(response => response.json())
            .then(data => this.setState({customer: data, customerId: data.id, name: data.name, ssn: data.ssn, isLoading: false}));

        fetch('/api/agreements/customer/' + this.state.customerId)
            .then(response => response.json())
            .then(data => this.setState({agreements: data}));
        this.state.agreements.forEach(agreement => {
            fetch('/api/agreementServices/agreement/' + agreement.id)
                .then(response => response.json())
                .then(data => agreement.append(data));
            console.log("services" + agreement)
        })
    }

    render() {
        const {customer} = this.state;

        const {agreements, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }

        const agreementList = agreements.map(agreement => {
            return(
                <tr key={agreement.id}>

                    <td>{agreement.agreementType}</td>
                    <td>{agreement.startDateTime}</td>
                    <td>{agreement.endDateTime}</td>
                </tr>
            )
        });

        return (<div>
                <h1>Customer</h1>
                <p> Name: {this.state.name} </p>
                <p> SSN: {this.state.ssn}</p>
                <h3>Agreements</h3>
                <Table  hover size="sm">
                    <thead>
                    <tr>

                        <th >Type</th>
                        <th >Start date</th>
                        <th >End date</th>
                    </tr>
                    </thead>
                    <tbody>
                    {agreementList}
                    </tbody>
                </Table>
            </div>
        )
    }

}
