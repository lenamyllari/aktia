import React from 'react';

const AgreementService = ({service}) => {

     return ( <div>
		<p> Service type: {service.type} </p>
             <p> Agreement: {service.agreement.id}</p>

             <p>Fee: {service.fee} </p>
        </div>
	 )
}
export default AgreementService
