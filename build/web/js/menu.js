/* 
 * Copyright 2017 Gilford.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


$(function () {
   
    var header = document.getElementById('header');
    var headroom = new Headroom (header);
    headroom.init();
   
    
    //menu responsivo
    //calcular el ancho de la pagina
    
    var ancho= $(window).width(),
        enlaces= $('#enlaces'),
        btnMenu= $('#btn-menu'),
        icono= $('#btn-menu .icono');
        
        if(ancho < 839){
            enlaces.hide();
            icono.addClass('fa-bars');
        }
        
        btnMenu.on('click', function(e){
            enlaces.slideToggle();
            icono.toggleClass('fa-bars');
            icono.toggleClass('fa-times');
            
        });
        
        
        $(window).on('resize', function(){
           if($(this).width()>839){
               enlaces.show();
               icono.addClass('fa-times');
               icono.removeClass('fa-bars');
           }else{
               enlaces.hide();
               icono.addClass('fa-bars');
               icono.removeClass('fa-times');
           } 
        });
    
});

