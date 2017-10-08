/**
 * Utilities
 */
$(document).ready(function(){
	$("#form-signup").validate({
		rules: {
			pass: {
				minlength: 4
			},
			cfmpass: {
				equalTo: "#pass",
				minlength: 4
			}
		},
		
		messages: {
			cfmpass: {
				required: "Must be the same with the password"
			}
		}
	});
})