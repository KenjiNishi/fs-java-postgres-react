import { FETCH_LOUNGES, CREATE_LOUNGE, DELETE_LOUNGE, EDIT_LOUNGE, GET_LOUNGE } from '../actions/types';

const initialState = {
  loungesList: [],
  selectedLounge: {}
};

export default function(state = initialState, action) {
  switch (action.type) {
    case FETCH_LOUNGES:
      return {
        ...state,
        loungesList: action.payload
      };
    
    case GET_LOUNGE:
      return {
        ...state,
        selectedLounge: action.payload
      };

    case CREATE_LOUNGE:
    case DELETE_LOUNGE:
    case EDIT_LOUNGE:
    default:
      return state;
  }
}