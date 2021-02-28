import React, { Component } from 'react';
import { connect } from 'react-redux';

import { createLounge } from '../actions/loungeActions';

class LoungeForm extends Component {
  constructor(props) {
    super(props);
    this.state = {
      name: ' '
    };

    this.onChange = this.onChange.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
  }

  onChange(e) {
    this.setState({ [e.target.name]: e.target.value });
  }

  onSubmit(e) {
    e.preventDefault();

    const lounge = {
      name: this.state.name
    };

    this.props.createLounge(lounge);
    this.setState({name: ''})
  }

  render() {
    return (
      <div className='container'>
        <h3>Register new Coffee Break Space:</h3>
        <form action='' onSubmit={this.onSubmit} id="loungeForm">
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
          </div>
          <br/>
          <button type="submit">Register</button>
        </form>
      </div>
    );
  }
}
export default connect(null, { createLounge})(LoungeForm);