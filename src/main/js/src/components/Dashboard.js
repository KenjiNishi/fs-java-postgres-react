import React, { Component } from 'react';

import PersonForm from './person-create-form';
import PersonsList from './person-list-all';
import LoungeForm from './lounge-create-form';
import RoomForm from './room-create-form';
import LoungeList from './lounge-list-all';
import RoomList from './room-list-all';
import Organizer from './Organizer';
import SearchBars from './SearchBars';

export default class Dashboard extends Component {
  render() {
    return (
        <div>
            <br/>
            <Organizer/>
            <br/>
            <SearchBars/>
            <br/>
            <PersonForm/>
            <PersonsList/>
            <br/>
            <LoungeForm/>
            <LoungeList/>
            <br/>
            <RoomForm/>
            <RoomList/>
            <br/>
        </div>
    );
  }
}