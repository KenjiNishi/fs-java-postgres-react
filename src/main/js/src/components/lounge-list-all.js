import React, { Component } from 'react';
import { connect } from 'react-redux';
import { Link } from 'react-router-dom';

import { fetchLounges, deleteLounge } from '../actions/loungeActions';
import { deletePerson } from '../actions/personActions';

const LoungeItem = props => (
  <tr>
    <td scope="row">{props.lounge.id}</td>
    <td>{props.lounge.name}</td>
    <td>{props.lounge.currentOccupation}</td>
    <td>
      <p> <button className="btn btn-danger" onClick={() => { 
            props.filteredGuests.map((at) => {
              props.deletePerson(at.id)
            })
            console.log(props.filteredGuests)
            setTimeout(() => { props.deleteLounge(props.lounge.id) }, 1000);
          }}>Delete</button> 
          
          <Link to={"/detailLounge/"+props.lounge.id} onClick={() => {}}> <button className="btn btn-info">Details</button></Link> 
      </p>
    </td>
  </tr>
)

class LoungesList extends Component {
  constructor(props) {
    super(props);
    this.state = {
    }
  }

  componentDidMount() {
    this.props.fetchLounges();
  }


  loungeList() {
    return this.props.lounges.map(currentlounge => {
      let filteredGuests = this.props.guests.filter((guest) => {
        if(!guest.loungeRoom){return false}
        return((guest.loungeRoom.name === currentlounge.name))
      })

      return <LoungeItem 
                lounge={currentlounge} 
                deleteLounge={this.props.deleteLounge} 
                deletePerson={this.props.deletePerson}
                filteredGuests={filteredGuests}
                key={currentlounge.id}
              />;
    })
  }

  render() {
    if(this.props.lounges.length>0){
    return (
      <div className='container'>
        <div className='row'>
          <div className='col-sm-12'>
            <br/>
            <h3>Coffee Break Rooms :</h3>
            <table className="table">
              <thead className="thead-dark">
                <tr >
                  <th scope="col-2">Id</th>
                  <th scope="col-4">Name</th>
                  <th scope="col-4">Atendees</th>
                  <th scope="col-2">Actions</th>
                </tr>
              </thead>
              <tbody>
                { this.loungeList() }
              </tbody>
            </table>
          </div>
        </div>
      </div>
    )}
    else{
        return(<div className='container'><h2>The lounge list is empty.</h2></div>)
    }
  }
}

const mapStateToProps = state => (
  {
  lounges: state.lounges.loungesList,
  guests: state.persons.personsList
});

export default connect(mapStateToProps, { fetchLounges, deleteLounge, deletePerson})(LoungesList);