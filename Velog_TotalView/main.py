import json

# series에서 id만 추출
'''
velog 내 series에서 id만 호출
  메인 화면에서는 최대 100개 호출 가능한데 100개 이상의 글이 존재, series는 제한 없이 모두 표시되었기에 series에서 진행
'''
post_id = []

# 사이트에서 series 방문해 응답으로 오는 json file 따로 저장
def addPostId(file, post_id):
  with open('./' + file + '.json', 'r') as f:
      json_data = json.load(f)

  for i in json_data['data']['series']['series_posts']:
      post_id.append(i['post']['id'])

# series별로 post id 저장
addPostId('ai', post_id)
addPostId('algorithm', post_id)
addPostId('back', post_id)
addPostId('cs', post_id)
addPostId('front', post_id)
addPostId('pj', post_id)


'''
# post id로 조회수 request
# ref : https://velog.io/@hamham/내-velog-총-조회수-확인하기#1-조회수-데이터를-받아오는-api-확인하기
# 위에 python 코드의 결과 리스트를 postIdArray에 넣고 브라우저 콘솔에서 진행

const postIdArray = []

const fetchPromises = postIdArray.map(postId => {
  const requestBody = {
    operationName: "GetStats",
    variables: {
      post_id: postId
    },
    query: "query GetStats($post_id: ID!) {\n  getStats(post_id: $post_id) {\n    total\n    count_by_day {\n      count\n      day\n      __typename\n    }\n    __typename\n  }\n}\n"
  };

  return fetch("https://v2cdn.velog.io/graphql", {
    headers: {
      accept: "*/*",
      "accept-language": "en-US,en;q=0.9,ko;q=0.8",
      "content-type": "application/json",
      "sec-ch-ua": "\"Not.A/Brand\";v=\"8\", \"Chromium\";v=\"114\", \"Google Chrome\";v=\"114\"",
      "sec-ch-ua-mobile": "?0",
      "sec-ch-ua-platform": "\"Windows\"",
      "sec-fetch-dest": "empty",
      "sec-fetch-mode": "cors",
      "sec-fetch-site": "same-site"
    },
    referrer: "https://velog.io/",
    referrerPolicy: "strict-origin-when-cross-origin",
    body: JSON.stringify(requestBody),
    method: "POST",
    mode: "cors",
    credentials: "include"
  })
  .then(response => response.json())
  .then(json => json.data.getStats.total);
});

Promise.all(fetchPromises)
  .then(results => {
    console.log(results)
    const totalSum = results.reduce((acc, val) => acc + val, 0);
    console.log("Total sum:", totalSum);
  });

'''