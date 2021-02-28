import React, { Component } from 'react';
import { connect } from 'react-redux';

import { OrganizeEvent } from '../actions/utils';

class Organizer extends Component {
  constructor(props) {
    super(props);
    this.state = {
      
    };

    this.onClick = this.onClick.bind(this);
  }

  onClick(){
    this.props.OrganizeEvent();
  }

  render() {
      if (this.props.loading){
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
    loading: state.utils.loading
  });

export default connect(mapStateToProps, { OrganizeEvent })(Organizer);