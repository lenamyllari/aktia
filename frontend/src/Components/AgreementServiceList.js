import React, {Component} from 'react';
import AgreementService from "./AgreementService"

export default class  AgreementServiceList extends Component  {

    state= {
        services: this.props.services,
        isLoaded: false,
	};

	static getDerivedStateFromProps(props, state) {
        if (props.services !== state.services) {
            return {
                agreements: props.services,
            };
        }
        // Return null to indicate no change to state.
        return null;
    }


	render() {
        console.log("services "+ this.state.services[1].type)
        return (

            <div>
                <h1>Services</h1>
                <ul >
                    {this.state.services.map(service =>
                        <AgreementService key={service._id} service={service}/>
                    )}
                </ul>
            </div>
        )
    }
}
