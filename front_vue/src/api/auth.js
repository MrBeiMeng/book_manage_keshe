import request from '@/utils/request'

export function getVerifyCode(toEmail) {
  return request({
    url: '/auth/get_verify_code',
    method: 'get',
    params: { toEmail }
  })
}

export function login(loginForm) {
  return request({
    url: '/auth/login',
    method: 'post',
    data: loginForm
    // loginForm
  })
}

export function logout() {
  return request({
    url: '/auth/logout',
    method: 'post',
  })
}

export function getInfo() {
  return request({
    url: '/auth/get_info',
    method: 'get',
  })
}

