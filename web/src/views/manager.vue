<script setup>
    import { get,post } from '../utils/request.js'
    import { ref } from 'vue'
    import router from '../router'
    import axios from 'axios'
    import '../style/iconfont.css'
    import ReviseBox from '../components/ReviseBox.vue'
    import AddBox from '../components/AddBox.vue'

    const content = ref({})
    const showEditBox = ref(false)
    const text = ref('')
    const updateId = ref(0)
    const data = ref('')
    const showAddBox = ref(false)
    const getContent = async () => {
        const res = await get('/retrieve')
        content.value = res.data
    }
    getContent()
    const quit = () => {
        router.push('/')
    }
    const handleClick = (event) => {
        if(event.target.classList[0] == 'article__tools--delete')
        {    const deleteId = event.target.parentNode.parentNode.id
            // console.log(event.target.parentNode.parentNode.id)
            axios.post('http://localhost:3939/delete',deleteId,{
                headers: {
                    "Content-Type": "application/json"
                }
            })
            router.go(0)
        } else if (event.target.classList[0] == 'article__tools--update') {
            showEditBox.value=true
            updateId.value = event.target.parentNode.parentNode.id
            text.value = content.value[updateId.value].data
        }
    }
    const update = () => {
        post(`/update/${updateId.value}`,{
            'data':text.value
        })
        router.go(0)
        showEditBox=false
    }
    const add = () => {
        post('/create', {
            'data':data.value
        })
        router.go(0)
        showEditBox=false
    }
</script>

<template>
     <AddBox v-if="showAddBox"
        v-model="data"
        @update:modelValue(v)="()=> data=v"
        @closeAddBox="()=>showAddBox=false"
        @add="add"
        />
    <ReviseBox v-if="showEditBox"
        @close="()=>showEditBox=false"
        v-model="text"
        @update:modelValue(v)="()=> text=v"
        @update="update"
        />
    <h1>Blog Manager</h1>
    <div class="add"
    @click="()=>showAddBox=true"
    ><span class="iconfont">&#xe658; </span>Post new article</div>
    <div class="manager iconfont" @click="quit">
        &#xe609;
    </div>
    <div class="wrapper" @click="handleClick($event)">
        <div class="article" v-for="item in content" :key="item" :id="item.id">
            <p style="overflow: hidden;">{{item.data}}</p>
            <div class="article__tools">
                <div class="article__tools--update iconfont" >&#xe60b;</div>
                <div class="article__tools--delete iconfont">&#xe69d;</div>
            </div>
        </div>
    </div>
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
    position: relative;
    width: 100%;
    max-width: 800px;
    padding: 2rem;
    border: 1px solid #ccc;
    border-radius: 5px;
    margin: 10px 2rem;
    &__tools {
        position: absolute;
        bottom: 10px;
        right: 10px;
        display: flex;
        &--delete {
            margin-left: 10px;
            color: red;
            &:hover{
                cursor: pointer;
            }
        }
        &--update {
            margin-right: 10px;
            color:blue;
            &:hover{
                cursor: pointer;
            }
        }
    }
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
.add {
    font-size: 20px;
    font-family: Inter, system-ui, Avenir, Helvetica, Arial, sans-serif;
    line-height: 1.5;
    font-weight: 400;
    font-synthesis: none;
    text-rendering: optimizeLegibility;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    -webkit-text-size-adjust: 100%;
    width: 170px;
    margin: 0 auto;
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