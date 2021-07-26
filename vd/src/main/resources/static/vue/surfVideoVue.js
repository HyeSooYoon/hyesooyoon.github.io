Vue.component('surfvideo-view', {  
  methods: {  
  },
  template: 
  `<ul style="z-index: 1;">
   <li><iframe width="560" id="vd" height="315" src="" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe></li>
  
  
</ul>`,
props: {
  vurl  : String 
},
mounted() {  
  document.getElementById('vd').setAttribute("src", "https://www.youtube.com/embed/" + this.vurl);
}

});


