import React, { Component } from "react";
import ReactDOM from "react-dom";
import { Provider } from 'react-redux';
import {BrowserRouter as Router, Route} from 'react-router-dom';

import store from './store';

export class App extends Component {
    render() {
        return (
            <Provider store={store}>
                <Router>
                    <div>
                        <div>
                            <h1>We Did It</h1>
                        </div>
                        {/* <Route path="/" exact component={} /> */}
                    </div>
                </Router>
            </Provider>
        );
    }
}
export default App;
ReactDOM.render(<App />, document.querySelector("#app"));