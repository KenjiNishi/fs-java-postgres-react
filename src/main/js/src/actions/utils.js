import { ORGANIZED_EVENT, ORGANIZING_EVENT } from './types';

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
        console.log('updated?')
    })
};