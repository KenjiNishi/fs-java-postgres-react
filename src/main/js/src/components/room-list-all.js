import React, { Component } from 'react';
import { connect } from 'react-redux';
import { Link } from 'react-router-dom';

import { fetchRooms, deleteRoom } from '../actions/roomActions';

const RoomItem = props => (
  <tr>
    <td scope="row">{props.room.id}</td>
    <td>{props.room.name}</td>
    <td>{props.room.capacity}</td>
    <td>{props.room.currentOccupation1}</td>
    <td>{props.room.currentOccupation2}</td>
    <td>
      <p> <button onClick={() => { 
            props.deleteRoom(props.room.id)
          }}>Delete</button> 
          
          <Link to={"/detailRoom/"+props.room.id} onClick={() => {}}> <button>Details</button></Link> 
      </p>
    </td>
  </tr>
)

class RoomsList extends Component {
  constructor(props) {
    super(props);
    this.state = {
    }
  }

  componentDidMount() {
    this.props.fetchRooms();
  }


  roomList() {
    return this.props.rooms.map(currentroom => {
      return <RoomItem room={currentroom} deleteRoom={this.props.deleteRoom} fetchRooms={this.props.fetchRooms} key={currentroom.id}/>;
    })
  }

  render() {
    if(this.props.rooms.length>0){
    return (
      <div className='container'>
        <div className='row'>
          <div className='col-sm-12'>
            <br/>
            <h3>Event Rooms :</h3>
            <table className="table">
              <thead className="thead-dark">
                <tr >
                  <th scope="col-2">Id</th>
                  <th scope="col-4">Name</th>
                  <th scope="col-2">Capacity</th>
                  <th scope="col-1">Stage 1 Guests</th>
                  <th scope="col-1">Stage 2 Guests</th>
                  <th scope="col-2">Actions</th>
                </tr>
              </thead>
              <tbody>
                { this.roomList() }
              </tbody>
            </table>
          </div>
        </div>
      </div>
    )}
    else{
        return(<div className='container'><h2>The room list is empty.</h2></div>)
    }
  }
}

const mapStateToProps = state => (
  {
  rooms: state.rooms.roomsList
});

export default connect(mapStateToProps, { fetchRooms, deleteRoom})(RoomsList);