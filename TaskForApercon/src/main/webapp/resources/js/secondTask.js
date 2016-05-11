/**
 * @author Pavlenko R.A.
 */
$(document).ready(function(){
	/*$('button:eq(0)').click(function(){
		$.getJSON('figures/getAll',function(data){$('.showAllTest').text(JSON.stringify(data));});
		$('.showAllTest').show();
	});
	$('button:eq(1)').click(function(){
		$('#forFigureById').show();
	});
	$('.apply').click(function(){
		var id = ('.showById').val();
		var url = "figures/"+id;
		$.getJSON(url,function(data){$('.showByIdTest').text(JSON.stringify(data));});
		$('.showByIdTest').show();
	});*/
	$('.link').hover(
		function(){
			$(this).css({"color":"black","border-color":"#FABE28"});
		}
        ,            
        function(){
        	$(this).css({"color":"#ccc","border-color":"#ccc"});
	});
});