import request from '@/utils/request'

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
    url: '/application/delete_application_by_id',
    method: 'post',
    data: ids
  })
}
