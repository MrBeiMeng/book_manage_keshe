import request from '@/utils/request'

export function recommendBook(nums) {
  return request({
    url: '/book/recommend_book',
    method: 'get',
    params: {nums}
  })
}


export function searchBook(searchForm) {
  return request({
    url: '/book/search_book',
    method: 'get',
    params: {searchForm}
  })
}


