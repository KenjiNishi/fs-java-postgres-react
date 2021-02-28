import React, { Component } from 'react';
import { connect } from 'react-redux';
import { Link } from 'react-router-dom';

import { fetchPersons, deletePerson } from '../actions/personActions';

const PersonItem = props => (
  <tr>
    <td>{props.person.id}</td>
    <td>{props.person.firstName}</td>
    <td>{props.person.lastName}</td>
    <td>{props.person.eventRoom1? props.person.eventRoom1.name : "Not allocated"}</td>
    <td>{props.person.loungeRoom? props.person.loungeRoom.name : "Not allocated"}</td>
    <td>{props.person.eventRoom2? props.person.eventRoom2.name : "Not allocated"}</td>
    <td>
      <p> <button onClick={() => { 
            props.deletePerson(props.person.id); props.fetchPersons()
          }}>Deletar</button> 
          
          <Link to={"/"+props.person.id} onClick={() => {}}> <button>Detalhes</button></Link> 
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
    return (
      <div className='container'>
        <h3>Produtos registrados:</h3>
        <table className="tabela1">
          <thead>
            <tr>
              <th>Id</th>
              <th>Name</th>
              <th>Surname</th>
              <th>Stage 1</th>
              <th>Coffee Break</th>
              <th>Stage 2</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            { this.personList() }
          </tbody>
        </table>
      </div>
    )
  }
}

const mapStateToProps = state => (
  {
  persons: state.persons.personsList
});

export default connect(mapStateToProps, { fetchPersons, deletePerson})(PersonsList);