import { combineReducers } from 'redux';
import personReducer from './personReducers';

export default combineReducers({
  persons: personReducer, //state.persons.VAR  eg VAR=personList
});
