import { createRouter, createWebHashHistory } from 'vue-router'

const routes = [
    {
        path: '/',
        name: 'Home',
        component: () => import(/* webpackChunkNameL "home_123" */ '../views/home.vue')
    },
    {
        path: '/manager',
        name: 'Manager',
        component: () => import(/* webpackChunkNameL "home_123" */ '../views/manager.vue')
    }
]

const router = createRouter({
    history: createWebHashHistory(),
    routes
  })

export default router