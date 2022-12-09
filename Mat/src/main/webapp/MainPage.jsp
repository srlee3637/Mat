<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@include file="include/header.jsp" %>
 
    <div class="container">

		<div class="row ">
        	
        	       
            <div class="box">
                
                       
                <div class="col-lg-6 text-center">
			      	<h2>맛집은 JMT</h2>
					<p>맛집이 궁금하다면?</p>
					<hr>
					<h3><a href="https://www.youtube.com/channel/UCXiyuCYo4dUqM556XpgqAcQ">둘러보기</a></h3>
					
                	
                    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel"><!-- data-ride="carousel" 자동 슬라이드 기능 -->
                       
                        <ol class="carousel-indicators hidden-xs">
                            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                            
                        </ol>

                     
                        <div class="carousel-inner">
                            <div class="item active">
                                <img class="img-responsive img-full" src="img/1.png">
                            </div>
                            <div class="item">
                                <img class="img-responsive img-full" src="img/2.png"> <!-- img-full 옵션 class -->
                            </div>
                            <div class="item">
                                <img class="img-responsive img-full" src="img/3.png">
                            </div>
                           
                        </div>

                       	
                        <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                            <span class="icon-prev"></span>
                        </a>
                        <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                            <span class="icon-next"></span>
                        </a>
                    </div>
                        
                </div>
                    
                <div class="col-lg-6 text-center" >    
                    
						<h2>hello world</h2>
						<p>
							깜빡하신게 있는것 같아요!
						</p>
						<hr>
						<h3>구독과 좋아요</h3>
				<iframe width="100%" height="351px" src="https://www.youtube.com/embed/nOTpuof2YG8?list=PLK7AWkPYwus6SdPJyhK9SNnKJybIC5qCs" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>						
                </div>   
                    
                
            </div>
            
          
            
        </div>

       

          
    <!-- /.container -->
    </div>
    
    <%@include file="include/footer.jsp" %>
   