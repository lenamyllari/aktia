import React, {Component} from 'react';
import {Container, Table} from "reactstrap";

export default class  AgreementServiceList extends Component  {

    state= {
        services: [],
        isLoading: false,
	};

    componentDidMount() {
        this.setState({isLoading: true});
        fetch('/api/agreementServices')
            .then(response => response.json())
            .then(data => this.setState({services: data, isLoading: false}));
    }

	render() {
        const {services, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }

        const serviceList = services.map(service => {
            return(
                <tr key={service.id}>

                    <td>{service.serviceType}</td>
                    <td>{service.agreement.id}</td>
                    <td>{service.agreement.customer.name}</td>
                    <td>{service.serviceFee}</td>
                </tr>
            )
        });

        return (

            <div>
                {this.state.services.length > 0 &&<div>
                    <h1>Services</h1>
                    <div size="sm">
                        <Container fluid>
                            <Table  hover size="sm">
                                <thead>
                                <tr>

                                    <th >Type</th>
                                    <th >Agreement</th>
                                    <th>Customer</th>
                                    <th >Fee</th>
                                </tr>
                                </thead>
                                <tbody>
                                {serviceList}
                                </tbody>
                            </Table>

                        </Container>
                    </div>

                </div>}
                {this.state.services.length ==0 &&<div>
                    <h1>Services</h1>
                    <p>Nothing to display</p>
                </div>}
            </div>
        )
    }
}
