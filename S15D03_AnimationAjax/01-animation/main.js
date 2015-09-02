var textContainer = document.getElementsByClassName('text-container')[0];

function increaseHeight() {
  currentHeight += 10;
  textContainer.style.height = currentHeight + 'px';

  if (currentHeight < 550) {
    // ako nismo dostigli maksimalnu visinu od 550px, ponovo pozivamo funkciju
    // `increaseHeight()` za 16ms
    setTimeout(increaseHeight, 16);
  }
}

textContainer.onclick = function() {
  // početnu visinu elementa dobivamo kroz `offsetHeight` atribut
  var currentHeight = textContainer.offsetHeight;

  // pozivamo funkciju `increaseHeight()` prvi put
  increaseHeight();
};
