import { combineReducers } from 'redux';
import personReducer from './personReducers';
import roomReducer from './roomReducers';
import loungeReducer from './loungeReducers';

export default combineReducers({
  persons: personReducer, //state.persons.VAR  eg VAR=personList
  lounges: loungeReducer,
  rooms: roomReducer
});
