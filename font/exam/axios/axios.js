import axios from 'axios';
import VueCookie from "vue-cookies"

axios.interceptors.request.use(config => {
    config.headers={
      'Authorization': 'Bearer ' + VueCookie.get("token-"+VueCookie.get("cid"))
    }
    return config;
}, err => {
    Toast('请求超时');
    return Promise.resolve(err);
});

export default axios
