import React, {Component} from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import { Link } from 'react-router-dom';



export default class  CustomerList extends Component  {

    state= {
        customers: [],
        isLoading: false,
	};

   componentDidMount() {
        this.setState({isLoading: true});
        fetch('/api/customers')
            .then(response => response.json())
            .then(data => this.setState({customers: data, isLoading: false}));
        console.log("customers " + this.state.customers)
    }

    async remove(id) {
        await fetch(`/api/customer/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedCustomers = [...this.state.customers].filter(i => i.id !== id);
            this.setState({customers: updatedCustomers});
        });
    }
	render() {
        const {customers, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }

        const customerList = customers.map(customer => {
            return(
            <tr key={customer.id}>
                <td style={{whiteSpace: 'nowrap'}} >{customer.name}</td>
                <td>{customer.ssn}</td>
                <td>
                </td>
            </tr>
            )
        });

        return (
            <div size="sm">
                <Container fluid>
                <Table  hover size="sm">
                    <thead>
                    <tr>
                        <th >Name</th>
                        <th >SSN</th>
                    </tr>
                    </thead>
                    <tbody>
                    {customerList}
                    </tbody>
                </Table>

                </Container>
            </div>
        )
    }
}
