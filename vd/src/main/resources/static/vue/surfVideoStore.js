const surfVideoStore = {
    state: {
        videoNo: '',
        ytubeUrl: 'https://www.youtube.com/embed/',
        twcUrl: 'https://player.twitch.tv/?video='        
  },
  mutations: { 
    commitVdNo (state, payload) {       
      state.videoNo = payload
    } 
  } 
}