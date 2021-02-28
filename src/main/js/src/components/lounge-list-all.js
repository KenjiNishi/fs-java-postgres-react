import React, { Component } from 'react';
import { connect } from 'react-redux';
import { Link } from 'react-router-dom';

import { fetchLounges, deleteLounge } from '../actions/loungeActions';

const LoungeItem = props => (
  <tr>
    <td scope="row">{props.lounge.id}</td>
    <td>{props.lounge.name}</td>
    <td>{props.lounge.currentOccupation}</td>
    <td>
      <p> <button onClick={() => { 
            props.deleteLounge(props.lounge.id)
          }}>Delete</button> 
          
          <Link to={"/detailLounge/"+props.lounge.id} onClick={() => {}}> <button>Details</button></Link> 
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
      return <LoungeItem lounge={currentlounge} deleteLounge={this.props.deleteLounge} fetchLounges={this.props.fetchLounges} key={currentlounge.id}/>;
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
                  <th scope="col-4">Guests</th>
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
  lounges: state.lounges.loungesList
});

export default connect(mapStateToProps, { fetchLounges, deleteLounge})(LoungesList);