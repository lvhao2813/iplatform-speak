$.fn.placeholder = function(){
	return this.each(function () {
		if(!window.applicationCache){
			var _self = $(this);
			var _parent = _self.parent();
			var phv = _self.attr('placeholder');
			var color = '#777777';
			//div setup
			var placeholder = $('<div>'+phv+'</div>').css('display','none').on("click",function(event){
				_self.focus();
			});
			$('body').append(placeholder);
			var top = _self.offset().top + ((_self.outerHeight() - _self.height()) / 2);
			var left = _self.offset().left + ((_self.outerWidth() - _self.width()) / 2)+2;
			//临时处理施工台中的问题
			var mt = _parent.css("margin-top");
			if(mt){
				mt = mt.substring(0,mt.length-2);
				if(mt>0){
					top = top-mt-1;
				}
			}
			var width = _self.outerWidth();
			var height =  _self.outerHeight();
			var zIndex = _self.css('zIndex');
			if(zIndex != 'auto'){
				zIndex = parseInt(zIndex) + 1;
			}
			placeholder.css({display:'block',pointerEvents: 'none',cursor: 'text',display: 'none',zIndex: zIndex, color: color, position: 'absolute', left: left, top: top ,width: width ,height: height });
			
			var value = function(){
				var val = _self.val();
				if(val == typeof(undefined) || val == null || val == '')
				return '';
				else
				return val;
			};
			var addPlaceholder = function(){
				placeholder.css('display','');
			};
			var remPlaceholder = function(){
				placeholder.css('display','none');
			};
		
			if(value() == ''){
				addPlaceholder();
			}
			//needs to be keydown to get the value before changed
			_self.focusin(function(e){
				remPlaceholder();
			});
			_self.focusout(function(e){
				if(value() == ''){
					addPlaceholder();
				}else{
					remPlaceholder();
				}
			});
			_self.change(function(e){
				_self.focusout();
			});			
		}
	});
};
$(window).load(function(){
	$('input[placeholder][type=text]').placeholder();
	
});