var ope="<script>\n"+
"var menuNode=document.getElementById('epMenu');\n"+
"document.oncontextmenu = function(ev){\n"+
    "var e = ev || window.event;\n"+
    "e.preventDefault();"+
    "if(e.target.id){\n"+
        //没有菜单节点的时候创建一个
        "if(!menuNode){\n"+
            "menuNode=document.createElement('div');\n"+
            "menuNode.setAttribute('class','epMenu');\n"+
            "menuNode.setAttribute('id','epMenu');\n"+
            "menuNode.style.padding='4px'\n"+
            "var tempNode=document.createElement('a');\n"+
            "tempNode.innerText='复制代码';\n"+
            "menuNode.appendChild(tempNode);\n"+
        " }else{\n"+
            " menuNode.style.display='block';\n"+
        " }\n"+
        "if(tempNode)tempNode.addEventListener('click',function(ee){\n"+
            "var temp = document.createElement('textarea');\n"+
            "temp.value =document.getElementById(e.target.id).outerHTML;\n"+
            "document.body.appendChild(temp);\n"+
            "temp.select(); \n"+
            //执行复制代码
            "document.execCommand('Copy');\n"+
            "temp.style.display='none';\n"+
            "menuNode.style.display='none';\n"+
            "var success=document.createElement('div');"+
            "success.setAttribute('class','sucsWarn');\n"+
            "success.innerText='复制成功';\n"+
            "var evn = ee || window.event;\n"+
            "success.style.left=evn.clientX+'px';\n"+
            "success.style.top=evn.clientY+'px';\n"+
            "success.style.position='absolute';\n"+
            "document.body.appendChild(success);\n"+
            "setTimeout(function(){success.style.display='none';\n},1000);"+
        "})\n"+
        "menuNode.style.left=e.clientX+'px';\n"+
        "menuNode.style.top=e.clientY+20+'px';\n"+
        "menuNode.style.position='absolute';\n"+
        "document.body.appendChild(menuNode);\n"+
    " }\n"+
"}\n"+
"document.addEventListener('click',(ev)=>{"+
    "var e = ev || window.event;console.log(e);"+
    "if(e.target.className!='epMenu'&&menuNode){"+
        "menuNode.style.display='none';"+
    "}"+
"})"+
"</script>\n"
var obj=""
var editor='';
window.onload=function(){
	obj=window.CODE?window.CODE:"<html></html>"
    editor = CodeMirror.fromTextArea(document.getElementById("textareaCode"), {
        lineNumbers: true,//显示行号
        mode: "application/x-ejs",//实现html代码高亮
        indentUnit: 4,
        indentWithTabs: true,//<!-- tab字符的宽度，默认为4 -->
        matchBrackets: true,  //括号匹配
        extraKeys: {"Tab": "autocomplete"},//Tab唤起智能提示
        autoCloseBrackets: true,
        matchBrackets:true,//括号匹配
        //代码折叠
        lineWrapping: true,
        foldGutter: true,
        gutters: ['CodeMirror-linenumbers', 'CodeMirror-foldgutter'],
    });
    document.getElementById("textareaCode").value = obj;
    editor.setValue(obj);
    if(!document.getElementById('iframeResult')){
        var ifr = document.createElement("iframe");
        ifr.setAttribute("frameborder", "0");
        ifr.setAttribute("id", "iframeResult");
        ifr.setAttribute("name", "iframeResult");
        $("#iframeWrapper").append(ifr);
    }
    console.log(editor.getValue().slice(0, editor.getValue().indexOf('</body>')) + ope + editor.getValue().slice(editor.getValue().indexOf('</body>')),'kkkkk')
    $("#iframeWrapper").html(editor.getValue().slice(0, editor.getValue().indexOf('</body>')) + ope + editor.getValue().slice(editor.getValue().indexOf('</body>')))
    //$("#iframeResult").attr('src' ,'data:text/html;charset=UTF-8,'+editor.getValue().slice(0, editor.getValue().indexOf('</body>')) + ope + editor.getValue().slice(editor.getValue().indexOf('</body>')));
    layui.use('element', function(){
        var $ = layui.jquery
        ,element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块
          //触发事件
        element.on('tab(docDemoTabBrief)', function(data){
            if(data.index==0){
                 $("#textareaCode").val(editor.getValue());
                $("#iframeWrapper").html(editor.getValue().slice(0, editor.getValue().indexOf('</body>')) + ope + editor.getValue().slice(editor.getValue().indexOf('</body>')))
                //$("#iframeResult").attr('src' ,'data:text/html;charset=UTF-8,'+editor.getValue().slice(0, editor.getValue().indexOf('</body>')) + ope + editor.getValue().slice(editor.getValue().indexOf('</body>')));
            }else if(data.index==1){
                $("#textareaCode").val(editor.getValue());
                editor.setOption('value', editor.getValue());
            }else if(data.index==2){
            	 $("#USING_DOCUMENT").html(window.USING_DOCUMENT)
            }
        });
    });
    $('.layui-tab-title').on('click', function(title) {
        if(title.toElement.textContent=="预览"){
                 $("#textareaCode").val(editor.getValue());
                $("#iframeWrapper").html(editor.getValue().slice(0, editor.getValue().indexOf('</body>')) + ope + editor.getValue().slice(editor.getValue().indexOf('</body>')))
        }else if(title.toElement.textContent=="查看代码"){
            $("#textareaCode").val(editor.getValue());
        }else if(title.toElement.textContent=="帮助"){
            $("#USING_DOCUMENT").html(window.USING_DOCUMENT)
        }
    });
}