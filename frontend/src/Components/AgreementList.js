import React, {Component} from 'react';
import {Container, Table} from "reactstrap";

export default class  AgreementList extends Component  {

    state= {
        agreements: [],
        isLoading: false,
	};

    componentDidMount() {
        this.setState({isLoading: true});
        fetch('/api/agreements')
            .then(response => response.json())
            .then(data => this.setState({agreements: data, isLoading: false}));
        console.log("agreements " + this.state.agreements)
    }


	render() {
        const {agreements, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }

        const agreementList = agreements.map(agreement => {
            return(
                <tr key={agreement.id}>
                    <td style={{whiteSpace: 'nowrap'}} >{agreement.id}</td>
                    <td>{agreement.agreementType}</td>
                    <td>{agreement.customer.name}</td>
                    <td>{agreement.startDateTime}</td>
                </tr>
            )
        });

        return (
            <div>
            {this.state.agreements.length > 0 &&<div>
                <h1>Agreements</h1>
                <div size="sm">
                    <Container fluid>
                        <Table  hover size="sm">
                            <thead>
                            <tr>
                                <th >ID</th>
                                <th >Type</th>
                                <th >Customer</th>
                                <th >Start date</th>
                            </tr>
                            </thead>
                            <tbody>
                            {agreementList}
                            </tbody>
                        </Table>

                    </Container>
                </div>

            </div>}
                {this.state.agreements.length ==0 &&<div>
                    <h1>Agreements</h1>
                    <p>Nothing to display</p>
                </div>}
            </div>
        )
    }
}
