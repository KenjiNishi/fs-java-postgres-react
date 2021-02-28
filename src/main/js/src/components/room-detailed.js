import React, { Component } from "react";
import { connect } from 'react-redux';

import { getRoom } from '../actions/roomActions';
import { fetchPersons } from '../actions/personActions';

const GuestItem = props => (
  <tr>
    <td scope="row">{props.person.id}</td>
    <td>{props.person.firstName} {props.person.lastName}</td>
  </tr>
)

class RoomDetailed extends Component {
    componentDidMount() {
        this.props.getRoom(this.props.match.params.id);
        this.props.fetchPersons()
    }

    guestList() {
      let filteredGuests1 = this.props.guests.filter((guest) => {
        if(!guest.eventRoom1){return false}
        return((guest.eventRoom1.name === this.props.room.name))
      })
      let filteredGuests2 = this.props.guests.filter((guest) => {
        if(!guest.eventRoom2){return false}
        return((guest.eventRoom2.name === this.props.room.name))
      })

      if (filteredGuests1.length > 0){
        return (
          <div>
            <div>
              <h3>Stage 1 ({filteredGuests1.length}/{this.props.room.capacity})</h3>
              <table className="table">
                <thead className="thead-light">
                  <tr >
                    <th scope="col-2">Id</th>
                    <th scope="col-10">Name</th>
                  </tr>
                </thead>
                <tbody>
                  {filteredGuests1.map(currentperson1 => {
                      return <GuestItem person={currentperson1} key={currentperson1.id}/>;
                  })}
                </tbody>
              </table> 
          </div>
          <div>
            <h3>Stage 2 ({filteredGuests2.length}/{this.props.room.capacity})</h3>
            <table className="table">
              <thead className="thead-light">
                <tr >
                  <th scope="col-2">Id</th>
                  <th scope="col-10">Name</th>
                </tr>
              </thead>
              <tbody>
                {filteredGuests2.map(currentperson2 => {
                    return <GuestItem person={currentperson2} key={currentperson2.id}/>;
                })}
              </tbody>
            </table> 
          </div>
        </div>
        )
      }
      else{
        return(
          <div>
            
          </div>
        )
      }
    }

    render() {
        if(this.props.room){return (
          <div className='container'>
            <div>
                <br />
                <h1>Event Room:</h1>
                <h3>ID: {this.props.room.id}</h3>
                <h3>Name: {this.props.room.name}</h3>
                <br />
                <h4>Atendees:</h4>
                {this.guestList()}
                <br />
            </div>
          </div>
        );}
        else{
            return(<div className='container'><h2>Id not found or not yet loaded...</h2></div>)
        }
    }
}
const mapStateToProps = state => (
  {
  room: state.rooms.selectedRoom,
  guests: state.persons.personsList
});

export default connect(mapStateToProps, { getRoom, fetchPersons })(RoomDetailed);