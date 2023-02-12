'use strict';
var slideIndex = 1;
showSlides(slideIndex);

// Next/previous controls
function plusSlides(n) {
  showSlides((slideIndex += n));
}

// Thumbnail image controls
function currentSlide(n) {
  showSlides((slideIndex = n));
}

function showSlides(n) {
  let i;
  const $AptImg = document.getElementsByClassName("Apt-img");

  if (n > $AptImg.length) {
    slideIndex = 1;
  }
  if (n < 1) {
    slideIndex = $AptImg.length;
  }
  for (i = 0; i < $AptImg.length; i++) {
    $AptImg[i].style.display = "none";
  }

  $AptImg[slideIndex - 1].style.display = "block";
}
