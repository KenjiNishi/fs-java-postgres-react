import React, { Component } from 'react';
import { connect } from 'react-redux';

import { createPerson } from '../actions/personActions';

class Organizer extends Component {
  constructor(props) {
    super(props);
    this.state = {
      
    };

    this.onClick = this.onClick.bind(this);
  }

  onClick(){
    console.log('organizeeeee')
  }

  render() {
    return (
      <div className='container'>
        <button type="button" className="btn btn-warning" onClick={this.onClick}>Organize atendees</button>
      </div>
    );
  }
}
export default connect(null, { createPerson})(Organizer);