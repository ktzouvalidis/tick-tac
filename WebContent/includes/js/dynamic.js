/**
 * Dynamic look 
 */
$(document).ready(function(){
	$("#nav-ul li").on("click", function() {
		$("li").attr('class', "nav-item");
	    $(this).addClass("nav-item active");
	    });
})

function showSideNav() {
    document.getElementById("sidenav").style.width = "250px";
}

function hideSideNav() {
    document.getElementById("sidenav").style.width = "0";
}