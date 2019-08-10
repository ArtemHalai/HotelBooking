
let h = document.getElementById("home");
let a = document.getElementById("about");
let b = document.getElementById("but_bar");

h.onclick = function () {
b.style.backgroundImage = 'linear-gradient(to right, #1F1C2C, #928DAB)';
}

a.onclick = function () {
b.style.backgroundImage = 'linear-gradient(-20deg, #2b5876 0%, #4e4376 100%)';
}

window.onload = function() {
    document.getElementById("audio").play();
}


