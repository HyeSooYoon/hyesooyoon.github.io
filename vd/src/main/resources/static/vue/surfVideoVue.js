Vue.component('surfvideo-view', {    
template: 
`
  <ul style="z-index: 1;">   
    <li><iframe width="560" id="youtubevd" height="315" src="" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe></li>  
  </ul>`,  
mounted() {  
  document.getElementById('youtubevd').setAttribute("src", this.youtubeUrl);
}, 
data() { 
  return { 
    youtubeUrl: 'https://www.youtube.com/embed/' + this.$store.state.videoNo
  } 
}
 
});


