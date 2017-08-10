/**
 * All the custom js functions
 */
	$.fn.parseTemplate = function(data){ 
		var str = (this).html(); 
		var _tmplCache = {} 
		var err = ""; 
		try{ 
			var func = _tmplCache[str]; 
			if (!func){ 
				var strFunc = 
				"var p=[],print=function(){p.push.apply(p,arguments);};" + 
				"with(obj){p.push('" + 
				str.replace(/[\r\t\n]/g, " ") 
				.replace(/'(?=[^#]*#>)/g, "\t") 
				.split("'").join("\\'") 
				.split("\t").join("'") 
				.replace(/<#=(.+?)#>/g, "',$1,'") 
				.split("<#").join("');") 
				.split("#>").join("p.push('") 
				+ "');}return p.join('');";
				func = new Function("obj", strFunc); 
				_tmplCache[str] = func; 
			} 
				return func(data); 
		} catch(e){
			err = e.message; 
		} 
			return "< # ERROR: " + err.toString() + " # >"; 
	};
				
		//$(document).ready(function(){
	$.fn.serializeObject = function(){  	   
	 	var o = {};    
	 	var a = this.serializeArray();    
	 	$.each(a, function() {    
		 	if(o[this.name]){    
		 	   if (!o[this.name].push) {    
		 	         o[this.name] = [o[this.name]];    
		 	   }    
		 	   o[this.name].push(this.value || '');    
		 	} else {    
		 	   o[this.name] = this.value || '';    
		 	}    
	 	});    
	 		return o;    
	};
	
	$(function() {
		var winH = $(window).height();
		var categorySpace = 10;

		$('.js_item').on('click', function() {
			var id = $(this).data('id');
			window.pageManager.go(id);
		});
		$('.js_category').on('click', function() {
			var $this = $(this),
				$inner = $this.next('.js_categoryInner'),
				$page = $this.parents('.page'),
				$parent = $(this).parent('li');
			var innerH = $inner.data('height');
			bear = $page;

			if(!innerH) {
				$inner.css('height', 'auto');
				innerH = $inner.height();
				$inner.removeAttr('style');
				$inner.data('height', innerH);
			}

			if($parent.hasClass('js_show')) {
				$parent.removeClass('js_show');
			} else {
				$parent.siblings().removeClass('js_show');

				$parent.addClass('js_show');
				if(this.offsetTop + this.offsetHeight + innerH > $page.scrollTop() + winH) {
					var scrollTop = this.offsetTop + this.offsetHeight + innerH - winH + categorySpace;

					if(scrollTop > this.offsetTop) {
						scrollTop = this.offsetTop - categorySpace;
					}

					$page.scrollTop(scrollTop);
				}
			}
		});
	});
