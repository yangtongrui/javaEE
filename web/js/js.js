/**
 * Created by yaoxuecheng on 16/5/4.
 */
(function(){

    //gotop
    var oTop = document.getElementById('gotop');
    var oCon = document.getElementById('container');
    var timer = null;
    //var i = 0;
    var arr = new Array(3);
    arr[0] = 'rgb(244, 33, 78)';arr[1] = 'rgb(26, 194, 233)';arr[2] = 'rgb(239, 99, 72)';



    var timer2 = null;
    var bOnff = true;

    window.onscroll = function(){

        var iScrollTop = document.body.scrollTop || document.documentElement.scrollTop;
        if( iScrollTop > 200 && bOnff ){
            oTop.style.display = 'block';
            bOnff = false;
        }else{
            if(iScrollTop <= 200 && !bOnff){
                oTop.style.display = 'none';
                bOnff = true;

            }
        }


    };

    oTop.onclick = function () {

        var iScrollTop = document.body.scrollTop || document.documentElement.scrollTop;
        //oTop.style.display = 'none';

        timer2 = setInterval(function () {
            window.scrollTo(0 , iScrollTop *= 0.8);
            if (iScrollTop <= 1) {
                window.scrollTo(0, 0);
                clearInterval(timer2);
            }
        }, 20);
        bOnff = false;
        return false;

    };


    var oContainer = document.getElementById('container');
    var oUl = document.getElementById('container-list-box');
    var oLi = oUl.getElementsByTagName('li');
    var index = 0;
//    for(var i=0;i<oLi.length;i++) {
//        oLi[i].index = i;
//        oLi[i].onmouseover = function () {
//
//    }



//    轮播图

    var oPrev = document.getElementById('prev');
    var oNext = document.getElementById('next');
    var oTab2 =document.getElementById('tab-2');
    var aLi = oTab2.getElementsByTagName('li');
    var aImg = oContainer.getElementsByTagName('img');

    var index1 = 0;


    for(var i=0;i<aLi.length;i++) {
        aLi[i].index = i;
        aLi[i].onmouseover = function () {
            index1 = this.index;
            this.style.background = '#bcbc';
            changeImg();
        }
        aLi[i].onmouseout = function () {
            this.style.background = 'black';
        }
    }
    oPrev.onclick = function(){
        index1 --;
        if(index1 < 0){
            index1 = aImg.length - 1;
        }
        changeImg();
    };
    oNext.onclick = function(){
        index1 ++;
        if(index1 > aImg.length - 1){
            index1 = 0 ;
        }
        changeImg();
    };
    run();

    oContainer.onmouseover = function(){
        clearInterval(timer);
    };
    oContainer.onmouseout = function(){
        run();
    };
    function changeImg(){
        for(var i=0;i<aImg.length;i++){
            aImg[i].className = '';
            aLi[i].style.background = '';
        }
        aImg[index1].className = 'select' ;
        aLi[index1].style.background = '#bcbc';
        oContainer.style.background = arr[index1];
    }
    function clearImg(){
        for(var i=0;i<aImg.length;i++){
            aImg[i].className = '';
        }
    }

    function run(){
        timer = setInterval(function(){
            index1 ++;
            if(index1 > aImg.length - 1){
                index1 = 0 ;
            }
            changeImg();
        },1500);
    }






})();





