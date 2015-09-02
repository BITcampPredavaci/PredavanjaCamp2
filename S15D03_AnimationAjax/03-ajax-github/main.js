// Sljedeći dio otkomentarišite ako se želite autorizirati na GitHub kako biste
// mogli pristupiti ličnim podacima ili zaobići strogo ograničenje od 60
// request-a po satu
//
// $.ajaxSetup({
//   headers: {
//     'Authorization':
//       'Basic ' + btoa('<username>:<personal-access-token>')
//   }
// });

$('#get-repos').on('click', function() {
  // GitHub username korisnika o kome želimo dohvatiti podatke
  var username = $('#username').val();

  // Izvršavamo GET zahtjev koji dobavlja informacije o repozitorijima za
  // trenutni username
  $.get(
    'https://api.github.com/users/' + username + '/repos',
    // Sljedeća *callback* funkcija se izvršava tek onda kada je GET zahtjev
    // završen, tj. kada dobijemo odgovor od servera
    function(data) {
      // Prvo sakrivamo listu repozitorija koja je ranije bila prikazana
      // koristeći `slideUp()` metodu. Ovoj metodi kao argument dajemo
      // *callback* funkciju koja će biti pozvana tek onda kada se animacija
      // završi.
      $('#user-repos').slideUp(function() {
        // Kad je animacija završila, čistimo listu, te ubacujemo repozitorije
        // koje smo dobili ranijim GET zahtjevom.
        $('#user-repos').empty();

        for (var i = 0; i < data.length; i++) {
          $('<li>', { text: data[i].name }).appendTo('#user-repos');
        }

        // Nakon što smo zamijenili sadržaj liste, radimo `slideDown()` kako
        // bismo opet prikazali listu.
        $('#user-repos').slideDown();
      });
    });
});
