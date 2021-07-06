Vue.component('itview', {
   data: () => ({
   }),
  methods: {
    getEyeLiner() {
        return this.$store.state.data.EyeLiner
     },
     getBlusher() {
        return this.$store.state.data.Blusher
     },
     getPowder() {
        return this.$store.state.data.Powder
     },
     getEyeShadow() {
        return this.$store.state.data.EyeShadow
     },
     getFoundation() {
        return this.$store.state.data.Foundation
     },
     getLipstick() {
        return this.$store.state.data.Lipstick
     },
     getPerfume() {
        return this.$store.state.data.Perfume
     },
     getMascara() {
        return this.$store.state.data.Mascara
     },

    viewContent(no) {
        return location.href = '/spray/board/boardContent/' + no
    },
    vieeChart1() {
        return location.href = '/spray/vote/voteFront?type=CS01'
    },
    vieeChart2() {
        return location.href = '/spray/vote/voteFront?type=CS02'
    },
    vieeChart3() {
        return location.href = '/spray/vote/voteFront?type=CS03'
    },
    vieeChart4() {
        return location.href = '/spray/vote/voteFront?type=CS04'
    },
    vieeChart5() {
        return location.href = '/spray/vote/voteFront?type=CS05'
    },
    vieeChart6() {
        return location.href = '/spray/vote/voteFront?type=CS06'
    },
    vieeChart7() {
        return location.href = '/spray/vote/voteFront?type=CS07'
    },
    vieeChart8() {
        return location.href = '/spray/vote/voteFront?type=CS08'
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
                             <!-- 최다득표 제품 이미지 셋팅 어케하지 ... ㅡㅡ;; -->
                             <img class="card-img-top" src="/assets/img/product/Camel화장품.jpg" alt="..." />
                             <!-- Product details-->
                             <div class="card-body p-4">
                                 <div class="text-center">
                                     <!-- Product name-->
                                     <h5 class="fw-bolder" style="font-family: 'Open Sans', sans-serif; color:#C12247">Eye Liner</h5>
                                     <!-- Product price-->
                                     <a href="#" v-for="(EyeLiner, index) in getEyeLiner()" style="text-decoration:none; color: #333e4e;">
                                     <div class='CS01'>
                                        <span @click="viewContent(EyeLiner.no)" style="font-family: 'Nanum Myeongjo', serif;">
                                            {{index+1}}. {{ EyeLiner.title }}
                                        </span>
                                        <span style="color: rgb(195 93 112);font-family: 'Nanum Brush Script', cursive;"> / {{ EyeLiner.voteCnt }}득표</span><br>
                                     </div>                                     
                                     </a>
                                 </div>
                             </div>
                             <!-- Product actions-->
                             <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                 <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#" @click="vieeChart1()">show chart</a></div>
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
                                     <a href="#" v-for="(Blusher, index) in getBlusher()" style="text-decoration:none; color: #333e4e;">
                                     <div class='CS02'>
                                     <span @click="viewContent(Blusher.no)" style="font-family: 'Nanum Myeongjo', serif;">
                                        {{index+1}}. {{ Blusher.title }}
                                     </span>
                                     <span style="color: rgb(195 93 112);font-family: 'Nanum Brush Script', cursive;"> / {{ Blusher.voteCnt }}득표</span><br>
                                     </div>
                                     </a>
                                 </div>
                             </div>
                             <!-- Product actions-->
                             <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                 <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#" @click="vieeChart2()">show chart</a></div>
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
                                     <a href="#" v-for="(Powder, index) in getPowder()" style="text-decoration:none; color: #333e4e;">
                                     <div class='CS03'>
                                     <span @click="viewContent(Powder.no)" style="font-family: 'Nanum Myeongjo', serif;">
                                        {{index+1}}. {{ Powder.title }}
                                     </span>
                                     <span style="color: rgb(195 93 112);font-family: 'Nanum Brush Script', cursive;"> / {{ Powder.voteCnt }}득표</span><br>
                                     </div>
                                     </a>
                                 </div>
                             </div>
                             <!-- Product actions-->
                             <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                 <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#" @click="vieeChart3()">show chart</a></div>
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
                                     <a href="#" v-for="(EyeShadow, index) in getEyeShadow()" style="text-decoration:none; color: #333e4e;">
                                     <div class='CS04'>
                                     <span @click="viewContent(EyeShadow.no)" style="font-family: 'Nanum Myeongjo', serif;">
                                        {{index+1}}. {{ EyeShadow.title }}
                                     </span>
                                     <span style="color: rgb(195 93 112);font-family: 'Nanum Brush Script', cursive;"> / {{ EyeShadow.voteCnt }}득표</span><br>
                                     </div>
                                     </a>
                                 </div>
                             </div>
                             <!-- Product actions-->
                             <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                 <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#" @click="vieeChart4()">show chart</a></div>
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
                                         <a href="#" v-for="(Foundation, index) in getFoundation()" style="text-decoration:none; color: #333e4e;">
                                         <div class='CS05'>
                                         <span @click="viewContent(Foundation.no)" style="font-family: 'Nanum Myeongjo', serif;">
                                          {{index+1}}. {{ Foundation.title }}
                                         </span>
                                         <span style="color: rgb(195 93 112);font-family: 'Nanum Brush Script', cursive;"> / {{ Foundation.voteCnt }}득표</span><br>
                                         </div>
                                         </a>
                                     </div>
                                 </div>
                                 <!-- Product actions-->
                                 <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                     <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#" @click="vieeChart5()">show chart</a></div>
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
                                     <a href="#" v-for="(Lipstick, index) in getLipstick()" style="text-decoration:none; color: #333e4e;">                                     
                                     <div class='CS06'>
                                     <span @click="viewContent(Lipstick.no)" style="font-family: 'Nanum Myeongjo', serif;">
                                        {{index+1}}. {{ Lipstick.title }}
                                     </span>
                                     <span style="color: rgb(195 93 112);font-family: 'Nanum Brush Script', cursive;"> / {{ Lipstick.voteCnt }}득표</span><br>
                                     </div>
                                     </a>
                                 </div>
                             </div>
                             <!-- Product actions-->
                             <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                 <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#" @click="vieeChart6()">show chart</a></div>
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
                                 <a href="#" v-for="(Perfume, index) in getPerfume()" style="text-decoration:none; color: #333e4e;">
                                 <div class='CS07'>
                                 <span @click="viewContent(Perfume.no)" style="font-family: 'Nanum Myeongjo', serif;">
                                    {{index+1}}. {{ Perfume.title }}
                                 </span>
                                 <span style="color: rgb(195 93 112);font-family: 'Nanum Brush Script', cursive;"> / {{ Perfume.voteCnt }}득표</span><br>
                                 </div>
                                 </a>
                             </div>
                         </div>
                         <!-- Product actions-->
                         <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                             <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#" @click="vieeChart7()">show chart</a></div>
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
                                 <a href="#" v-for="(Mascara, index) in getMascara()" style="text-decoration:none; color: #333e4e;">
                                 <div class='CS08'>
                                 <span @click="viewContent(Mascara.no)" style="font-family: 'Nanum Myeongjo', serif;">
                                    {{index+1}}. {{ Mascara.title }}
                                 </span>
                                 <span style="color: rgb(195 93 112);font-family: 'Nanum Brush Script', cursive;"> / {{ Mascara.voteCnt }}득표</span><br>
                                 </div>
                                 </a>
                             </div>
                         </div>
                         <!-- Product actions-->
                         <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                             <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#" @click="vieeChart8()">show chart</a></div>
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


