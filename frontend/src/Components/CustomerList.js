import React, {Component} from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import { Link } from 'react-router-dom';



export default class  CustomerList extends Component  {

    state= {
        customers: [],
        isLoading: false,
	};

/*	static getDerivedStateFromProps(props, state) {
        if (props.customers !== state.customers) {
            return {
                customers: props.customers,
            };
        }
        // Return null to indicate no change to state.
        return null;
    }*/

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
                    <ButtonGroup>
                        <Button size="sm" color="primary" tag={Link} to={"/customers/" + customer.id}>Edit</Button>
                        <Button size="sm" color="danger" onClick={() => this.remove(customer.id)}>Delete</Button>
                    </ButtonGroup>
                </td>
            </tr>
            )
        });

        return (
            <div>

                <div className="float-right">
                    <Button color="success" tag={Link} to="/customers/new">Add customer</Button>
                </div>
                <Table className="mt-4">
                    <thead>
                    <tr>
                        <th width="20%">Name</th>
                        <th width="20%">SSN</th>
                        <th width="10%">Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    {customerList}
                    </tbody>
                </Table>


            </div>
        )
    }
}
