// Pozdrav pri učitavanju stranice
alert("Hello, world!");

/**
 * Prikazuje poruku unutar stranice (ne kroz dijalog)
 */
function showMessage(message) {
  // pronalazimo <body> element, jedini na stranici po nazivu taga
  var body = document.getElementsByTagName("body")[0];

  // selektujemo sve prethodne poruke i brišemo ih
  var previousMessages = body.getElementsByClassName("message");
  for (var i = 0; i < previousMessages.length; i++) {
    body.removeChild(previousMessages[i]);

    // Alternativni (jednostavniji) način za brisanje elementa koji je u
    // eksperimentalnoj fazi (i nije podržan u svim browserima), te se ne bi
    // trebao koristiti u produkciji:
    //
    // previousMessages[i].remove();
  }

  // kreiramo novi <p> element te mu dajemo klasu i tekst
  var messageElement = document.createElement("p");
  messageElement.className = "message";
  messageElement.innerText = message;

  // dodajemo paragraf na kraj <body> elementa
  body.appendChild(messageElement);
}

/**
 * Prikazuje pozdrav koristeći ime upisano u polje s ID-em `full-name`
 */
function greetUser() {
  var fullName = document.getElementById("full-name");
  showMessage("Hello, " + fullName.value);

  // sprječavamo dugme da pošalje podatke forme
  return false;
}

var sayHiButton = document.getElementById("say-hi-button");

// dodjeljujemo funkciju `greetUser` kao event handler za dugme
sayHiButton.onclick = greetUser;
