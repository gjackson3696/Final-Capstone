import axios from "axios";

export default {

    getMember() {
        return axios.get('/member');
    },

    create(member) {
        return axios.post('/member',{
            "firstName": member.firstName,
            "lastName": member.lastName,
            "email": member.email
        });
    },

    update(member) {
        return axios.put('/member',{
            "firstName": member.firstName,
            "lastName": member.lastName,
            "email": member.email
        });
    }

}