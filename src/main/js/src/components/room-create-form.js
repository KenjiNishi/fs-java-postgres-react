import React, { Component } from 'react';
import { connect } from 'react-redux';

import { createRoom } from '../actions/roomActions';

class RoomForm extends Component {
  constructor(props) {
    super(props);
    this.state = {
      name: '',
      capacity: 0
    };

    this.onChange = this.onChange.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
  }

  onChange(e) {
    this.setState({ [e.target.name]: e.target.value });
  }

  onSubmit(e) {
    e.preventDefault();
    if(this.state.name.length==0){
      return false}

    const room = {
      name: this.state.name,
      capacity: this.state.capacity
    };

    this.props.createRoom(room);
    this.setState({name: '', capacity: 0})
  }

  render() {
    return (
      <div className='container'>
        <h3>Register new Event Room:</h3>
        <form action='' onSubmit={this.onSubmit} id="roomForm">
            <div className='row'>
              <div className='col-sm-12 col-md-6'>
                <label>Name: </label><br/>
                <input
                type="text" minLength='3'
                name="name"
                onChange={this.onChange}
                value={this.state.name}
                />
              </div>
              <div className='col-sm-12 col-md-6'>
                <label>Capacity: </label><br/>
                <input
                type="number" step="1" min="1"
                name="capacity"
                onChange={this.onChange}
                value={this.state.capacity}
                />
              </div>
            </div>
          <br/>
          <button type="submit">Register</button>
        </form>
      </div>
    );
  }
}
export default connect(null, { createRoom})(RoomForm);