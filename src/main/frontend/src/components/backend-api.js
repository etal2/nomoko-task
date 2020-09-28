import axios from 'axios'

const AXIOS = axios.create({
  baseURL: `/api`,
  timeout: 1000
});


export default {
    getPropertyValue(lat, lon) {
        //return AXIOS.post(`/property/value`);
        return AXIOS.post(`/property/value`, { lat: parseFloat(lat), lon: parseFloat(lon) });
    },
    /*getUser(userId) {
        return AXIOS.get(`/user/` + userId);
    },
    createUser(firstName, lastName) {
        return AXIOS.post(`/user/` + firstName + '/' + lastName);
    },
    getSecured(user, password) {
        return AXIOS.get(`/secured/`,{
            auth: {
                username: user,
                password: password
            }});
    }*/
}


