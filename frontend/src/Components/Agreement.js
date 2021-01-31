import React, {Component} from 'react';
import {Button, Form, FormGroup, Input, Label, Table} from "reactstrap";
import {Link} from "react-router-dom";

export default class   Agreement extends Component{
    constructor(props) {
        super(props);
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    emptyItem = {
        type: '',
        fee: '',
    };

    state = {
        agreementId: null,
        services: [],
        isLoading: false,
        adding:false,
        item: this.emptyItem,
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

    handleChange(event) {
        const target = event.target;
        const value = target.value;
        const type = target.type;
        const fee = target.fee;
        let item = {
            type: target.type,
            fee: target.fee,
        }
        this.setState({item: item});
    }

    async handleSubmit(event) {
        event.preventDefault();
        const {item} = this.state;

        await fetch('/api//agreementServices/add', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(item),
        });
        this.props.history.push('/customers');
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
                            <Label for="type">Type</Label>
                            <Input type="text" name="type" id="type" value={item.type || ''}
                                   onChange={this.handleChange} />
                        </FormGroup>
                        <FormGroup>
                            <Label for="fee">Fee</Label>
                            <Input type="text" name="fee" id="fee" value={item.fee || ''}
                                   onChange={this.handleChange} />
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

