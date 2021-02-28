import React, { Component } from "react";
import { connect } from 'react-redux';

import { getLounge } from '../actions/loungeActions';
import { fetchPersons } from '../actions/personActions';

const GuestItem = props => (
  <p>{props.person.id}: {props.person.firstName} {props.person.lastName} </p>
)

class LoungeDetailed extends Component {
    componentDidMount() {
        this.props.getLounge(this.props.match.params.id);
        this.props.fetchPersons()
    }

    guestList() {
      let filteredGuests = this.props.guests.filter((guest) => {
        if(!guest.loungeRoom){return false}
        return(guest.loungeRoom.name === this.props.lounge.name)
      })
      if (filteredGuests.length > 0){
        return (
          <div>
            {filteredGuests.map(currentperson => {
              return <GuestItem person={currentperson} key={currentperson.id}/>;
            })}
          </div>
        )
      }
      else{
        return(
          <div>
            <p>No guests</p>
          </div>
        )
      }
    }

    render() {
        if(this.props.lounge){return (
          <div className='container'>
            <div>
                <br />
                <h1>Coffe Break Room:</h1>
                <h3>ID: {this.props.lounge.id}</h3>
                <h3>Name: {this.props.lounge.name}</h3>
                <br />
                <h4>Guests: {this.props.lounge.currentOccupation}</h4>
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
  lounge: state.lounges.selectedLounge,
  guests: state.persons.personsList
});

export default connect(mapStateToProps, { getLounge, fetchPersons })(LoungeDetailed);