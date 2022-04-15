import axios from 'axios';

export default {
    getClasses () {
        return axios.get('/classes');
    },

    registerForClass (memberId, classId) {
        // console.log("in classService.js", memberId)
        axios.post('/classes/register', {
            
            "memberId": memberId,
            "classId": classId
            
        })
    },
    unregisterForClass(memberId, classId){
        axios.delete('/classes/unregister', {
            //will need to refactor (this) delete class
            data: {
                "memberId": memberId,
                "classId": classId
            }
        })
    },
    getRegisteredClasses(memberId) {
        return axios.get('/classes/registered/'+memberId);
    }
}