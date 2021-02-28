import React, { Component } from 'react';
import { connect } from 'react-redux';

import { OrganizeEvent } from '../actions/utils';

class Organizer extends Component {
  constructor(props) {
    super(props);
    this.state = {
      
    };

    this.onClick = this.onClick.bind(this);
  }

  onClick(){
    this.props.OrganizeEvent();
  }

  render() {
    return (
      <div className='container'>
        <button type="button" className="btn btn-warning" onClick={this.onClick}>Organize Event</button>
      </div>
    );
  }
}

const mapStateToProps = state => (
    {
    loading: state.utils.loading
  });

export default connect(mapStateToProps, { OrganizeEvent })(Organizer);