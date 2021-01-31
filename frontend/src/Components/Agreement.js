import React, {Component} from 'react';
import {Button, Form, FormGroup, Input, Label, Table} from "reactstrap";
import {Link} from "react-router-dom";

export default class   Agreement extends Component{
    constructor(props) {
        super(props);

        this.handleSubmit = this.handleSubmit.bind(this);
    }

    emptyItem = {
        serviceType: null,
        serviceFee: null,
    };

    state = {
        agreementId: null,
        services: [],
        isLoading: false,
        adding:false,
        item: this.emptyItem,
        itemFee:0,
        itemType:0,
        agreement: null,
    };

    static getDerivedStateFromProps(props, state) {
        if (props.match.params.id !== state.agreementId) {
            return {
                agreementId: props.match.params.id,
            };
        }
        // Return null to indicate no change to state.
        return null;
    }

    componentDidMount() {
        this.setState({isLoading: true, agreementId: this.props.match.params.id});

        fetch('/api/agreementServices/agreement/' + this.state.agreementId)
            .then(response => response.json())
            .then(data =>  this.setState({services: data,  isLoading: false}));
    }


    async handleSubmit(event) {
        event.preventDefault();
        await fetch('/api/agreements/' + this.state.agreementId)
            .then(response => response.json())
            .then(data =>  this.setState({agreement: data,  isLoading: false}));
        let item = {
            serviceType: this.state.itemType,
            serviceFee: this.state.itemFee,
            agreement: this.state.agreement
        }
        console.log(item)
        await fetch('/api/agreementServices/add', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(item),
        });
        this.props.history.push('/agreement/'+this.state.agreementId);
    }

    render() {
        const {item, services, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }

        const serviceList = services.map(service => {
            return(
                <tr key={service.id}>
                    <td>{service.serviceType}</td>
                    <td>{service.serviceFee}</td>
                </tr>
            )
        });
        return (<div>
                <h1>Services</h1>
                <Table  hover size="sm">
                    <thead>
                    <tr>
                        <th >Type</th>
                        <th >Fee</th>
                    </tr>
                    </thead>
                    <tbody>
                    {serviceList}
                    </tbody>
                </Table>
                <div>
                    <h2>Add new service</h2>
                    <Form onSubmit={this.handleSubmit}>
                        <FormGroup>
                            <Label for="serviceType">Type</Label>
                            <Input name="serviceType" id="serviceType"
                                   defaultValue={this.state.item.serviceType}
                                   onChange={(event) => {this.setState({itemType: event.target.value}) }}/>
                        </FormGroup>
                        <FormGroup>
                            <Label for="fee">Fee</Label>
                            <Input name="fee" id="fee"
                                   defaultValue={this.state.item.serviceFee}
                                   onChange={(event) => { this.setState({itemFee: event.target.value}) }}/>
                        </FormGroup>

                        <FormGroup>
                            <Button color="primary" type="submit">Save</Button>
                            <Button color="secondary" tag={Link} to={"/agreement/" + this.state.agreementId}>Cancel</Button>
                        </FormGroup>
                    </Form>
                </div>
            </div>
        )
    }
}

