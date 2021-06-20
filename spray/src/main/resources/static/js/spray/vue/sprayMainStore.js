const itBoardStore = {
 state: {
     data: {
        apiUrl: 'http://localhost:8080',
        type: 'get',
        boardList: [{
          no: [],
          title: [],
          writer: []
        }]
     },
     dummy: 'check ass!'
 },
 getters: { 
  getDummy (state) {
    return state.dummy
  }
},
 mutations: {
  setData: (state, payload) => state.data.boardList = payload.data
 },
 actions: {
   async itBoard(context) {
   try {
           await fetch(
                 'http://localhost:8080/mboard', {
                   method: this.state.data.type,
                   headers: {
                   'Content-Type': 'application/json',
                   'Accept': 'application/json'
                   }
                 })
               .then( data => { return data.json(); })
               .then( res => {
               let payload = res;
               context.commit('setData', payload);
               }
               )
           } catch (e) {
               alert(e.message);
               return false;
           }
           return true;
        }
      }


}