import { FETCH_PERSONS,CREATE_PERSON, DELETE_PERSON, EDIT_PERSON, GET_PERSON } from './types';

export const createPerson = personData => dispatch => {
  fetch('api/person/save', {
    method: 'POST',
    headers: {
      'content-type': 'application/json'
    },
    body: JSON.stringify(personData)
  })
    .then(res => res.json())
    .then(person =>
      dispatch({
        type: CREATE_PERSON,
        payload: person.DATA
      })
    );
};

export const fetchPersons = () => dispatch => {
  fetch('api/person/id/all' , {
    method: 'GET'})
    .then(res => res.json())
    .then(persons =>
      dispatch({
        type: FETCH_PERSONS,
        payload: persons.DATA
      })
    )
};

export const getPerson = (id) => dispatch => {
  fetch('api/person/id/'+id , {
    method: 'GET'})
    .then(res => res.json())
    .then(person =>
      dispatch({
        type: GET_PERSON,
        payload: person.DATA
      })
    )
};

export const editPerson = (id, changes) => dispatch => {
  fetch('api/person/update/'+id, {
    method: 'PUT',
    headers: {
      'content-type': 'application/json'
    },
    body : JSON.stringify(changes)
  })
    .then(res => res.json())
    .then(res =>
      dispatch({
        type: EDIT_PERSON,
        payload: res
      })
    );
};

export const deletePerson = id => dispatch => {
    fetch('api/person/delete/'+id, {
      method: 'DELETE',
      headers: {
        'content-type': 'application/json'
      }
    })
      .then(res => res.json())
      .then(res =>
        dispatch({
          type: DELETE_PERSON,
          payload: res
        })
      );
  };