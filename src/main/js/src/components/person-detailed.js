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
                <h1>Detailed information on:</h1>
                <h2>{this.props.person.id} - {this.props.person.firstName} {this.props.person.lastName}</h2>
                <br />
                <h3>Room 1: {this.props.person.eventRoom1 ? this.props.person.eventRoom1 : "Not allocated." }</h3>
                <h3>Coffe break: {this.props.person.loungeRoom ? this.props.person.loungeRoom : "Not allocated." }</h3>
                <h3>Room 1: {this.props.person.eventRoom2 ? this.props.person.eventRoom2 : "Not allocated." }</h3>
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