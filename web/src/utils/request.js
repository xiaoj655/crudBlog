import axios from 'axios'

const instance = axios.create({
    baseURL: 'http://localhost:3939',
    timeout: 10000,
})

export const post = (url, data) => {
    return new Promise((resolve, reject) => {
        instance.post(url,data,{
            headers: {
                'Content-type': 'application/json'
            }
        }).then((res) => {
            resolve(res.data)
        }, err => {
            reject(err)
        })
    })
}

export const get = (url, params={})=>{
    return new Promise((resolve,reject)=>{
        instance.get(url, {
            params
        }).then((res)=>{
            resolve(res)
            ,err=>{
                reject(err)
            }
        })
    })
}