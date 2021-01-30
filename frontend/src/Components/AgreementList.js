import React, {Component} from 'react';
import Agreement from "./Agreement"

export default class  AgreementList extends Component  {

    state= {
        agreements: this.props.agreements,
        isLoaded: false,
	};
	
	static getDerivedStateFromProps(props, state) {
        if (props.agreements !== state.agreements) {
            return {
                agreements: props.agreements,
            };
        }
        // Return null to indicate no change to state.
        return null;
    }


	render() {
        return (
            <div>
                <h1>Agreements</h1>
                <ul >
                    {this.state.agreements.map(agreement =>
                        <Agreement key={agreement._id} agreement={agreement}/>
                    )}
                </ul>
            </div>
        )
    }
}