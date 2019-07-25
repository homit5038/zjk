//显示搜索历史栏
function showSearchDiv(ele) {
    ele.style.display="block";
}
function hideSearchDiv(ele) {
    ele.style.display="none";
}
var search_video=document.getElementById("search_video");
var searchHistory=document.querySelector(".search-history");
search_video.addEventListener("focus", function () {
    showSearchDiv(searchHistory);
});
search_video.addEventListener("blur", function () {
    //设置延时，不然该事件会比搜索历史li的点击事件先执行
    setTimeout(function(){
        hideSearchDiv(searchHistory);
    }, 300);

});

//
(function () {
    //给每条搜索历史添加点击监听
    var search_istory_li=document.querySelectorAll(".searchh-istory-li");
    for(var i=0;i<search_istory_li.length;i++) {
        search_istory_li[i].addEventListener("click",function () {
            //先让选中记录到input标签的value，再隐藏搜索历史栏
            search_video.value=this.innerHTML;

            hideSearchDiv(searchHistory);
        })
    }

    //监控列表添加点击事件
    var monitorList=document.querySelectorAll(".address-list-ul");
    for(var j=0;j<monitorList.length;j++){
        monitorList[j].getElementsByTagName("span")[0].addEventListener("click",function () {
            var childArry=this.parentNode.getElementsByTagName("li");
            for(var i=0;i<childArry.length;i++){
                if(childArry[i].style.display!="none"){
                    childArry[i].style.display="none";
                }else childArry[i].style.display="block";
            }

        })
    }

})();