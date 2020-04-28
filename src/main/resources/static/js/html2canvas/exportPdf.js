function exportPdf(elemId) {
    var element = document.getElementById(elemId);
    getChildNode(element);
    
    html2canvas(element, {
        logging:false,
        allowTaint: true,//允许跨域，具体啥意思不清楚
        height: document.getElementById(elemId).scrollHeight,//
        width: document.getElementById(elemId).scrollWidth,//为了使横向滚动条的内容全部展示，这里必须指定
        background: "#FFFFFF"
    }).then(function(canvas) {
        var pdf = new jsPDF('p', 'mm', 'a4');    //A4纸，纵向
        var ctx = canvas.getContext('2d'),
            a4w = 190, a4h = 277,    //A4大小，210mm x 297mm，四边各保留10mm的边距，显示区域190x277
            imgHeight = Math.floor(a4h * canvas.width / a4w),    //按A4显示比例换算一页图像的像素高度
            renderedHeight = 0;

        while(renderedHeight < canvas.height) {
            var page = document.createElement("canvas");
            page.width = canvas.width;
            page.height = Math.min(imgHeight, canvas.height - renderedHeight);//可能内容不足一页

            //用getImageData剪裁指定区域，并画到前面创建的canvas对象中
            page.getContext('2d').putImageData(ctx.getImageData(0, renderedHeight, canvas.width, Math.min(imgHeight, canvas.height - renderedHeight)), 0, 0);
            pdf.addImage(page.toDataURL('image/jpeg', 1.0), 'JPEG', 10, 10, a4w, Math.min(a4h, a4w * page.height / page.width));    //添加图像到页面，保留10mm边距
            
            renderedHeight += imgHeight;
            if(renderedHeight < canvas.height) {
                pdf.addPage();//如果后面还有内容，添加一个空页
            }
            delete page;
        }
        pdf.save('content.pdf');
    });
    reductionHeight();
}

var arr=[];
/**
 * 还原高度
 */
function reductionHeight(){
//	console.log("打印对象：");
//	console.log(arr);
	for(var i=0;i<arr.length;i++){
		var obj=arr[i];
		$(obj.node).height(obj.height);
	}
	//清空数组
	arr.length=0;
} 

function hasScrolled(el, direction) {
	direction = direction || "vertical";
    if(direction === "vertical") {
        return el.scrollHeight > el.clientHeight;
    }else if(direction === "horizontal") {
        return el.scrollWidth > el.clientWidth;
    }
}

function getChildNode(node){
    //先找到子结点
    var nodeList = node.childNodes;
    for(var i = 0;i < nodeList.length;i++){
        //childNode获取到到的节点包含了各种类型的节点
        //但是我们只需要元素节点  通过nodeType去判断当前的这个节点是不是元素节点
        var childNode = nodeList[i];
        //判断是否是元素结点
        if(childNode.nodeType == 1){
        	if (hasScrolled(childNode, 'vertical')) {
        		var obj={};
        		obj.node=childNode;
        		obj.height=$(childNode).css('height');
        		arr.push(obj);
        		$(childNode).css('height','100%');
        	}
            getChildNode(childNode);
        }
    }
}