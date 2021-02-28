import React, { Component } from 'react';
import { connect } from 'react-redux';

import { createPerson } from '../actions/personActions';

class PersonForm extends Component {
  constructor(props) {
    super(props);
    this.state = {
      firstName: '',
      lastName: '',
    };

    this.onChange = this.onChange.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
  }

  onChange(e) {
    this.setState({ [e.target.name]: e.target.value });
  }

  onSubmit(e) {
    e.preventDefault();

    const person = {
      firstName: this.state.firstName,
      lastName: this.state.lastName
    };

    this.props.createPerson(person);
    this.setState({firstName: '',lastName: ''})
  }

  render() {
    return (
      <div className='container'>
        <h3>Register new atendee:</h3>
        <form action='' onSubmit={this.onSubmit} id="personForm">
            <div className='row'>
                <div className='col-sm-12 col-md-6'>
                    <label>Name: </label><br/>
                    <input
                    type="text"
                    name="firstName"
                    onChange={this.onChange}
                    value={this.state.firstName}
                    />
                </div>
                <div className='col-sm-12 col-md-6'>
                    <label>Surname: </label><br/>
                    <input
                    type="text"
                    name="lastName"
                    onChange={this.onChange}
                    value={this.state.lastName}
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
export default connect(null, { createPerson})(PersonForm);