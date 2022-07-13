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
    params: searchForm
  })
}

export function getBook(bookId) {
  return request({
    url: '/book/get_one_book',
    method: 'get',
    params: {bookId}
  })
}

export function getByCategoryId(categoryId) {
  return request({
    url: '/book/get_by_category_id',
    method: 'get',
    params: {categoryId}
  })
}


export function getAllBook() {
  return request({
    url: '/book/get_all_book',
    method: 'get',
  })
}

export function saveOrUpdate(book) {
  return request({
    url: '/book/save_or_update_book',
    method: 'post',
    data:book
  })
}
