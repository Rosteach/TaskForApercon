/**
 * @author Pavlenko R.A.
 */
$(document).ready(function(){
	var nav_wrap = $(".sliding-menu"),
		elem_width,
		elem_left_offset,
		elem_parent,
		slider_line;
	
	$(window).load(function(){

		nav_wrap.each(function(){
			$(this).append('<li class="sliding-line"></li>');

			var start_elem_width = 0;
			var start_elem_offset = 0;
			var active_elem = $(this).find(".active");

			if(active_elem.length){
				start_elem_width = active_elem.outerWidth();
				start_elem_offset = active_elem.position().left;
			} 

			$(this).find(".sliding-line").css({ 
				"width": start_elem_width + "px",
				"left": start_elem_offset + "px"
			})
			.data("width", start_elem_width)
			.data("left", start_elem_offset);
		});

	});

	nav_wrap.find("li a").hover(function(){

		elem_parent = $(this).parent();
		elem_width = elem_parent.outerWidth();
	    elem_left_offset = $(this).position().left;
	    slider_line = elem_parent.siblings(".sliding-line");
	    slider_line.stop().animate({
	    	"width": elem_width + "px",
	        "left": elem_left_offset + "px"
	    });

	}, function(){

	    slider_line.stop().animate({
	    	"width": slider_line.data("width") + "px",
	        "left": slider_line.data("left") + "px"
	    });
	      
	});
	// ajax
	$("#numOfTestCases").keyup(function(){
		var value = $(this).val();
		$.ajax({
			url: 'testCases',
			method: 'POST',
			data: ({name: value}),
			success: function(data){$('.checkCaseTest').html(data);}
		});
	});
	$(".calc").click(function(){
		$(".output").show();
		var value = $("#parameter").val();
		$.ajax({
			url: 'parameters',
			method: 'POST',
			data: ({name: value}),
			success: function(data){$('.output').html(data);}
		});
	});
	// adding parameters input 
	$(".apply").click(function(){
		var input = $("#numOfTestCases").val();
		if(input==0||input>30){
			return false
		}
		else if(isNaN(input)){
			return false
		}
		else{
			//$("#parameter").attr("maxlength",input*4);
			$(".parameters").show();
		}
    });
	// check our parameters input must be <= $("#numOfTestCases").val();
	$("#parameter").keyup(function(){
		var input = $(this).val();
		var maxlength = 0;
		var count = 0;
		for(i=0;i<input.length;i++){
			var temp = input[i];
			if(temp==';'){
				count++;
				if(count==$("#numOfTestCases").val()){
					maxlength = i;
					$(this).attr("maxlength",maxlength);
				}
			}
		}
		
	});
	
	$(".clearParam").click(function(){
		$(".parameters").val("");
		$("#parameter").val("");
		$("#numOfTestCases").val("");
		$(".parameters").hide();
		$(".output").hide();
	});
});

