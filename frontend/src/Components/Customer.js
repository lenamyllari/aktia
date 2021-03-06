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
     async componentDidMount() {
         this.setState({isLoading: true, customerId: this.props.match.params.id});
         await fetch('/api/customers/' + this.state.customerId)
             .then(response => response.json())
             .then(data => this.setState({
                 customer: data,
                 customerId: data.id,
                 name: data.name,
                 ssn: data.ssn,
                 isLoading: false
             }));

         await fetch('/api/agreements/customer/' + this.state.customerId)
             .then(response => response.json())
             .then(data => this.setState({agreements: data}))

     }

    render() {
        const {agreements, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }

        const agreementList = agreements.map(agreement => {
            return(
                <tr key={agreement.id}>

                    <td ><Link to={"/agreement/" + agreement.id} params={{id:agreement.id}}>{agreement.agreementType}</Link></td>
                    <td>{agreement.startDateTime}</td>
                    <td>{agreement.endDateTime}</td>
                    <td>{this.getFeeSum(agreement.id)}</td>
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
                        <th>Fees for services</th>
                    </tr>
                    </thead>
                    <tbody>
                    {agreementList}
                    </tbody>
                </Table>

            </div>
        )
    }

    getFeeSum(agr_id) {
       let sum = 0.0;
        this.state.agreements.forEach(async agreement => {
            await fetch('/api/agreementServices/sum/' + agr_id)
                .then(response => response.json())
                .then(data => sum = data);
            console.log("sum " + sum);
            return sum;
        });


    }
}
