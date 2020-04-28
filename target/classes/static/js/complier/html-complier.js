var obj={
    html:"",
    java:"",
}
var editor='';
window.onload=function(){
	//obj.html=window.CODE?window.CODE:obj.html;
	obj[window.CATEGORIA]=window.CODE
	if(window.CATEGORIA=='java'){
		$('#iframewrapper').hide();
		$('#textResult').show()
	}else{
		$('#iframewrapper').show();
		$('#textResult').hide()
	}
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
    document.getElementById("textareaCode").value = obj[$("#language option:selected").val()];
    editor.setValue( obj[$("#language option:selected").val()]);
    submitTryit();
}
function submitTryit() {
$("#textareaCode").val(editor.getValue());
    if($("#language option:selected").val()=='java'){
    	$('#iframewrapper').hide();
		$('#textResult').show()
   		 $.ajax({
                    url:'/api/v1/javaCompiler/runJavaApi',
                    type:"POST",
                    data:{
                        code:editor.getValue()
                    },
                    dataType: 'text',
                    responseType:'string',
                    success: function(r){
                    console.log(r.toString())
                             $("#textResult").val(r);
                    },
                    error: function(r){
                            $("#iframewrapper").html(r)
                    }
                });
    }else{
    	$('#iframewrapper').show();
		$('#textResult').hide()
        if(!document.getElementById('iframeResult')){
            var ifr = document.createElement("iframe");
            ifr.setAttribute("frameborder", "0");
            ifr.setAttribute("id", "iframeResult");
            ifr.setAttribute("name", "iframeResult");
            $("#iframewrapper").append(ifr);
        }
        $("#iframewrapper").html($("#textareaCode").val())
        //$("#iframeResult").attr('src' ,'data:text/html;charset=UTF-8,'+$("#textareaCode").val());//这是iframe的写法
    }
    obj[$("#language option:selected").val()]=$("#textareaCode").val();//保存在全局变量中
}
function typeChange(){
    editor.setOption("mode",$("#language option:selected").val()=="java"?'text/x-java':"application/x-ejs");//动态更改mode类型
    editor.setValue( obj[$("#language option:selected").val()])//切换codemirror的值
    $("#textareaCode").val(obj[$("#language option:selected").val()]);
    $("#iframewrapper").html('');
}

