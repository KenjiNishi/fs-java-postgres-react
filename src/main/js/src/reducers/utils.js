import { ORGANIZED_EVENT, ORGANIZING_EVENT} from '../actions/types';

const initialState = {
  loading : false
};

export default function(state = initialState, action) {
  switch (action.type) {
    case ORGANIZED_EVENT:
      return {
        ...state,
        loading: false
      };
    
    case ORGANIZING_EVENT:
      return {
        ...state,
        loading: true
      };

    default:
      return state;
  }
}