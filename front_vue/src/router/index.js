import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import LoginView from "@/views/LoginView";
import Register from "@/components/Register";
import RegisterView from "@/views/RegisterView";
import MineView from "@/views/MineView";
import BooksView from "@/views/BooksView";
import SearchesView from "@/views/SearchesView";
import DetailsView from "@/views/DetailsView";
import BookManagesView from "@/views/BookManagesView";
import UserManagesView from "@/views/UserManagesView";
import ApplicationManagesView from "@/views/ApplicationManagesView";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/login',
    name: 'login',
    component: LoginView
  },
  {
    path: '/register',
    name: 'register',
    component: RegisterView
  },
  {
    path: '/me',
    name: 'me',
    component: MineView
  },
  {
    path: '/searches',
    name: 'searches',
    component: SearchesView,
    props:true
  },
  {
    path: '/manage_books',
    name: 'manage_books',
    component: BookManagesView,
  },
  {
    path: '/manage_users',
    name: 'manage_users',
    component: UserManagesView,
  },
  {
    path: '/manage_applications',
    name: 'manage_applications',
    component: ApplicationManagesView,
  },
  {
    path: '/book_detail/:bookId',
    name: 'book_detail',
    component: DetailsView,
    props:true
  },
  {
    path: '/books/:categoryId',
    name: 'books',
    component: BooksView,
    props: true
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
]

const router = new VueRouter({
  routes
})

export default router
