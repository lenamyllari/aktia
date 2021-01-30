import React, {Component} from 'react';
import Customer from "./Customer"

export default class  CustomerList extends Component  {

    state= {
        customers: this.props.customers,
        isLoaded: false,
	};
	
	static getDerivedStateFromProps(props, state) {
        if (props.customers !== state.customers) {
            return {
                customers: props.customers,
            };
        }
        // Return null to indicate no change to state.
        return null;
    }


	render() {
        return (
            <div>
                <h1>Customers</h1>
                <ul >
                    {this.state.customers.map(customer =>
                        <Customer key={customer._id} customer={customer}/>
                    )}
                </ul>
            </div>
        )
    }
}