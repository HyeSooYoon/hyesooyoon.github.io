Vue.component('cosmetic-view', {
    methods: { 
       
       // 게시글 저장
       saveBoard() {
        const contentInfo = {
            title: '',
            writer: '',
            content: '',
            productName: ''
        }
            
        contentInfo.title      = document.querySelector('#title').value;
        contentInfo.writer     = document.querySelector('#name').value;
        contentInfo.content    = document.querySelector('#comments').value;
        contentInfo.productName = document.querySelector('#productName').value;
        let res = false;
 
        if(_.isEmpty(contentInfo.title) || _.isEmpty(contentInfo.writer) || _.isEmpty(contentInfo.content) || _.isEmpty(contentInfo.content))
            res = true;

        if(res)
        {
            Swal.fire({
                      icon: 'info',
                      title: '내용을 입력해주세요.',
                      showConfirmButton: false,
                      timer: 1500
                    })
            return;
        }
 
        const initBbs = {
            apiUrl: 'http://localhost:8080/',
            CSRFToken: '',
            save: () => {
              return new Promise((resolve) => {
                fetch(initBbs.apiUrl + 'save', {
                     method: 'post',
                     credentials: 'include',
                     headers: {
                     'Content-Type': 'application/json',
                     'X-CSRF-TOKEN': initBbs.CSRFToken
                     },
                     body: JSON.stringify(contentInfo)
                     })
                     .then(res => resolve(res.json()))
               })
            }
        }

        initBbs.CSRFToken     = document.querySelector('meta[name="_csrf"]').getAttribute('content');

        initBbs.save().then(function(data) {
              if(data.code!=='0000')
              {
                 Swal.fire({
                  icon: 'info',
                  title: '저장 실패...',
                  footer: '<a href>도움이 필요하나요?</a>',
                  showConfirmButton: false,
                  timer: 1500
                })
              } 
               document.querySelector('#boardFrontMenu').click();
            });
       },
       // 뒤로가기
       back() {
        location.href = '/spray/board/boardFrontMenu';
       }
      },
      data: {
          dummy: 'Ass'

      },
    template: 
    `<div class="container">
     <form id="survey-form">
        <div class="form-group">
            <label id="title-label" for="name">Title</label>
            <input type="text" name="title" id="title" class="form-control">
        </div>
        <div class="form-group">
            <label id="name-label" for="name">Product</label>  

            <div class="searchbox"> 
                <input type="text" name="productName" id="productName" class="form-control">     
            </div>
  
        </div>
        <div class="form-group">
            <label id="name-label" for="name">Name</label>
            <input type="text" name="name" id="name" class="form-control">
        </div>
        <div class="form-group">
            <p>Contents</p>
            <textarea id="comments" class="input-textarea" name="comment"></textarea>
        </div>
        <div class="form-group">
            <button type="button" class="return-button" @click="saveBoard()" style="float: right;">
                save
            </button>
            <button type="button" class="return-button back" @click="back()">
                back
            </button>
        </div>
    </form>
    </div>`
  
  });
  
  
  