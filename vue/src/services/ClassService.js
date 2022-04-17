import axios from 'axios';

export default {
    getClasses () {
        return axios.get('/classes');
    },
    registerForClass (classId) {
        axios.post('/classes/register/'+classId)
    },
    unregisterForClass(classId){
        axios.delete('/classes/unregister/'+classId)
    },
    getRegisteredClasses() {
        return axios.get('/classes/registered');
    }
}