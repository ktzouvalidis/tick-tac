/**
 * Dynamic look 
 */
$("ul li").on("click", function() {
	var cl = "nav-item active";
	subCl = cl.lastIndexOf(" ");
	subCl = cl.substring(0, subCl);
	$("li").removeClass(cl);
    $(this).addClass(subCl);
    });


function showSideNav() {
    document.getElementById("sidenav").style.width = "250px";
}

function hideSideNav() {
    document.getElementById("sidenav").style.width = "0";
}