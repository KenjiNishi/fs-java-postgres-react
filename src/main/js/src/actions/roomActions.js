import { FETCH_ROOMS,CREATE_ROOM, DELETE_ROOM, EDIT_ROOM, GET_ROOM } from './types';

export const createRoom = roomData => dispatch => {
  fetch('api/room/save', {
    method: 'POST',
    headers: {
      'content-type': 'application/json'
    },
    body: JSON.stringify(roomData)
  })
    .then(() => 
      dispatch({
        type: CREATE_ROOM
      })
    )
    .then(()=>dispatch(fetchRooms()))
};

export const fetchRooms = () => dispatch => {
  fetch('api/room/all' , {method: 'GET'})
    .then(res => res.json())
    .then(rooms =>
      {
        dispatch({
          type: FETCH_ROOMS,
          payload: rooms
        })
      }
    )
};

export const getRoom = (id) => dispatch => {
  fetch('http://localhost:8080/api/room/id/'+id , {
    mode: 'cors',
    method: 'GET',
    headers: {'content-type': 'application/json'}
  })
  .then(res => res.json())
  .then(room =>{
    dispatch({
      type: GET_ROOM,
      payload: room
    })
  })
};

export const editRoom = (id, changes) => dispatch => {
  fetch('api/room/update/'+id, {
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
          type: EDIT_ROOM,
          payload: res
        })
        dispatch(fetchRooms())
      }
    );
};

export const deleteRoom = id => dispatch => {
    fetch('api/room/delete/'+id, {
      method: 'DELETE',
      headers: {
        'content-type': 'application/json'
      }
    })
    .then(res =>
      { 
        dispatch({
          type: DELETE_ROOM
        })
        dispatch(fetchRooms())
      });
  };