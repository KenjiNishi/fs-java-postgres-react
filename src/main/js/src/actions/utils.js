import { ORGANIZED_EVENT, ORGANIZING_EVENT, CLEAR_LOUNGE, CLEAR_PERSON, CLEAR_ROOM } from './types';

import { fetchRooms} from './roomActions';
import { fetchLounges} from './loungeActions';
import { fetchPersons} from './personActions';

export const OrganizeEvent = () => dispatch => {
    dispatch({
        type: ORGANIZING_EVENT
    })
    fetch('/api/actions/organizeAtendees', {
        method: 'GET'
    })
    .then(() => 
        dispatch({
            type: ORGANIZED_EVENT
        })
    )
    .then(()=>{
        dispatch(fetchRooms())
        dispatch(fetchPersons())
        dispatch(fetchLounges())
    })
};

export const ClearSearches = () => dispatch => {
    dispatch({type: CLEAR_LOUNGE})
    dispatch({type: CLEAR_PERSON})
    dispatch({type: CLEAR_ROOM})
};