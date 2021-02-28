import React, { Component } from "react";
import ReactDOM from "react-dom";
import { Provider } from 'react-redux';
import {BrowserRouter as Router, Route} from 'react-router-dom';
import Dashboard from "./components/Dashboard";
import Navbar from "./components/Navbar";

import store from './store';

export class App extends Component {
    render() {
        return (
            <Provider store={store}>
                <Router>
                    <div>
                        <Navbar/>
                        <Route path="/" exact component={Dashboard} />
                    </div>
                </Router>
            </Provider>
        );
    }
}
export default App;
ReactDOM.render(<App />, document.querySelector("#app"));