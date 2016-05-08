/**
 * @author Pavlenko R.A.
 */

$(document).ready(function(){
	$("a").hover(
        function(){
	       $(this).css("color","#FABE28");
        }
        ,             
        function(){
            $(this).css("color","dimgray");
        }
    );
});