const cosmeticStore = {
 state: {
     data: {
        apiUrl: 'http://localhost:8080',
        type: 'get',
        EyeLiner: [{
          no: [],
          title: [],
          writer: [],
          voteCnt: [],
          boardType: [],
        }],
        Blusher: [{
          no: [],
          title: [],
          writer: [],
          voteCnt: [],
          boardType: [],
        }],
        Powder: [{
          no: [],
          title: [],
          writer: [],
          voteCnt: [],
          boardType: [],
        }],
        EyeShadow: [{
          no: [],
          title: [],
          writer: [],
          voteCnt: [],
          boardType: [],
        }],
        Foundation: [{
          no: [],
          title: [],
          writer: [],
          voteCnt: [],
          boardType: [],
        }],
        Lipstick: [{
          no: [],
          title: [],
          writer: [],
          voteCnt: [],
          boardType: [],
        }],
        Perfume: [{
          no: [],
          title: [],
          writer: [],
          voteCnt: [],
          boardType: [],
        }],
        Mascara: [{
          no: [],
          title: [],
          writer: [],
          voteCnt: [],
          boardType: [],
        }]
     },
     dummy: 'check!'
 },
 getters: { 
  getDummy (state) {
    return state.dummy
  }
},
 mutations: {
  setEyeLinerData: (state, payload) => state.data.EyeLiner = payload.data,
  setBlusherData: (state, payload) => state.data.Blusher = payload.data,
  setPowderData: (state, payload) => state.data.Powder = payload.data,
  setEyeShadowData: (state, payload) => state.data.EyeShadow = payload.data,
  setFoundationData: (state, payload) => state.data.Foundation = payload.data,
  setLipstickData: (state, payload) => state.data.Lipstick = payload.data,
  setPerfumeData: (state, payload) => state.data.Perfume = payload.data,
  setMascaraData: (state, payload) => state.data.Mascara = payload.data
 },
 actions: {
   async cosmetic(context) {
   try {
           // Eye Liner
           await fetch(             
                 'http://localhost:8080/mboard?type=CS01', {                  
                   method: this.state.data.type,
                   headers: {
                   'Content-Type': 'application/json',
                   'Accept': 'application/json'
                   }
                 })
               .then( data => { return data.json(); })
               .then( res => {
               let payload = res;
               context.commit('setEyeLinerData', payload);
               }
               )
               
               // Blusher
               await fetch(             
                'http://localhost:8080/mboard?type=CS02', {                  
                  method: this.state.data.type,
                  headers: {
                  'Content-Type': 'application/json',
                  'Accept': 'application/json'
                  }
                })
              .then( data => { return data.json(); })
              .then( res => {
              let payload = res;
              context.commit('setBlusherData', payload);
              }
              )

              // Powder
              await fetch(             
                'http://localhost:8080/mboard?type=CS03', {                  
                  method: this.state.data.type,
                  headers: {
                  'Content-Type': 'application/json',
                  'Accept': 'application/json'
                  }
                })
              .then( data => { return data.json(); })
              .then( res => {
              let payload = res;
              context.commit('setPowderData', payload);
              }
              )

              // Eye Shadow
              await fetch(             
                'http://localhost:8080/mboard?type=CS04', {                  
                  method: this.state.data.type,
                  headers: {
                  'Content-Type': 'application/json',
                  'Accept': 'application/json'
                  }
                })
              .then( data => { return data.json(); })
              .then( res => {
              let payload = res;
              context.commit('setEyeShadowData', payload);
              }
              )

              // Foundation
              await fetch(             
                'http://localhost:8080/mboard?type=CS05', {                  
                  method: this.state.data.type,
                  headers: {
                  'Content-Type': 'application/json',
                  'Accept': 'application/json'
                  }
                })
              .then( data => { return data.json(); })
              .then( res => {
              let payload = res;
              context.commit('setFoundationData', payload);
              }
              )

              // Lipstick
              await fetch(             
                'http://localhost:8080/mboard?type=CS06', {                  
                  method: this.state.data.type,
                  headers: {
                  'Content-Type': 'application/json',
                  'Accept': 'application/json'
                  }
                })
              .then( data => { return data.json(); })
              .then( res => {
              let payload = res;
              context.commit('setLipstickData', payload);
              }
              )

              // Perfume
              await fetch(             
                'http://localhost:8080/mboard?type=CS07', {                  
                  method: this.state.data.type,
                  headers: {
                  'Content-Type': 'application/json',
                  'Accept': 'application/json'
                  }
                })
              .then( data => { return data.json(); })
              .then( res => {
              let payload = res;
              context.commit('setPerfumeData', payload);
              }
              )


              // Mascara
              await fetch(             
                'http://localhost:8080/mboard?type=CS08', {                  
                  method: this.state.data.type,
                  headers: {
                  'Content-Type': 'application/json',
                  'Accept': 'application/json'
                  }
                })
              .then( data => { return data.json(); })
              .then( res => {
              let payload = res;
              context.commit('setMascaraData', payload);
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