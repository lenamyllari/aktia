import React, {Component} from 'react';

export default class  Customer extends Component{

    emptyItem = {
        name: '',
        ssn: '',
    };

    constructor(props) {
        super(props);
        this.state = {
            item: this.emptyItem
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    async componentDidMount() {
        const customer = await (await fetch(`/api/${Number(this.props.match.params.id)}`)).json();
        this.setState({customer: customer});

    }

    render() {
        const {customer} = this.state;
        return (<div>
                <p> {customer.name} </p>
                <p> {customer.ssn}</p>
            </div>
        )
    }

}
