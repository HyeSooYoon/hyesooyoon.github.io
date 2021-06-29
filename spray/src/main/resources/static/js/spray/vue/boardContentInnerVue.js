Vue.component('boardcontentinner-view', {
      data(){
        return {  
          csrf : this.$attrs.csrftoken
        }
    },
    methods: {  
       // 뒤로가기
       back() {
        location.href = '/spray/board/boardFrontMenu';
       }, 
       voteCnt() {

        if(document.querySelector('.emoji--like').style.backgroundColor=='rgb(234, 206, 189)')
        { 
        }
        else
        {
          fetch('http://localhost:8080/voteCount', {
            method: 'post',
            credentials: 'include',
            headers: {
            'Content-Type': 'application/json',
            'X-CSRF-TOKEN': this._data.csrf
            },
            body: JSON.stringify({
                code: this.$attrs.productcd
              })
            })
          .then(

            fetch('http://localhost:8080/saveVote', {
            method: 'post',
            credentials: 'include',
            headers: {
            'Content-Type': 'application/json',
            'X-CSRF-TOKEN': this._data.csrf
            },
            body: JSON.stringify({ 
                 product_cd: this.$attrs.productcd,
                 user_no: '',
                 tel: ''
              }) 
            }).then(res => res.json())
            .then(function(data) {
              if(data.code==='0000')
              {
                 Swal.fire({
                  icon: 'success',
                  title: '추천합니다!',
                  text: '투표 성공!',
                  footer: '',
                  showConfirmButton: false,
                  timer: 1600
                  }) 
                  document.querySelector('.emoji--like').style.backgroundColor = '#eacebd'
              }
              else
              {
                Swal.fire({
                  icon: 'fail',
                  title: '투표에 실패하였습니다.',
                  footer: '투표 실패!',
                  showConfirmButton: false,
                  timer: 1600
                  })
              }
            }) 

            
            )
        }




        
       }
      },
      props: {
        title  : String, 
        writer : String, 
        regdte : String,
        readcnt: String,
        content: String, 
        csrfToken: String,
        productCd: String
      },
      mounted() {  
          document.getElementById('title').value = this.title
          document.getElementById('name').value  = this.writer
          document.getElementById('date').value  = this.regdte
          document.getElementById('view').value  = this.readcnt 
        },
    template: 
    `<div class="container">     
    <form id="survey-form">
        <div class="form-group">
            <label id="title-label" for="productCd">Product</label>
            <img class="card-img-top" name="productCd" id="productCd" alt="..." style="display: block; margin: auto; width: 100%;"/>
        </div>
        <div class="form-group">
            <label id="title-label" for="name">Title</label>
            <input type="text" name="title" id="title" class="form-control" readonly="readonly">
        </div>
        <div class="form-group">
            <label id="name-label" for="name">Name</label>
            <input type="text" name="name" id="name" class="form-control" readonly="readonly">
        </div>
        <div class="form-group">
            <label id="date-label" for="date">Date</label>
            <input type="text" name="date" id="date" class="form-control" readonly="readonly">
        </div>        
        <div class="form-group"> 
            <label id="content-label" for="comment">Contents</label>
            <textarea id="comments" class="input-textarea" name="comment" readonly="readonly">{{content}}</textarea>
        </div>

        <!-- thumbs up -->
        <div class="form-group">
         <div class="emoji  emoji--like" @click="voteCnt()">
           <div class="emoji__hand">
           <div class="emoji__thumb"></div>
           </div>
         </div>
       </div>

        <div class="form-group">
        <button type="button" class="return-button" @click="back()">
                back
            </button>
        </div>
        
    </form>
    </div>`
  
  });
  
  
  