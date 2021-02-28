import React, { Component } from "react";
import { connect } from 'react-redux';

import { getPerson } from '../actions/personActions';

class PersonDetailed extends Component {
    componentDidMount() {
        this.props.getPerson(this.props.match.params.id)
    }
    render() {
        if(this.props.person){return (
          <div className='container'>
            <div>
                <br />
                <h1>Registered to attend:</h1>
                <h3>ID: {this.props.person.id}</h3>
                <h3>Name: {this.props.person.firstName} {this.props.person.lastName}</h3>
                <br />
                <h4>Room 1: {this.props.person.eventRoom1 ? this.props.person.eventRoom1.name : "Not allocated." }</h4>
                <h4>Coffe breaks: {this.props.person.loungeRoom ? this.props.person.loungeRoom.name : "Not allocated." }</h4>
                <h4>Room 2: {this.props.person.eventRoom2 ? this.props.person.eventRoom2.name : "Not allocated." }</h4>
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
  person: state.persons.selectedPerson
});

export default connect(mapStateToProps, { getPerson })(PersonDetailed);