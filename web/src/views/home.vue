<script setup>
    import { get, post } from '../utils/request.js'
    import { ref } from 'vue'
    import Login from '../components/Login.vue'
    import 'vue-router'

    const content = ref({})
    const showLogin = ref(false)
    const getContent = async () => {
        const res = await get('/retrieve')
        content.value = res.data
    }
    const close = () => {
        showLogin.value = false
    }
    getContent()
</script>

<template>
    <h1>Blog Display</h1>
    <div class="manager" @click="()=>showLogin=true">
    <img src="../style/manager.svg" class="manager__img"/>
    </div>
    <div class="wrapper">
        <div class="article" v-for="item in content" :key="item">
            <p>{{item.data}}</p>
        </div>
    </div>
    <Login v-if="showLogin" @close="close"/>
</template>

<style lang='scss' scoped>
h1 {
    text-align: center;
    font-size: 3rem;
    margin: 2rem 0;
}
.wrapper {
    display: flex;
    justify-content: center;
    margin: 0 4rem;
    flex-wrap: wrap;
}
.article {
    display: flex;
    width: 100%;
    max-width: 800px;
    padding: 2rem;
    border: 1px solid #ccc;
    border-radius: 5px;
    margin: 10px 2rem;
}
.manager {
    position: absolute;
    top: 1rem;
    right: 1rem;
    &:hover {
        cursor: pointer;
    }
    &__img {
        width: 3rem;
        height: 3rem;
    }
}
</style>