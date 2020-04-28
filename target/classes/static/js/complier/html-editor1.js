var ope="<script>\n"+
"document.oncontextmenu = function(ev){\n"+
    "var e = ev || window.event;\n"+
    "if(ev.target.id){\n"+
        //没有菜单节点的时候创建一个
        "var menuNode=document.getElementById('epMenu');\n"+
        "if(!menuNode){\n"+
            "menuNode=document.createElement('div');\n"+
            "menuNode.setAttribute('class','epMenu');\n"+
            "menuNode.setAttribute('id','epMenu');\n"+
            "var tempNode=document.createElement('a');\n"+
            "tempNode.innerText='复制代码';\n"+
            "menuNode.appendChild(tempNode);\n"+
        " }else{\n"+
            " menuNode.style.display='block';\n"+
        " }\n"+
        "tempNode.addEventListener('click',function(){\n"+
            "var temp = document.createElement('textarea');\n"+
            "temp.value =document.getElementById(ev.target.id).outerHTML;\n"+
            "document.body.appendChild(temp);\n"+
            "temp.select(); \n"+
            //执行复制代码
            "document.execCommand('Copy');\n"+
            "temp.style.display='none';\n"+
            "menuNode.style.display='none';\n"+
        "})\n"+
        "menuNode.style.left=e.clientX+'px';\n"+
        "menuNode.style.top=e.clientY+'px';\n"+
        "document.body.appendChild(menuNode);\n"+
    " }\n"+
    "return false;\n"+
"}</script>\n"
var obj=""
var editor='';
window.onload=function(){
	obj=window.CODE
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
    $("#iframeResult").attr('src' ,'data:text/html;charset=UTF-8,'+$("#textareaCode").val());
    layui.use('element', function(){
        var $ = layui.jquery
        ,element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块
          //触发事件
        element.on('tab(docDemoTabBrief)', function(data){
            if(data.index==0){
                $("#iframeResult").attr('src' ,'data:text/html;charset=UTF-8,'+editor.getValue());
            }else if(data.index==1){
                $("#textareaCode").val(editor.getValue());
            }else if(data.index==2){
            	 $("#USING_DOCUMENT").html(window.USING_DOCUMENT)
            }
        });
    });
    document.oncontextmenu = function(ev){
        var e = ev || window.event;
        if(ev.target.id){
            //没有菜单节点的时候创建一个
            var menuNode=document.getElementById('epMenu');
            if(!menuNode){
                menuNode=document.createElement("div");
                menuNode.setAttribute('class','epMenu');
                menuNode.setAttribute('id','epMenu');
                var tempNode=document.createElement("a");
                tempNode.innerText='复制代码'
                menuNode.appendChild(tempNode);
            }else{
                menuNode.style.display='block';
            }
            $(tempNode).on('click',function(){
                var temp = document.createElement('textarea');
                temp.value =document.getElementById(ev.target.id).outerHTML;
                document.body.appendChild(temp);
                temp.select(); // 选择对象
                document.execCommand("Copy"); // 执行浏览器复制命令
                temp.style.display='none';
                menuNode.style.display='none';
            })
            menuNode.style.left=e.clientX+'px';
            menuNode.style.top=e.clientY+'px';
            document.body.appendChild(menuNode);
        }
        return false;
    }
}