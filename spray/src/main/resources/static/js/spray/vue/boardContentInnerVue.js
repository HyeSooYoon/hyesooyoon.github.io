Vue.component('boardcontentinner-view', {
    methods: {  
       // 뒤로가기
       back() {
        location.href = '/spray/board/boardFrontMenu';
       }
      },
      props: {
        title  : String, 
        writer : String, 
        regdte : String,
        readcnt: String,
        content: String
      },
      mounted() { 
          document.getElementById('title').value = eval('this.title')
          document.getElementById('name').value = eval('this.writer')
          document.getElementById('date').value = eval('this.regdte')
          document.getElementById('view').value = eval('this.readcnt') 
        },
    template: 
    `<div class="container">
    <form id="survey-form">
        <div class="form-group">
            <p>Product</p>
            <img class="card-img-top" src="/assets/img/product/Deer화장품.jpg" alt="..." style="display: block; margin: auto;"/>
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
        <!-- <div class="form-group">
            <label id="view-label" for="view">Count</label>
            <input type="text" name="view" id="view" class="form-control" readonly="readonly">
        </div> -->
        <div class="form-group">
            <p>Contents</p>
            <textarea id="comments" class="input-textarea" name="comment" readonly="readonly">{{content}}</textarea>
        </div>
        <div class="form-group">
            <button type="button" class="return-button" @click="back()">
                back
            </button>
        </div>
    </form>
    </div>`
  
  });
  
  
  