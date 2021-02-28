import React, { Component } from 'react';

import PersonForm from './person-create-form';
import PersonsList from './person-list-all';
export default class Dashboard extends Component {
  render() {
    return (
        <div>
            <h1>We Did It</h1>
            <PersonForm/>
            <PersonsList/>
        </div>
    );
  }
}