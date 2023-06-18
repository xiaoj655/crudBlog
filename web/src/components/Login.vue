<script setup>
    import { inject, ref } from 'vue'
    import { useRouter } from 'vue-router'
    import '../style/iconfont.css'
    import router from '../router/index.js'

    const username = ref('')
    const password = ref('')
    const login = () => {
        if(username.value.trim() !== '' && password.value.trim() !== '') {
            // const router = inject('router')
            console.log(router)
            router.push('/manager')
        } else {
            alert('用户名或密码错误')
        }
    }
</script>
<template>
    <div class="login">
        <div class="login-wrapper">
            <div class="login-title">管理员登录</div>
            <span class="iconfont close" @click="()=>this.$emit('close')">&#xe7fc;</span>
            <div class="login-input">
                <input type="text" placeholder="请输入用户名" v-model="username" />
                <input type="password" placeholder="请输入密码" v-model="password" />
            </div>
            <div class="login-btn" @click="login">登录</div>
        </div>
    </div>
</template>

<style lang="scss" scoped>
.login {
    width: 350px;
    height: 300px;
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    // background-color: #f5f5f5;
    display: flex;
    justify-content: center;
    align-items: center;
}
.login-wrapper {
    width: 100%;
    // height: 400px;
    background-color: #fff;
    border-radius: 5px;
    box-shadow: 0 0 10px #ccc;
    padding: 20px;
}
.login-title {
    font-size: 2rem;
    text-align: center;
    margin-bottom: 20px;
}
.login-input {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    input {
        box-sizing: border-box;
        width: 300px;
        height: 40px;
        border: 1px solid #ccc;
        border-radius: 5px;
        margin-bottom: 20px;
        padding: 0 10px;
        &:focus {
            outline: none;
        }
    }
}
.login-btn {
    width: 300px;
    height: 40px;
    background-color: #409eff;
    color: #fff;
    text-align: center;
    line-height: 40px;
    border-radius: 5px;
    &:hover {
        cursor: pointer;
    }
}
.close {
    position: absolute;
    top: 20px;
    right: 10px;
    font-size: 1.5rem;
    &:hover {
        cursor: pointer;
    }
}
.iconfont{
font-family:"iconfont" !important;
font-size:16px;font-style:normal;
-webkit-font-smoothing: antialiased;
-webkit-text-stroke-width: 0.2px;
-moz-osx-font-smoothing: grayscale;}
</style>