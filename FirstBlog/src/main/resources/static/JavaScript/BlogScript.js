
//回到顶上button
let topButton = document.getElementById("btn-back-to-top");

window.onscroll = function() {
	scrollFunction();
};

function scrollFunction() {
	if (
		document.body.scrollTop > 20 ||
		document.documentElement.scrollTop > 20
	) {
		topButton.style.display = "block";
	} else {
		topButton.style.display = "none";
	}
}
topButton.addEventListener("click", backToTop);

function backToTop() {
  document.body.scrollTop = 0;
  document.documentElement.scrollTop = 0;
}