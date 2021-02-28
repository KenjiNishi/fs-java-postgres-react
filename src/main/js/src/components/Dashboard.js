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
        <div className='container-fluid'>
          <div className='row mt-3'>
            <Organizer/>
          </div>
          <div className='row mt-2'>
            <SearchBars/>
          </div>

          <div className='row mt-4'>
            <RoomForm/>
          </div>

          <div className='row mt-3'>
            <RoomList/>
          </div>

          <div className='row mt-4'>
            <LoungeForm/>
          </div>
          <div className='row mt-2'>
            <LoungeList/>
          </div>

          <div className='row mt-4'>
            <PersonForm/>
          </div>

          <div className='row mt-2'>
            <PersonsList/>
          </div>
        </div>
    );
  }
}