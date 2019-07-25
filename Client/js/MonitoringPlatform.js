(
    function () {
        //提醒角标点击事件
        var number_icon = document.querySelectorAll(".number-icon");
        for (var i = 0; i < number_icon.length; i++) {
            number_icon[i].addEventListener("click", function () {
                this.style.display = "none";
            })
        }

        //点击警示提醒框
        var attention_click1 = document.querySelector(".work-in-attention");
        var attention_click2 = document.querySelector(".work-leave-attention");
        var attention_click3 = document.querySelector(".work-gather-attention");
        attention_click1.addEventListener("click", function () {
            this.querySelector(".number-icon").style.display = "none";
            document.querySelector(".attention-modal").style.display = "block";
            var modal_p = document.querySelector(".attention-modal-p");
            modal_p.setAttribute("class", "attention-modal-p safe-color");
        });
        attention_click2.addEventListener("click", function () {
            this.querySelector(".number-icon").style.display = "none";
            document.querySelector(".attention-modal").style.display = "block";
            var modal_p = document.querySelector(".attention-modal-p");
            modal_p.setAttribute("class", "attention-modal-p warn-color");
        });
        attention_click3.addEventListener("click", function () {
            this.querySelector(".number-icon").style.display = "none";
            document.querySelector(".attention-modal").style.display = "block";
            var modal_p = document.querySelector(".attention-modal-p");
            modal_p.setAttribute("class", "attention-modal-p warn-color");

        });

        //警示提醒模态框
        var attention_modal_div = document.querySelectorAll(".attention-modal-div");
        for (var j = 0; j < attention_modal_div.length; j++) {
            attention_modal_div[j].addEventListener("click", function () {

                var modal_imgs = this.getElementsByTagName("img");
                //判断箭头
                for (var k = 0; k < modal_imgs.length; k++) {
                    if (modal_imgs[k].style.display === "none") {
                        modal_imgs[k].style.display = "block"
                    } else {
                        modal_imgs[k].style.display = "none"
                    }

                }
                var modal_divs = this.getElementsByTagName("div");
                for (var l = 0; l < modal_divs.length; l++) {
                    if (modal_divs[l].style["white-space"] === "normal") {
                        modal_divs[l].style["white-space"] = "nowrap";
                    } else {
                        modal_divs[l].style["white-space"] = "normal";
                    }
                }
            })
        }

        //关闭模态框
        var shutdown_modal = document.querySelector(".attention-modal-img");
        shutdown_modal.addEventListener("click", function () {
            document.querySelector(".attention-modal").style.display = "none";
        });
        //关闭、开启弹出层
        var shutdown_search_modal =document.querySelector(".shutdown-search-modal");
        shutdown_search_modal.addEventListener("click", function () {
            document.querySelector(".search-modal").style.display = "none";
        });
        var open_search_modal=document.getElementById("search_modal");
        open_search_modal.addEventListener("click", function () {
            document.querySelector(".search-modal").style.display = "block";
        });

        //
        var condition_img=document.querySelectorAll(".condition-img");
        for(var m=0;m<condition_img.length;m++){
            condition_img[m].addEventListener("click", function () {
                if(this.style.transform === "rotate(180deg)"){
                    this.style.transform = "rotate(0deg)";
                }else this.style.transform = "rotate(180deg)";
            });
        }
    }
)();