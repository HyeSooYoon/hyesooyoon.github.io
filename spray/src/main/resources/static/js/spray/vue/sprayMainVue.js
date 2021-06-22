Vue.component('itview', {
  methods: {
    getBoardList() {
        return this.$store.state.data.boardList
     },
    viewContent(no) {
        return location.href = '/spray/board/boardContent/' + no
    },
    vieeChart() {
        return location.href = '/spray/vote/voteFront'
    }
    },
  template: `<!DOCTYPE html>
             <html lang="en">
             <head>
                 <meta charset="utf-8" />
                 <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
                 <meta name="description" content="" />
                 <meta name="author" content="" />
                 <title>Shop Homepage - Start Bootstrap Template</title>
                 <!-- Favicon-->
                 <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
                 <!-- Bootstrap icons--> 
                 <link rel="preconnect" href="https://fonts.gstatic.com">
                 <link href="https://fonts.googleapis.com/css2?family=Nanum+Myeongjo&family=Open+Sans:ital,wght@1,300&display=swap" rel="stylesheet">
             </head>
             <body>
             <!-- Section-->
             <section class="py-5">
                 <div class="container px-4 px-lg-5 mt-5">
                     <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                         
                         <div class="col mb-5">
                         <div class="card h-100">
                             <!-- Product image-->
                             <img class="card-img-top" src="/assets/img/product/Camel화장품.jpg" alt="..." />
                             <!-- Product details-->
                             <div class="card-body p-4">
                                 <div class="text-center">
                                     <!-- Product name-->
                                     <h5 class="fw-bolder" style="font-family: 'Open Sans', sans-serif; color:#C12247">Eye Liner</h5>
                                     <!-- Product price-->
                                     <a href="#" v-for="(boardList, index) in getBoardList()" style="text-decoration:none; color: #333e4e;">
                                     <span @click="viewContent(boardList.no)" style="font-family: 'Nanum Myeongjo', serif;">
                                        {{index+1}}. {{ boardList.title }}
                                     </span>
                                     <span style="color: #517b7b;font-size: 95%;"> / {{ boardList.writer }}</span><br>
                                     </a>
                                 </div>
                             </div>
                             <!-- Product actions-->
                             <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                 <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#" @click="vieeChart()">go to vote</a></div>
                             </div>
                         </div>
                         </div>

                         <div class="col mb-5">
                         <div class="card h-100">
                             <!-- Product image-->
                             <img class="card-img-top" src="/assets/img/product/Capybara화장품.jpg" alt="..." />
                             <!-- Product details-->
                             <div class="card-body p-4">
                                 <div class="text-center">
                                     <!-- Product name-->
                                     <h5 class="fw-bolder" style="font-family: 'Open Sans', sans-serif; color:#C12247">Blusher</h5>
                                     <!-- Product price-->
                                     <a href="#" v-for="(boardList, index) in getBoardList()" style="text-decoration:none; color: #333e4e;">
                                     <span @click="viewContent(boardList.no)" style="font-family: 'Nanum Myeongjo', serif;">
                                        {{index+1}}. {{ boardList.title }}
                                     </span>
                                     <span style="color: #517b7b;font-size: 95%;"> / {{ boardList.writer }}</span><br>
                                     </a>
                                 </div>
                             </div>
                             <!-- Product actions-->
                             <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                 <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">go to vote</a></div>
                             </div>
                         </div>
                         </div>

                         <div class="col mb-5">
                         <div class="card h-100">
                             <!-- Product image-->
                             <img class="card-img-top" src="/assets/img/product/Deer화장품.jpg" alt="..." />
                             <!-- Product details-->
                             <div class="card-body p-4">
                                 <div class="text-center">
                                     <!-- Product name-->
                                     <h5 class="fw-bolder" style="font-family: 'Open Sans', sans-serif; color:#C12247">Powder</h5>
                                     <!-- Product price-->
                                     <a href="#" v-for="(boardList, index) in getBoardList()" style="text-decoration:none; color: #333e4e;">
                                     <span @click="viewContent(boardList.no)" style="font-family: 'Nanum Myeongjo', serif;">
                                        {{index+1}}. {{ boardList.title }}
                                     </span>
                                     <span style="color: #517b7b;font-size: 95%;"> / {{ boardList.writer }}</span><br>
                                     </a>
                                 </div>
                             </div>
                             <!-- Product actions-->
                             <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                 <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">go to vote</a></div>
                             </div>
                         </div>
                         </div>
                       
                         <div class="col mb-5">
                         <div class="card h-100">
                             <!-- Product image-->
                             <img class="card-img-top" src="/assets/img/product/Anteater화장품.jpg" alt="..." />
                             <!-- Product details-->
                             <div class="card-body p-4">
                                 <div class="text-center">
                                     <!-- Product name-->
                                     <h5 class="fw-bolder" style="font-family: 'Open Sans', sans-serif; color:#C12247">Eye Shadow</h5>
                                     <!-- Product price-->
                                     <a href="#" v-for="(boardList, index) in getBoardList()" style="text-decoration:none; color: #333e4e;">
                                     <span @click="viewContent(boardList.no)" style="font-family: 'Nanum Myeongjo', serif;">
                                        {{index+1}}. {{ boardList.title }}
                                     </span>
                                     <span style="color: #517b7b;font-size: 95%;"> / {{ boardList.writer }}</span><br>
                                     </a>
                                 </div>
                             </div>
                             <!-- Product actions-->
                             <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                 <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">go to vote</a></div>
                             </div>
                         </div>
                         </div>

                         <div class="col mb-5">
                             <div class="card h-100">
                                 <!-- Product image-->
                                 <img class="card-img-top" src="/assets/img/product/Aardvark화장품.jpg" alt="..." />
                                 <!-- Product details-->
                                 <div class="card-body p-4">
                                     <div class="text-center">
                                         <!-- Product name-->
                                         <h5 class="fw-bolder" style="font-family: 'Open Sans', sans-serif; color:#C12247">Foundation</h5>
                                         <!-- Product price-->
                                         <a href="#" v-for="(boardList, index) in getBoardList()" style="text-decoration:none; color: #333e4e;">
                                         <span @click="viewContent(boardList.no)" style="font-family: 'Nanum Myeongjo', serif;">
                                            {{index+1}}. {{ boardList.title }}
                                         </span>
                                         <span style="color: #517b7b;font-size: 95%;"> / {{ boardList.writer }}</span><br>
                                         </a>
                                     </div>
                                 </div>
                                 <!-- Product actions-->
                                 <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                     <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">go to vote</a></div>
                                 </div>
                             </div>
                         </div>

                         <div class="col mb-5">
                         <div class="card h-100">
                             <!-- Product image-->
                             <img class="card-img-top" src="/assets/img/product/Donkey화장품.jpg" alt="..." />
                             <!-- Product details-->
                             <div class="card-body p-4">
                                 <div class="text-center">
                                     <!-- Product name-->
                                     <h5 class="fw-bolder" style="font-family: 'Open Sans', sans-serif; color:#C12247">Lipstick</h5>
                                     <!-- Product price-->
                                     <a href="#" v-for="(boardList, index) in getBoardList()" style="text-decoration:none; color: #333e4e;">                                     
                                     <span @click="viewContent(boardList.no)" style="font-family: 'Nanum Myeongjo', serif;">
                                        {{index+1}}. {{ boardList.title }}
                                     </span>
                                     <span style="color: #517b7b;font-size: 95%;"> / {{ boardList.writer }}</span><br>
                                     </a>
                                 </div>
                             </div>
                             <!-- Product actions-->
                             <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                 <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">go to vote</a></div>
                             </div>
                         </div>
                     </div>

                     <div class="col mb-5">
                     <div class="card h-100">
                         <!-- Product image-->
                         <img class="card-img-top" src="/assets/img/product/Baboon화장품.jpg" alt="..." />
                         <!-- Product details-->
                         <div class="card-body p-4">
                             <div class="text-center">
                                 <!-- Product name-->
                                 <h5 class="fw-bolder" style="font-family: 'Open Sans', sans-serif; color:#C12247">Perfume</h5>
                                 <!-- Product price-->
                                 <a href="#" v-for="(boardList, index) in getBoardList()" style="text-decoration:none; color: #333e4e;">
                                 <span @click="viewContent(boardList.no)" style="font-family: 'Nanum Myeongjo', serif;">
                                    {{index+1}}. {{ boardList.title }}
                                 </span>
                                 <span style="color: #517b7b;font-size: 95%;"> / {{ boardList.writer }}</span><br>
                                 </a>
                             </div>
                         </div>
                         <!-- Product actions-->
                         <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                             <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">go to vote</a></div>
                         </div>
                     </div>
                     </div>

                     <div class="col mb-5">
                     <div class="card h-100">
                         <!-- Product image-->
                         <img class="card-img-top" src="/assets/img/product/Butterfly화장품.jpg" alt="..." />
                         <!-- Product details-->
                         <div class="card-body p-4">
                             <div class="text-center">
                                 <!-- Product name-->
                                 <h5 class="fw-bolder" style="font-family: 'Open Sans', sans-serif; color:#C12247">Mascara</h5>
                                 <!-- Product price-->
                                 <a href="#" v-for="(boardList, index) in getBoardList()" style="text-decoration:none; color: #333e4e;">
                                 <span @click="viewContent(boardList.no)" style="font-family: 'Nanum Myeongjo', serif;">
                                    {{index+1}}. {{ boardList.title }}
                                 </span>
                                 <span style="color: #517b7b;font-size: 95%;"> / {{ boardList.writer }}</span><br>
                                 </a>
                             </div>
                         </div>
                         <!-- Product actions-->
                         <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                             <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">go to vote</a></div>
                         </div>
                     </div>
                     </div>
                          
                     </div>
                 </div>
             </section>
             <!-- Footer-->
             <footer class="py-5 bg-dark">
                 <div class="container"><p class="m-0 text-center text-white">Copyright &copy; Spray 2021</p></div>
             </footer>
             <!-- Bootstrap core JS-->
             <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>
             <!-- Core theme JS-->
             <script src="js/style/sprayMainScript.js"></script>
             </body>
             </html>`

});


