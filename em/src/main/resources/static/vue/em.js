import chartComp from '/vue/chart.js'

export default {    
  template: 
`
<div class="container">
 <div class="user-profile-area">
  <div class="task-manager">emotion manager</div> 
  <div class="side-wrapper">
   <div class="user-profile">
    <img src="../img/me.png" alt="" class="user-photo">
    <div class="user-name">윤혜수</div>
    <div class="user-mail">yhs1790@naver.com</div>
   </div>
   <div class="progress-status">{{now}}/365 Days</div>
   <div class="progress">
    <div class="progress-bar"></div>
   </div>
   <div class="task-status">
   <div class="task-stat">
     <div class="task-number deplight"></div>
     <div class="task-condition">약간우울</div> 
    </div>
    <div class="task-stat">
     <div class="task-number dep"></div>
     <div class="task-condition">우울</div> 
    </div>
    <div class="task-stat">
     <div class="task-number normal"></div>
     <div class="task-condition">약간낙관</div> 
    </div>
    <div class="task-stat">
     <div class="task-number angry"></div>
     <div class="task-condition">다혈질</div> 
    </div>
   </div>
  </div>
  <div class="side-wrapper">
   <div class="project-title">Emotion</div>
   <div class="project-name">
    <div class="project-department">보통(약간우울)</div>
    <div class="project-department">우울</div>
    <div class="project-department">보통(약간낙관)</div>
    <div class="project-department">다혈질</div>
   </div>
  </div> 
 </div>
 <div class="main-area">
  <div class="header">
   <div class="search-bar">
    <input type="text" id="value" placeholder="Search..." @keyup="searchbar">
   </div>
   <div class="inbox-calendar" @click="toggleCalendar">
    <input type="checkbox" class="inbox-calendar-checkbox">
    <div class="toggle-page">
     <span>Diary</span>
    </div>
    <div class="layer"></div>
   </div>
   <div class="color-menu">
    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 464.7 464.7"><path d="M446.6 18.1a62 62 0 00-87.6 0L342.3 35a23 23 0 10-32.5 32.5l5.4 5.4-180.6 180.6L71.9 316c-5 5-8 11.6-8.2 18.7l-.2 3.3-2.5 56.7a9.4 9.4 0 009.4 9.8h.4l30-1.3 18.4-.8 8.3-.4a37 37 0 0024.5-10.8l240.9-240.9 4.5 4.6a23 23 0 0032.5 0c9-9 9-23.6 0-32.6l16.7-16.7a62 62 0 000-87.6zm-174 209.2l-84.6 16 138-138 34.4 34.3-87.8 87.7zM64.5 423.9C28.9 423.9 0 433 0 444.3c0 11.3 28.9 20.4 64.5 20.4s64.5-9.1 64.5-20.4C129 433 100 424 64.5 424z"/></svg>
   </div>
  </div>
  <div class="main-container">
   <div class="inbox-container">
    <div class="inbox">
    
    <div id="all" class="msg msg-department anim-y all">
      전체
      <svg xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 492 492" style="display:none;">
       <path d="M484.13 124.99l-16.11-16.23a26.72 26.72 0 00-19.04-7.86c-7.2 0-13.96 2.79-19.03 7.86L246.1 292.6 62.06 108.55c-5.07-5.06-11.82-7.85-19.03-7.85s-13.97 2.79-19.04 7.85L7.87 124.68a26.94 26.94 0 000 38.06l219.14 219.93c5.06 5.06 11.81 8.63 19.08 8.63h.09c7.2 0 13.96-3.57 19.02-8.63l218.93-219.33A27.18 27.18 0 00492 144.1c0-7.2-2.8-14.06-7.87-19.12z"></path>
      </svg>
     </div>

     <div id="deplight" class="msg msg-department anim-y deplight none">
      보통(약간우울)
      <svg xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 492 492" style="display:none;">
       <path d="M484.13 124.99l-16.11-16.23a26.72 26.72 0 00-19.04-7.86c-7.2 0-13.96 2.79-19.03 7.86L246.1 292.6 62.06 108.55c-5.07-5.06-11.82-7.85-19.03-7.85s-13.97 2.79-19.04 7.85L7.87 124.68a26.94 26.94 0 000 38.06l219.14 219.93c5.06 5.06 11.81 8.63 19.08 8.63h.09c7.2 0 13.96-3.57 19.02-8.63l218.93-219.33A27.18 27.18 0 00492 144.1c0-7.2-2.8-14.06-7.87-19.12z"></path>
      </svg>
     </div>
     <div id="dep" class="msg msg-department anim-y dep none">
     우울
     <svg xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 492 492" style="display:none;">
       <path d="M484.13 124.99l-16.11-16.23a26.72 26.72 0 00-19.04-7.86c-7.2 0-13.96 2.79-19.03 7.86L246.1 292.6 62.06 108.55c-5.07-5.06-11.82-7.85-19.03-7.85s-13.97 2.79-19.04 7.85L7.87 124.68a26.94 26.94 0 000 38.06l219.14 219.93c5.06 5.06 11.81 8.63 19.08 8.63h.09c7.2 0 13.96-3.57 19.02-8.63l218.93-219.33A27.18 27.18 0 00492 144.1c0-7.2-2.8-14.06-7.87-19.12z"></path>
      </svg>
     </div>
     <div id="normal" class="msg msg-department anim-y normal none">
     보통(약간낙관)
     <svg xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 492 492" style="display:none;">
       <path d="M484.13 124.99l-16.11-16.23a26.72 26.72 0 00-19.04-7.86c-7.2 0-13.96 2.79-19.03 7.86L246.1 292.6 62.06 108.55c-5.07-5.06-11.82-7.85-19.03-7.85s-13.97 2.79-19.04 7.85L7.87 124.68a26.94 26.94 0 000 38.06l219.14 219.93c5.06 5.06 11.81 8.63 19.08 8.63h.09c7.2 0 13.96-3.57 19.02-8.63l218.93-219.33A27.18 27.18 0 00492 144.1c0-7.2-2.8-14.06-7.87-19.12z"></path>
      </svg>
     </div>
     <div id="angry" class="msg msg-department anim-y angry none">
     다혈질
     <svg xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 492 492" style="display:none;">
       <path d="M484.13 124.99l-16.11-16.23a26.72 26.72 0 00-19.04-7.86c-7.2 0-13.96 2.79-19.03 7.86L246.1 292.6 62.06 108.55c-5.07-5.06-11.82-7.85-19.03-7.85s-13.97 2.79-19.04 7.85L7.87 124.68a26.94 26.94 0 000 38.06l219.14 219.93c5.06 5.06 11.81 8.63 19.08 8.63h.09c7.2 0 13.96-3.57 19.02-8.63l218.93-219.33A27.18 27.18 0 00492 144.1c0-7.2-2.8-14.06-7.87-19.12z"></path>
      </svg>
     </div>
     
     <div id="loopdata"></div>        

    </div>
    <div class="add-task">
     <button class="add-button" @click="write">Add Diary</button>
    </div>
   </div>
   <div class="mail-detail">
    <div class="mail-detail-header">
     <div class="mail-detail-profile">
      <img src="../img/me.png" alt="" class="members inbox-detail" />
      <div class="mail-detail-name">윤혜수</div>
     </div> 
    </div>
    <div class="mail-contents">
     <div class="mail-contents-subject" title="우울">
      <input type="checkbox" name="msg" id="mail20" class="mail-choice EM04" checked disabled>
      <label for="mail20" @click="changeEm"></label>      
      <div class="mail-contents-title"><input type="text" name="title" style="font-size: 17px;"></input></div>
     </div>
     <div class="mail">
      <div class="mail-time">
       <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-clock">
        <circle cx="12" cy="12" r="10" />
        <path d="M12 6v6l4 2" /></svg>
        <span id="date">{{date}}</span>
      </div>
      <div class="mail-inside">
          <article>
          <section>
            <textarea spellcheck=false name="contents"></textarea>
            <div class="textarea-clone"></div>
          </section>   
        </article>
      </div>
     </div>
    </div>
    <div class="mail-textarea">     
     <div class="textarea-icons" name="textarea-icons"> 
      <div class="send" @click="save">
       <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-send">
        <path d="M22 2L11 13M22 2l-7 20-4-9-9-4 20-7z" /></svg>
      </div>
     </div>
    </div>
   </div>
   <div class="calendar-container">
    <div class="calender-tab anim-y">


    <chart-comp></chart-comp>   

    

    </div>
   </div>
  </div>
 </div>
</div>
`, 
data() {
  return {         
    date: moment(new Date()).format('DD MMM, YYYY'),
    count: 0,
    emcd: '',
    now: moment().diff(moment(new Date()).format('YYYY-01-01'),"days")
  }
},
components: { 
'chart-comp': chartComp
},
methods:{
  toggleCalendar: function() {
    document.getElementsByClassName("calendar-container")[0].classList.toggle('calendar-show');
    document.getElementsByClassName("inbox-container")[0].classList.toggle('hide');
    document.getElementsByClassName("mail-detail")[0].classList.toggle('hide');
  },
  /**********************************************
    다이어리 저장 API
  ***********************************************/  
  add: function() {
   
    let contents = document.getElementsByName("contents")[0].value;
    let title = document.getElementsByName("title")[0].value;

    if(contents==='' || title==='') {
      alert('값이 비었다... ');
      return;
    }

    return new Promise((resolve) => { 

      this.emcd = document.querySelector('#mail20').classList[1]
      
      fetch('http://localhost:5013/add', {
      method: 'post', 
      headers: {
      'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        contents: contents,
        title: title,
        emotion_cd: this.emcd
        })
      })
      .then(res => resolve(res.json())) 
    })    
  },
  /**********************************************
    다이어리 저장
  ***********************************************/  
  save: function() {     
    this.add().then(function(data) {
      
        if(data === '')
        { 
          alert(data.message); 
          return;
        }        
        else
        {          
          location.href = '/em'; 
        }
        
    }) 
  },
  /**********************************************
    다이어리 타이틀 전체 조회 API
  ***********************************************/  
  list: function() { 
    fetch('http://localhost:5013/list', {
      method: 'get', 
      headers: {
      'Content-Type': 'application/json'
      } 
      })
      .then(res => res.json())
      .then(function(data) { 
        let datahtml = '' 
        if(data !== '')
        {  
          for (let i in data) { 
            datahtml = datahtml + '<div class="msg selected-bg anim-y" onclick="showcontent(this)">' +
            '<input type="checkbox" name="msg" id="mail3" class="mail-choice ' + data[i].emotionCd + '" checked disabled><label for="mail3"></label>' +
            '<div class="msg-content">' +  
            '<div class="msg-title">' + data[i].title + '<span id="msgno" style="display:none;">' + data[i].uuid + '</span>'+ 
            '</div><div class="msg-date">' + moment(String(data[i].date[0]) + String(data[i].date[1])+ String(data[i].date[2])).format('DD MMM, YYYY') + 
            '</div></div><img src="../img/me.png" alt="" class="members mail-members"></div>'  
          }          
        } 
          document.getElementById('loopdata').innerHTML = datahtml; 
          
        } 
      )
  },
  /**********************************************
    감정코드 카운트 셋팅
  ***********************************************/  
  listCount: function() { 
    this.searchdiary('EM01').then(function(data) { 
        document.querySelector('.task-number.deplight').textContent = data.length; 
    })
    
    this.searchdiary('EM02').then(function(data) { 
        document.querySelector('.task-number.normal').textContent = data.length; 
    })

    this.searchdiary('EM03').then(function(data) { 
        document.querySelector('.task-number.angry').textContent = data.length; 
    })

    this.searchdiary('EM04').then(function(data) { 
        document.querySelector('.task-number.dep').textContent = data.length; 
    })

    document.styleSheets[0].cssRules[25].cssRules[1].style.cssText = 'width:' + ((this.now / 365) * 100) + '%;';
    document.getElementsByClassName('progress-bar')[0].setAttribute('style', 'width:' + ((this.now / 365) * 100) + '%;');
    
  },
  /**********************************************
    글쓰기 버튼 선택
  ***********************************************/  
  write: function() {    
    document.getElementsByName("textarea-icons")[0].style.display = 'flex';
    document.getElementsByName("title")[0].disabled = false;
    document.getElementsByName("contents")[0].disabled = false;
    document.getElementsByName("title")[0].value = '';
    document.getElementsByName("contents")[0].value = '';
  },
  /**********************************************
    감정코드 변경
  ***********************************************/  
  changeEm: function() {     

    if( document.getElementsByName("title")[0].disabled ) 
    {
      return;
    }

    const mail20 = document.querySelector('#mail20');
    
    mail20.className = 'mail-choice';        
    this.count += 1; 

    if(this.count == 1) {
      mail20.classList.add('EM01');    
      document.querySelector('.mail-contents-subject').title = '보통(약간우울)';

    } else if(this.count == 2) {
      mail20.classList.add('EM02');     
      document.querySelector('.mail-contents-subject').title = '보통(약간낙관)';
    
    } else if(this.count == 3) {
      mail20.classList.add('EM03');     
      document.querySelector('.mail-contents-subject').title = '다혈질';
    
    } else {
      mail20.classList.add('EM04');     
      document.querySelector('.mail-contents-subject').title = '우울';
      this.count = 0; 
    }
    
  },
  /**********************************************
    감정코드로 다이어리 조회 API
  ***********************************************/  
  searchdiary: function(obj) { 
    return new Promise((resolve) => { 
      fetch('http://localhost:5013/listbyemcd/' + obj, {
      method: 'get', 
      headers: {
      'Content-Type': 'application/json'
      }
      })
      .then(res => resolve(res.json())) 
    })    
  }, 
  /**********************************************
    검색어 입력 필터링
  ***********************************************/  
  searchbar: function(obj) {

    let value, name, item, i;

    value = document.getElementById("value").value.toUpperCase();
    item  = document.getElementsByClassName("selected-bg");

    for(i=0; i<item.length; i++) {
      name = item[i].getElementsByClassName("msg-title");
    
      if(name[0].innerHTML.toUpperCase().indexOf(value) > -1){
        item[i].style.display = "flex";

      }else{
        item[i].style.display = "none";
      }
    }

  }

},
mounted() {  
  this.list(); 
  this.listCount();
} 
}; 
  







