import axios from 'axios';

export default {
    getClasses () {
        return axios.get('/classes');
    },

    registerForClass (memberId, classId) {
        return axios.post('/classes/register', {
            "memberId": memberId,
            "classId": classId
        })
    },
    unregisterForClass(memberId, classId){
        return axios.delete('/classes/unregister', {
            "memberId": memberId,
            "classId": classId
        })
    }
}