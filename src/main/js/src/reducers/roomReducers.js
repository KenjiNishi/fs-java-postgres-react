import { FETCH_ROOMS, CREATE_ROOM, DELETE_ROOM, EDIT_ROOM, GET_ROOM, CLEAR_ROOM } from '../actions/types';

const initialState = {
  roomsList: [],
  selectedRoom: {}
};

export default function(state = initialState, action) {
  switch (action.type) {
    case FETCH_ROOMS:
      return {
        ...state,
        roomsList: action.payload
      };
    
    case GET_ROOM:
      return {
        ...state,
        selectedRoom: action.payload
      };
    
    case CLEAR_ROOM:
      return {
        ...state,
        selectedRoom: null
      };

    case CREATE_ROOM:
    case DELETE_ROOM:
    case EDIT_ROOM:
    default:
      return state;
  }
}