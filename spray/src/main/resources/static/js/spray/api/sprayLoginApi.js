const userInfo = {
    name: '',
    det: '',
    addr: '',
    tel: ''
}

const apiInitInfo = [
  { 'methodType': 'checkUser',
    'title': '회원가입 여부 확인 API',
    'type': 'GET',
    'msg': '이미 회원가입된 번호 입니다.'
  },
  { 'methodType': 'joinUser',
      'title': '회원가입 API',
      'type': 'POST',
      'msg': '회원가입에 성공했습니다. 로그인 화면으로 이동합니다.'
   }
];


const init = {
    apiUrl: 'http://localhost:8080/',
    title: '',
    type: '',
    msg: '',
    CSRFToken: '',
    checkUser: () => {
       return new Promise((resolve) => {
        fetch(init.apiUrl + 'user/' + userInfo.tel, {
                method: init.type,
                headers: {
                'contentType': 'application/json'
                }
                })
              .then(res => resolve(res.json()))
          })
    },
    join: () => {
      return new Promise((resolve) => {
        fetch(init.apiUrl + 'user', {
             method: init.type,
             credentials: 'include',
             headers: {
             'Content-Type': 'application/json',
             'X-CSRF-TOKEN': init.CSRFToken
             },
             body: JSON.stringify(userInfo)
             })
           .then(res => resolve(res.json()))
       })
    }
}


