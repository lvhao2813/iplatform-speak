	/*导出为图片*/
	function countImageExport(projectName) {
	//document.querySelector(".countImageExport").onclick = function(){
		var message="图片生成中...";
		//window.top.setBlockUI(message);
		
		var dom = document.querySelector("#alarmCountContent");
		html2canvas(dom).then(function(canvas) {
			var image = canvas.toDataURL("image/png");
			image = image.replace("image/png",'image/octet-stream');
			/**
			 * 在本地进行文件保存
			 * @param  {String} data     要保存到本地的图片数据
			 * @param  {String} filename 文件名
			 */
			var saveFile = function(data, filename){
				var save_link = document.createElementNS('http://www.w3.org/1999/xhtml', 'a');
				save_link.href = data;
				save_link.download = filename;
				var event = document.createEvent('MouseEvents');
				event.initMouseEvent('click', true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);
				save_link.dispatchEvent(event);
			};
			// 下载后的文件名
			var filename = projectName + '.png';
			// download
			//假如是ie浏览器
			if(browserIsIe()){     
				// alert("IE浏览器");
				DownLoadReportIMG(projectName + '.png',image);
			}else{
				// alert("非IE浏览器");
				saveFile(image,filename);  //下载图片
			}
			function browserIsIe() {
				if (!!window.ActiveXObject || "ActiveXObject" in window)
					return true;
				else
					return false;
			}
			function DownLoadReportIMG(fileName,imgPathURL) {
				var blob = base64Img2Blob(imgPathURL); 
				//ie11及以上
				window.navigator.msSaveBlob(blob, fileName);  
			}
			function base64Img2Blob(code){
				var parts = code.split(';base64,');
				var contentType = parts[0].split(':')[1];
				var raw = window.atob(parts[1]);
				var rawLength = raw.length;
				var uInt8Array = new Uint8Array(rawLength);
				for (var i = 0; i < rawLength; ++i) {
					uInt8Array[i] = raw.charCodeAt(i);
				}
				return new Blob([uInt8Array], {type: contentType}); 
			}
			
			//window.top.setUnBlockUI();//取消遮罩
  		});
	}
