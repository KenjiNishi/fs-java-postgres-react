import { FETCH_LOUNGES,CREATE_LOUNGE, DELETE_LOUNGE, EDIT_LOUNGE, GET_LOUNGE } from './types';

export const createLounge = loungeData => dispatch => {
  fetch('api/lounge/save', {
    method: 'POST',
    headers: {
      'content-type': 'application/json'
    },
    body: JSON.stringify(loungeData)
  })
    .then(() => 
      dispatch({
        type: CREATE_LOUNGE
      })
    )
    .then(()=>dispatch(fetchLounges()))
};

export const fetchLounges = () => dispatch => {
  fetch('api/lounge/all' , {method: 'GET'})
    .then(res => res.json())
    .then(lounges =>
      {
        dispatch({
          type: FETCH_LOUNGES,
          payload: lounges
        })
      }
    )
};

export const getLounge = (id) => dispatch => {
  fetch('http://localhost:8080/api/lounge/id/'+id , {
    mode: 'cors',
    method: 'GET',
    headers: {'content-type': 'application/json'}
  })
  .then(res => res.json())
  .then(lounge =>{
    dispatch({
      type: GET_LOUNGE,
      payload: lounge
    })
  })
};

export const editLounge = (id, changes) => dispatch => {
  fetch('api/lounge/update/'+id, {
    method: 'PUT',
    headers: {
      'content-type': 'application/json'
    },
    body : JSON.stringify(changes)
  })
    .then(res => res.json())
    .then(res =>
      {
        dispatch({
          type: EDIT_LOUNGE,
          payload: res
        })
        dispatch(fetchLounges())
      }
    );
};

export const deleteLounge = id => dispatch => {
    fetch('api/lounge/delete/'+id, {
      method: 'DELETE',
      headers: {
        'content-type': 'application/json'
      }
    })
    .then(res =>
      { 
        dispatch({
          type: DELETE_LOUNGE
        })
        dispatch(fetchLounges())
      });
  };