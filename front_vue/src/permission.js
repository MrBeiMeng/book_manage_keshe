import router from './router'
import store from './store'
import { Message } from 'element-ui'
import NProgress from 'nprogress' // progress bar
import 'nprogress/nprogress.css' // progress bar style
import { getToken } from '@/utils/auth' // get token from cookie


NProgress.configure({ showSpinner: false }) // NProgress Configuration

const whiteList = [ // 地址白名单
  '/login',
  '/',
  '/register',
  '/books',
  '/searches',
  '/book_detail'
] // no redirect whitelist

router.beforeEach(async(to, from, next) => {
  // start progress bar
  NProgress.start()

  // set page title
  document.title = "读书 - 图书"

  // determine whether the users has logged in
  const hasToken = getToken()
  // alert("有token")

  if (hasToken) {
    if (to.path === '/login') {
      // if is logged in, redirect to the home page
      next({ path: '/' })
      NProgress.done()
    } else {
      // determine whether the users has obtained his permission roles through getInfo
      const hasRoles = store.getters.roles && store.getters.roles.length > 0
      if (hasRoles) {
        next()
      } else {
        try {
          // 如果没有roles  没有角色，就代表还没有登录// 我们就调用getInfo 来拿到登录信息
          const { roles } = await store.dispatch('user/getInfo')
          console.log(roles)

          next({ ...to, replace: true })
        } catch (error) {
          // remove token and go to login page to re-login
          await store.dispatch('user/resetToken')
          Message.error(error || 'Has Error')
          next(`/login?redirect=${to.path}`)
          NProgress.done()
        }
      }
    }
  } else {
    /* has no token*/
    if (whiteList.indexOf(to.path) !== -1 || to.path.indexOf(whiteList[3]) !== -1 || to.path.indexOf(whiteList[5]) !== -1) {
      // in the free login whitelist, go directly
      next()
    } else {
      // other pages that do not have permission to access are redirected to the login page.
      next(`/login?redirect=${to.path}`)
      NProgress.done()
    }
  }
})

router.afterEach(() => {
  // finish progress bar
  NProgress.done()
})
