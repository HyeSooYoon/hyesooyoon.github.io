const surfVideoStore = {
    state: {
        videoNo: '',
        ytubeUrl: 'https://www.youtube.com/embed/'
  },
  mutations: { 
    commitVdNo (state, payload) {       
      state.videoNo = payload
    } 
  } 
}