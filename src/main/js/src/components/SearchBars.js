import React, { Component } from 'react';
import { connect } from 'react-redux';
import { Link } from 'react-router-dom';

class SearchBar extends Component {
    constructor(props) {
        super(props);
        this.state = {
          personId: '',
          roomId: '',
          loungeId: ''
        };
    
        this.onChange = this.onChange.bind(this);
      }
    
      onChange(e) {
        this.setState({ [e.target.name]: e.target.value });
      }

    render() {
        return (
            <div className='container'>
                <div className="row">
                    <div className="col-sm-12 col-md-4">
                        <form className="form-inline">
                            <input
                            className="mx-auto"
                            type="search"
                            name="personId"
                            onChange={this.onChange}
                            value={this.state.personId}
                            />

                            <Link
                                to={"/detailPerson/"+this.state.personId}
                                className="btn btn-secondary mt-2 mx-auto"
                            >Search Atendee</Link>
                        </form>
                    </div>

                    <div className="col-sm-12 col-md-4">
                        <form className="form-inline ">
                            <input
                            className="mx-auto"
                            type="search"
                            name="loungeId"
                            onChange={this.onChange}
                            value={this.state.loungeId}
                            />
                            <Link to={"/detailLounge/"+this.state.loungeId}
                                className="btn btn-secondary mt-2 mx-auto"
                            >Search Coffee Room</Link>
                        </form>
                    </div>

                    <div className="col-sm-12 col-md-4">
                        <form className="form-inline">
                            <input
                            className="mx-auto"
                            type="search"
                            name="roomId"
                            onChange={this.onChange}
                            value={this.state.roomId}
                            />
                            <Link to={"/detailRoom/"+this.state.roomId}
                                className="btn btn-secondary mt-2 mx-auto"
                            >Search Event Room</Link>
                        </form>
                    </div>
                </div>
            </div>
         );
    }
}
export default connect(null, null)(SearchBar);