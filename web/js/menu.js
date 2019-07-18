/**
 * Created by yaoxuecheng on 16/5/31.
 */
(function(){

    var oContainer = document.getElementById('container-center');
    var oContainerBox = document.getElementById('container-list-box');
    var oUl = document.getElementById('container-list-box');
    var aLi = oUl.getElementsByTagName('li');
    var oMenu = oContainer.getElementsByTagName('ul');
    var index = 0;
    var that = 0;
    var _that = 0;
    var bOnff  = false;


    for(var i=0;i<oMenu.length;i++){
        aLi[i].timer = i;
        aLi[i].index = i;
        aLi[i].onmouseover =  function(){
            clearInterval(that.timer);
            if(that){
                oMenu[that.index].style.display = 'none';
            }
            index  = this.index ;
            oMenu[index].style.width =oMenu[index].children.length*130 + 'px' ;
            oMenu[index].style.top = index*40 +'px';
            oMenu[index].style.display = 'block';
            var aMenuList = oMenu[index].children;
            for(var j=0;j<aMenuList.length;j++){
                aMenuList[j].timer = j;
                aMenuList[j].onmouseover = function(){

                    bOnff = false;
                    clearTimeout(_that.timer);
                };
                aMenuList[j].onmouseout = function(){
                    _that = this;
                    this.timer = setTimeout(function(){
                        bOnff = true;
                    },500);
                };
            }
        };
        aLi[i].onmouseout = function(){
            that = this;
                this.timer = setInterval(function(){
                    if(bOnff){
                        for(var i=0;i<oMenu.length;i++){
                            oMenu[i].style.display = 'none';
                       }
                    }
                },500);
        };
    }



































})();