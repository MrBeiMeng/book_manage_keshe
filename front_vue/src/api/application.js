import request from '@/utils/request'

export function addApplication(application) {
  return request({
    url: '/application/add_application',
    method: 'post',
    data:application
  })
}

export function getAllApplication() {
  return request({
    url: '/application/get_all_application',
    method: 'get',
  })
}

export function saveOrUpdateApplication(application) {
  return request({
    url: '/application/save_or_update_application',
    method: 'post',
    data:application
  })
}

export function deleteApplication(ids) {
  return request({
    url: '/application/delete_these_applications',
    method: 'post',
    data: ids
  })
}
