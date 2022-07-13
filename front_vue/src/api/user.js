import request from '@/utils/request'

export function getAllUser() {
  return request({
    url: '/user/get_all_user',
    method: 'get',
  })
}

export function saveOrUpdateUser(user) {
  return request({
    url: '/user/save_or_update_user',
    method: 'post',
    data:user
  })
}

export function deleteUser(ids) {
  return request({
    url: '/user/delete_user_by_id',
    method: 'post',
    data: ids
  })
}
