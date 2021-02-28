import React, { Component } from 'react';
import { connect } from 'react-redux';
import { Link } from 'react-router-dom';

import { fetchPersons, deletePerson } from '../actions/personActions';

const PersonItem = props => (
  <tr>
    <td scope="row">{props.person.id}</td>
    <td>{props.person.firstName}</td>
    <td>{props.person.lastName}</td>
    <td>
      <p> <button onClick={() => { 
            props.deletePerson(props.person.id)
          }}>Delete</button> 
          
          <Link to={"/detailPerson/"+props.person.id} onClick={() => {}}> <button>Details</button></Link> 
      </p>
    </td>
  </tr>
)

class PersonsList extends Component {
  constructor(props) {
    super(props);
    this.state = {
    }
  }

  componentDidMount() {
    this.props.fetchPersons();
  }


  personList() {
    return this.props.persons.map(currentperson => {
      return <PersonItem person={currentperson} deletePerson={this.props.deletePerson} fetchPersons={this.props.fetchPersons} key={currentperson.id}/>;
    })
  }

  render() {
    if(this.props.persons.length>0){
    return (
      <div className='container'>
        <div className='row'>
          <div className='col-sm-12'>
            <br/>
            <h3>Registered to attend :</h3>
            <table className="table">
              <thead className="thead-dark">
                <tr >
                  <th scope="col-2">Id</th>
                  <th scope="col-4">Name</th>
                  <th scope="col-4">Surname</th>
                  <th scope="col-2">Actions</th>
                </tr>
              </thead>
              <tbody>
                { this.personList() }
              </tbody>
            </table>
          </div>
        </div>
      </div>
    )}
    else{
        return(<div className='container'><h2>The person list is empty.</h2></div>)
    }
  }
}

const mapStateToProps = state => (
  {
  persons: state.persons.personsList
});

export default connect(mapStateToProps, { fetchPersons, deletePerson})(PersonsList);