import React, { Component } from 'react';
import { connect } from 'react-redux';

import { OrganizeEvent } from '../actions/utils';

class Organizer extends Component {
  constructor(props) {
    super(props);
    this.state = {
      
    };

    this.onClick = this.onClick.bind(this);
    this.checkLockConditions = this.checkLockConditions.bind(this);
  }

  onClick(){
    this.props.OrganizeEvent();
  }

  checkLockConditions(){
    if( this.props.persons.length > 0 &&
        this.props.rooms.length > 0 &&
        this.props.lounges.length > 0)
      return false
    else return true;
  }

  render() {
      if (this.checkLockConditions() || this.props.loading){
          return(
            <div className='container'>
                <button 
                    type="button" 
                    className="btn btn-warning btn-lg btn-block" 
                    onClick={this.onClick}
                    disabled
                >Organize Event</button>
            </div>)
      }
    else{
        return (
            <div className='container'>
                <button 
                    type="button"
                    className="btn btn-warning btn-lg btn-block"
                    onClick={this.onClick}
                >Organize Event</button>
            </div>
         );
    }
  }
}

const mapStateToProps = state => (
    {
    loading: state.utils.loading,
    rooms : state.rooms.roomsList,
    persons : state.persons.personsList,
    lounges : state.lounges.loungesList
  });

export default connect(mapStateToProps, { OrganizeEvent })(Organizer);