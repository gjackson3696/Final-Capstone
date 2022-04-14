import axios from 'axios';

export default {
    getClasses () {
        return axios.get('/classes',{
            "startDate": "2022-04-24"
        });
    }
}