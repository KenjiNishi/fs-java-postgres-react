import { combineReducers } from 'redux';
import personReducer from './personReducers';
import roomReducer from './roomReducers';
import loungeReducer from './loungeReducers';
import utilsReducer from './utils'

export default combineReducers({
  persons: personReducer, //state.persons.VAR  eg VAR=personList
  lounges: loungeReducer,
  rooms: roomReducer,
  utils: utilsReducer
});
