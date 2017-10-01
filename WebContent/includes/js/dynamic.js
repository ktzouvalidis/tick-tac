/**
 * Dynamic look 
 */
$(document).ready(function(){
	$("#nav-ul li").on("click", function() {
		$("li").attr('class', "nav-item");
	    $(this).addClass("nav-item active");
	    });
	
	$('#sidenav-ul a').hover(function(){
		$(this).addClass('a-hovered');
	},
	function(){
		$(this).removeClass('a-hovered');
	});
})

function showSideNav() {
    document.getElementById("sidenav").style.width = "250px";
}

function hideSideNav() {
    document.getElementById("sidenav").style.width = "0";
}