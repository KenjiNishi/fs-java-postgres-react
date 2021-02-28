import React, { Component } from 'react';


import PersonForm from './person-create-form';
import PersonsList from './person-list-all';
import LoungeForm from './lounge-create-form';
import RoomForm from './room-create-form';
export default class Dashboard extends Component {
  render() {
    return (
        <div>
            <PersonForm/>
            <br/>
            <LoungeForm/>
            <br/>
            <RoomForm/>
            <br/>

            <PersonsList/>
        </div>
    );
  }
}