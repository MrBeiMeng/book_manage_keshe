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

export function logout(username) {
  return request({
    url: '/auth/get_verify_code',
    method: 'get',
    params: { username }
  })
}

export function getInfo(username) {
  return request({
    url: '/auth/get_verify_code',
    method: 'get',
    params: { username }
  })
}

