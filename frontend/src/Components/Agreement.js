import React from 'react';

const Agreement = ({agreement}) => {

     return ( <div>
             <p> Agreement: {agreement.id}</p>
             <p> Customer: {agreement.customer}</p>
		<p>Type: {agreement.type} </p>
        </div>
	 )
}
export default Agreement
